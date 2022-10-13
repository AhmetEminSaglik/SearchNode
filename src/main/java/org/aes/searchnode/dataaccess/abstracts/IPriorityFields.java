package org.aes.searchnode.dataaccess.abstracts;

import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotImplementedRequiredInterfaceErrorException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface IPriorityFields {
    List<Field> list = new ArrayList<>();

    default List<Field> getPriorityFields() throws NotFoundAnyDeclaredFieldException {
        List<Field> list = new ArrayList<>();
            for(int i=0;i<getClass().getDeclaredFields().length;i++){
                list.add(getClass().getDeclaredFields()[i]);
                System.out.println("Fields will be in use :  : "+list.get(i).getName());
            }

        if(list.size()>0)
            return list;
//        throw new IllegalArgumentException()
        throw new NotFoundAnyDeclaredFieldException(getClass());
//        System.out.println("Have no declared fields");
//        return null;

    }

default List<Object> getPriorityFieldValue(List<Field> fieldListObjects, String fieldName) throws NotFoundAnyDeclaredFieldException, NotImplementedRequiredInterfaceErrorException { // Student[10] geldi
        List<Object> valueList = new ArrayList<>();
        for (Object tmpObject : fieldListObjects) {
            if (tmpObject instanceof IPriorityFields) {
                IPriorityFields pf = (IPriorityFields) tmpObject;
                List<Field> priorityFields = pf.getPriorityFields();

                for (Field tmp : priorityFields) {
                    if (tmp.getName().equals(fieldName)) {
                        tmp.trySetAccessible();
                        try {
                            valueList.add(tmp.get((tmpObject)));
                        } catch (IllegalAccessException e) {
                            System.out.println("tmp.get() error : " + e.getMessage());
                        }
                    }
                }

            for (Field tmp : priorityFields) {
                    try {
                        tmp.trySetAccessible();
                        System.out.println(tmp.getName() + " : " + tmp.get(tmpObject));
                        System.out.println("field name ==>  : " + tmp.getName());
                        valueList.add(tmp.get(tmpObject));
                    } catch (IllegalAccessException e) {
                        System.out.println("tmp.get() error : " + e.getMessage());
                    }
                }


            } else if (tmpObject instanceof Byte ||
                    tmpObject instanceof Short ||
                    tmpObject instanceof Integer ||
                    tmpObject instanceof Float ||
                    tmpObject instanceof Double ||
                    tmpObject instanceof Boolean ||
                    tmpObject instanceof Character ||
                    tmpObject instanceof String
            ) {
                System.out.print(tmpObject + ", ");
            } else {
                throw new NotImplementedRequiredInterfaceErrorException(tmpObject.getClass());
            }
        }
        return valueList;
    }


}
