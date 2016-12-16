package com.example.retrofit;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Leovo on 2016/12/16.
 */
public interface PhoneCallBack<T> {
    public abstract void onResponse(Call<T> call, Response<T> response);
    public abstract void onFailure(Call<T> call, Throwable t);
}
