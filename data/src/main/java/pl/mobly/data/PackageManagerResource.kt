package pl.mobly.data


import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

import java.util.ArrayList

class PackageManagerResource(private val packageManager: PackageManager) : IPackageManager {

    override fun loadInstalledApps(): List<ApplicationInfo> {
        return packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
    }

    override fun loadInstalledAppsLabels(): List<String> {
        val installedApplicationsLabels = ArrayList<String>()
        val installedApplications = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        for (applicationInfo in installedApplications)
            installedApplicationsLabels.add(applicationInfo.loadLabel(packageManager).toString())
        return installedApplicationsLabels
    }
}
