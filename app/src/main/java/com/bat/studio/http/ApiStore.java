package com.bat.studio.http;

import com.bat.studio.model.AD;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiStore {

    @GET("startAdvertising")
    Call<AD> getad();

}
