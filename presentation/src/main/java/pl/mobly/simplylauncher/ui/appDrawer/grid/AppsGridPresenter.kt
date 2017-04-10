package pl.mobly.simplylauncher.ui.appDrawer.grid

import pl.mobly.simplylauncher.ui.base.BasePresenter


class AppsGridPresenter : BasePresenter<AppsGridView>(), AppsGridContract.Presenter {

	override fun bind(view: AppsGridView) {
		super.bind(view)
		getInstalledApps()
	}

	private fun getInstalledApps() {
	}
}