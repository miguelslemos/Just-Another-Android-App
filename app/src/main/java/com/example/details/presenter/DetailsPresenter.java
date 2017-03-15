package com.example.details.presenter;

import android.support.test.espresso.idling.CountingIdlingResource;

import com.example.details.view.DetailsView;
import com.example.networking.RestService;
import com.example.tools.analytics.AnalyticsHelper;
import com.example.util.mvp.base.MvpNullObjectBasePresenter;
import com.example.util.rx.RxSchedulers;

import javax.annotation.Nullable;
import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by miguellemos on 3/15/17.
 */

public class DetailsPresenter extends MvpNullObjectBasePresenter<DetailsView> {

    private final RestService restService;
    private final RxSchedulers rxSchedulers;
    private final AnalyticsHelper analyticsHelper;
    private final CountingIdlingResource countingIdlingResource;

    @Nullable
    private Subscription subscription;

    @Inject
    public DetailsPresenter(RestService restService, RxSchedulers rxSchedulers,
                            AnalyticsHelper analyticsHelper, CountingIdlingResource countingIdlingResource) {
        this.restService = restService;
        this.rxSchedulers = rxSchedulers;
        this.analyticsHelper = analyticsHelper;
        this.countingIdlingResource = countingIdlingResource;

    }

    public void doAnyThing() {
        // TODO: 3/15/17
        getView().showList();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }


}
