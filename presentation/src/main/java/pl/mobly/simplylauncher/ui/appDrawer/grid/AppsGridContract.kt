package pl.mobly.simplylauncher.ui.appDrawer.grid

import pl.mobly.domain.DomainApplicationInfo


interface AppsGridContract {

	interface View {
		fun displayAppsGrid(list: List<DomainApplicationInfo>)
		fun onItemClick()
	}

	interface Presenter {
		fun getInstalledApps()
	}
}