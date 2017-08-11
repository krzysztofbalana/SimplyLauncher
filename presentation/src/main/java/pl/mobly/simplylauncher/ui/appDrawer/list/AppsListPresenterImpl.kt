package pl.mobly.simplylauncher.ui.appDrawer.list

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import pl.mobly.domain.interactors.SystemInfoInteractorImpl
import pl.mobly.simplylauncher.ui.appDrawer.list.AppsListContract.Presenter
import pl.mobly.simplylauncher.ui.base.BasePresenter


class AppsListPresenterImpl(private val systemInfoInteractor: SystemInfoInteractorImpl) : BasePresenter<AppsListView>(), Presenter {
	private lateinit var disposable: Disposable

	override fun bind(view: AppsListView) {
		super.bind(view)
		getInstalledApps()
	}

	override fun getInstalledApps() {
		disposable = systemInfoInteractor.loadAppsList().observeOn(AndroidSchedulers.mainThread()).subscribe(
				{appsList ->
					view.get()?.displayInstalledAppsList(appsList)
				},
				Throwable::printStackTrace
		)
	}

}