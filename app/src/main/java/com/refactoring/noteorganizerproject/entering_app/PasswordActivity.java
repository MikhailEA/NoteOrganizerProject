package com.refactoring.noteorganizerproject.entering_app;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.refactoring.noteorganizerproject.BaseActivity;
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
    }


}
