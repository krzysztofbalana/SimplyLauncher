package pl.mobly.domain


import io.reactivex.Observable

abstract class SystemApi {

    abstract fun loadAppsList(): Observable<List<DomainApplicationInfo>>
}
