package com.refactoring.noteorganizerproject.entity.data_base.impl;

import com.refactoring.noteorganizerproject.entity.AppConfig;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;

public class TodoDaoImpl {

    public SharedPreferencesManager getAppSettings() {
        return AppConfig.getInstance().getAppSettings();
    }
}
