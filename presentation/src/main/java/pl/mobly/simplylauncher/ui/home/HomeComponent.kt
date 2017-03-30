package pl.mobly.simplylauncher.ui.home

import dagger.Subcomponent

@HomeScope
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}