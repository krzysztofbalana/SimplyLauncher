package pl.mobly.simplylauncher.common.components;

import javax.inject.Singleton;

import dagger.Component;
import pl.mobly.simplylauncher.HomeActivity;
import pl.mobly.simplylauncher.common.components.modules.AppModule;
import pl.mobly.simplylauncher.common.components.modules.DataModule;
import pl.mobly.simplylauncher.common.components.modules.DomainModule;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, DomainModule.class})
public interface AppComponent {
    void inject(HomeActivity target);
}
