package pl.mobly.domain


import io.reactivex.Observable

class LoadInstalledAppsUseCase(private val systemApi: SystemApi) : NoParamUseCase<List<DomainApplicationInfo>> {

	override fun buildUseCase(): Observable<List<DomainApplicationInfo>> {
		return systemApi.loadAppsList()
	}
}
