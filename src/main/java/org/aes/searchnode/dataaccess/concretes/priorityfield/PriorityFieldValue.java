package org.aes.searchnode.dataaccess.concretes.priorityfield;

import org.aes.searchnode.business.concretes.PrimitiveWrapper;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;

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
    private final List<Field> priorityFieldList;
    private final PrimitiveWrapper primitiveWrapper = new PrimitiveWrapper();
    private final Class clazz;

    public PriorityFieldValue(PriorityFieldOrder priorityFieldOrder) {
        this.priorityFieldList = priorityFieldOrder.getFieldNameList();
        this.clazz = priorityFieldOrder.getClazz();
    }

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
    }

    private boolean isFieldOrderClassEqualsToFieldValueClass(Object object) {
        return clazz.getSimpleName().equals(object.getClass().getSimpleName());
    }
}
