package com.learn2code.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public abstract class BaseActivity extends AppCompatActivity {

    private PreferencesHelper prefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefsHelper = new PreferencesHelper(this);
        applyTheme();
        super.onCreate(savedInstanceState);
    }

    protected void applyTheme() {
        boolean isDarkMode = prefsHelper.isDarkMode();
        AppCompatDelegate.setDefaultNightMode(
            isDarkMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
        );
    }

    protected PreferencesHelper getPrefsHelper() {
        return prefsHelper;
    }
}