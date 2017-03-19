package pl.mobly.simplylauncher.common.components;

import javax.inject.Singleton;

import dagger.Component;
import pl.mobly.simplylauncher.HomeActivity;
import pl.mobly.simplylauncher.common.components.modules.AppModule;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(HomeActivity target);
}
