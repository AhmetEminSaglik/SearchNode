package org.aes.searchnode;

//import org.aes.searchnode.objefield.ObjectField;
//import org.aes.searchnode.objefield.PriorityObjectField;

import org.aes.searchnode.dataaccess.concretes.PriorityField;
import org.aes.searchnode.entities.concretes.Employee;
import org.aes.searchnode.entities.concretes.Language;
import org.aes.searchnode.entities.concretes.Student;
import org.aes.searchnode.dataaccess.abstracts.IPriorityFields;
import org.aes.searchnode.exception.NotImplementedRequiredInterfaceError;

import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public void getFieldInfo(Object object, String fieldName) throws Exception {
//        System.out.println("A");

//        System.out.println("B");
//        IPriorityFields pf = (IPriorityFields) object;
//        List<Object> list = pf.getPriorityFieldValue();
//        System.out.println("C");
        PriorityField priorityField = new PriorityField();
//        System.out.println("D");

        Object value = priorityField.getPriorityFieldValue(object, fieldName);
//        System.out.println("Z");

        System.out.println(object + " -----------> " + fieldName + " : " + value);


        /*if (object instanceof IPriorityFields) {
            IPriorityFields pf = (IPriorityFields) object;
            List<Field> fieldList = pf.getPriorityFields();
            for (Field tmp : fieldList) {
                try {
                    tmp.trySetAccessible();
                    System.out.println(tmp.getName() + " : " + tmp.get(object));
                    System.out.println("field name ==>  : " + tmp.getName());
                } catch (IllegalAccessException e) {
                    System.out.println("tmp.get() error : " + e.getMessage());
                }
            }

        } else if (object instanceof Byte ||
                object instanceof Short ||
                object instanceof Integer ||
                object instanceof Float ||
                object instanceof Double ||
                object instanceof Boolean ||
                object instanceof Character ||
                object instanceof String
        ) {
            System.out.print(object + ", ");
        } else {
            throw new NotImplementedRequiredInterfaceError(object.getClass());
        }*/
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Main main = new Main();
        int[] numbers = {12, 3, 4};
        String[] text = {"Kayseri", "Zeynep", "Yemek", "Kalem", "Ulke", "Ingilizce"};
        Student[] students = {
                new Student("Ahmet", "SAGLIK", 24, 1001),
                new Student("Omer", "Koramaz", 20, 1002),
                new Student("Aynur", "YILDIRIM", 25, 1003),
        };
//        Employee[] employees = {new Employee(),new Employee(),new Employee()};
        Language[] languages = {new Language(1, "Turkish", 2), new Language(2, "English", 1), new Language(3, "Spanish", 3)};
        Employee[] employees = {
                new Employee("Software", 111111111, languages),
                new Employee("Human Resources", 222222222, languages),
                new Employee("IT", 333333333, languages)
        };
        try {
//            System.out.println("Integer : ");
            for (Integer tmp : numbers) {
//                main.getFieldInfo(tmp,null);
            }
            System.out.println("\n----------------");

//            System.out.println("String : ");
            for (String tmp : text) {
//                main.getFieldInfo(tmp,null);
            }
            System.out.println("\n----------------");

            System.out.println("Student : ");
            for (Student tmp : students) {
//                main.getFieldInfo(tmp,"no");
                if(tmp.getPriorityFields().size()>0)
                main.getFieldInfo(tmp, tmp.getPriorityFields().get(0).getName());

            }
            System.out.println("\n----------------");

            System.out.println("Employee");
            for (Employee tmp : employees) {
//                main.getFieldInfo(tmp, "language");
            }
            System.out.println("\n----------------");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        NodeSearch<Integer> nsInteger = new NodeSearch();
//        nsInteger.ad
        List<Field> fieldPriority = new ArrayList<Field>();
//        fieldPriority.add(list.get(1)); //lastname
//        fieldPriority.add(list.get(1));
        /*
         *
         * business
         *   abstracts
         *   concretes
         * core
         *   utilities
         * dataAccess
         *   abstracts
         *   concretes
         * entities
         *   abstracts
         *   concretes
         * */
    }

}

