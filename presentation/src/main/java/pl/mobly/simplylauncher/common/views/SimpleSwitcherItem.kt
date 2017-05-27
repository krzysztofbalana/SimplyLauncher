package pl.mobly.simplylauncher.common.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import pl.mobly.simplylauncher.R


class SimpleSwitcherItem : LinearLayout {
	private lateinit var attributeSet:AttributeSet

	private lateinit var icon: ImageView
	private lateinit var caption:TextView

	constructor(context: Context?) : super(context) {
		init()
	}

	constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet) {
		this.attributeSet = attributeSet
		init()
	}

	private fun init() {
		val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		val view = layoutInflater.inflate(R.layout.view_simple_switcher_item, this, true)
		icon = view.findViewById(R.id.simple_switcher_item_icon) as ImageView
		caption = view.findViewById(R.id.simple_switcher_item_caption) as TextView

		val obtainedAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleSwitcherItem)
		val caption = obtainedAttributes.getString(R.styleable.SimpleSwitcherItem_caption)

		setCaption(caption)

		obtainedAttributes.recycle()
	}

	fun setIcon(iconDrawable:Drawable) {
		this.icon.setBackgroundDrawable(iconDrawable)
	}

	fun setCaption(caption:String) {
		this.caption.text = caption
	}

}