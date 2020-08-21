package com.refactoring.noteorganizerproject.entity.shared_prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.refactoring.noteorganizerproject.R;

public class SharedPreferencesManager {
    private final String CLASS_TAG = "SharedPreferencesManager";
    private SharedPreferences sp;

    public SharedPreferencesManager(Context context) {
        sp = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE);
    }

    public long getClickedNoteId() { return getLong("clickedNoteId", -1L); }
    public void setClickedNoteId(long id) { putLong("clickedNoteId", id); }
    public long getClickedTodoId() {return getLong("clickedTodoId", -1L); }
    public void setClickedTodoId(long id) {putLong("clickedTodoId", id); }

    // theme

    public int getAppTheme() { return getInt("appTheme", R.style.AppTheme); }
    public void setAppTheme(int appThemeId) {putInt("appTheme", appThemeId);}


    public void setAppDataDirectory(String path) {
        putString("appDataDirectory", path);
    }

    // BASIC FOR SP

    private Long getString(String key, Long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    private Long getLong(String key, Long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    private Long getInt(String key, Long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    private Long getBoolean(String key, Long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    private void putString(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private void putLong(String key, Long value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    private void putInt(String key, Integer value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}
