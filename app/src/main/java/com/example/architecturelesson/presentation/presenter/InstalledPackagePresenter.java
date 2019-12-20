package com.example.architecturelesson.presentation.presenter;

import androidx.annotation.NonNull;

import com.example.architecturelesson.IPackageInstalledView;
import com.example.architecturelesson.data.model.InstalledPackageModel;
import com.example.architecturelesson.data.provider.InstallPackageRepository;

import java.lang.ref.WeakReference;
import java.util.List;

public class InstalledPackagePresenter {

    private WeakReference<IPackageInstalledView> viewWeakReference;

    private InstallPackageRepository installPackageRepository;



    public InstalledPackagePresenter(IPackageInstalledView installedView,InstallPackageRepository installPackageRepository) {
        this.installPackageRepository = installPackageRepository;
        viewWeakReference = new WeakReference<>(installedView);
    }

    public void startLoading() {
        IPackageInstalledView installedView = viewWeakReference.get();

        if (installedView != null) {
            installedView.showProgress();

            List<InstalledPackageModel> installedPackageModelList
                    = installPackageRepository.getInstalledPackageModels();
            installedView.hideProgress();

            installedView.showInstalledPackages(installedPackageModelList);
        }
    }


    public void attach(@NonNull IPackageInstalledView packageInstalledView) {
        viewWeakReference = new WeakReference<>(packageInstalledView);
    }

    public void detach() {
        viewWeakReference.clear();
    }
}
