package pl.mobly.simplylauncher.common.components

import javax.inject.Singleton

import dagger.Component
import pl.mobly.simplylauncher.HomeActivity
import pl.mobly.simplylauncher.common.components.modules.AppModule

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(target: HomeActivity)
}
