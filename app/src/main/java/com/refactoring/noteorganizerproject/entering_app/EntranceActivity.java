package com.refactoring.noteorganizerproject.entering_app;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.refactoring.noteorganizerproject.BaseActivity;
import com.refactoring.noteorganizerproject.MainActivity;
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
        TextView appNameTv = findViewById(R.id.app_name);
        TextView teamCopyright = findViewById(R.id.team_copyright);
        resetAlpha(launcherIcon);
        resetAlpha(appNameTv);
        resetAlpha(launcherIcon);
        setAnimation(launcherIcon);
        setAnimation(appNameTv);
        setAnimation(teamCopyright);
    }

    private void enterApp() {
        boolean passwordEnable = appSettings.enterOnPassword();
        startActivity(new Intent(this,
                passwordEnable ? PasswordActivity.class : MainActivity.class));
        this.finish();
    }

    private void resetAlpha(View v) {
        v.setAlpha(0f);
    }

    private void setAnimation(View v) {
        float alphaTo = 1f;
        long duration = 1000;

        v.animate().alpha(alphaTo)
                .setDuration(duration)
                .setListener(null);
    }

    private void initEnteringAppTimer() {
        Handler delayedOpen = new Handler();
        delayedOpen.postDelayed(
                this::enterApp, 1000
        );
    }
}
