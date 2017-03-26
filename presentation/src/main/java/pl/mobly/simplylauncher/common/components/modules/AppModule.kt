package pl.mobly.simplylauncher.common.components.modules

import android.app.Application
import android.content.Context

import dagger.Module
import dagger.Provides

@Module class AppModule(private val application: Application) {

    @Provides
    fun provideAppContext(): Context {
        return application
    }
}
