package pl.mobly.simplylauncher.common


import android.app.Application

import pl.mobly.simplylauncher.common.components.AppComponent
import pl.mobly.simplylauncher.common.components.DaggerAppComponent
import pl.mobly.simplylauncher.common.components.modules.AppModule
import pl.mobly.simplylauncher.common.components.modules.DataModule
import pl.mobly.simplylauncher.common.components.modules.DomainModule

class AppBase : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .dataModule(DataModule(this))
                .domainModule(DomainModule(this))
                .build()
    }
}

