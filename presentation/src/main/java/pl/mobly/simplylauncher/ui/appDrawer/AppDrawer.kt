package pl.mobly.simplylauncher.ui.appDrawer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.LinearLayout
import io.reactivex.disposables.Disposable
import pl.mobly.simplylauncher.R
import pl.mobly.simplylauncher.common.AppBase
import pl.mobly.simplylauncher.common.views.SimpleSwitcher
import pl.mobly.simplylauncher.common.gone
import pl.mobly.simplylauncher.common.invisible
import pl.mobly.simplylauncher.common.visible
import pl.mobly.simplylauncher.ui.appDrawer.grid.AppsGridView
import pl.mobly.simplylauncher.ui.appDrawer.list.AppsListView
import javax.inject.Inject

class AppDrawer : LinearLayout, AppDrawerView {
    @Inject lateinit var presenter: AppDrawerPresenterImpl

    lateinit var disposable: Disposable
    lateinit var parentView: LinearLayout
    lateinit var simpleSwitcher: SimpleSwitcher
    lateinit var listView: AppsListView
    lateinit var gridView: AppsGridView

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()

    }

    private fun init() {
        (context.applicationContext as AppBase).createHomeComponent().inject(this)

        val layoutInflater = LayoutInflater.from(context)
        parentView = layoutInflater.inflate(R.layout.app_drawer, this, true) as LinearLayout
        parentView.orientation = LinearLayout.VERTICAL

        simpleSwitcher = parentView.findViewById(R.id.switcher) as SimpleSwitcher
        listView = parentView.findViewById(R.id.view_apps_list) as AppsListView
        gridView = parentView.findViewById(R.id.view_apps_grid) as AppsGridView

        disposable = simpleSwitcher.listenToClicks()
                .doOnNext { i -> notifyHost(i) }
                .doOnComplete { }
                .subscribe()

        presenter.bind(this)

    }

    private fun notifyHost(i: Int?) {
        presenter.onSwitcherTapped(i)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.unbind()
        (context.applicationContext as AppBase).releaseHomeComponent()
    }

    override fun showList() {
        listView.visible()
        gridView.invisible()
    }

    override fun showGrid() {
        gridView.visible()
        listView.invisible()
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }

}