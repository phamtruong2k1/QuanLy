package com.student.manager;

import android.app.Application;

import com.student.manager.dao.AccountDAO;
import com.student.manager.dao.LecturerDAO;
import com.student.manager.dao.StaffDAO;
import com.student.manager.dao.StudentDAO;
import com.student.manager.database.DatabaseDAO;
import com.student.manager.util.SaveUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SaveUtil.init(this);
        DatabaseDAO.init(this);
        initDataDAO();
    }

    private void initDataDAO() {
        AccountDAO.init(this);
        StudentDAO.init(this);
        LecturerDAO.init(this);
        StaffDAO.init(this);
    }

}
