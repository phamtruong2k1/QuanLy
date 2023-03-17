package com.student.manager.dao;

import android.content.Context;

import com.student.manager.database.AppDataBase;
import com.student.manager.util.Constant;

public class LecturerDAO {
    public static AppDataBase dataBase;


    public static void init(Context context) {
        dataBase = new AppDataBase(context, Constant.NAME_DATABASE, null, 1);
    }
}
