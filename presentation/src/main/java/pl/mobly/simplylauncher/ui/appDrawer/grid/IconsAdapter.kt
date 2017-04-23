package pl.mobly.simplylauncher.ui.appDrawer.grid

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import pl.mobly.domain.DomainApplicationInfo


class IconsAdapter(val context: Context, val list:List<DomainApplicationInfo>) : BaseAdapter() {

	override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
		var imageView:ImageView
		if (p1 == null) {
			imageView = ImageView(context)
			imageView.layoutParams = LinearLayout.LayoutParams(85,85)
			imageView.scaleType = ImageView.ScaleType.CENTER_CROP
			imageView.setPadding(0,0,0,0)
		} else {
			imageView = p1 as ImageView
		}
		imageView.setImageResource(list.get(p0).icon)
		return imageView
	}

	override fun getItem(p0: Int): Any {
		return list.get(p0)
	}

	override fun getItemId(p0: Int): Long {
		return 0
	}

	override fun getCount(): Int {
		return list.size
	}
}