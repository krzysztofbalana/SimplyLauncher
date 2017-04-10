package pl.mobly.domain.interactors


import io.reactivex.Observable
import pl.mobly.domain.DomainApplicationInfo

interface SystemInfoInteractor {
    fun loadAppsList(): Observable<List<DomainApplicationInfo>>
}
