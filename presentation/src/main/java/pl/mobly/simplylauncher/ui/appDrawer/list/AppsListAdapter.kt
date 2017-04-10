package pl.mobly.simplylauncher.ui.appDrawer.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.simplylauncher.R


class AppsListAdapter : RecyclerView.Adapter<AppsListViewHolder> {

	private val context: Context
	private val installedApps: List<DomainApplicationInfo>

	constructor(context: Context, installedApps: List<DomainApplicationInfo>) : super() {
		this.context = context
		this.installedApps = installedApps.toMutableList()
	}

	override fun onBindViewHolder(holder: AppsListViewHolder?, position: Int) {
		holder?.bind(installedApps.get(position))
	}

	override fun getItemCount(): Int {
		return installedApps.size
	}

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AppsListViewHolder {
		val view = LayoutInflater.from(context).inflate(R.layout.item_installed_app, parent, false)
		return AppsListViewHolder(view)
	}
}