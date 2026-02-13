package com.learn2code.app;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private static final String PREFS_NAME = "AppPrefs";
    private static final String DARK_MODE_KEY = "DarkMode";
    private static final String PROGRAMMING_LANGUAGE_KEY = "ProgrammingLanguage";
    private static final String MODULE_ID_KEY = "ModuleID";
    private static final String MODULE_NAME_KEY = "ModuleName";
    private static final String TOPIC_ID_KEY = "TopicID";
    private static final String TOPIC_NAME_KEY = "TopicName";

    private final SharedPreferences prefs;

    public PreferencesHelper(Context context) {
        this.prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public boolean isDarkMode() {
        return prefs.getBoolean(DARK_MODE_KEY, false);
    }

    public void setDarkMode(boolean isDarkMode) {
        prefs.edit().putBoolean(DARK_MODE_KEY, isDarkMode).apply();
    }

    public String getProgrammingLanguage() {
        return prefs.getString(PROGRAMMING_LANGUAGE_KEY, "Java");
    }

    public void setProgrammingLanguage(String language) {
        prefs.edit().putString(PROGRAMMING_LANGUAGE_KEY, language).apply();
    }

    public long getModuleId() {
        return prefs.getLong(MODULE_ID_KEY, -1);
    }

    public void setModuleId(long moduleId) {
        prefs.edit().putLong(MODULE_ID_KEY, moduleId).apply();
    }

    public String getModuleName() {
        return prefs.getString(MODULE_NAME_KEY, "");
    }

    public void setModuleName(String moduleName) {
        prefs.edit().putString(MODULE_NAME_KEY, moduleName).apply();
    }

    public long getTopicId() {
        return prefs.getLong(TOPIC_ID_KEY, -1);
    }

    public void setTopicId(long topicId) {
        prefs.edit().putLong(TOPIC_ID_KEY, topicId).apply();
    }

    public String getTopicName() {
        return prefs.getString(TOPIC_NAME_KEY, "");
    }

    public void setTopicName(String topicName) {
        prefs.edit().putString(TOPIC_NAME_KEY, topicName).apply();
    }
}