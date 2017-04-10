package pl.mobly.simplylauncher.ui.appDrawer.grid

import android.content.Context
import android.util.AttributeSet
import android.widget.GridView
import pl.mobly.domain.DomainApplicationInfo
import javax.inject.Inject


class AppsGridView : GridView, AppsGridContract.View {
	private val mContext:Context
	@Inject lateinit var appsGridPresenter:AppsGridPresenter

	constructor(context: Context?, mContext: Context) : super(context) {
		this.mContext = mContext
	}

	constructor(context: Context?, attrs: AttributeSet?, mContext: Context) : super(context, attrs) {
		this.mContext = mContext
		init(context, attrs)
	}

	private fun init(context: Context?, attrs: AttributeSet?) {
	}


	public fun dispose() {
	}

	override fun displayAppsGrid(list: List<DomainApplicationInfo>) {
	}

	override fun onIconClick() {
	}
}