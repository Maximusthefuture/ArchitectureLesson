package com.example.architecturelesson.data.model;

import android.graphics.drawable.Drawable;

import java.util.Objects;

public class InstalledPackageModel {

    private String mAppTitle;

    private String mAppPackageName;

    private Drawable mAppIconDrawable;

    public InstalledPackageModel(String appName, String packageName, Drawable appIcon) {
        mAppTitle = appName;
        mAppPackageName = packageName;
        mAppIconDrawable = appIcon;
    }


    public String getmAppTitle() {
        return mAppTitle;
    }

    public void setmAppTitle(String mAppTitle) {
        this.mAppTitle = mAppTitle;
    }

    public String getmAppPackageName() {
        return mAppPackageName;
    }

    public void setmAppPackageName(String mAppPackageName) {
        this.mAppPackageName = mAppPackageName;
    }

    public Drawable getmAppIconDrawable() {
        return mAppIconDrawable;
    }

    public void setmAppIconDrawable(Drawable mAppIconDrawable) {
        this.mAppIconDrawable = mAppIconDrawable;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstalledPackageModel that = (InstalledPackageModel) o;
        return Objects.equals(mAppTitle, that.mAppTitle) &&
                Objects.equals(mAppPackageName, that.mAppPackageName) &&
                Objects.equals(mAppIconDrawable, that.mAppIconDrawable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mAppTitle, mAppPackageName, mAppIconDrawable);
    }


    @Override
    public String toString() {
        return "InstalledPackageModel{" +
                "mAppTitle='" + mAppTitle + '\'' +
                ", mAppPackageName='" + mAppPackageName + '\'' +
                ", mAppIconDrawable='" + mAppIconDrawable + '\'' +
                '}';
    }
}
