package com.example.ehospitalapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ehospitalapp.R;
import com.example.ehospitalapp.activity.DetailActivity;
import com.example.ehospitalapp.model.DashboardModel;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ProjectViewHolder> {

    private DashboardModel[] projects;

    public DashboardAdapter(DashboardModel[] projects) {
        this.projects = projects;
    }

    @Override
    public int getItemCount() {
        return projects.length;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard_rv, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.bind(projects[position], position);
    }


    static class ProjectViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView text;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.name);
        }

        public void bind(DashboardModel projects, int pos) {
            text.setText(projects.getText());
            icon.setImageResource(projects.getImage());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(itemView.getContext(), DetailActivity.class);
                    i.putExtra("type", projects.getText());
                    itemView.getContext().startActivity(i);
                }
            });

        }
    }
}
