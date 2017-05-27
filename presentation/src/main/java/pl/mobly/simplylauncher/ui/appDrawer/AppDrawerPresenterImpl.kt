package pl.mobly.simplylauncher.ui.appDrawer

import pl.mobly.simplylauncher.ui.base.BasePresenter


class AppDrawerPresenterImpl: BasePresenter<AppDrawerView>(), AppDrawerPresenter {

	override fun bind(view: AppDrawerView) {
		super.bind(view)
		view.showGrid()
	}

	override fun unbind() {
		super.unbind()
	}

	override fun onSwitcherTapped(position: Int?) {
		when (position) {
			1 -> view.get()?.showList()
			2 -> view.get()?.showGrid()
		}
	}
}