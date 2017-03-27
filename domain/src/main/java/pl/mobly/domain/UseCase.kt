package pl.mobly.domain


import io.reactivex.Observable

abstract class UseCase<T, P> {
    abstract fun buildUseCase(params: P): Observable<T>
}
