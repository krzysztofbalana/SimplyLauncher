package pl.mobly.domain


import io.reactivex.Observable

interface ParamUseCase<T, P> {
    fun buildUseCase(params: P): Observable<T>
}

