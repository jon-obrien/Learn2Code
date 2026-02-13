package com.learn2code.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.learn2code.app.data.repository.AppRepository;

public class TopicActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        long moduleId = getIntent().getLongExtra("MODULE_ID", -1);

        if (moduleId == -1) {
            moduleId = getPrefsHelper().getModuleId();
        }

        if (moduleId == -1) {
            finish();
        }

        if (getSupportActionBar() != null) {
            String descriptionResourceName = String.format("module_%s_title", moduleId);
            int resourceId = this.getResources().getIdentifier(descriptionResourceName, "string", this.getPackageName());
            getSupportActionBar().setTitle(this.getString(resourceId));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.topicListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Topic> topics = AppRepository.getInstance(this).getTopicsForModule(moduleId);
        TopicAdapter adapter = new TopicAdapter(topics, topic -> {
            Intent intent = new Intent(this, InfoLessonActivity.class);
            intent.putExtra("TOPIC_ID", topic.getId());
            intent.putExtra("TOPIC_NAME", topic.getName());

            getPrefsHelper().setTopicId(topic.getId());
            getPrefsHelper().setTopicName(topic.getName());

            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}