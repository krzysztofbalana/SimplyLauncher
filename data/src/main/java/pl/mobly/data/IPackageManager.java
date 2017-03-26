package pl.mobly.data;


import android.content.pm.ApplicationInfo;

import java.util.List;

interface IPackageManager {
    List<ApplicationInfo> loadInstalledApps();
    List<String> loadInstalledAppsLabels();
}
