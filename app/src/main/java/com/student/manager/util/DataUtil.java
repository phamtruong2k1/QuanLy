package com.student.manager.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataUtil {
    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        return  sdf.format(new Date());
    }
}
