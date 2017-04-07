package pl.mobly.simplylauncher.ui.appDrawer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.mobly.domain.DomainApplicationInfo
import pl.mobly.simplylauncher.R


class AppsListAdapter(private val context: Context, private val installedApps: List<DomainApplicationInfo>) : RecyclerView.Adapter<AppListViewHolder>() {

	override fun onBindViewHolder(holder: AppListViewHolder?, position: Int) {
		holder?.bind(installedApps.get(position))
	}

	override fun getItemCount(): Int {
		return installedApps.size
	}

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AppListViewHolder {
		val view = LayoutInflater.from(context).inflate(R.layout.list_installed_apps, parent, true)
		return AppListViewHolder(view)
	}
}