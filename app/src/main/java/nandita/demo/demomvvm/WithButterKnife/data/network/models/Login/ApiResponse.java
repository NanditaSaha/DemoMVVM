package nandita.demo.demomvvm.WithButterKnife.data.network.models.Login;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.JsonElement;

import nandita.demo.demomvvm.WithButterKnife.Utils.Status;

import static nandita.demo.demomvvm.WithButterKnife.Utils.Status.ERROR;
import static nandita.demo.demomvvm.WithButterKnife.Utils.Status.LOADING;
import static nandita.demo.demomvvm.WithButterKnife.Utils.Status.SUCCESS;

public class ApiResponse {

    public final Status status;
    final String TAG="NANDITA";

    @Nullable
    public final JsonElement data;

    @Nullable
    public final Throwable error;

    private ApiResponse(Status status, @Nullable JsonElement data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static ApiResponse success(@NonNull JsonElement data) {
        Log.d("NANDITA","Success");
        return new ApiResponse(SUCCESS, data, null);
    }
//    public static ApiResponse success(@NonNull Throwable error) {
//        return new ApiResponse(ERROR, null, error);
//    }

    public static ApiResponse error(@NonNull Throwable error) {
        Log.d("NANDITA","faliur"+error.toString());
        return new ApiResponse(ERROR, null, error);
    }

}
