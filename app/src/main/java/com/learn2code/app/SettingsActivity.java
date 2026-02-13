package com.learn2code.app;

import android.os.Bundle;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Switch themeSwitch = findViewById(R.id.themeSwitch);
        themeSwitch.setChecked(getPrefsHelper().isDarkMode());
        
        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            getPrefsHelper().setDarkMode(isChecked);
            AppCompatDelegate.setDefaultNightMode(
                isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
            );
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}