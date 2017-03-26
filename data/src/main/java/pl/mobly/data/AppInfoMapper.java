package pl.mobly.data;


import android.content.pm.ApplicationInfo;

import java.util.ArrayList;
import java.util.List;

import pl.mobly.domain.DomainApplicationInfo;

public class AppInfoMapper {

    static List<DomainApplicationInfo> mapToDomain(List<ApplicationInfo> info) {
        List<DomainApplicationInfo> domainApplicationInfos = new ArrayList<>();
        for (ApplicationInfo applicationInfo : info) {
            domainApplicationInfos.add(new DomainApplicationInfo(applicationInfo.name));
        }
        return domainApplicationInfos;
    }
}
