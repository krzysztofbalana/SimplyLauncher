package pl.mobly.simplylauncher.common

import android.view.View
import android.view.ViewGroup


fun View.makeVisible() {
    val visible: Int = View.VISIBLE

    when (this.visibility) {
        View.INVISIBLE -> this.visibility = visible
        View.GONE -> this.visibility = visible
    }

}

fun View.makeGone() {
    val gone: Int = View.GONE

    when (this.visibility) {
        View.VISIBLE -> this.visibility = gone
    }
}

fun ViewGroup.childList(): List<View> {
    var list = ArrayList<View>()
    for (i in 0..this.childCount - 1) {
        val childAt = this.getChildAt(i)
        list.add(childAt)
    }
    return list
}
