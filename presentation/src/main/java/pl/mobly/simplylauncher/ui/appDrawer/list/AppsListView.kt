package pl.mobly.simplylauncher.ui.appDrawer.list

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


class AppsListView : LinearLayout, AppsListContract.View {

	@Inject lateinit var presenterList: AppsListPresenterImpl

	constructor(context: Context):super(context) {
		init()
	}

	constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
		init()
	}

	private fun init() {
		(context.applicationContext as AppBase).createHomeComponent().inject(this)
		presenterList.bind(this)

		val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		val inflatedView = inflater.inflate(R.layout.view_appdrawer, this, true)

		installedAppsList.layoutManager = LinearLayoutManager(context, VERTICAL, false)
	}

	override fun onAttachedToWindow() {
		super.onAttachedToWindow()
	}

	override fun displayInstalledAppsList(list: List<DomainApplicationInfo>) {
		installedAppsList.adapter = AppsListAdapter(context, list)
	}

	override fun onIconClick() {
	}

	override fun onDetachedFromWindow() {
		super.onDetachedFromWindow()
		dispose()
	}

	public fun dispose() {
		presenterList.unbind()
		(context.applicationContext as AppBase).releaseHomeComponent()
	}
}

