package com.example.a336819.jhsapplication;

public class Student {
    String Name;
    String Grade;
    String uID;

    public Student(String name, String grade, String uid) {
        this.Name=name;
        this.Grade=grade;
        this.uID=uid;
    }
    public String getStudentID() {
        return this.uID;
    }
    public String getStudentName() {
        return this.Name;
    }
    public String getStudentGrade() {
        return this.Grade;
    }

}
