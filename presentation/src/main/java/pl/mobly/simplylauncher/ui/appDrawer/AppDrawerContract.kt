package pl.mobly.simplylauncher.ui.appDrawer

import pl.mobly.domain.DomainApplicationInfo


interface AppDrawerContract {

	interface View {
		fun displayInstalledAppsList(list: List<DomainApplicationInfo>)
		fun onIconClick()
	}

	interface Presenter<V: android.view.View> {
		fun bind(view:V)
		fun unbind()
	}

}