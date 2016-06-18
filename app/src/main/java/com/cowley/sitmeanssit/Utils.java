package com.cowley.sitmeanssit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ian Cowley on 6/12/16 at 5:38 PM.
 */

public class Utils {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static void launchDialer(@NonNull Context context, @NonNull String phone) {
        phone = stripNonNumeric(phone);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }

    public static boolean validatePhoneNumber(@NonNull EditText input) {
        String phone = input.getText().toString().trim();
        phone = stripNonNumeric(phone);
        return phone.length() == 10;
    }

    public static boolean validateEmailAddress(@NonNull EditText input) {
        String email = input.getText().toString().trim();
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }

    private static String stripNonNumeric(String input) {
        return input.replaceAll( "[^\\d]", "");
    }
}
