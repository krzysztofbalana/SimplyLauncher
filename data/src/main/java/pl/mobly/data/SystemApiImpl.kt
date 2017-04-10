package pl.mobly.data

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.domain.SystemApi


class SystemApiImpl(private val packageManagerResource: PackageManagerResource) : SystemApi {

    override fun loadAppsList(): Observable<List<DomainApplicationInfo>> {
        return Observable.fromArray(
                AppInfoMapper
                        .mapToDomain(packageManagerResource.loadInstalledApps()))
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())

    }
}
