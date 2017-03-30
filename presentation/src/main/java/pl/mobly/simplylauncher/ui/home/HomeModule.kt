package pl.mobly.simplylauncher.ui.home

import android.app.Application
import dagger.Module
import dagger.Provides
import pl.mobly.domain.interactors.SystemInfoInteractorImpl

@Module
open class HomeModule(private val application: Application) {

    @Provides
    @HomeScope
    fun provideHomePresenter(systemInfoInteractor: SystemInfoInteractorImpl):HomePresenter {
        return HomePresenterImpl(systemInfoInteractor)
    }
}