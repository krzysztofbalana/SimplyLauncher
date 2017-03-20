package pl.mobly.simplylauncher.common.components.modules;


import android.app.Application;

import dagger.Module;
import dagger.Provides;
import pl.mobly.data.SystemApiImpl;
import pl.mobly.domain.LoadInstalledAppsUseCase;
import pl.mobly.domain.SystemApi;
import pl.mobly.domain.interactors.SystemInfoInteractorImpl;

@Module
public class DomainModule {
    private Application application;

    public DomainModule(Application application) {
        this.application = application;
    }

    @Provides
    LoadInstalledAppsUseCase provideLoadInstalledAppsUseCase(SystemApiImpl systemApi) {
        return new LoadInstalledAppsUseCase(systemApi);
    }

    @Provides
    SystemInfoInteractorImpl provideSystemInfoInteractor(LoadInstalledAppsUseCase loadInstalledAppsUseCase) {
        return new SystemInfoInteractorImpl(loadInstalledAppsUseCase);
    }
}
