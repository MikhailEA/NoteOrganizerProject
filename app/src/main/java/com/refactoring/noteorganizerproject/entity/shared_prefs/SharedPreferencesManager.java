package com.refactoring.noteorganizerproject.entity.shared_prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private final String CLASS_TAG = "SharedPreferencesManager";
    private SharedPreferences sp;

    public SharedPreferencesManager(Context context) {
        sp = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE);
    }

    public void setAppDataDirectory(String path) {
        putString("appDataDirectory", path);
    }

    private void putString(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
