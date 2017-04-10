package pl.mobly.simplylauncher.ui.home

import pl.mobly.simplylauncher.ui.base.BaseView


interface HomeView:BaseView {
    fun showDrawer()
    fun hideDrawer()
}