package pl.mobly.simplylauncher.ui.appDrawer

import io.reactivex.disposables.Disposable
import pl.mobly.domain.interactors.SystemInfoInteractorImpl
import java.lang.ref.WeakReference


class AppDrawerPresenterImpl(private val systemInfoInteractor: SystemInfoInteractorImpl) : AppDrawerContract.Presenter<AppDrawerViewImpl> {
	private lateinit var viewCaptor: WeakReference<AppDrawerViewImpl>
	private lateinit var disposable: Disposable

	override fun bind(view: AppDrawerViewImpl) {
		viewCaptor = WeakReference(view)
		getInstalledApps();
	}

	private fun getInstalledApps() {
		disposable = systemInfoInteractor.loadAppsList().subscribe(
				{appsList ->
					viewCaptor.get()?.displayInstalledAppsList(appsList)
				},
				{ error->

				}
		)
	}

	override fun unbind() {
		viewCaptor.clear()
	}


}