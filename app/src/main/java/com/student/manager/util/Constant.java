package com.student.manager.util;

import com.student.manager.model.Account;

public class Constant {
    public static String NAME_DATABASE = "quanly_student.sqlite";

    public static String ROLE_ADMIN = "admin";
    public static String ROLE_STAFF = "staff";
    public static String ROLE_LECTURER = "lecturer";
    public static String ROLE_STUDENT = "student";


    public static Account accountAdmin01 = new Account(0, "a", "a", ROLE_ADMIN, "okla@gmail.com");
}
