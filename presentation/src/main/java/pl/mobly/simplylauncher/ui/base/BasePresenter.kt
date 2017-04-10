package pl.mobly.simplylauncher.ui.base


interface BasePresenter<V> {
    fun bind(view: V)
    fun unbind()
}