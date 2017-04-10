package pl.mobly.simplylauncher.ui.appDrawer

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.simplylauncher.R


class AppListViewHolder: RecyclerView.ViewHolder {
	private var text:TextView

	constructor(view:View) : super(view) {
		text = view.findViewById(R.id.installed_app_position) as TextView
	}


	fun bind(domainApplicationInfoItem: DomainApplicationInfo) {
		text.text = domainApplicationInfoItem.name
	}
}