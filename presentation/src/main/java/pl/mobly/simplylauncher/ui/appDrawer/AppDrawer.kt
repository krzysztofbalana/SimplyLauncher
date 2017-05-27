package pl.mobly.simplylauncher.ui.appDrawer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import pl.mobly.simplylauncher.R

class AppDrawer : LinearLayout {

	constructor(context: Context) : super(context) {
		init()
	}

	constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
		init()
	}

	constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
		init()
	}

	constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)


	private fun init() {
		val layoutInflater = LayoutInflater.from(context)
		val view = layoutInflater.inflate(R.layout.app_drawer, this, true) as LinearLayout
		view.orientation = LinearLayout.VERTICAL
	}


}