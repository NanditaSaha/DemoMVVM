package nandita.demo.demomvvm.WithButterKnife.feature.Dashboard;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import nandita.demo.demomvvm.WithButterKnife.Utils.Repository;
import nandita.demo.demomvvm.WithButterKnife.data.network.models.Login.ApiResponse;

public class DashboardViewModel extends ViewModel {


    private Repository repository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<ApiResponse> responseLiveData = new MutableLiveData<>();

    public DashboardViewModel(Repository repository)
    {
        this.repository = repository;
    }

    public MutableLiveData<ApiResponse> featureResponse() {
        return responseLiveData;
    }
    @Override
    protected void onCleared() {
        disposables.clear();
    }
}
