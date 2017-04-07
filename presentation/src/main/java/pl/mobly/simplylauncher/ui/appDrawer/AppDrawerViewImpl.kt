package pl.mobly.simplylauncher.ui.appDrawer

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.simplylauncher.R
import pl.mobly.simplylauncher.common.AppBase
import javax.inject.Inject


class AppDrawerViewImpl : LinearLayout, AppDrawerContract.View {

	lateinit private var mContext: Context
	lateinit private var recyclerView: RecyclerView
	@Inject lateinit var presenter:AppDrawerPresenterImpl

	constructor(context: Context) : super(context)

	constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
		this.mContext = context
		init()
	}

	private fun init() {
		LayoutInflater.from(mContext).inflate(R.layout.kotlin_appdrawer, this, true)

		recyclerView = RecyclerView(mContext)
		recyclerView.layoutManager = LinearLayoutManager(mContext)

		(mContext.applicationContext as AppBase).createHomeComponent().inject(this)

		presenter.bind(this)

	}

	override fun onAttachedToWindow() {
		super.onAttachedToWindow()
	}

	override fun displayInstalledAppsList(list:List<DomainApplicationInfo>) {
		recyclerView.adapter = AppsListAdapter(mContext, list)
		recyclerView.adapter.notifyDataSetChanged()
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

