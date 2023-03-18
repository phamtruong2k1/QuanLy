package com.student.manager.util;

import com.student.manager.model.CourseType;
import com.student.manager.model.Level;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DataUtil {
    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        return  sdf.format(new Date());
    }

    public static ArrayList<Level> listLevel = new ArrayList<>();
    public static ArrayList<CourseType> listCourseType = new ArrayList<>();

    public static void init() {
        listLevel.clear();
        listLevel.add(new Level(1, "Beginer", ""));
        listLevel.add(new Level(2, "Normal", ""));
        listLevel.add(new Level(3, "Medium", ""));
        listLevel.add(new Level(4, "Good", ""));
        listLevel.add(new Level(5, "Excellent", ""));

        listCourseType.clear();
        listCourseType.add(new CourseType(1, "Quick Course", ""));
        listCourseType.add(new CourseType(2, "Basic Course", ""));
        listCourseType.add(new CourseType(3, "Advanced Course", ""));
    }
}
