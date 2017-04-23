package pl.mobly.simplylauncher.ui.appDrawer.grid

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.domain.interactors.SystemInfoInteractorImpl
import pl.mobly.simplylauncher.ui.base.BasePresenter


class AppsGridPresenter(val systemInfoInteractor: SystemInfoInteractorImpl) : BasePresenter<AppsGridView>(), AppsGridContract.Presenter {
	private lateinit var disposable: Disposable

	override fun bind(view: AppsGridView) {
		super.bind(view)
		getInstalledApps()
	}

	private fun getInstalledApps() {
		disposable = systemInfoInteractor.loadAppsList()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe({ arrayListOf<DomainApplicationInfo>()})
	}
}