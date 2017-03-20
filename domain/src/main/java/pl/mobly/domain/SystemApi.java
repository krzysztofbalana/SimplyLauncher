package pl.mobly.domain;


import java.util.List;

import io.reactivex.Observable;

public interface SystemApi {

    Observable<List<DomainApplicationInfo>> loadAppsList();
}
