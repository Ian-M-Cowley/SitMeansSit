package com.cowley.sitmeanssit.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.cowley.sitmeanssit.BaseActivity;
import com.cowley.sitmeanssit.R;
import com.cowley.sitmeanssit.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ian Cowley on 6/12/16 at 7:50 PM.
 */

@SuppressWarnings("ConstantConditions")
public class RequestConsultationActivity extends BaseActivity {

    private static final String INVALID = "Invalid";

    @BindView(R.id.name_layout)
    TextInputLayout nameInput;
    @BindView(R.id.email_layout)
    TextInputLayout emailInput;
    @BindView(R.id.phone_layout)
    TextInputLayout phoneInput;
    @BindView(R.id.zip_layout)
    TextInputLayout zipInput;
    @BindView(R.id.best_time)
    RadioGroup bestTimeGroup;
    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;

    public static void start(@NonNull Activity caller) {
        caller.startActivity(new Intent(caller, RequestConsultationActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        submit.setOnClickListener(view -> {
            if(validateForm()) {
                submit();
            }
        });

        nameInput.getEditText().setOnFocusChangeListener(errorClearer);
        emailInput.getEditText().setOnFocusChangeListener(errorClearer);
        phoneInput.getEditText().setOnFocusChangeListener(errorClearer);
        zipInput.getEditText().setOnFocusChangeListener(errorClearer);

        phoneInput.getEditText().addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_clear, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.clear:
                clear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean validateForm() {
        coordinatorLayout.requestFocus();
        boolean nameValid = !nameInput.getEditText().getText().toString().isEmpty();
        boolean emailValid = Utils.validateEmailAddress(emailInput.getEditText());
        boolean phoneValid = Utils.validatePhoneNumber(phoneInput.getEditText());
        boolean zipValid = zipInput.getEditText().getText().toString().length() == 5;

        if(nameValid) {
            nameInput.setError(null);
            nameInput.setErrorEnabled(false);
        } else {
            nameInput.setErrorEnabled(true);
            nameInput.setError(INVALID);
        }

        if(emailValid) {
            emailInput.setError(null);
            emailInput.setErrorEnabled(false);
        } else {
            emailInput.setErrorEnabled(true);
            emailInput.setError(INVALID);
        }

        if(phoneValid) {
            phoneInput.setError(null);
            phoneInput.setErrorEnabled(false);
        } else {
            phoneInput.setErrorEnabled(true);
            phoneInput.setError(INVALID);
        }

        if(zipValid) {
            zipInput.setError(null);
            zipInput.setErrorEnabled(false);
        } else {
            zipInput.setErrorEnabled(true);
            zipInput.setError(INVALID);
        }

        return nameValid && emailValid && phoneValid && zipValid;
    }

    private void submit() {

    }

    private void clear() {
        hideKeyboard(coordinatorLayout);
        coordinatorLayout.requestFocus();
        bestTimeGroup.check(R.id.mornings);

        nameInput.getEditText().setText(null);
        emailInput.getEditText().setText(null);
        phoneInput.getEditText().setText(null);
        zipInput.getEditText().setText(null);


        nameInput.setError(null);
        nameInput.setErrorEnabled(false);
        emailInput.setError(null);
        emailInput.setErrorEnabled(false);
        phoneInput.setError(null);
        phoneInput.setErrorEnabled(false);
        zipInput.setError(null);
        zipInput.setErrorEnabled(false);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_request_consultation;
    }

    @Override
    public int getNavigationId() {
        return R.id.request_consultation;
    }

    @Override
    protected @StringRes int getToolbarTitleId() {
        return R.string.request_consultation;
    }

    protected void showError(@NonNull String error) {
        Snackbar.make(coordinatorLayout, error, Snackbar.LENGTH_SHORT).show();
    }

    private View.OnFocusChangeListener errorClearer = (view, hasFocus) -> {
        if(hasFocus) {
            ((TextInputLayout)view.getParent()).setError(null);
            ((TextInputLayout)view.getParent()).setErrorEnabled(false);
        }
    };
}
