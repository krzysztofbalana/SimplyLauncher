package pl.mobly.data



import io.reactivex.Observable
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.domain.SystemApi


class SystemApiImpl(private val packageManagerResource: PackageManagerResource) : SystemApi() {

    override fun loadAppsList(): Observable<List<DomainApplicationInfo>> {
        return Observable.fromArray(
                AppInfoMapper
                        .mapToDomain(packageManagerResource.loadInstalledApps()))

    }
}
