package com.wisn.tools;

public class TextUtils {
    public static boolean isEmpty(String text) {
        if (text == null || text.trim().length() == 0) return true;
        return false;
    }
}
