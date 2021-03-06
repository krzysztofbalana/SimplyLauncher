package pl.mobly.simplylauncher.ui.appDrawer.list

import pl.mobly.domain.DomainApplicationInfo


interface AppsListContract {

	interface View {
		fun displayInstalledAppsList(list: List<DomainApplicationInfo>)
		fun onItemClick()
	}

	interface Presenter {
		fun getInstalledApps()
	}

}