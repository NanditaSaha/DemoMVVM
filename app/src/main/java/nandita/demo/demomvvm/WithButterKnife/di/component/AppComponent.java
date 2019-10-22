package nandita.demo.demomvvm.WithButterKnife.di.component;


import javax.inject.Singleton;

import dagger.Component;
import nandita.demo.demomvvm.WithButterKnife.di.models.AppModule;
import nandita.demo.demomvvm.WithButterKnife.di.models.UtilsModule;
import nandita.demo.demomvvm.WithButterKnife.feature.Dashboard.DashboardActivity;
import nandita.demo.demomvvm.WithButterKnife.feature.Login.LoginActivity;

@Component(modules = {AppModule.class, UtilsModule.class})
@Singleton
public interface AppComponent {
    void doInjection(LoginActivity loginActivity);
    void doInjection(DashboardActivity activity);
}
