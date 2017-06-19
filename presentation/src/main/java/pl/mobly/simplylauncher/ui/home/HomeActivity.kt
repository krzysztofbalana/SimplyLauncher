package pl.mobly.simplylauncher.ui.home

import android.app.Activity
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import butterknife.ButterKnife
import pl.mobly.simplylauncher.R
import pl.mobly.simplylauncher.common.AppBase
import java.util.logging.Logger
import javax.inject.Inject


class HomeActivity : Activity(), HomeView {

    companion object {
        val log = Logger.getLogger(javaClass.simpleName)
    }

    @Inject lateinit var homePresenter: HomePresenterImpl
    lateinit var gestureDetector: GestureDetector


    override fun onResume() {
        super.onResume()
        homePresenter.bindView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        initInjectionSystem()

        gestureDetector = GestureDetector(this, object : SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                return super.onSingleTapConfirmed(e)
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                var minimalDistanceLength = 100
                if (distanceY >= minimalDistanceLength) {
                    log.info("MOVING UP")

                    val rootLayout = findViewById(android.R.id.content) as FrameLayout
                    val view = View.inflate(this@HomeActivity, R.layout.app_drawer, null)

                    val lp: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT)

                    view.layoutParams = lp

                    rootLayout.addView(view)
                    view.invalidate()

                    rootLayout.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
                        override fun onLayoutChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int, p5: Int, p6: Int, p7: Int, p8: Int) {
                            p0.toString()
                        }
                    })

                }
                return super.onScroll(e1, e2, distanceX, distanceY)

            }
        })


        val testint = testint(111112, { it -> it.toString() })
        Toast.makeText(this, "$testint", Toast.LENGTH_LONG).show()

    }

    fun testint(int: Int, op: (Int) -> String): String {
        return op(int)
    }


    fun convertIntToString(int: Int): String {
        return int.toString()
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

