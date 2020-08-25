package com.refactoring.noteorganizerproject.entering_app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.refactoring.noteorganizerproject.Action;
import com.refactoring.noteorganizerproject.BaseActivity;
import com.refactoring.noteorganizerproject.MainActivity;
import com.refactoring.noteorganizerproject.R;
import com.refactoring.noteorganizerproject.entering_app.presenter.PasswordPresenter;

public class PasswordActivity extends BaseActivity {

    TextInputLayout passwordInputLayout;
    MaterialButton confirm;

    PasswordPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppTheme();
        setContentView(R.layout.activity_password);

        presenter = new PasswordPresenter(this);

        initUI();
    }

    private void initUI() {
        passwordInputLayout = findViewById(R.id.password_textInputLayout);
        confirm = findViewById(R.id.confirm_password);
        confirm.setOnClickListener(v -> presenter.checkPassword());
    }

    public String getPassword() { return passwordInputLayout.getEditText().getText().toString(); }

    public void allowEnterApp() {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    public void showConfirmation(int messageId, Action positive, Action negative,
                                 int textButtonPositiveId, int textButtonNegativeId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(messageId);
        if (textButtonPositiveId != -1) {
            builder.setPositiveButton(textButtonPositiveId, (dialog, which) -> {
                if (positive != null) positive.doAction();
                dialog.dismiss();
            });
        }
        if (textButtonNegativeId != -1) {
            builder.setNegativeButton(textButtonNegativeId, (d, w) -> {
                if (negative != null) negative.doAction();
                d.dismiss();
            });
            builder.show();
        }
    }



}
