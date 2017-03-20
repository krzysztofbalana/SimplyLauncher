package pl.mobly.data;


import android.content.pm.ApplicationInfo;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import pl.mobly.domain.DomainApplicationInfo;
import pl.mobly.domain.SystemApi;

import static android.content.ContentValues.TAG;

public class SystemApiImpl implements SystemApi {
    private PackageManagerResource packageManagerResource;

    public SystemApiImpl(PackageManagerResource packageManagerResource) {

        this.packageManagerResource = packageManagerResource;
    }

    @Override
    public Observable<List<DomainApplicationInfo>> loadAppsList() {
        Observable.fromArray(
                AppInfoMapper
                        .mapToDomain(packageManagerResource.loadInstalledApps()))
                .doOnComplete(() -> {})
                .doOnNext(domainApplicationInfos -> {
                    Log.i(TAG, "loadAppsList: " + domainApplicationInfos.toString());
                }).subscribe();
        return null;
    }
}
