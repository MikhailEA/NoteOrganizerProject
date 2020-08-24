package com.refactoring.noteorganizerproject.entering_app.presenter;

import com.refactoring.noteorganizerproject.entering_app.PasswordActivity;
import com.refactoring.noteorganizerproject.entity.AppConfig;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;

public class PasswordPresenter {
    private SharedPreferencesManager appSettings;
    private PasswordActivity view;

    private String oldPassword;

    public PasswordPresenter (PasswordActivity activity) {
        this.view = activity;
        appSettings = AppConfig.getInstance().getAppSettings();
        oldPassword = appSettings.getLocalPassword();
    }
}