/*  Integer i = 1998;
        Main main = new Main();
        main.getFieldInfo(i);

        Character ccc = 'c';
        main.getFieldInfo(ccc);
        Float f = 222.2f;
        main.getFieldInfo(f);
        String sss = "STRING TEST";
        System.out.println("sss : " + sss);
        main.getFieldInfo(sss);

        Student student = new Student("Ahmet","SAGLIK",24,1998);
        main.getFieldInfo(student);

        System.exit(0);
        Double ddd = 2.2;
        Character character = 'c';
        Field cField = character.getClass().getDeclaredField("value");
        cField.trySetAccessible();
//        System.out.println(cField.getName());
//        System.out.println(cField+ " : "+cField.get(cField));
        System.out.println("------");
//        Integer i = 1998;
        Field field = i.getClass().getDeclaredField("value");
        field.setAccessible(true);
//        field.set(null,null);
//        System.out.println(field.trySetAccessible());
//        field.setBoolean(field,Boolean.TRUE);
        System.out.println(field.getName());
        System.out.println(field + " : " + field.get(i));
        System.out.println("referance :" + i);

        i = 1997;
        System.out.println("referance :" + i.getClass());
//        System.out.println(i.getClass().getDeclaredField("value").get(i));

//        System.exit(0);
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("cField : " + cField.getClass().getDeclaredFields().length);
        for (Field tmp : cField.getClass().getDeclaredFields()) {
            try {
                tmp.setAccessible(true);
                Object value = tmp.get(cField);
                System.out.println(tmp + "  : " + value);
            } catch (Exception e) {
                System.out.println(" error : " + e.getMessage());
            }
        }
        System.out.println("bitti");
        System.exit(0);
//        Student student = new Student();
        System.out.println(student);
        List<Field> list = student.getPriorityFields();
        for (Field tmp : list) {
            System.out.println(tmp);
        }
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        char b[] = {'a', 'b', 'c', 'd'};
        String c[] = {"aa", "bb", "cc", "dd"};
        List<Integer> intList = new ArrayList();
        List<Character> charList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        int val = 111;
        Integer iInt = val;
        System.out.println(iInt);
        System.out.println(iInt.getClass());
        char ch = 'c';
//        Character character = ch;
//        System.out.println(character);

        System.out.println(character.getClass());
        double dob = 22.22;
        Double dDob = dob;
        System.out.println(dDob);

        System.out.println(dDob.getClass());
        byte bytee = 22;
        Byte bByte = bytee;
        System.out.println(bByte);

        System.out.println(bByte.getClass());

        NodeSearch<String> nsString = new NodeSearch();
        NodeSearch<Integer> nsInt = new NodeSearch();
        NodeSearch<Student> nsStudent = new NodeSearch();

        System.exit(0);
//        NodeSearch<Integer> nsInteger = new NodeSearch<>();
//        System.out.println(nsInteger.getPriorityFields());
//        NodeSearch<Student> nsStudent = new NodeSearch<>();
//        System.out.println("Student : " + nsStudent.getPriorityFields());
        List<? extends IPriorityFields> ipfList = new ArrayList<>();
        Student s = new Student();
//        ipfList.add(s);

        IPriorityFields pf = new IPriorityFields() {
            @Override
            public List<Field> getPriorityFields() {
                return IPriorityFields.super.getPriorityFields();
            }
        };
        //nodeSearch.
//        St

//        ObjectField objectField = new ObjectField();

/*
       List<Integer> priorityListOrder = new ArrayList<>();
        priorityListOrder.add(1);
        priorityListOrder.add(0);
        priorityListOrder.add(2);

        PriorityObjectField priorityObjectField = new PriorityObjectField();
        List priorityFieldOrder =  priorityObjectField.getFieldsInPriorityOrder(Student.class, priorityListOrder);



        List<Field> fieldListOfObject = objectField.getFieldListOfObject(Student.class);


        objectField.getNameOfDeclaredFieldIndex(Student.class, priorityListOrder);

        priorityList.add(objectField.getNameOfDeclaredFieldIndex(Student.class, 1));
        priorityList.add(objectField.getNameOfDeclaredFieldIndex(Student.class, 0));

        PriorityObjectField priorityObjectField = new PriorityObjectField();*/

//        List<String> priorityList = new ArrayList<>();
//        priorityList.add(new Student().getClass().getDeclaredField())
//        System.out.println(new Student().getClass().getDeclaredField("name"));
//        System.out.println(new Student().getClass().getDeclaredFields()[0]);
//        System.out.println(new Student().getClass().getDeclaredFields()[0].getName());
//        System.out.println(Student.class.getDeclaredFields()[0].getName());
//        objectField.getNameOfDeclaredFieldIndex(Student.class, 1);
//        System.out.println("--");

//        objectField.getNameOfDeclaredFieldIndex(Student.class.getDeclaredFields()[0],)
//        System.exit(0);
//        priorityObjectField.setPriorityField();
//        priorityList.add(fieldList)
//        HashMap<String, Field> hashMap = objectField.getFieldMapOfObject(new Student());
//        Student student = new Student("Ahmet", "SAGLIK", 24, 100);
//        for(Map.Entry<String,Field> set : hashMap.entrySet()){
//            System.out.println("hashmap : "+set.getKey()+ " : " +set.getValue().get);
//        }
//        System.out.println("name : "+hashMap.get("name").getName());
//        for (Field tmp : list) {
//            System.out.println(tmp.getName() + " : " + tmp.get(student));
//        }

// lastname, name, no ya gore listelemek istiyorum*/