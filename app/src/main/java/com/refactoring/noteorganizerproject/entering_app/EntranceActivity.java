package com.refactoring.noteorganizerproject.entering_app;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.refactoring.noteorganizerproject.BaseActivity;
import com.refactoring.noteorganizerproject.R;
import com.refactoring.noteorganizerproject.entity.AppConfig;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;

public class EntranceActivity extends BaseActivity {

    SharedPreferencesManager appSettings = AppConfig.getInstance().getAppSettings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppTheme();
        setContentView(R.layout.activity_entrance);

        initUI();
        initEnteringAppTimer();
    }

    private void initUI() {
        ImageView launcherIcon = findViewById(R.id.launcher_icon);
    }
}
