package com.cowley.sitmeanssit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by Ian Cowley on 6/12/16 at 5:38 PM.
 */

public class Utils {

    public static void launchDialer(@NonNull Context context, @NonNull String phone) {
        phone = stripNonNumeric(phone);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }

    private static String stripNonNumeric(String input) {
        return input.replaceAll( "[^\\d]", "");
    }
}
