package com.gkemon.mvvm_livedata_viewmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.gkemon.mvvm_livedata_viewmodel.service.model.Project;
import com.gkemon.mvvm_livedata_viewmodel.service.repository.ProjectRepository;

import java.util.List;

public class ProjectListViewModel extends AndroidViewModel {
    private final LiveData<List<Project>> projectListObservable;

    public ProjectListViewModel(Application application) {
        super(application);
        projectListObservable = ProjectRepository.getInstance().getProjectList("Google");
    }


    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
