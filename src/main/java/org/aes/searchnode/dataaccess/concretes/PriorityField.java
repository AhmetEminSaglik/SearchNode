/*

Deger almak icin Bu Class yerine
package org.aes.searchnode.dataaccess.concretes;

import org.aes.searchnode.dataaccess.abstracts.IPriorityFields;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotImplementedRequiredInterfaceErrorException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PriorityField {
    public Object getPriorityFieldValue(Object object, String fieldName) {
        */
/*TODO
         * Student : age, no,  return null
         * Employee : departman   return null
         * integer, String  works perfect
         *lanuage returns  toString() -> if need to get use composite fields, than it have to implements << IPriorityField >> interface
         * *//*

//        System.out.println("E");

        Object value = null;
        if (object instanceof IPriorityFields) {
            IPriorityFields pf = (IPriorityFields) object;
            List<Field> priorityFields = null;
            try {
                priorityFields = pf.getPriorityFields();
            } catch (NotFoundAnyDeclaredFieldException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }

            for (Field tmp : priorityFields) {
                if (tmp.getName().equals(fieldName)) {
                    tmp.trySetAccessible();
                    try {
//                        System.out.println("tmp.getName() : "+tmp.getName() );
                        value = tmp.get(object);
//                        System.out.println(" -------> "+value);
                    } catch (IllegalAccessException e) {
                        System.out.println("tmp.get() error : " + e.getMessage());
                    }
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
            value = object;
        } else {
            try {
                throw new NotImplementedRequiredInterfaceErrorException(object.getClass());
            } catch (NotImplementedRequiredInterfaceErrorException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        System.out.println("null burdan mi geciyor check et :" + value);
        return value;
       */
/* for (Field tmp : priorityFields) {
            if (tmp.getName().equals(fieldName)) {
                tmp.trySetAccessible();
                try {
                    valueList.add(tmp.get((tmpObject)));
                } catch (IllegalAccessException e) {
                    System.out.println("tmp.get() error : " + e.getMessage());
                }
            }
        }*//*



    }

    public List<Object> getPriorityFieldValue(List<Object> objectList, String fieldName) { // Student[10] geldi
        List<Object> valueList = new ArrayList<>();
        for (Object tmpObject : objectList) {
            valueList.add(getPriorityFieldValue(tmpObject, fieldName));
          */
/*  if (tmpObject instanceof IPriorityFields) {
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
                        valueList.add(tmp.get(tmpObject))
                    } catch (IllegalAccessException e) {
                        System.out.println("tmp.get() error : " + e.getMessage());
                    }
                }


            } *//*
*/
/*else if (tmpObject instanceof Byte ||
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
            }*//*

        }
        return valueList;
    }
}
*/
