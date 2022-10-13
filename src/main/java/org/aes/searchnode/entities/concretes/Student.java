package org.aes.searchnode.entities.concretes;

import org.aes.searchnode.dataaccess.abstracts.IPriorityFields;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Student implements IPriorityFields {
    private String name;
    private String lastName;
//    List<Student> studentDirectionList = new ArrayList<>();

//    Student root;
//    HashMap hashMapDirection= new HashMap<Student,Student>();

    //    private StudentDirection studentDirection;//= new StudentDirectionList();//= new StudentDirectionHashmap();
    private int age;
    private int no;

    public Student() {
    }

    public Student(String name, String lastName, int age, int no) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.no = no;
    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", no=" + no +
                '}';
    }

/*   @Override
    public List<Field> getPriorityFields() {
      *//*  List<Field> list = new ArrayList<>();
        try {
            list.add(this.getClass().getDeclaredField("lastName"));
            list.add(this.getClass().getDeclaredField("no"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }*//*
        return list;
    }*/
//    public Student getStudent(){
//        return  new Student(name,lastName,age,no);
//    }

//    public StudentDirection getStudentDirection() {
//        if (studentDirection == null)
//            studentDirection = new StudentConfiguration().getStudentDirection();
//        return studentDirection;
//    }
//
//    public void setStudentDirection(StudentDirection studentDirection) {
//        this.studentDirection = studentDirection;
//    }
}
