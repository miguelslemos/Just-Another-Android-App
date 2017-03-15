package com.example.features.dashboard.view;

import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.R;
import com.example.model.Shot;
import com.example.util.other.ViewHolderFactory;
import com.example.util.testing.ForTestingPurposes;

import timber.log.Timber;

import java.util.ArrayList;
import java.util.List;

public class ShotsAdapter extends RecyclerView.Adapter<ShotViewHolder> {

    private List<Shot> shots;
    private Callback mCallback;
    private final ViewHolderFactory<ShotViewHolder> shotViewHolderFactory;


    public ShotsAdapter(ViewHolderFactory<ShotViewHolder> shotViewHolderFactory) {
        this.shots = new ArrayList<>();
        this.shotViewHolderFactory = shotViewHolderFactory;
    }

    public void setData(List<Shot> shots) {
        Timber.v("Updating adapter with shots");
        this.shots = shots;
        notifyDataSetChanged();
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;

    }

    @Override
    public ShotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shot_adapter_row_item, parent, false);
        return shotViewHolderFactory.createViewHolder(view, mCallback);
    }

    @Override
    public void onBindViewHolder(ShotViewHolder holder, int position) {
        Shot shot = shots.get(position);
        holder.bind(shot);

    }

    @Override
    public int getItemCount() {
        return shots.size();
    }

    @ForTestingPurposes
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public List<Shot> getData() {
        return shots;
    }


}
