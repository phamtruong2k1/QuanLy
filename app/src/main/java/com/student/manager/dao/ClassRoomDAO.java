package com.student.manager.dao;

import android.content.Context;
import android.database.Cursor;

import com.student.manager.database.AppDataBase;
import com.student.manager.model.ClassRoom;
import com.student.manager.model.Course;
import com.student.manager.util.Constant;

import java.util.ArrayList;

public class ClassRoomDAO {
    public static AppDataBase dataBase;

    public static void init(Context context) {
        dataBase = new AppDataBase(context , Constant.NAME_DATABASE , null , 1);
        dataBase.QueryData(" CREATE TABLE IF NOT EXISTS ClassRoom(" +
                "class_id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "course_id INTEGER , " +
                "name VARCHAR(1000),  " +
                "start_date VARCHAR(1000),  " +
                "end_date VARCHAR(1000)  " +
                ") ");
    }

    public static void insertClassRoom(ClassRoom classRoom) {
        String sql = String.format(
                "INSERT INTO ClassRoom VALUES ( null, %s, '%s','%s','%s')",
                classRoom.getCourse_id(),
                classRoom.getName(),
                classRoom.getStart_date(),
                classRoom.getEnd_date()
        );
        dataBase.QueryData(sql);
    }

    public static void updateClassRoom(ClassRoom classRoom) {
        String sql = String.format(
                "UPDATE ClassRoom SET course_id = %s, name='%s', start_date='%s', end_date='%s' WHERE class_id = %s",
                classRoom.getCourse_id(),
                classRoom.getName(),
                classRoom.getStart_date(),
                classRoom.getEnd_date(),
                classRoom.getClass_id()
        );
        dataBase.QueryData(sql);
    }

    public static ArrayList<Course> getListCourse() {
        String query = "SELECT * FROM ClassRoom ";
        Cursor data = dataBase.GetData(query);
        ArrayList<Course> list = new ArrayList<>();
        while (data.moveToNext()){
            list.add( new Course(
                    data.getInt(0),
                    data.getString(1),
                    data.getString(2),
                    data.getInt(3),
                    data.getInt(4)
            ));
        }
        return list;
    }

    public static void deleteCourse(int id) {
        dataBase.QueryData(" DELETE FROM ClassRoom WHERE course_id = " + id +"" );
    }
}
