package com.cowley.sitmeanssit.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.cowley.sitmeanssit.BaseActivity;
import com.cowley.sitmeanssit.R;

/**
 * Created by Ian Cowley on 6/6/16 at 11:40 PM.
 */

public class HomeActivity extends BaseActivity {

    public static void start(@NonNull Activity caller) {
        caller.startActivity(new Intent(caller, HomeActivity.class));
    }

    public static void startNew(@NonNull Activity caller) {
        Intent intent = new Intent(caller, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    public int getNavigationId() {
        return R.id.home;
    }
}
