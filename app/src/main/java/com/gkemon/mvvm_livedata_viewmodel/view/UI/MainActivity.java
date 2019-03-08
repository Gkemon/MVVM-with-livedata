package com.gkemon.mvvm_livedata_viewmodel.view.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.gkemon.mvvm_livedata_viewmodel.R;
import com.gkemon.mvvm_livedata_viewmodel.service.model.Project;
import com.gkemon.mvvm_livedata_viewmodel.view.adapter.ProjectAdapter;
import com.gkemon.mvvm_livedata_viewmodel.view.callback.ProjectClickCallback;
import com.gkemon.mvvm_livedata_viewmodel.viewmodel.ProjectListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ProjectClickCallback {
    ProjectListViewModel projectListViewModel;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.projectListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        projectListViewModel=ViewModelProviders.of(this).get(ProjectListViewModel.class);

        projectListViewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public
            void onChanged(@Nullable List<Project> projects) {
                recyclerView.setAdapter(new ProjectAdapter(MainActivity.this,projects));
            }
        });

    }


    @Override
    public
    void onClick(Project project) {
        Log.d("GK",project.name+" is the selected project");
        Toast.makeText(MainActivity.this,"Project name: "+project.name,Toast.LENGTH_LONG).show();
    }
}
