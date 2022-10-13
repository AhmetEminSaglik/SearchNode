package org.aes.searchnode.dataaccess.concretes;

import org.aes.searchnode.dataaccess.abstracts.IPriorityFields;
import org.aes.searchnode.entities.concretes.PrimitiveWrapper;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;

import java.lang.reflect.Field;
import java.util.List;

public class PriorityFieldValue {
    List<Field> priorityFieldList = null;
    PrimitiveWrapper primitiveWrapper = new PrimitiveWrapper();

    public PriorityFieldValue(List<Field> priorityFieldList) {
        this.priorityFieldList = priorityFieldList;
    }

    public Object getValueOfField(Object object) throws InvalidFieldOrFieldNameException {
        return getValueOfField(object, "");
    }

    public Object getValueOfField(Object object, Field field) throws InvalidFieldOrFieldNameException {
        return getValueOfField(object, field.getName());
    }

    public Object getValueOfField(Object object, String fieldName) throws InvalidFieldOrFieldNameException {
        System.out.println("Object to process :" + object);

        if (primitiveWrapper.isPrimitive(object)) {
            return object;
        } else if (object instanceof IPriorityFields) {
            if (fieldName == null || fieldName.equals("")) {
                throw new InvalidFieldOrFieldNameException(object.getClass(), fieldName);
            }
            for (Field tmp : priorityFieldList) {
                if (tmp.getName().equals(fieldName)) {
                    tmp.trySetAccessible();
                    try {
                        System.out.println("requested value of object is : " + tmp.get(object));
                        return tmp.get(object);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else {
            System.out.println(object.getClass());
//            System.out.println(object.getClass());
            System.out.println(" -------->  Hata firlatilacak");
//            throw new NotImplementedRequiredInterfaceErrorException(tmpObject.getClass());
        }
        System.out.println("????????????????????????????? " + getClass().getSimpleName());
        return null;
    }
}
