package com.student.manager.model;

public class Staff {
    int staff_id;
    int accountId;
    String name;
    boolean gender;
    String date_of_birth;
    String address;
    String phone_number;
    String date_of_join;
    int status;

    public Staff(int staff_id, int accountId, String name, boolean gender, String date_of_birth, String address, String phone_number, String date_of_join, int status) {
        this.staff_id = staff_id;
        this.accountId = accountId;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.phone_number = phone_number;
        this.date_of_join = date_of_join;
        this.status = status;
    }

    public Staff() {
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(String date_of_join) {
        this.date_of_join = date_of_join;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
