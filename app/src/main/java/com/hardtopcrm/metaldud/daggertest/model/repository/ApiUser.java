package com.hardtopcrm.metaldud.daggertest.model.repository;

import com.hardtopcrm.metaldud.daggertest.model.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 12.02.18.
 */

public interface ApiUser {

    @GET("api/")
    Call<UserResponse> getUserList(@Query("results") Integer count);

    @GET("api/v1/{userId}")
    Call<UserResponse> getUserListLocal(@Query("userId") Integer count);

}
