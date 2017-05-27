package pl.mobly.simplylauncher.ui.appDrawer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscription
import pl.mobly.simplylauncher.R
import pl.mobly.simplylauncher.common.views.SimpleSwitcher

class AppDrawer : LinearLayout {
	lateinit var disposable:Disposable
	lateinit var subscription:Subscription

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

		val view1 = view.findViewById(R.id.switcher) as SimpleSwitcher

		disposable = view1.listenToClicks()
				.doOnNext { i -> makeToast(i) }
				.doOnComplete {  }
				.subscribe()
	}


	private fun makeToast(t: Int?) {
		Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
	}

}