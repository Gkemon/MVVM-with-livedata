package com.gkemon.mvvm_livedata_viewmodel.view.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gkemon.mvvm_livedata_viewmodel.R;
import com.gkemon.mvvm_livedata_viewmodel.service.model.Project;
import com.gkemon.mvvm_livedata_viewmodel.view.callback.ProjectClickCallback;

import java.util.List;


public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    ProjectClickCallback projectClickCallback;
    public
    List<Project> projects;

    public
    ProjectAdapter(ProjectClickCallback projectClickCallback,List<Project> projects){

        this.projectClickCallback =projectClickCallback;
        this.projects=projects;
    }


    @NonNull
    @Override
    public
    ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProjectViewHolder projectViewHolder =new ProjectViewHolder( LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_list_item, parent, false));

        return projectViewHolder;
    }

    @Override
    public
    void onBindViewHolder(@NonNull final ProjectViewHolder projectViewHolder,final int i) {
        projectViewHolder.name.setText(projects.get(i).name);
        projectViewHolder.language.setText(projects.get(i).language);

        projectViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View v) {
                projectClickCallback.onClick(projects.get(i));
            }
        });
    }



    @Override
    public
    int getItemCount() {
        if(projects==null)return 0;
        else return projects.size();
    }



    class ProjectViewHolder extends RecyclerView.ViewHolder {
        public TextView name,language;

        public ProjectViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            language = (TextView) view.findViewById(R.id.languages);

        }
    }




}
