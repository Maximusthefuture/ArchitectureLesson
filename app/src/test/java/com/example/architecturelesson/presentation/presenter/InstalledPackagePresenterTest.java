package com.example.architecturelesson.presentation.presenter;

import com.example.architecturelesson.IPackageInstalledView;
import com.example.architecturelesson.data.model.InstalledPackageModel;
import com.example.architecturelesson.data.provider.InstallPackageRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class InstalledPackagePresenterTest {

    private InstalledPackagePresenter installedPackagePresenter;
    @Mock
    private IPackageInstalledView iPackageInstalledView;
    @Mock
    private InstallPackageRepository installPackageRepository;


    @Before
    public void setUp() throws Exception {
        installedPackagePresenter = new InstalledPackagePresenter(iPackageInstalledView, installPackageRepository);
    }

    @Test
    public void testStartLoading() {
        Mockito.when(installPackageRepository.getInstalledPackageModels()).thenReturn(createInstalledPackageModels());

        installedPackagePresenter.startLoading();

        InOrder inOrder = Mockito.inOrder(iPackageInstalledView);

        inOrder.Mockito.verity(iPackageInstalledView).showProgress();

        Mockito.verify(iPackageInstalledView).showInstalledPackaget(createInstalledPackageModels());
    }

    private List<InstalledPackageModel> createInstalledPackageModels() {
        List<InstalledPackageModel> installedPackageModels = new ArrayList<>();

        installedPackageModels.add(new InstalledPackageModel("fdfdfdf", "fdfdf", null));
        installedPackageModels.add(new InstalledPackageModel("gfbfgnfhn", "bvcbcvb", null));


        return installedPackageModels;
    }



}