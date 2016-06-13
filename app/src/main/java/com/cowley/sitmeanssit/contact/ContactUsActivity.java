package com.cowley.sitmeanssit.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.widget.EditText;

import com.cowley.sitmeanssit.AppModule;
import com.cowley.sitmeanssit.BaseActivity;
import com.cowley.sitmeanssit.R;
import com.cowley.sitmeanssit.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ian Cowley on 6/12/16 at 7:50 PM.
 */

public class ContactUsActivity extends BaseActivity {

    @BindView(R.id.call_fab)
    FloatingActionButton callFab;
    @BindView(R.id.name_input)
    EditText nameInput;
    @BindView(R.id.email_input)
    EditText emailInput;
    @BindView(R.id.phone_input)
    EditText phoneInput;
    @BindView(R.id.zip_input)
    EditText zipInput;

    public static void start(@NonNull Activity caller) {
        caller.startActivity(new Intent(caller, ContactUsActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        callFab.setOnClickListener(view -> Utils.launchDialer(this, AppModule.getPhoneNumber()));
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_contact_us;
    }

    @Override
    public int getNavigationId() {
        return R.id.contact_us;
    }
}
