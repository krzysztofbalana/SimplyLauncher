package pl.mobly.simplylauncher.common.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import io.reactivex.Observable
import pl.mobly.simplylauncher.R


class SimpleSwitcher : LinearLayout {
	private lateinit var viewGroup: LinearLayout
	private lateinit var viewsCollection: MutableList<View>

	constructor(context: Context) : super(context) {
		init()
	}

	constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
		init()
	}

	private fun init() {
		val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		viewGroup = layoutInflater.inflate(R.layout.view_simple_switcher, this, true) as LinearLayout
	}

	fun addItem(caption: String) {
		val item = createItemViewWith(caption)
		viewGroup.addView(item)
		invalidate()
	}

	private fun createItemViewWith(caption: String): LinearLayout {
		val item = View.inflate(context, R.layout.view_simple_switcher_item, null) as LinearLayout
		val textView = item.findViewById(R.id.simple_switcher_item_caption) as TextView
		textView.text = caption

		return item
	}

	fun listenToClicks(): Observable<Int> {
		return Observable.create { subscrirber ->
			for (view in viewGroup.getChildList()) {
				view.setOnClickListener { view -> subscrirber.onNext(viewGroup.indexOfChild(view)) }
			}
	}
	}

	fun ViewGroup.getChildList(): List<View> {
		var list = ArrayList<View>()
		for (i in 0..this.childCount - 1) {
			val childAt = this.getChildAt(i) as View
			list.add(childAt)
		}
		return list
	}

}