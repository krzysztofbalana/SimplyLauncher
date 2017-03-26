package pl.mobly.simplylauncher.common


import android.app.Application

import pl.mobly.simplylauncher.common.components.AppComponent
import pl.mobly.simplylauncher.common.components.DaggerAppComponent
import pl.mobly.simplylauncher.common.components.modules.AppModule

class AppBase : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}
