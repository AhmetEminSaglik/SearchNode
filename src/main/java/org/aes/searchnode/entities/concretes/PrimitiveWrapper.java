package org.aes.searchnode.entities.concretes;

public class PrimitiveWrapper {
    public boolean isPrimitive(Object object) {
        if (object instanceof Byte ||
                object instanceof Short ||
                object instanceof Integer ||
                object instanceof Float ||
                object instanceof Double ||
                object instanceof Boolean ||
                object instanceof Character ||
                object instanceof String) {
            return true;
        }
        return false;


    }
}
