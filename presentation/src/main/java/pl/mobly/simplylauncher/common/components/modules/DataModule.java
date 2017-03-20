package pl.mobly.simplylauncher.common.components.modules;

import android.app.Application;
import android.content.Context;

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
    PackageManagerResource providePackageManagerResource(Context context) {
        return new PackageManagerResource(context);
    }

    @Provides
    SystemApiImpl providesSystemApi(PackageManagerResource packageManagerResource) {
    return new SystemApiImpl(packageManagerResource);
    }
}
