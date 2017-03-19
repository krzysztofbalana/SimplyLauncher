package pl.mobly.domain;


import io.reactivex.Observable;

public abstract class UseCase<T, P> {
    public abstract Observable<T> buildUseCase(P params);
}
