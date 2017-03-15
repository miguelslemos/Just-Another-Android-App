package com.example.details.view;

import android.os.Bundle;

import com.example.App;
import com.example.R;
import com.example.details.dagger.DaggerDetailsActivityComponent;
import com.example.details.dagger.DetailsActivityComponent;
import com.example.details.presenter.DetailsPresenter;
import com.example.tools.analytics.AnalyticsHelper;
import com.example.util.mvp.base.BaseActivity;

import javax.inject.Inject;


public class DetailsActivity extends BaseActivity<DetailsActivityComponent, DetailsView, DetailsPresenter, DetailsActivityViewState> implements DetailsView {


    @Inject
    AnalyticsHelper analyticsHelper;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected DetailsActivityComponent constructComponent() {
         return DaggerDetailsActivityComponent.builder()
                .applicationComponent(App.getApplicationComponent())
                .build();
    }

    @Override
    protected void onFirstCreate() {
        super.onFirstCreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showList() {

    }
}
