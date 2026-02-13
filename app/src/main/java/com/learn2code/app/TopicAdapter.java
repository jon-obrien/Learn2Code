package com.learn2code.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private final List<Topic> topics;
    private final OnTopicClickListener listener;

    public interface OnTopicClickListener {
        void onTopicClick(Topic topic);
    }

    public TopicAdapter(List<Topic> topics, OnTopicClickListener listener) {
        this.topics = topics;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_item, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Topic topic = topics.get(position);

        String titleResourceName = String.format("topic_%s_title", topic.getId());
        int titleResourceId = holder.itemView.getContext().getResources().getIdentifier(titleResourceName, "string", holder.itemView.getContext().getPackageName());
        String descriptionResourceName = String.format("topic_%s_desc", topic.getId());
        int descriptionResourceId = holder.itemView.getContext().getResources().getIdentifier(descriptionResourceName, "string", holder.itemView.getContext().getPackageName());

        holder.textView.setText(holder.itemView.getContext().getString(titleResourceId));
        holder.descriptionTextView.setText(holder.itemView.getContext().getString(descriptionResourceId));

        holder.itemView.setOnClickListener(v -> listener.onTopicClick(topic));
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public static class TopicViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView descriptionTextView;
        public TopicViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.topicName);
            descriptionTextView = itemView.findViewById(R.id.topicDescription);
        }
    }
}