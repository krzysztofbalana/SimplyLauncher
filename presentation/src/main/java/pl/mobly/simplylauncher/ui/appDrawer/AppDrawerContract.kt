package pl.mobly.simplylauncher.ui.appDrawer


interface AppDrawerContract {

    interface View {
        fun showList()
        fun showGrid()
        fun highlightSwitch(switchNumber:Int)
    }

    interface Presenter {
        fun onSwitcherTapped(position:Int)
    }
}