package com.refactoring.noteorganizerproject.entering_app.presenter;

import com.refactoring.noteorganizerproject.R;
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

    public void checkPassword() {
        if (isAppFirstEnter()) {
            appFirstEnter();
        } else {
            comparePasswords();
        }
    }

    private void comparePasswords() {
        String password = view.getPassword();
        if (isConvenient(password) && oldPassword.equals(password))
            view.allowEnterApp();
        else {
            view.showConfirmation(R.string.wrong_password_hint, null, null, R.string.understand, -1);
        }
    }

    private boolean isConvenient(String password) {
        if (password.length() < 4)
            return false;

        String oldPassword = appSettings.getLocalPassword();
        return oldPassword.equals("") || oldPassword.equals(password);
    }

    private void appFirstEnter() {

    }

    private boolean isAppFirstEnter() {
        return oldPassword.equals("");
    }
}
