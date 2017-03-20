package pl.mobly.domain.interactors;


import java.util.List;

import io.reactivex.Observable;
import pl.mobly.domain.DomainApplicationInfo;
import pl.mobly.domain.LoadInstalledAppsUseCase;

public class SystemInfoInteractorImpl implements SystemInfoInteractor {
    private LoadInstalledAppsUseCase loadInstalledAppsUseCase;

    public SystemInfoInteractorImpl(LoadInstalledAppsUseCase loadInstalledAppsUseCase) {
        this.loadInstalledAppsUseCase = loadInstalledAppsUseCase;
    }

    @Override
    public Observable<List<DomainApplicationInfo>> loadAppsList() {
        return loadInstalledAppsUseCase.buildUseCase(null);
    }
}
