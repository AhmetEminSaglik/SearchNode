package org.aes.searchnode;


import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.*;
import org.aes.searchnode.entities.example.Employee;
import org.aes.searchnode.entities.example.Language;
import org.aes.searchnode.entities.example.SpecialBigDecimal;
import org.aes.searchnode.entities.example.Student;

import java.math.BigDecimal;
import java.util.*;

public class Main {
//    static PrimitiveWrapper primitiveWrapper = new PrimitiveWrapper();

    static void printList(Object[] objects, PriorityFieldValue priorityFieldValue, String fieldName) {
        System.out.println("----------------------------  ARRAY : ");
        System.out.println(objects.getClass().getSimpleName());
        try {

            for (Object tmp : objects) {
                System.out.println("Read value : " + priorityFieldValue.getValueOfField(tmp, fieldName));
                printPriorityCharOfText(priorityFieldValue.getValueOfField(tmp, fieldName).toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void printList(List<?> objects, PriorityFieldValue priorityFieldValue, String fieldName) {
        System.out.println("++++++++++++++++++++++++++++  LISTE : ");
        System.out.println(objects.getClass().getSimpleName());
        try {
            for (Object tmp : objects) {
                System.out.println("Read value : " + priorityFieldValue.getValueOfField(tmp, fieldName));
                printPriorityCharOfText(priorityFieldValue.getValueOfField(tmp, fieldName).toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void printPriorityCharOfText(String text) {
        PriorityCharManager priorityCharManager = new PriorityCharManager();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            DataResult<PriorityChar> dataResult = priorityCharManager.getPriorityChar(chars[i]);
//            System.out.println(dataResult.toString());
            System.out.println("PriorityChar : " + dataResult.getData() + " / message : " + dataResult.getMsg());
//            System.exit(0);
//            System.out.println("PriorityChar : "+);;

        }
    }
static void printIntegerAscii(){

    System.out.println("0 : "+(int)('0'));
    System.out.println("1 : "+(int)('1'));
    System.out.println("2 : "+(int)('2'));
    System.out.println("3 : "+(int)('3'));
    System.out.println("4 : "+(int)('4'));
    System.out.println("5 : "+(int)('5'));
    System.out.println("6 : "+(int)('6'));
    System.out.println("7 : "+(int)('7'));
    System.out.println("8 : "+(int)('8'));
    System.out.println("9 : "+(int)('9'));
    System.exit(0);
}
    public static void main(String[] args) {
//        Bu kismi arraylerden veri cekerek test edicem.
//        printIntegerAscii();



        Double[] numDoubles = {12.2, 3.3, 4.0, -2.2};
        Integer[] numbers = {12, 3, 4};
        List<Integer> numberList = new ArrayList<>();
        numberList.add(101);
        numberList.add(102);
        numberList.add(103);


        BigDecimal[] bigDecimals = {new BigDecimal("11.11"), new BigDecimal("12.999"), new BigDecimal("0.001")};
        String[] text = {"Kayseri", "Zeynep", "Yemek", "Kalem", "Ulke", "Ingilizce"};

        Student[] students = {
                new Student("Ahmet", "SAGLIK", 24, 1001),
                new Student("Omer", "Koramaz", 20, 1002),
                new Student("Aynur", "YILDIRIM", 25, 1003),
        };
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("ŞşİiIıÖöÜüÇç", "SAGLIK", 24, 1001));
        studentList.add(new Student("niña", "Koramaz", 20, 1002));
        studentList.add(new Student("诶 贼德", "YILDIRIM", 25, 1003));
        studentList.add(new Student("あん", "YILDIRIM", 26, 1004));
        studentList.add(new Student("شغظذخثتسرقضفعصنملكيطحزوهدجبا", "YILDIRIM", 26, 1005));
//        Employee[] employees = {new Employee(),new Employee(),new Employee()};
        Language[] languages = {new Language(1, "Turkish", 2), new Language(2, "English", 1), new Language(3, "Spanish", 3)};
        Employee[] employees = {
                new Employee("Software", 111111111, languages),
                new Employee("Human Resources", 222222222, languages),
                new Employee("IT", 333333333, languages)
        };
        Boolean[] booleans = {true, false, false, true, true, false};
        Character[] characters = {'c', 'h', 'a', 'r', 'a', 'c', 't', 'e', 'r', 's'};
        SpecialBigDecimal[] specialBigDecimal = {new SpecialBigDecimal("1"), new SpecialBigDecimal("2"), new SpecialBigDecimal("3"), new SpecialBigDecimal("4")};

        try {

            PriorityFieldOrder pfoInteger = new PriorityFieldOrder(Integer.class);
            PriorityFieldValue pfvInteger = new PriorityFieldValue(pfoInteger);
            printList(numbers, pfvInteger, "");
            printList(numberList, pfvInteger, "");

            PriorityFieldOrder pfoStudent = new PriorityFieldOrder(Student.class);
            PriorityFieldValue pfvStudent = new PriorityFieldValue(pfoStudent);
            String fieldName = pfoStudent.getPriorityFieldName(0).getName();
            printList(students, pfvStudent, fieldName);
            printList(studentList, pfvStudent, fieldName);

        } catch (Exception e) {
            e.printStackTrace();
        }


      /*  try {
//            AbstractPriorityFieldOrder pfooInteger = new WrapperObjectPriorityFieldOrder(Integer.class);
//            IPriorityFieldValue pfvInteger= pfoInteger.getiPriorityFieldValue();
//            pfvInteger.getValueOfField()


//            System.exit(0);

            PriorityFieldOrder pfoInteger = new PriorityFieldOrder(Integer.class);
//            pfoInteger.setPriorityFieldsInDefaultOrder();
//            List<Field> fnIntegerList = pfoInteger.getAllPriorityFieldsName();
            PriorityFieldValue pfvInteger = new PriorityFieldValue(pfoInteger*//*Integer.class, fnIntegerList*//*);


            System.out.println("Integer : ");
            for (Integer tmp : numbers) {
                System.out.println("Read Value : " + pfvInteger.getValueOfField(tmp));
            }
            System.out.println("\n----------------");

            System.out.println("String : ");
            PriorityFieldOrder pfoString = new PriorityFieldOrder(String.class);
            pfoString.setPriorityFieldsInDefaultOrder();
            List<Field> fnStringList = pfoString.getAllPriorityFieldsName();


            PriorityFieldValue pfvString = new PriorityFieldValue(*//*String.class, fnStringList*//*pfoString);

            for (String tmp : text) {
                System.out.println("Read Value : " + pfvString.getValueOfField(tmp));
            }
//            for (Field tmp : fnStringList) {
//                main.getFieldInfo(tmp,null);
//                System.out.println(tmp.getName());
//                pfv.getValueOfField(tmp,null);

//            }
            System.out.println("\n----------------");

//            System.exit(0);

            System.out.println("Student : ");
            PriorityFieldOrder pfoStudent = new PriorityFieldOrder(Student.class);
            pfoStudent.setPriorityFieldsInDefaultOrder();
            List<Field> pfList = pfoStudent.getAllPriorityFieldsName();
//            System.exit(0);
            PriorityFieldValue pfValueStudent = new PriorityFieldValue(*//*Student.class, pfList*//*pfoStudent);
            System.out.println("List<String> fieldNameList= pfStudent.getAllPriorityFieldsName(); : ");
            for (Student tmp : students) {
                pfValueStudent.getValueOfField(tmp, pfoStudent.getPriorityFieldName(3));
//                main.getFieldInfo(tmp,"no");
//                if(tmp.getPriorityFields().size()>0)
//                main.getFieldInfo(tmp, tmp.getPriorityFields().get(0).getName());


            }
//            System.exit(0);
//            for(Field tmp : pfList){
//                System.out.println(tmp.getName());
//            }

            System.out.println("\n----------------");
//            System.exit(0);


            *//*
         * (Abstract)PriorityFieldOrder pfOrderEmployee = new PriorityFieldOrder(Employee.class);
         * pfOrderEmployee.setPriorityFieldsInDefaultOrder();
         * (Abstract) PriorityFieldValue pfValueEmployee = new PriorityFieldValue(Employee.class, null); // PriorityFieldOrder alsa
         * *//*
            PriorityFieldOrder pfOrderEmployee = new PriorityFieldOrder(Employee.class);
//            pfOrderEmployee.setPriorityFieldsInDefaultOrder();
            List<Field> pfEmployeeList = pfOrderEmployee.getAllPriorityFieldsName();
            PriorityFieldValue pfValueEmployee = new PriorityFieldValue(*//*Employee.class, pfEmployeeList*//*pfOrderEmployee);
            for (Employee tmp : employees) {
                pfValueEmployee.getValueOfField(tmp, pfOrderEmployee.getPriorityFieldName(0));
            }
            System.out.println("\n----------------");
       *//* } catch (Exception e) {
            e.printStackTrace();
//            System.err.println(e.getMessage());
        }

        try {*//*
            PriorityFieldOrder pfOBigDecimal = new PriorityFieldOrder(BigDecimal.class);
            pfOBigDecimal.setPriorityFieldsInDefaultOrder();
            List<Field> pfBigDecimalList = pfOBigDecimal.getAllPriorityFieldsName();
            PriorityFieldValue pfValueBigDecimal = new PriorityFieldValue(pfOBigDecimal*//*BigDecimal.class, pfBigDecimalList*//*);
            for (BigDecimal tmp : bigDecimals) {
                System.out.println("big deciemal : " + pfValueBigDecimal.getValueOfField(tmp));
            }
            PriorityFieldOrder pfOBooleans = new PriorityFieldOrder(Boolean.class);
            pfOBooleans.setPriorityFieldsInDefaultOrder();
            List<Field> pfBooleansList = pfOBooleans.getAllPriorityFieldsName();
            PriorityFieldValue pfValueBoolean = new PriorityFieldValue(pfOBooleans*//*Boolean.class, pfBooleansList*//*);
            for (Boolean tmp : booleans) {
                System.out.println("booleans : " + pfValueBoolean.getValueOfField(tmp));
            }
            System.out.println("-------------");
            PriorityFieldOrder pfOCharacter = new PriorityFieldOrder(Character.class);
            pfOCharacter.setPriorityFieldsInDefaultOrder();
            List<Field> pfCharacterList = pfOCharacter.getAllPriorityFieldsName();
            PriorityFieldValue pfValueCharacter = new PriorityFieldValue(pfOCharacter*//*Character.class, pfCharacterList*//*);
            for (Character tmp : characters) {
                System.out.println("Characters : " + pfValueCharacter.getValueOfField(tmp));
            }

            PriorityFieldOrder pfOSpecialString = new PriorityFieldOrder(SpecialBigDecimal.class);
            pfOSpecialString.setPriorityFieldsInDefaultOrder();
            List<Field> pfSpecialStringList = pfOSpecialString.getAllPriorityFieldsName();
            PriorityFieldValue pfValueSpecialString = new PriorityFieldValue(pfOSpecialString*//*SpecialBigDecimal.class, null*//*);
            for (SpecialBigDecimal tmp : specialBigDecimal) {
                System.out.println("Special string : " + pfValueSpecialString.getValueOfField(tmp));
            }


        } catch (InvalidFieldOrFieldNameException e) {
            throw new RuntimeException(e);
        } catch (ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException e) {
            throw new RuntimeException(e);
        } catch (NotFoundAnyDeclaredFieldException e) {
            throw new RuntimeException(e);
        } catch (NotFoundRequestedFieldException e) {
            throw new RuntimeException(e);
        }
        SearchNode<Integer> nsInteger = new SearchNode();
//        nsInteger.ad
        List<Field> fieldPriority = new ArrayList<Field>();
//        fieldPriority.add(list.get(1)); //lastname
//        fieldPriority.add(list.get(1));
        *//*
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

        SearchNode<String> nsString = new SearchNode();
        SearchNode<Integer> nsInt = new SearchNode();
        SearchNode<Student> nsStudent = new SearchNode();

        System.exit(0);
//        SearchNode<Integer> nsInteger = new SearchNode<>();
//        System.out.println(nsInteger.getPriorityFields());
//        SearchNode<Student> nsStudent = new SearchNode<>();
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