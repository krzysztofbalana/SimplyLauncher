package pl.mobly.data


import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo

internal interface IPackageManager {
    fun loadInstalledApps(): List<PackageInfo>
}
