package pl.mobly.simplylauncher.common.components.modules;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context provideAppContext() {
        return application;
    }

    @Provides
    @Singleton
    public PackageManager providePackageManager(Context context) {
        return context.getPackageManager();
    }

}
