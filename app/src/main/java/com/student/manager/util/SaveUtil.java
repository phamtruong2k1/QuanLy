package com.student.manager.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

@SuppressLint("CommitPrefEdits")
public class SaveUtil {
    public  static SharedPreferences sharedPreferences;

    public static void init(Context context){
        sharedPreferences = context.getSharedPreferences("data_quanly_manager", Context.MODE_PRIVATE);
    }

    public static void setTaikoan(String data) {
        sharedPreferences.edit().putString("local_taikhoan", data).apply();
    }
    public static String getTaikoan() {
        return sharedPreferences.getString("local_taikhoan", "");
    }


    public static void setMatKhau(String data) {
        sharedPreferences.edit().putString("local_matkhau", data).apply();
    }
    public static String getMatKhau() {
        return sharedPreferences.getString("local_matkhau", "");
    }


    public static void setName(String data) {
        sharedPreferences.edit().putString("local_name", data).apply();
    }
    public static String getName() {
        return sharedPreferences.getString("local_name", "");
    }


}
