package pl.mobly.simplylauncher

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import pl.mobly.domain.interactors.SystemInfoInteractorImpl
import pl.mobly.simplylauncher.common.AppBase
import java.util.logging.Logger
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class HomeActivity : Activity() {
    companion object {
        val log = Logger.getLogger(javaClass.simpleName)
    }

    @Inject
    lateinit var systemInfoInteractorImpl: SystemInfoInteractorImpl

    lateinit var gestureDetector: android.view.GestureDetector


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        AppBase.appComponent.inject(this)

        gestureDetector = GestureDetector(this, object : SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                return super.onSingleTapConfirmed(e)
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                var minimalDistanceLenght = 100
                if (distanceY >= minimalDistanceLenght) {
                    log.info("MOVING UP")
                    val from = BottomSheetBehavior.from(bottom_sheet)
                    from.setState(BottomSheetBehavior.STATE_EXPANDED)
                }
                return super.onScroll(e1, e2, distanceX, distanceY)
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }


}

