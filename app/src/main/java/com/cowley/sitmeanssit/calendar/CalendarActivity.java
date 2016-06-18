package com.cowley.sitmeanssit.calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.webkit.WebView;

import com.cowley.sitmeanssit.BaseActivity;
import com.cowley.sitmeanssit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ian Cowley on 6/17/16 at 9:59 PM.
 */

public class CalendarActivity extends BaseActivity {

    private static final String CALENDAR_URL = "https://calendar.google.com/calendar/embed?&showTz=0&mode=AGENDA&height=450&wkst=1&bgcolor=%23ffffff&src=sitmeanssitaustin.com_ut631cbgpr6hal0ib82uck8v38@group.calendar.google.com&color=%230D7813&ctz=America/Chicago";

    @BindView(R.id.webview)
    WebView webview;

    public static void start(Activity caller) {
        caller.startActivity(new Intent(caller, CalendarActivity.class));
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(CALENDAR_URL);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_calendar;
    }

    @Override
    public int getNavigationId() {
        return R.id.calendar;
    }

    @Override
    protected @StringRes int getToolbarTitleId() {
        return R.string.calendar;
    }
}
