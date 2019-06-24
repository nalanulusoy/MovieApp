package com.nalan.movieapp.di.component;


import android.app.Application;

import com.nalan.movieapp.MovieApp;
import com.nalan.movieapp.di.module.AppModule;
import com.nalan.movieapp.di.module.FragmentBuildersModule;
import com.nalan.movieapp.di.module.MainActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        MainActivityModule.class,
        AppModule.class

})

public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MovieApp movieApp);
}