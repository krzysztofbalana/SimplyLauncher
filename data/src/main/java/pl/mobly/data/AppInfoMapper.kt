package pl.mobly.data


import android.content.pm.ApplicationInfo

import java.util.ArrayList

import pl.mobly.domain.DomainApplicationInfo

object AppInfoMapper {

    internal fun mapToDomain(info: List<ApplicationInfo>): List<DomainApplicationInfo> {
        val domainApplicationInfos = ArrayList<DomainApplicationInfo>()
        for (applicationInfo in info) {
            domainApplicationInfos.add(DomainApplicationInfo(applicationInfo.name))
        }
        return domainApplicationInfos
    }
}
