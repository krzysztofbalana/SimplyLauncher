package pl.mobly.data


import android.content.pm.ApplicationInfo
import pl.mobly.domain.DomainApplicationInfo
import java.util.*

object AppInfoMapper {

    internal fun mapToDomain(info: MutableList<ApplicationInfo>): List<DomainApplicationInfo> {
        val domainApplicationInfos = ArrayList<DomainApplicationInfo>()
        for (appInfo in info) {
            domainApplicationInfos.add(DomainApplicationInfo(appInfo.packageName, appInfo.icon))
        }
        return domainApplicationInfos
    }
}
