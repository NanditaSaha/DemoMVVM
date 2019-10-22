package nandita.demo.demomvvm.WithButterKnife.Utils;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import nandita.demo.demomvvm.WithButterKnife.data.ApiCallInterface;
import nandita.demo.demomvvm.WithButterKnife.data.network.models.Login.ApiRequest;

public class Repository {

    private ApiCallInterface apiCallInterface;

    public Repository(ApiCallInterface apiCallInterface) {
        this.apiCallInterface = apiCallInterface;
    }

    /*
     * method to call login api
     * */
    public Observable<JsonElement> executeLogin(ApiRequest apiRequest) {
        return apiCallInterface.login(apiRequest);
    }

}
