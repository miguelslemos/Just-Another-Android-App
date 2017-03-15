package com.example.util.other;

import android.view.View;

import com.example.features.dashboard.view.Callback;

public interface ViewHolderFactory<VIEW_HOLDER> {

    VIEW_HOLDER createViewHolder(View view, Callback callback);

}
