package com.hardtopcrm.metaldud.daggertest.model.repository;

import com.hardtopcrm.metaldud.daggertest.model.response.UserResponse;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by user on 12.02.18.
 */

public class RemoteDataRepository implements IRemoteRepository {

    private ApiUser apiUser;

    public RemoteDataRepository(Retrofit retrofit) {
        this.apiUser = retrofit.create(ApiUser.class);
    }

    @Override
    public Call<UserResponse> getUserList(Integer count) {
        return apiUser.getUserList(count);
    }

    @Override
    public Call<UserResponse> getLocalUser(Integer count) {
        return apiUser.getUserListLocal(count);
    }
}
