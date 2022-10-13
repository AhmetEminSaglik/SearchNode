package org.aes.searchnode.dataaccess.concretes;

import org.aes.searchnode.dataaccess.abstracts.IPriorityFields;
import org.aes.searchnode.entities.concretes.PrimitiveWrapper;

import java.lang.reflect.Field;
import java.util.List;

public class PriorityFieldValue {
    List<Field> priorityFieldList = null;
    PrimitiveWrapper primitiveWrapper = new PrimitiveWrapper();

    public PriorityFieldValue(List<Field> priorityFieldList) {
        this.priorityFieldList = priorityFieldList;
    }

    public Object getValueOfField(Object object) {
        return getValueOfField(object, "");
    }

    public Object getValueOfField/*ByField*/(Object object, Field field) {
        return getValueOfField(object, field.getName());
    }

    public Object getValueOfField/*ByFieldName*/(Object object, String fieldName) {
        System.out.println("gelen obje  : " + object);

        if (object instanceof IPriorityFields) {
            System.out.println("AAAAAAAAAAAAAAAAA");
            if (fieldName == null) {
                System.out.println("Please fill FieldName");
            }
            for (Field tmp : priorityFieldList) {

                if (tmp.getName().equals(fieldName)) {
                    tmp.trySetAccessible();
                    try {
                        System.out.println("requested value of object is : " + tmp.get(object));
                        return tmp.get(object);
//                        System.exit(0);
                    } catch (IllegalAccessException e) {
                        System.out.println("cathc dusut");
                        throw new RuntimeException(e);
                    }
                }
            }

            for (Field tmpField : priorityFieldList) {

                tmpField.trySetAccessible();
                System.out.println("----------->  tmpField.getName : " + tmpField.getName() + " / fieldName " + fieldName);
                if (tmpField.getName().equals(fieldName)) {
                    System.out.println("CCCCCCCCCC");

                    System.out.println("tmpField : " + tmpField + " / fieldName : " + fieldName);
                }
            }

        }
        if (primitiveWrapper.isPrimitive(object)) {
//            System.out.println(" TEST ::: " + object);
            return object;
        } else {
            System.out.println(object.getClass());
//            System.out.println(object.getClass());
            System.out.println(" -------->  Hata firlatilacak");
//            throw new NotImplementedRequiredInterfaceErrorException(tmpObject.getClass());
            return null;
        }
    }
}
