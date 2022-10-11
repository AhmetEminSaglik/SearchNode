package org.aes.searchnode.dataaccess.concretes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PriorityFieldOrder<T> {
    List<T> tList = new ArrayList<>();
    Class clazz;

    public PriorityFieldOrder(Class clazz) {
        this.clazz = clazz;
    }

    public void setPriorityFieldsInRequestOrder(/*T t*/List<Object> fieldList) {
        //obje yerine clazz ile islemler yapilacak
    }

    public void setPriorityFieldsInDefaultOrder(/*T t*/) {
        //obje yerine clazz ile islemler yapilacak
    }

    public Field getPriorityField(/*T t*/) { // returns first index, this is for String,Integer...Byte
        //obje yerine clazz ile islemler yapilacak

    }

    public Field getPriorityField(/*T t,*/ String fieldName) {
        //obje yerine clazz ile islemler yapilacak

    }

    public Field getPriorityField(/*T t, */int index) {
        //obje yerine clazz ile islemler yapilacak

    }

    public List<Field> getPriorityFields(/*Object object*/) {
        //obje yerine clazz ile islemler yapilacak


    }
}
