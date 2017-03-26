package pl.mobly.simplylauncher.common.components.modules

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class AppModule(private val application: Application) {

    @Provides
    fun provideAppContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun providePackageManager(context: Context) : PackageManager {
        return context.packageManager
    }

}
