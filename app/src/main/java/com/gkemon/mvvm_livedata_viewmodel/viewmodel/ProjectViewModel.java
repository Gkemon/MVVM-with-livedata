package com.gkemon.mvvm_livedata_viewmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import android.support.annotation.NonNull;

import com.gkemon.mvvm_livedata_viewmodel.service.model.Project;
import com.gkemon.mvvm_livedata_viewmodel.service.repository.ProjectRepository;


public class ProjectViewModel extends ViewModel {

    private final LiveData<Project> projectObservable;
    private final String projectID;

    public ProjectViewModel(final String projectID) {

        this.projectID = projectID;

        projectObservable = ProjectRepository.getInstance().getProjectDetails("Google", projectID);
    }

    public LiveData<Project> getObservableProject() {
        return projectObservable;
    }

}
