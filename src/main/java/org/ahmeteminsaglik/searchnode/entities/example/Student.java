package org.ahmeteminsaglik.searchnode.entities.example;

//import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.IPriorityFields;

public class Student {
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

}
