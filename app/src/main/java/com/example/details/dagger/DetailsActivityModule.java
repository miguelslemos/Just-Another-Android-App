package com.example.details.dagger;

import android.support.test.espresso.idling.CountingIdlingResource;

import com.example.details.presenter.DetailsPresenter;
import com.example.details.view.DetailsActivityViewState;
import com.example.networking.RestService;
import com.example.tools.analytics.AnalyticsHelper;
import com.example.util.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by miguellemos on 3/15/17.
 */

@Module
public final class DetailsActivityModule {


    private DetailsActivityModule() {

        throw new AssertionError();
    }

    @Provides
    public static DetailsActivityViewState providesDetailsActivityViewState() {

        return new DetailsActivityViewState();
    }

    @Provides
    public static DetailsPresenter providesMainPresenter(RestService restService, RxSchedulers rxSchedulers,
                                                         AnalyticsHelper analyticsHelper,
                                                         CountingIdlingResource countingIdlingResource) {

        return new DetailsPresenter(restService, rxSchedulers, analyticsHelper, countingIdlingResource);
    }

}
