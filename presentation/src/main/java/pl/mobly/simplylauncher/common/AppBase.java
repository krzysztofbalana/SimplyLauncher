package pl.mobly.simplylauncher.common;


import android.app.Application;

import pl.mobly.simplylauncher.common.components.AppComponent;
import pl.mobly.simplylauncher.common.components.DaggerAppComponent;
import pl.mobly.simplylauncher.common.components.modules.AppModule;
import pl.mobly.simplylauncher.common.components.modules.DataModule;
import pl.mobly.simplylauncher.common.components.modules.DomainModule;

public class AppBase extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule(this))
                .domainModule(new DomainModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
