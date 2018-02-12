package com.hardtopcrm.metaldud.daggertest.model.repository;

import com.hardtopcrm.metaldud.daggertest.model.response.UserResponse;
import java.util.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 12.02.18.
 */

public interface IRemoteRepository {

    Call<UserResponse> getUserList(Integer count);
    Call<UserResponse> getLocalUser(Integer count);
    //Observable<UserResponse> getUserListRx(Integer count);


}
