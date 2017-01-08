package com.example.retrofit.service;

import com.example.retrofit.data.PhoneResult;

import retrofit2.Call;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Leovo on 2016/12/15.
 */
public interface PhoneService {
    /**
     * 用来请求获取手机号码
     * @param apikey
     * @param phone
     * @return
     */
    @GET("/apistore/mobilenumber/mobilenumber")
    Call<PhoneResult> getPhoneResult(@Header("apikey") String apikey, @Query("phone") String phone);


    /**
     * 用来请求获取手机号码
     * @param apikey
     * @param phone
     * @return
     */
    @GET("/apistore/mobilenumber/mobilenumber")
    Observable<Result<PhoneResult>> getPhoneRxResult(@Header("apikey") String apikey, @Query("phone") String phone);
}
