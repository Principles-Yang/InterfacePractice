package yyh.school.model;

public class Students {
    private String name;
    private String sex;
    private int age;

    public Students(){

    }

    public Students(String name,String sex, int age){
        this.name=name;
        this.sex=sex;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
