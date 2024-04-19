package org.aes.searchnode.dataaccess.concretes.priorityfield;

import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriorityFieldOrder {
    List<Field> fieldNameList = new ArrayList<>();
    Class clazz;

    public PriorityFieldOrder(Class<?> clazz) throws NotFoundAnyDeclaredFieldException {
        this.clazz = clazz;
        setPriorityFieldsInDefaultOrder();
    }

    public void setPriorityFieldsInRequestOrder(List<Object> fieldList) throws NotFoundAnyDeclaredFieldException {
        if (fieldList.size() == 0) {
            throw new NotFoundAnyDeclaredFieldException(clazz);
        }
    }

    public void setPriorityFieldsInDefaultOrder() throws NotFoundAnyDeclaredFieldException {
        fieldNameList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        if (fieldNameList.size() == 0) {
            throw new NotFoundAnyDeclaredFieldException(clazz);
        }
    }
/*

    public Field getFirstField() {
        if (!fieldNameList.isEmpty()) {
            return fieldNameList.get(0);
        }
        return null;
    }

    public Field getPriorityField(String fieldName) {
        for (Field tmp : fieldNameList) {
            if (tmp.getName().equals(fieldName)) {
                return tmp;
            }
        }
        return null;
    }
*/

    public Field getPriorityFieldName(int index) throws NotFoundRequestedFieldException { // returns first index, this is for String,Integer...Byte
        if (fieldNameList.size() > index) {
            return fieldNameList.get(index);
        }
        throw new NotFoundRequestedFieldException(clazz, fieldNameList.size());

    }


    public List<Field> getAllPriorityFieldsName() {
        return fieldNameList;
    }

    public List<Field> getFieldNameList() {
        return new ArrayList<>(fieldNameList);
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
