package com.example.model;

import java.util.Date;

public class Student {
    private String codeStudent, fullName, major, phone, email;
    private Date dateCreate;
    private boolean gender;

    public Student(String codeStudent, String fullName, boolean gender, String major, String phone, String email, Date dateCreate) {
        this.codeStudent = codeStudent;
        this.fullName = fullName;
        this.gender = gender;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.dateCreate = dateCreate;
    }

    public Student() {
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
