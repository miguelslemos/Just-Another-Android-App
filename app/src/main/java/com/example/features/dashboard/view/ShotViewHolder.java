package com.example.features.dashboard.view;

import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;

import com.example.R;
import com.example.model.Shot;
import com.example.tools.images.ImageLoader;
import com.example.util.other.InjectedViewHolder;

public class ShotViewHolder extends InjectedViewHolder {

    @BindView(R.id.shot_adapter_item_image_view) ImageView shotImageView;

    private final ImageLoader imageLoader;
    private Callback mCallback;
    private Shot mShot;

    public ShotViewHolder(View itemView, ImageLoader imageLoader, Callback callback) {
        super(itemView);
        this.imageLoader = imageLoader;
        this.mCallback = callback;
    }


    public void bind(Shot shot) {
        this.mShot = shot;
        shotImageView.setContentDescription("Image with title: " + shot.getTitle());
        imageLoader.loadImage(shot.getUrl(), shotImageView);
    }

    @OnClick(R.id.shot_adapter_item_image_view)
    void onItemClicked() {
        if (mCallback != null) mCallback.onShotClicked(mShot);
    }




}
