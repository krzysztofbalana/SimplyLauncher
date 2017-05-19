package pl.mobly.simplylauncher.ui.appDrawer.grid

import pl.mobly.domain.DomainApplicationInfo


interface AppsGridContract {

	interface View {
		fun displayAppsGrid(list: List<DomainApplicationInfo>)
	}

	interface Presenter {
		fun getInstalledApps()
		fun onItemSelected(it: String)
	}
}