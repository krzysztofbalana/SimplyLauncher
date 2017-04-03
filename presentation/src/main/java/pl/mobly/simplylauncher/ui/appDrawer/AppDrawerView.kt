package pl.mobly.simplylauncher.ui.appDrawer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import pl.mobly.simplylauncher.R


class AppDrawerView : LinearLayout {

	lateinit private var mContext: Context

	constructor(context: Context) : super(context)

	constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
		this.mContext = context
		init()
	}

	private fun init() {
		LayoutInflater.from(mContext).inflate(R.layout.kotlin_appdrawer, this, true)
	}


}

