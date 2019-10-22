package nandita.demo.demomvvm.WithButterKnife.feature.Login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nandita.demo.demomvvm.R;
import nandita.demo.demomvvm.WithButterKnife.MyApplication;
import nandita.demo.demomvvm.WithButterKnife.data.network.models.Login.ApiResponse;
import nandita.demo.demomvvm.WithButterKnife.feature.Dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.phone_no)
    EditText phoneNo;

    @BindView(R.id.password)
    EditText password;

    LoginViewModel viewModel;


    String TAG="NANDITA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        ((MyApplication) getApplication()).getAppComponent().doInjection(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);

        viewModel.loginResponse().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(@Nullable ApiResponse apiResponse) {
                Log.d(TAG,"ViewModel" );
                consumeResponse(apiResponse);
            }
        });
    }


    @OnClick(R.id.login)
    void onLoginClicked() {
        if (isValid()) {
            Log.d(TAG, "Onclick");

                viewModel.hitLoginApi(phoneNo.getText().toString(), password.getText().toString());


        }
    }

    private boolean isValid() {

        if (phoneNo.getText().toString().trim().isEmpty()) {
            Toast.makeText(LoginActivity.this,"enter mobile", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.getText().toString().trim().isEmpty()) {
            Toast.makeText(LoginActivity.this,"enter pwd", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    private void consumeResponse(ApiResponse apiResponse) {

        switch (apiResponse.status) {

            case LOADING:

                break;

            case SUCCESS:

                renderSuccessResponse(apiResponse.data);
                break;

            case ERROR:

                Toast.makeText(LoginActivity.this,"error", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
    /*
     * method to handle success response
     * */
    private void renderSuccessResponse(JsonElement response) {
        if (!response.isJsonNull()) {
          //  Log.d(TAG, response.toString());
           // JsonObject jsonObject=response.getAsJsonObject();
            String responseS=response.toString();

            Log.d(TAG,"---"+responseS);
            try {
                JSONObject object=new JSONObject(responseS);
               // Toast.makeText(LoginActivity.this,"nandits--"+object.toString(), Toast.LENGTH_SHORT).show();

                 if(object.getString("success").equals("1")) {

                     if(object.getString("user_phone").equals("1234567890")&&object.getString("user_password").equals("123456")) {
                         Intent i = new Intent(this, DashboardActivity.class);
                         i.putExtra("Name",object.getString("user_name"));
                         i.putExtra("Phone",object.getString("user_phone"));
                         i.putExtra("Email",object.getString("user_email"));
                         i.putExtra("Address",object.getString("user_address"));
                         startActivity(i);
                     }
                 }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(LoginActivity.this,"error", Toast.LENGTH_SHORT).show();
        }
    }

}
