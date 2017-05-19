package pl.mobly.simplylauncher.ui.appDrawer.grid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.simplylauncher.R


class IconsAdapter(val context: Context, val list:List<DomainApplicationInfo>, val listener: (String) -> Unit) : BaseAdapter() {

	override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
		val gridItemElement = LayoutInflater.from(context).inflate(R.layout.item_installed_app_icon, p2, false)
		val iv = gridItemElement.findViewById(R.id.item_icon) as ImageView
		val tv = gridItemElement.findViewById(R.id.item_label) as TextView
		val applicationIcon = context.packageManager.getApplicationIcon(list.get(p0).packageName)
		iv.setImageDrawable(applicationIcon)
		tv.setText(list.get(p0).name)

		gridItemElement.setOnClickListener { listener.invoke(list.get(p0).packageName) }

		return gridItemElement
	}

	override fun getItem(p0: Int): DomainApplicationInfo {
		return list.get(p0)
	}

	override fun getItemId(p0: Int): Long {
		return 0
	}

	override fun getCount(): Int {
		return list.size
	}


}
