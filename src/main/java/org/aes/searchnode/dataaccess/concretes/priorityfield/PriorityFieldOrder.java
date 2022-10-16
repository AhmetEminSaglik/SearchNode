package org.aes.searchnode.dataaccess.concretes.priorityfield;

import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriorityFieldOrder {
    /*TODO
     *  List ve clazz newlenerek dondurulecek*/
    List<Field> fieldNameList = new ArrayList<>();
    Class clazz;

    public PriorityFieldOrder(Class clazz) throws NotFoundAnyDeclaredFieldException {
        this.clazz = clazz;
        setPriorityFieldsInDefaultOrder();
    }

    public void setPriorityFieldsInRequestOrder(List<Object> fieldList) throws NotFoundAnyDeclaredFieldException {
        if (fieldList.size() == 0) {
            throw new NotFoundAnyDeclaredFieldException(clazz);
        }
        //obje yerine clazz ile islemler yapilacak

    }

    public void setPriorityFieldsInDefaultOrder() throws NotFoundAnyDeclaredFieldException {
        //obje yerine clazz ile islemler yapilacak


        fieldNameList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        if (fieldNameList.size() == 0) {
            throw new NotFoundAnyDeclaredFieldException(clazz);
        }

//        System.out.println(fieldNameList.size());

    }

    public Field getFirstField() {
        if (!fieldNameList.isEmpty()) {
            return fieldNameList.get(0);
        }
        //obje yerine clazz ile islemler yapilacak
        return null;
    }

    public Field getPriorityField(String fieldName) {
        //obje yerine clazz ile islemler yapilacak
        for (Field tmp : fieldNameList) {
            if (tmp.getName().equals(fieldName)) {
                return tmp;
            }
        }
        return null;
    }

    public Field getPriorityFieldName(int index) throws NotFoundRequestedFieldException { // returns first index, this is for String,Integer...Byte
        //obje yerine clazz ile islemler yapilacak
        if (fieldNameList.size() > index) {
            return fieldNameList.get(index);
        }
        throw new NotFoundRequestedFieldException(clazz, fieldNameList.size());

    }


    public List<Field> getAllPriorityFieldsName() {
        //obje yerine clazz ile islemler yapilacak
        return fieldNameList;
    }

    public List<Field> getFieldNameList() {
//        Security precaution : In case of changing any element of list prevents changing original list
        return new ArrayList(fieldNameList);
    }

    public Class getClazz() {
        return clazz;
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
