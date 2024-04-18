package org.aes.searchnode.business.concretes.searchnode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("Ahmet");
        Student s2 = new Student("Meryem");
        List<Student> list = new ArrayList<>();
        list.add(student);
        student.name = "aaaaaaaaa";
        list.add(student);
        student= new Student("bbb");
        list.add(student);
        list.forEach(System.out::println);
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
