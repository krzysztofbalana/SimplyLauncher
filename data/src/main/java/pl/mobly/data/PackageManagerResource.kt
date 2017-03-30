package pl.mobly.data


import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

import java.util.ArrayList

class PackageManagerResource(private val packageManager: PackageManager) : IPackageManager {

    override fun loadInstalledApps(): List<PackageInfo> {
        return packageManager.getInstalledPackages(PackageManager.COMPONENT_ENABLED_STATE_ENABLED)
    }

}
