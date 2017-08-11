package pl.mobly.simplylauncher.common.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import io.reactivex.Observable
import pl.mobly.simplylauncher.R
import pl.mobly.simplylauncher.common.childList


class SimpleSwitcher : LinearLayout {
    private lateinit var rootView: LinearLayout
    private lateinit var viewsCollection: MutableList<View>

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }

    private fun init() {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        rootView = layoutInflater.inflate(R.layout.view_simple_switcher, this, true) as LinearLayout
    }

    fun addItem(caption: String) {
        val item = createItemViewWith(caption)
        rootView.addView(item)
        invalidate()
    }

    private fun createItemViewWith(caption: String): LinearLayout {
        val item = View.inflate(context, R.layout.view_simple_switcher_item, null) as LinearLayout
        val textView = item.findViewById(R.id.simple_switcher_item_caption) as TextView
        textView.text = caption

        return item
    }

    fun listenToClicks(): Observable<Int> {
        return Observable.create { subscriber ->
            for (view in rootView.childList()) {
                view.setOnClickListener { view ->
                    subscriber.onNext(rootView.indexOfChild(view))
                    view as SimpleSwitcherItem
                    view.activate()
                }
            }
        }
    }

    private fun unselectAll() {
        rootView.childList()
                .forEach {
                    when (it) {
                        is SimpleSwitcherItem -> {
                            it.unselect()
                        }
                    }
                }
    }


    fun highlight(index: Int) {
        unselectAll()
        val view = rootView.getChildAt(index)
        when (view) {
            is SimpleSwitcherItem -> {
                view.highlight()
            }
        }
    }

}