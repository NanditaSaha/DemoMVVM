package nandita.demo.demomvvm.WithButterKnife.feature.Dashboard;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import nandita.demo.demomvvm.R;
import nandita.demo.demomvvm.WithButterKnife.MyApplication;

public class DashboardActivity extends AppCompatActivity {

    @Inject
    DashboardViewModelFactory viewModelFactory;

    DashboardViewModel viewModel;

    String email,phone,name,address;
    @BindView(R.id.Name)
    TextView Name;
    @BindView(R.id.Email)
    TextView Email;
    @BindView(R.id.Phone)
    TextView Phone;
    @BindView(R.id.Address)
    TextView Address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getAppComponent().doInjection(this);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DashboardViewModel.class);
        getData();
    }

    private void getData()
    {
        name=getIntent().getStringExtra("Name");
        phone=getIntent().getStringExtra("Phone");
        email=getIntent().getStringExtra("Email");
        address=getIntent().getStringExtra("Address");

        Name.setText(name);
        Email.setText(email);
        Phone.setText(phone);
        Address.setText(address);
    }
}
