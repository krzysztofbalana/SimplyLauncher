package pl.mobly.domain.interactors;


import java.util.List;

import io.reactivex.Observable;
import pl.mobly.domain.DomainApplicationInfo;

public interface SystemInfoInteractor {
    Observable<List<DomainApplicationInfo>> loadAppsList();
}
