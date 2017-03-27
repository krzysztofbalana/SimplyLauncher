package pl.mobly.domain


import io.reactivex.Observable

class LoadInstalledAppsUseCase(private val systemApi: SystemApi) : UseCase<List<DomainApplicationInfo>, Void>() {

    override fun buildUseCase(params: Void): Observable<List<DomainApplicationInfo>> {
        return systemApi.loadAppsList()
    }
}
