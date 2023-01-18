package org.ahmeteminsaglik.searchnode.dataaccess.concretes.priorityfield;

import org.ahmeteminsaglik.searchnode.business.concretes.PrimitiveWrapper;
import org.ahmeteminsaglik.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.ahmeteminsaglik.searchnode.exception.InvalidFieldOrFieldNameException;

import java.lang.reflect.Field;
import java.util.List;

public class PriorityFieldValue {
    /*TODO
    eger alinan clazz degeri primivite ise liste alinmasina gerek yok.
        eger primitive degilse liste alinmasi sart
        Cunku primitive olunca objeyi,
        primitive olmayinca listeden deger donduruluyor.

        priorityFieldList null ise hata firlatacak sekilde customException yazilmali
    *  */
    private List<Field> priorityFieldList;
    private PrimitiveWrapper primitiveWrapper = new PrimitiveWrapper();
    private Class clazz;

    public PriorityFieldValue(PriorityFieldOrder priorityFieldOrder) {
        this.priorityFieldList = priorityFieldOrder.getFieldNameList();
        this.clazz = priorityFieldOrder.getClazz();
    }
/* public PriorityFieldValue(Class clazz, List<Field> priorityFieldList) {

        this.clazz = clazz;
        this.priorityFieldList = priorityFieldList;
    }*/

  /*  public PriorityFieldValue(Class clazz) {

        this.clazz = clazz;
    }*/

    public Object getValueOfField(Object object) throws InvalidFieldOrFieldNameException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException {
        return getValueOfField(object, "");
    }

    public Object getValueOfField(Object object, Field field) throws InvalidFieldOrFieldNameException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException {
        return getValueOfField(object, field.getName());
    }

    public Object getValueOfField(Object object, String fieldName) throws InvalidFieldOrFieldNameException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException {

        if (primitiveWrapper.isPrimitive(object)) {//if it is primitive then return value
            return object;
        } else // if not a primitive than is it a custom object. Then need to get paramaters of any field in custom Object
            if (fieldName == null || fieldName.equals("")) {
                throw new InvalidFieldOrFieldNameException(object.getClass(), fieldName);
            }
        for (Field tmp : priorityFieldList) {
            if (tmp.getName().equals(fieldName)) {
                tmp.trySetAccessible();
                try {
                    System.out.println("tmp : "+tmp);
                    System.out.println("object : "+object);
                    System.out.println("requested value of object is : " + tmp.get(object));
                    return tmp.get(object);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (!isFieldOrderClassEqualsToFieldValueClass(object)) {
            throw new ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException(clazz, object.getClass());
        }
        throw new InvalidFieldOrFieldNameException(object.getClass(), fieldName);
   /*     } else {
            System.out.println(object.getClass());
//            System.out.println(object.getClass());

            System.out.println(" -------->  Hata firlatilacak");
            throw new NotImplementedRequiredInterfaceException(object.getClass());
        }*/

    }

    private boolean isFieldOrderClassEqualsToFieldValueClass(Object object) {
        if (clazz.getSimpleName().equals(object.getClass().getSimpleName()))
            return true;
        return false;
    }
}
