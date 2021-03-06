package pl.mobly.simplylauncher.common.views

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import pl.mobly.simplylauncher.R


class SimpleSwitcherItem : LinearLayout {
	private lateinit var attributeSet: AttributeSet
	private lateinit var view: View
	private lateinit var icon: ImageView
	private lateinit var caption:TextView
	var isActive = false

	constructor(context: Context?) : super(context) {
		init()
	}

	constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet) {
		this.attributeSet = attributeSet
		init()
	}

	private fun init() {
		val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		view = layoutInflater.inflate(R.layout.view_simple_switcher_item, this, true)
		icon = view.findViewById(R.id.simple_switcher_item_icon) as ImageView
		caption = view.findViewById(R.id.simple_switcher_item_caption) as TextView

		val obtainedAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleSwitcherItem)
		val caption = obtainedAttributes.getString(R.styleable.SimpleSwitcherItem_caption)
		val iconId = obtainedAttributes.getResourceId(R.styleable.SimpleSwitcherItem_icon, 0)

		if (!caption.isNullOrEmpty()) {
			setCaption(caption)
		}

		if (iconId != 0) {
			setIcon(iconId)
		}

		obtainedAttributes.recycle()
	}

	fun setIcon(iconDrawable:Int) {
		icon.setBackgroundResource(iconDrawable)
		makeVisible(icon)
	}

	fun setIconColor(color:Int) {
		val background = icon.background
		background.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
		icon.setBackgroundDrawable(background)
	}

	fun activate() {
		isActive = true
	}

	fun unselect() {
        val drawable = ContextCompat.getDrawable(context, R.drawable.bg_transparent)
		view.setBackgroundDrawable(drawable)
		isActive = false
	}

	fun setCaption(caption:String) {
		this.caption.text = caption
		makeVisible(this.caption)
	}

	private fun makeVisible(view: View) {
		if ( view.visibility == View.GONE || view.visibility == View.INVISIBLE) {
			view.visibility = View.VISIBLE
		}
	}

    fun highlight() {
        val drawable = ContextCompat.getDrawable(context, R.drawable.bg_oval)
        view.setBackgroundDrawable(drawable)
    }

}