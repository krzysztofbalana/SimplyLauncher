package pl.mobly.simplylauncher.common.components.modules;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;

import dagger.Module;
import dagger.Provides;
import pl.mobly.data.PackageManagerResource;
import pl.mobly.data.SystemApiImpl;

@Module
public class DataModule {
    private Application application;

    public DataModule(Application application) {
        this.application = application;
    }

    @Provides
    PackageManagerResource providePackageManagerResource(PackageManager packageManager) {
        return new PackageManagerResource(packageManager);
    }

    @Provides
    SystemApiImpl providesSystemApi(PackageManagerResource packageManagerResource) {
    return new SystemApiImpl(packageManagerResource);
    }
}
