package com.enity;

import java.util.Date;

public class Student {

    private String codeStudent, fullName, major, phone, email;
    private boolean gender;
    private Date date;

    public Student() {
    }

    public Student(String codeStudent, String fullName, String major, String phone, String email, boolean gender, Date date) {
        this.codeStudent = codeStudent;
        this.fullName = fullName;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.date = date;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
