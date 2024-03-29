package nandita.demo.demomvvm.WithButterKnife;

import android.app.Application;
import android.content.Context;

import nandita.demo.demomvvm.WithButterKnife.di.component.AppComponent;
import nandita.demo.demomvvm.WithButterKnife.di.component.DaggerAppComponent;
import nandita.demo.demomvvm.WithButterKnife.di.models.AppModule;
import nandita.demo.demomvvm.WithButterKnife.di.models.UtilsModule;

public class MyApplication extends Application {

    AppComponent appComponent;
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).utilsModule(new UtilsModule()).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }
}
