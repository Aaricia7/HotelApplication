package com.capgemini.repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {


    public static boolean emailMatcher(String guestEmailAdress) {//Email validator
        final Pattern pattern = Pattern.compile("[_a-zA-Z0-9-]+\\@+[a-zA-Z0-9-.]+\\.+[a-zA-Z]*", Pattern.CASE_INSENSITIVE);
        Matcher e = pattern.matcher(guestEmailAdress);
        return e.find();
    }

    public static boolean phoneMatcher(String guestPhonenumber) {//PhoneNumber validator
        final Pattern pattern = Pattern.compile("\\+([0-9]){1,6}-([0-9]){10,15}", Pattern.CASE_INSENSITIVE);
        Matcher p = pattern.matcher(guestPhonenumber);
        return p.find();
    }


    }
