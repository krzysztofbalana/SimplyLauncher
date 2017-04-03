package pl.mobly.simplylauncher.ui.home

import pl.mobly.domain.interactors.SystemInfoInteractorImpl
import java.lang.ref.WeakReference


class HomePresenterImpl(private val systemInfoInteractor: SystemInfoInteractorImpl) : HomePresenter<HomeActivity> {

	override fun loadInstalledApps() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	lateinit var view: WeakReference<HomeActivity>

	override fun bindView(view: HomeActivity) {
		this.view = WeakReference(view)
		loadInstalledApps()

	}

	override fun unbindView() {
		view.clear()
	}
}