package pl.mobly.simplylauncher.common.components.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import pl.mobly.data.SystemApiImpl
import pl.mobly.domain.LoadInstalledAppsUseCase
import pl.mobly.domain.interactors.SystemInfoInteractorImpl


@Module class DomainModule(private val application: Application) {

    @Module class DomainModule(application: Application)

    @Provides
    fun provideLoadInstalledAppsUseCase(systemApiImpl: SystemApiImpl): LoadInstalledAppsUseCase {
        return LoadInstalledAppsUseCase(systemApiImpl)
    }

    @Provides
    fun provideSystemIfoInteractorImpl(loadInstalledAppsUseCase: LoadInstalledAppsUseCase): SystemInfoInteractorImpl {
        return SystemInfoInteractorImpl(loadInstalledAppsUseCase)
    }
}
