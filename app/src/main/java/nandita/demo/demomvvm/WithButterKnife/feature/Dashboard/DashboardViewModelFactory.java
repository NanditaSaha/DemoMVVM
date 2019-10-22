package nandita.demo.demomvvm.WithButterKnife.feature.Dashboard;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import nandita.demo.demomvvm.WithButterKnife.Utils.Repository;

public class DashboardViewModelFactory implements ViewModelProvider.Factory {
    private Repository repository;

    @Inject
    public DashboardViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DashboardViewModel.class)) {
            return (T) new DashboardViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
