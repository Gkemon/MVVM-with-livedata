package com.gkemon.mvvm_livedata_viewmodel.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;


import com.gkemon.mvvm_livedata_viewmodel.service.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectRepository {
    private GitHubService gitHubService;
    private static ProjectRepository projectRepository;

    private ProjectRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubService = retrofit.create(GitHubService.class);
    }

    public synchronized static ProjectRepository getInstance() {
        if (projectRepository == null) {
            if (projectRepository == null) {
                projectRepository = new ProjectRepository();
            }
        }
        return projectRepository;
    }

    public LiveData<List<Project>> getProjectList(String userId) {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        gitHubService.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                // TODO better error handling in part #2 ...
                data.setValue(null);
            }
        });

        return data;
    }

    

    private void simulateDelay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
