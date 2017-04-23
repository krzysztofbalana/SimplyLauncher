package pl.mobly.simplylauncher.ui.appDrawer.grid

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.simplylauncher.R
import pl.mobly.simplylauncher.common.AppBase
import javax.inject.Inject


class AppsGridView : LinearLayout, AppsGridContract.View {
	@Inject lateinit var presenter:AppsGridPresenter

	constructor(context: Context?) : super(context) {
		init()
	}

	constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
		init()
	}

	private fun init() {
		(context.applicationContext as AppBase).createHomeComponent().inject(this)
		val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		layoutInflater.inflate(R.layout.view_grid_list, this, true)
		presenter.bind(this)
	}

	override fun onDetachedFromWindow() {
		super.onDetachedFromWindow()
		dispose()
	}

	fun dispose() {
		presenter.unbind()
		(context.applicationContext as AppBase).releaseHomeComponent()
	}

	override fun displayAppsGrid(list: List<DomainApplicationInfo>) {
	}

	override fun onIconClick() {
	}
}