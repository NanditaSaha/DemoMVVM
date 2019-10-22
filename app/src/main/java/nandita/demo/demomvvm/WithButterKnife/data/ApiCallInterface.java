package nandita.demo.demomvvm.WithButterKnife.data;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import nandita.demo.demomvvm.WithButterKnife.data.network.models.Login.ApiRequest;
import nandita.demo.demomvvm.WithButterKnife.Utils.Urls;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiCallInterface {

    @POST(Urls.LOGIN)
    Observable<JsonElement> login(@Body ApiRequest apiRequest);
}


