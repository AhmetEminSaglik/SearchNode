package org.aes.searchnode.dataaccess.concretes;

import org.aes.searchnode.dataaccess.abstracts.IPriorityFields;

import java.lang.reflect.Field;
import java.util.List;

public class PriorityFieldValue {
List<Field> priorityFieldList= null;

    public PriorityFieldValue(List<Field> priorityFieldList) {
        this.priorityFieldList = priorityFieldList;
    }

//    public PriorityFieldValue() {
//    }

    public void getValueOfField(Object object){
        getValueOfFieldByFieldName(object,null);

    }
    public void getValueOfFieldByField(Object object,Field field){
        getValueOfFieldByFieldName(object,field.getName());

    }
    public void getValueOfFieldByFieldName(Object object, String fieldName)  {
        System.out.println("gelen obje  : "+object);
//        System.exit(0);
       // Object object = field;
        if (object instanceof IPriorityFields) {
            System.out.println("AAAAAAAAAAAAAAAAA");
            if(fieldName==null){
                System.out.println("Please fill FieldName");
            }
            for(Field tmp : priorityFieldList){

                if(tmp.getName().equals(fieldName)){
                    tmp.trySetAccessible();
                    try {
                        System.out.println("requested value of object is : "+tmp.get(object));
                        System.exit(0);
                    } catch (IllegalAccessException e) {
                        System.out.println("cathc dusut");
                        throw new RuntimeException(e);
                    }
                }
            }
//            try {//Field field=((IPriorityFields) object).getPriorityFields();
//                List<Field>  fieldList=((IPriorityFields) object).getPriorityFields();

            /*System.out.println("object : "+object);
            System.out.println("fieldList size : "+fieldList.size());
            System.out.println("fieldList size : "+fieldList.get(0));
            System.out.println("fieldList size : "+fieldList.get(1));
            System.out.println("fieldList size : "+fieldList.get(2));
            System.exit(0);*/
//            System.out.println(fieldList.get(0));
//            System.out.println(fieldList.get(1));
//            System.exit(0);
                for(Field tmpField : priorityFieldList){

                    tmpField.trySetAccessible();
                    System.out.println("----------->  tmpField.getName : "+tmpField.getName()+" / fieldName "+fieldName);
                    if(tmpField.getName().equals(fieldName)){
                        System.out.println("CCCCCCCCCC");

                        System.out.println("tmpField : "+tmpField+ " / fieldName : "+fieldName);
                    }
                }

//                System.out.println(field.get(fieldName));
//                System.out.println(((IPriorityFields) object).getPriorityFields().get(0).get(fieldName));
//                System.out.println(object.getClass().getDeclaredField(fieldName));
//            } catch (NoSuchFieldException e) {
//                System.out.println("REQUEST FIELD NAME IS INVALID");
//                throw new RuntimeException(e);
//            } catch (IllegalAccessException e) {
//                System.out.println("IllegalAccessException");
//                throw new RuntimeException(e);
//            }
        }
        if (object instanceof Byte ||
                object instanceof Short ||
                object instanceof Integer ||
                object instanceof Float ||
                object instanceof Double ||
                object instanceof Boolean ||
                object instanceof Character ||
                object instanceof String
        ) {
            System.out.println(" TEST ::: " + object);
        } else {
            System.out.println(object.getClass());
//            System.out.println(object.getClass());
            System.out.println(" -------->  Hata firlatilacak");
//            throw new NotImplementedRequiredInterfaceErrorException(tmpObject.getClass());
        }


//        return field.get(fieldName);
    }
}
