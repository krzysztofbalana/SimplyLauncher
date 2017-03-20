package pl.mobly.data;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;

public class PackageManagerResource implements IPackageManager {
    private Context context;

    public PackageManagerResource(Context context) {
        this.context = context;
    }

    @Override
    public List<ApplicationInfo> loadInstalledApps() {
        return context.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
    }
}
