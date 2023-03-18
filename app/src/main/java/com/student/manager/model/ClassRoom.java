package com.student.manager.model;

public class ClassRoom {
    int class_id;
    int course_id;
    int lecturer_id;
    String name;
    String start_date;
    String end_date;

    public ClassRoom(int class_id, int course_id, int lecturer_id, String name, String start_date, String end_date) {
        this.class_id = class_id;
        this.course_id = course_id;
        this.lecturer_id = lecturer_id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public ClassRoom() {
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }
}
