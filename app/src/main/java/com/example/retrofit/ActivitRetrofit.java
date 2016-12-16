package com.example.retrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gittestproject.R;
import com.example.retrofit.data.PhoneResult;
import com.example.retrofit.util.RetrofitUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * http://www.cnblogs.com/android-blogs/p/5752442.html
 */
public class ActivitRetrofit extends AppCompatActivity implements PhoneCallBack<PhoneResult>,View.OnClickListener{
    @Bind(R.id.ed_phone_retrofit)
    EditText etPhone;
    @Bind(R.id.btn_query_retrofit)
    Button btnQueryPhone;
    @Bind(R.id.tv_city_retrofit)
    TextView tvCity;
    private RetrofitUtil retrofitUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ButterKnife.bind(this);

        retrofitUtil = new RetrofitUtil(this);
        retrofitUtil.initRetrofit();

//        etPhone = (EditText) findViewById(R.id.ed_phone_retrofit);
//        btnQueryPhone = (Button) findViewById(R.id.btn_query_retrofit);
//        tvCity = (TextView) findViewById(R.id.tv_city_retrofit);
    }



    @Override
    public void onResponse(Call<PhoneResult> call, Response<PhoneResult> response) {
        //4.处理结果
        if (response.isSuccessful()){
            PhoneResult result = response.body();
            if (result != null){
                PhoneResult.RetDataEntity entity = result.getRetData();
                tvCity.setText(entity.getCity());
            }
        }
    }

    @Override
    public void onFailure(Call<PhoneResult> call, Throwable t) {

    }

    @OnClick(R.id.btn_query_retrofit)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_query_retrofit:
                if(!etPhone.getEditableText().toString().equals("")){
                    retrofitUtil.doRequest(etPhone.getEditableText().toString());
                }
                break;
        }
    }
}
