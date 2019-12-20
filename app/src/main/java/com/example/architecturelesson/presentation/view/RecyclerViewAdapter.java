package com.example.architecturelesson.presentation.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architecturelesson.R;
import com.example.architecturelesson.data.model.InstalledPackageModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private final List<InstalledPackageModel> installedPackageModelList;

    public RecyclerViewAdapter(List<InstalledPackageModel> installedPackageModelList) {
        this.installedPackageModelList = installedPackageModelList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_package, parent, false);


        return new RecyclerViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        holder.bindView(installedPackageModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return installedPackageModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView mPackageTitle;
        private TextView mPackageName;
        private ImageView mPackackeIconDrawable;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mPackageTitle = itemView.findViewById(R.id.app_title_text_view);
            mPackageName = itemView.findViewById(R.id.app_package_name_text_view);
            mPackackeIconDrawable = itemView.findViewById(R.id.install_package_image_view);
        }

        public void bindView(@NonNull InstalledPackageModel installedPackageModel) {
            mPackageTitle.setText(installedPackageModel.getmAppTitle());
            mPackageName.setText(installedPackageModel.getmAppPackageName());
            mPackackeIconDrawable.setImageDrawable(installedPackageModel.getmAppIconDrawable());
        }
    }
}
