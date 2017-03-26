package pl.mobly.simplylauncher.common.components

import dagger.Component
import pl.mobly.simplylauncher.HomeActivity
import pl.mobly.simplylauncher.common.components.modules.AppModule
import pl.mobly.simplylauncher.common.components.modules.DataModule
import pl.mobly.simplylauncher.common.components.modules.DomainModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class, DomainModule::class))
interface AppComponent {
    fun inject(target: HomeActivity)
}
