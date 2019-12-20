package com.example.architecturelesson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.architecturelesson.data.model.InstalledPackageModel;
import com.example.architecturelesson.data.provider.InstallPackageRepository;
import com.example.architecturelesson.presentation.presenter.InstalledPackagePresenter;
import com.example.architecturelesson.presentation.view.RecyclerViewAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IPackageInstalledView {


    private View progressView;
    private RecyclerView recyclerView;
    private InstalledPackagePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InstallPackageRepository repository = new InstallPackageRepository(this);

        presenter = new InstalledPackagePresenter(this, repository);

        initViews();
    }

    private void initViews() {
        progressView = findViewById(R.id.progress_view);
        recyclerView = findViewById(R.id.recycler_view);
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.GONE);
    }

    @Override
    public void showInstalledPackages(@NonNull List<InstalledPackageModel> installedPackageModelList) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(installedPackageModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        presenter.startLoading();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
