package com.example.details.dagger;

import com.example.details.view.DetailsActivity;
import com.example.tools.dagger.components.ApplicationComponent;
import com.example.tools.dagger.components.BaseActivityComponent;
import com.example.tools.dagger.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by miguellemos on 3/15/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = DetailsActivityModule.class)
public interface DetailsActivityComponent extends BaseActivityComponent<DetailsActivity> {

}

