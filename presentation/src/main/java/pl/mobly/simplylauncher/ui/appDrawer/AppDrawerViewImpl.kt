package pl.mobly.simplylauncher.ui.appDrawer

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_appdrawer.view.*
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.simplylauncher.R
import pl.mobly.simplylauncher.common.AppBase
import javax.inject.Inject


class AppDrawerViewImpl : LinearLayout, AppDrawerContract.View {

	lateinit private var mContext: Context
	@Inject lateinit var presenter: AppDrawerPresenterImpl

	constructor(context: Context):super(context) {
		init()
	}

	constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
		this.mContext = context
		init()
	}

	private fun init() {
		(mContext.applicationContext as AppBase).createHomeComponent().inject(this)
		presenter.bind(this)

		val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		val inflatedView = inflater.inflate(R.layout.view_appdrawer, this, true)

		installedAppsList.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
	}

	override fun onAttachedToWindow() {
		super.onAttachedToWindow()
	}

	override fun displayInstalledAppsList(list: List<DomainApplicationInfo>) {
		installedAppsList.adapter = AppsListAdapter(mContext, list)
	}

	override fun onIconClick() {
	}

	override fun onDetachedFromWindow() {
		super.onDetachedFromWindow()
		dispose()
	}

	public fun dispose() {
		presenter.unbind()
		(mContext.applicationContext as AppBase).releaseHomeComponent()
	}
}

