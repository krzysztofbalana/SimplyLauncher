package pl.mobly.simplylauncher.ui.home

import android.app.Application
import dagger.Module
import dagger.Provides
import pl.mobly.domain.interactors.SystemInfoInteractorImpl
import pl.mobly.simplylauncher.ui.appDrawer.AppDrawerPresenter
import pl.mobly.simplylauncher.ui.appDrawer.grid.AppsGridPresenter
import pl.mobly.simplylauncher.ui.appDrawer.list.AppsListPresenterImpl

@Module
open class HomeModule(private val application: Application) {

    @Provides
    @HomeScope
    fun provideHomePresenter(systemInfoInteractor: SystemInfoInteractorImpl):HomePresenterImpl {
        return HomePresenterImpl(systemInfoInteractor)
    }

    @Provides
    @HomeScope
    fun provideAppListPresenter(systemInfoInteractor: SystemInfoInteractorImpl): AppsListPresenterImpl {
        return AppsListPresenterImpl(systemInfoInteractor)
    }

    @Provides
    @HomeScope
    fun provideGridLisPresenter(systemInfoInteractor: SystemInfoInteractorImpl):AppsGridPresenter {
        return AppsGridPresenter(systemInfoInteractor)
    }

    @Provides
    @HomeScope
    fun provideAppDrawerPresneter(): AppDrawerPresenter {
        return AppDrawerPresenter()
    }

}