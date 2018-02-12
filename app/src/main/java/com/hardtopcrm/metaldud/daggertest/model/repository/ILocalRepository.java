package com.hardtopcrm.metaldud.daggertest.model.repository;

import com.hardtopcrm.metaldud.daggertest.model.response.UserResponse;
import java.util.List;

/**
 * Created by user on 12.02.18.
 */

public interface ILocalRepository {

    List<UserResponse> getUserList();

    UserResponse getUserByIndex(int index);

}
