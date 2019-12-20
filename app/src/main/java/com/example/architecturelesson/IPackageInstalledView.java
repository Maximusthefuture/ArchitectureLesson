package com.example.architecturelesson;

import androidx.annotation.NonNull;

import com.example.architecturelesson.data.model.InstalledPackageModel;

import java.util.List;

public interface IPackageInstalledView {

    void showProgress();
    void hideProgress();
    void showInstalledPackages(@NonNull List<InstalledPackageModel> installedPackageModelList);

}
