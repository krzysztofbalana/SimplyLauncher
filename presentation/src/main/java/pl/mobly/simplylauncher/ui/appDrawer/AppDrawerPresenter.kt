package pl.mobly.simplylauncher.ui.appDrawer

import pl.mobly.simplylauncher.ui.base.BasePresenter


class AppDrawerPresenter : BasePresenter<AppDrawerContract.View>(), AppDrawerContract.Presenter {
    companion object {
        val DEFAULT_APP_DRAWER_PRESENTATION_MODE = 2
    }

    override fun bind(view: AppDrawerContract.View) {
        super.bind(view)
        activateSwitchFor(DEFAULT_APP_DRAWER_PRESENTATION_MODE)
    }

    override fun onSwitcherTapped(position: Int) {
        activateSwitchFor(position)
    }

    private fun activateSwitchFor(int: Int) {
        when (int) {
            1 -> {
                view.get()?.showList()
                highlightProperSwitch(1)
            }
            2 -> {
                view.get()?.showGrid()
                highlightProperSwitch(2)
            }
        }
    }

    private fun highlightProperSwitch(switchNumber: Int) {
        view.get()?.highlightSwitch(switchNumber)
    }
}