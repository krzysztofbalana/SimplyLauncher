package pl.mobly.domain;



import java.util.List;

import io.reactivex.Observable;

public class LoadInstalledAppsUseCase extends UseCase<List<DomainApplicationInfo>, Void> {
    private SystemApi systemApi;

    public LoadInstalledAppsUseCase(SystemApi systemApi) {
        this.systemApi = systemApi;
    }

    @Override
    public Observable<List<DomainApplicationInfo>> buildUseCase(Void params) {
        return systemApi.loadAppsList();
    }
}
