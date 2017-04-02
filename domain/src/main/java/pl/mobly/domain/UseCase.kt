package pl.mobly.domain


import io.reactivex.Observable

interface UseCase<T, P> {
    fun buildUseCase(params: P): Observable<T>
}
