package pl.mobly.simplylauncher.common.components.modules

import android.app.Application
import android.content.pm.PackageManager
import dagger.Module
import dagger.Provides
import pl.mobly.data.PackageManagerResource
import pl.mobly.data.SystemApiImpl
import javax.inject.Singleton


@Module class DataModule(private val application: Application) {

    @Provides
    @Singleton
    fun providePackageManagerResource(packageManager: PackageManager) : PackageManagerResource {
        return PackageManagerResource(packageManager)
    }

    @Provides
    @Singleton
    fun provideSystemApi(packageManagerResource: PackageManagerResource) : SystemApiImpl {
        return SystemApiImpl(packageManagerResource)
    }
}