package pl.mobly.data;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

public class PackageManagerResource implements IPackageManager {

    private PackageManager packageManager;

    public PackageManagerResource(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    @Override
    public List<ApplicationInfo> loadInstalledApps() {
        return packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
    }

    @Override
    public List<String> loadInstalledAppsLabels() {
        List<String> installedApplicationsLabels = new ArrayList<>();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo applicationInfo : installedApplications)
            installedApplicationsLabels.add(applicationInfo.loadLabel(packageManager).toString());
        return installedApplicationsLabels;
    }
}
