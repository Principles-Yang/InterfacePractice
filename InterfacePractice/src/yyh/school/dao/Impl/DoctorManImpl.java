package yyh.school.dao.Impl;

import yyh.school.dao.StudentMan;
import yyh.school.dao.TeacherMan;
import yyh.school.model.Students;


public class DoctorManImpl extends Students implements StudentMan, TeacherMan {
    private String name;
    private String sex;
    private int age;
    private double tuitiion;//每学期学费
    private double wage;//每月薪水
    public DoctorManImpl(String n, String s, int a){
        super();
        this.name=n;
        this.sex=s;
        this.age=a;
    }


    @Override
    public String toString() {
        return "该名博士生的信息{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }



    @Override
    public double payTuition(double t) {
        return tuitiion=t;
    }

    @Override
    public double checkTuition() {
        return tuitiion;
    }

    @Override
    public double payWage(double w) {
        return wage=w;
    }

    @Override
    public double checkWage() {
        return wage;
    }





}
