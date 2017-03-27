package pl.mobly.data


import android.content.pm.ApplicationInfo
import android.util.Log

import io.reactivex.Observable
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.domain.SystemApi

import android.content.ContentValues.TAG

class SystemApiImpl(private val packageManagerResource: PackageManagerResource) : SystemApi {

    override fun loadAppsList(): Observable<List<DomainApplicationInfo>> {
        return Observable.fromArray(
                AppInfoMapper
                        .mapToDomain(packageManagerResource.loadInstalledApps()))

    }
}
