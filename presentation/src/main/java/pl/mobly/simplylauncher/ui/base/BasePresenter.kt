package pl.mobly.simplylauncher.ui.base

import java.lang.ref.WeakReference


open abstract class BasePresenter<V> {

    open lateinit var view:WeakReference<V>

    open fun bind(view: V) {
        this.view = WeakReference(view)
    }

    open fun unbind() {
        this.view.clear()
    }
}