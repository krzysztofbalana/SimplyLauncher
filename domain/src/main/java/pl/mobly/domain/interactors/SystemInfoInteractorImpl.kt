package pl.mobly.domain.interactors


import io.reactivex.Observable
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.domain.LoadInstalledAppsUseCase

class SystemInfoInteractorImpl(private val loadInstalledAppsUseCase: LoadInstalledAppsUseCase) : SystemInfoInteractor {

    override fun loadAppsList(): Observable<List<DomainApplicationInfo>> {
        return loadInstalledAppsUseCase.buildUseCase(null)
    }
}
