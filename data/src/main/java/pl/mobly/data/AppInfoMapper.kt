package pl.mobly.data


import android.content.pm.PackageInfo
import pl.mobly.domain.DomainApplicationInfo
import java.util.*

object AppInfoMapper {

    internal fun mapToDomain(info: List<PackageInfo>): List<DomainApplicationInfo> {
        val domainApplicationInfos = ArrayList<DomainApplicationInfo>()
        for (appInfo in info) {
            domainApplicationInfos.add(DomainApplicationInfo(appInfo.applicationInfo.processName))
        }
        return domainApplicationInfos
    }
}
