package com.learn2code.app;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.learn2code.app.data.repository.AppRepository;

public class InfoLessonActivity extends BaseActivity {

    private TextView infoTextView;
    private TextView sampleCodeTextView;
    private Spinner languageSpinner;
    private long topicId;
    private String[] languages = {"Java", "Python", "C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_lesson);

        infoTextView = findViewById(R.id.infoTextView);
        sampleCodeTextView = findViewById(R.id.sampleCodeTextView);
        Button startLessonButton = findViewById(R.id.startLessonButton);
        languageSpinner = findViewById(R.id.languageSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        topicId = getIntent().getLongExtra("TOPIC_ID", -1);

        if (topicId == -1) {
            topicId = getPrefsHelper().getTopicId();
        }

        if (topicId == -1) {
            finish();
        }

        if (getSupportActionBar() != null) {
            String descriptionResourceName = String.format("topic_%s_title", topicId);
            int resourceId = this.getResources().getIdentifier(descriptionResourceName, "string", this.getPackageName());
            if (resourceId != 0){
                getSupportActionBar().setTitle(this.getString(resourceId));
            }
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String savedLanguage = getPrefsHelper().getProgrammingLanguage();
        int savedIndex = java.util.Arrays.asList(languages).indexOf(savedLanguage);
        languageSpinner.setSelection(savedIndex);

        updateContent(savedLanguage);

        languageSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                String selectedLanguage = languages[position];
                getPrefsHelper().setProgrammingLanguage(selectedLanguage);
                updateContent(selectedLanguage);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
            }
        });

        startLessonButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, LessonActivity.class);
            intent.putExtra("TOPIC_ID", topicId);
            startActivity(intent);
        });
    }

    private void updateContent(String language) {
        Info topicInfo = AppRepository.getInstance(this).getTopicInfo(topicId, language);
        if (topicInfo != null && topicInfo.getSampleCode() != null && !topicInfo.getSampleCode().isEmpty()) {
            sampleCodeTextView.setText(topicInfo.getSampleCode());
            sampleCodeTextView.setVisibility(View.VISIBLE);
        } else {
            sampleCodeTextView.setVisibility(View.GONE);
        }

        String infoLangResourceName = String.format("topic_%s_info_%s", topicId, language.toLowerCase());
        int infoLangResourceID = this.getResources().getIdentifier(infoLangResourceName, "string", this.getPackageName());

        if (topicInfo == null && infoLangResourceID == 0) {
            infoTextView.setVisibility(View.GONE);
        } else if (infoLangResourceID != 0) {
            infoTextView.setText(getString(infoLangResourceID));
            infoTextView.setVisibility(View.VISIBLE);
        } else {
            infoTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}