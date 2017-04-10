package pl.mobly.simplylauncher.ui.home

import dagger.Subcomponent
import pl.mobly.simplylauncher.ui.appDrawer.AppDrawerViewImpl

@HomeScope
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(appDrawerView: AppDrawerViewImpl)
}