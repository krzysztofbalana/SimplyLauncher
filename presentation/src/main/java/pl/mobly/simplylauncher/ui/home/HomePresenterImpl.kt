package pl.mobly.simplylauncher.ui.home

import pl.mobly.domain.interactors.SystemInfoInteractorImpl
import java.lang.ref.WeakReference


class HomePresenterImpl(private val systemInfoInteractor: SystemInfoInteractorImpl) : HomePresenter<HomeActivity> {


	lateinit var view: WeakReference<HomeActivity>

	override fun bindView(view: HomeActivity) {
		this.view = WeakReference(view)
	}

	override fun unbindView() {
		view.clear()
	}
}