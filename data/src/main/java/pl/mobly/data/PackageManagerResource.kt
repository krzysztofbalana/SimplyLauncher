package pl.mobly.data


import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

class PackageManagerResource(private val packageManager: PackageManager) : IPackageManager {

	override fun loadInstalledApps(): MutableList<ApplicationInfo> {
		val installedAllApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
		val installedNonSystemApps: MutableList<ApplicationInfo> = mutableListOf()
		if (installedAllApps.size != 0) {
			for (unit in installedAllApps) {
				if (packageManager.getLaunchIntentForPackage(unit.packageName) != null) {
					installedNonSystemApps.add(unit)
				}
			}
		}
		return installedNonSystemApps
	}

}
