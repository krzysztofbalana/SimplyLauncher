package pl.mobly.simplylauncher.common.components

import dagger.Component
import pl.mobly.simplylauncher.common.components.modules.AppModule
import pl.mobly.simplylauncher.common.components.modules.DataModule
import pl.mobly.simplylauncher.common.components.modules.DomainModule
import pl.mobly.simplylauncher.ui.home.HomeComponent
import pl.mobly.simplylauncher.ui.home.HomeModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class, DomainModule::class))
interface AppComponent {
    fun plus(homeModule: HomeModule): HomeComponent
}
