package pl.mobly.simplylauncher.ui.home

import pl.mobly.simplylauncher.ui.base.BaseView


interface HomePresenter<in V : BaseView> {
	fun bindView(view: V)
	fun unbindView()
	fun loadInstalledApps()
}