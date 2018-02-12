package com.hardtopcrm.metaldud.daggertest.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.hardtopcrm.metaldud.daggertest.App;
import com.hardtopcrm.metaldud.daggertest.R;
import com.hardtopcrm.metaldud.daggertest.model.repository.IRemoteRepository;
import com.hardtopcrm.metaldud.daggertest.model.response.UserResponse;
import com.hardtopcrm.metaldud.daggertest.utils.Constants;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_main)
    RecyclerView rvMainScreen;

    @Inject
    IRemoteRepository remoteRepository;


    @OnClick(R.id.btnSendRequest)
    public void sendRequest() {
        remoteRepository.getLocalUser(10).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse body = response.body();
                if(response.equals(Constants.ERROR)){
                    showMassage(response.message());
                }else {

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        ButterKnife.bind(this);


    }


    @Override
    public int getContentViewLayoutResource() {
        return R.layout.activity_main;
    }
}
