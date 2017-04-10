package pl.mobly.domain

import io.reactivex.Observable


interface NoParamUseCase<T> {

	fun buildUseCase():Observable<T>
}