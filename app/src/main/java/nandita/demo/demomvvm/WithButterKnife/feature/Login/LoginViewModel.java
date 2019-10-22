package nandita.demo.demomvvm.WithButterKnife.feature.Login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import nandita.demo.demomvvm.WithButterKnife.Utils.Repository;
import nandita.demo.demomvvm.WithButterKnife.data.network.models.Login.ApiRequest;
import nandita.demo.demomvvm.WithButterKnife.data.network.models.Login.ApiResponse;

public class LoginViewModel extends ViewModel {

    private Repository repository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<ApiResponse> responseLiveData = new MutableLiveData<>();

    String TAG="NANDITA";

    public LoginViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ApiResponse> loginResponse() {
        return responseLiveData;
    }

    /*
     * method to call normal login api with $(mobileNumber + password)
     * */
    public void hitLoginApi(String mobileNumber, String password) {

        Log.d(TAG,"hitLoginApi");
        ApiRequest apiRequest=new ApiRequest(mobileNumber,password,"","");

        disposables.add(repository.executeLogin(apiRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> responseLiveData.setValue(ApiResponse.loading()))
                .subscribe(
                        result -> responseLiveData.setValue(ApiResponse.success(result)),
                        throwable -> responseLiveData.setValue(ApiResponse.error(throwable))
                ));


    }


    @Override
    protected void onCleared() {
        disposables.clear();
    }
}

