package pl.mobly.simplylauncher.ui.home

import dagger.Subcomponent
import pl.mobly.simplylauncher.ui.appDrawer.AppDrawer
import pl.mobly.simplylauncher.ui.appDrawer.grid.AppsGridView
import pl.mobly.simplylauncher.ui.appDrawer.list.AppsListView

@HomeScope
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(appsListView: AppsListView)
    fun inject(appsGridView: AppsGridView)
    fun inject(appDrawer: AppDrawer)
}