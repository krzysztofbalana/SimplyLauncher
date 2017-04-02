package pl.mobly.domain


import io.reactivex.Observable

interface SystemApi {

    fun loadAppsList(): Observable<List<DomainApplicationInfo>>
}
