package org.aes.searchnode.dataaccess.concretes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PriorityFieldOrder {
    List<String> fieldNameList = new ArrayList<>();
    Class clazz;

    public PriorityFieldOrder(Class clazz) {
        this.clazz = clazz;
    }

    public void setPriorityFieldsInRequestOrder(List<Object> fieldList) {
        //obje yerine clazz ile islemler yapilacak

    }

    public void setPriorityFieldsInDefaultOrder() {
        //obje yerine clazz ile islemler yapilacak
        System.out.println(clazz.getDeclaredFields().length);
        for (Field tmp : clazz.getDeclaredFields()) {
            fieldNameList.add(tmp.getName());
        }
//        System.out.println(clazz.getDeclaredFields()[1].getName());

    }

    public String getPriorityField() {
        if (!fieldNameList.isEmpty()) {
            return fieldNameList.get(0);
        }
        //obje yerine clazz ile islemler yapilacak
        return null;
    }

    public String getPriorityFieldName(String fieldName) {
        //obje yerine clazz ile islemler yapilacak
        for (String tmp : fieldNameList) {
            if (tmp.equals(fieldName)) {
                return tmp;
            }
        }
        return null;
    }

    public String getPriorityFieldName(int index) { // returns first index, this is for String,Integer...Byte
        //obje yerine clazz ile islemler yapilacak
        if (fieldNameList.size() > index) {
            return fieldNameList.get(index);
        }
        return null;

    }


    public List<String> getPriorityFieldsName() {
        //obje yerine clazz ile islemler yapilacak
        return fieldNameList;


    }
/*
Asagisi Field uzerinden islem yapmak icin
List<Object> tList = new ArrayList<>();

    public void setPriorityFieldsInRequestOrder(T tList<Object> fieldList) {
        //obje yerine clazz ile islemler yapilacak

    }

    public void setPriorityFieldsInDefaultOrder(T t) {
        //obje yerine clazz ile islemler yapilacak
        System.out.println(clazz.getDeclaredFields().length);
        for (Field tmp : clazz.getDeclaredFields()) {
            tList.add(tmp);
            System.out.println(tmp.getName());

        }
        System.out.println(clazz.getDeclaredFields()[1].getName());
        System.out.println("set over ");

    }

       public Field getPriorityField(T t) { // returns first index, this is for String,Integer...Byte
        //obje yerine clazz ile islemler yapilacak

  }

        public Field getPriorityField(T t, String fieldName) {
            //obje yerine clazz ile islemler yapilacak

        }

        public Field getPriorityField(T t, int index) {
            //obje yerine clazz ile islemler yapilacak

        }

        public List<Field> getPriorityFields () {
            //obje yerine clazz ile islemler yapilacak
            return (List<Field>) (Object) tList;


        }*/
}
