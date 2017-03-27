package pl.mobly.data


import android.content.pm.ApplicationInfo

internal interface IPackageManager {
    fun loadInstalledApps(): List<ApplicationInfo>
    fun loadInstalledAppsLabels(): List<String>
}
