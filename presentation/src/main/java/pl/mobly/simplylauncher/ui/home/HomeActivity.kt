package pl.mobly.simplylauncher.ui.home

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import kotlinx.android.synthetic.main.bottom_sheet.*
import pl.mobly.simplylauncher.R
import pl.mobly.simplylauncher.common.AppBase
import java.util.logging.Logger
import javax.inject.Inject

class HomeActivity : Activity(), HomeView {

    companion object {
        val log = Logger.getLogger(javaClass.simpleName)
    }

    @Inject lateinit var homePresenter:HomePresenterImpl
    lateinit var gestureDetector: GestureDetector

    override fun onResume() {
        super.onResume()
	    homePresenter.bindView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initInjectionSystem()

        gestureDetector = GestureDetector(this, object : SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                return super.onSingleTapConfirmed(e)
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                var minimalDistanceLength = 100
                if (distanceY >= minimalDistanceLength) {
                    log.info("MOVING UP")
                    val from = BottomSheetBehavior.from(bottom_sheet)
                    from.setState(BottomSheetBehavior.STATE_EXPANDED)
                }
                return super.onScroll(e1, e2, distanceX, distanceY)
            }
        })
    }

    private fun initInjectionSystem() {
        (applicationContext as AppBase).createHomeComponent().inject(this)
    }

    override fun onDestroy() {
        releaseInjectionSystem()
	    homePresenter.unbindView()
        super.onDestroy()
    }


    private fun releaseInjectionSystem() {
        (applicationContext as AppBase).releaseHomeComponent()
    }

    override fun showDrawer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideDrawer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }


}

