package com.learn2code.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> {
    private final List<Module> modules;
    private final OnModuleClickListener listener;

    public interface OnModuleClickListener {
        void onModuleClick(Module module);
    }

    public ModuleAdapter(List<Module> modules, OnModuleClickListener listener) {
        this.modules = modules;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_item, parent, false);
        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        Module module = modules.get(position);

        String titleResourceName = String.format("module_%s_title", position + 1);
        int titleResourceId = holder.itemView.getContext().getResources().getIdentifier(titleResourceName, "string", holder.itemView.getContext().getPackageName());
        String descriptionResourceName = String.format("module_%s_desc", position + 1);
        int descriptionResourceId = holder.itemView.getContext().getResources().getIdentifier(descriptionResourceName, "string", holder.itemView.getContext().getPackageName());

        holder.nameTextView.setText(holder.itemView.getContext().getString(titleResourceId));
        holder.descriptionTextView.setText(holder.itemView.getContext().getString(descriptionResourceId));

        holder.itemView.setOnClickListener(v -> listener.onModuleClick(module));
    }

    @Override
    public int getItemCount() {
        return modules.size();
    }

    public static class ModuleViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView descriptionTextView;

        public ModuleViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.moduleName);
            descriptionTextView = itemView.findViewById(R.id.moduleDescription);
        }
    }
}