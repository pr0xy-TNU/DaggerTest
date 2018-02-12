package com.hardtopcrm.metaldud.daggertest.model.repository;

import android.content.Context;
import com.hardtopcrm.metaldud.daggertest.model.response.UserResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.02.18.
 */

public class LocalDataRepository implements ILocalRepository {

    private List<UserResponse> responses;
    private Context context;

    public LocalDataRepository(
        Context context) {
        this.context = context;
    }

    public LocalDataRepository() {
        this.responses = new ArrayList<>();
        /**
         * Set user info
         *
         */
    }

    @Override
    public List<UserResponse> getUserList() {
        return responses;
    }

    @Override
    public UserResponse getUserByIndex(int index) {
        return responses.get(index);
    }
}
