package pl.mobly.data


import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import pl.mobly.domain.DomainApplicationInfo
import java.util.*

object AppInfoMapper {

    internal fun mapToDomain(info: MutableList<ApplicationInfo>, packageManager: PackageManager): List<DomainApplicationInfo> {
        val domainApplicationInfos = ArrayList<DomainApplicationInfo>()
        for (appInfo in info) {
            domainApplicationInfos.add(DomainApplicationInfo(appInfo.loadLabel(packageManager).toString(), appInfo.packageName, appInfo.icon))
        }
        return domainApplicationInfos
    }
}
