package com.cowley.sitmeanssit.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cowley.sitmeanssit.BaseActivity;
import com.cowley.sitmeanssit.R;

/**
 * Created by Ian Cowley on 6/6/16 at 11:40 PM.
 */

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_home;
    }
}
