package pl.mobly.data;


import java.util.List;

import io.reactivex.Observable;
import pl.mobly.domain.SystemApi;

public class SystemApiImpl implements SystemApi {
    
    @Override
    public Observable<List> loadAppsList() {
        return null;
    }
}
