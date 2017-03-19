package pl.mobly.simplylauncher.common;


import android.app.Application;

import pl.mobly.simplylauncher.common.components.AppComponent;
import pl.mobly.simplylauncher.common.components.DaggerAppComponent;
import pl.mobly.simplylauncher.common.components.modules.AppModule;

public class AppBase extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
