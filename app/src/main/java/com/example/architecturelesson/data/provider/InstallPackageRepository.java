package com.example.architecturelesson.data.provider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.architecturelesson.R;
import com.example.architecturelesson.data.model.InstalledPackageModel;

import java.util.ArrayList;
import java.util.List;

public class InstallPackageRepository {

    private  final Context context;
    private final PackageManager packageManager;


    public InstallPackageRepository(@NonNull Context context) {
        this.context = context;
        packageManager = context.getPackageManager();
    }

    public List<InstalledPackageModel> getInstalledPackageModels() {
        List<InstalledPackageModel> installedPackageModels = new ArrayList<>();

        for (String packageName : getInstalledPackages()) {
            installedPackageModels.add(new InstalledPackageModel(
                    getAppName(packageName),
                    packageName,
                    getAppIcon(packageName)));
        }
        return installedPackageModels;
    }


    private String getAppName(@NonNull String packageName) {
        String appName = "";
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            appName = (String) packageManager.getApplicationLabel(applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appName;
    }


    private List<String> getInstalledPackages() {
        List<String> apkPackageName = new ArrayList<>();

        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(intent, 0);

        for (ResolveInfo resolveInfo : resolveInfoList) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            apkPackageName.add(activityInfo.applicationInfo.packageName);
        }
        return apkPackageName;
    }


    private Drawable getAppIcon(@NonNull String packageName) {
        Drawable drawable;
        try {
            drawable = packageManager.getApplicationIcon(packageName);
        } catch (PackageManager.NameNotFoundException e) {
            drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher);
            e.printStackTrace();
        }
        return drawable;
    }
}
