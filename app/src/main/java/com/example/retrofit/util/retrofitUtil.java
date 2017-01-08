package com.example.retrofit.util;

import android.widget.TextView;

import com.example.retrofit.PhoneCallBack;
import com.example.retrofit.data.PhoneResult;
import com.example.retrofit.service.PhoneService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.adapter.rxjava.Result;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Leovo on 2016/12/15.
 */
public class RetrofitUtil {
    /**
     * 基本的url
     */
    private static String BASE_URL = "http://apis.baidu.com";
    /**
     * apikey
     */
    private static String API_KEY = "8e13586b86e4b7f3758ba3bd6c9c9135";

    private PhoneCallBack<PhoneResult> callBack;

    private Retrofit retrofit;

    public RetrofitUtil(PhoneCallBack<PhoneResult> callBack){
        this.callBack = callBack;
    }

    public void initRetrofit(){
        //1.创建Retrofit对象
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//解析方法
                .baseUrl(BASE_URL)//主机地址
                .build();
    }

    public void doRequest(String phoneNum){
        //2.创建访问API的请求
        PhoneService service = retrofit.create(PhoneService.class);
        Call<PhoneResult> call = service.getPhoneResult(API_KEY, phoneNum);

        //3.发送请求
        call.enqueue(new Callback<PhoneResult>() {
            @Override
            public void onResponse(Call<PhoneResult> call, Response<PhoneResult> response) {
                callBack.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<PhoneResult> call, Throwable t) {
                callBack.onFailure(call,t);
            }
        });
    }

    public void initRetrofitWithRxjava(){
        //1.创建Retrofit对象
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//解析方法
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)//主机地址
                .build();
    }

    public void doRequestWithRxjava(final String phoneNum, final TextView tvText){
        //2.创建访问API的请求
        PhoneService service = retrofit.create(PhoneService.class);
        service.getPhoneRxResult(API_KEY, phoneNum).
                subscribeOn(Schedulers.io())    //设置代码执行的线程
                .subscribe(new Subscriber<Result<PhoneResult>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Result<PhoneResult> phoneResult) {
                        PhoneResult.RetDataEntity phoneResult1 = phoneResult.response().body().getRetData();
                        tvText.setText(phoneResult1.getCity());
                    }
                });
    }

}
