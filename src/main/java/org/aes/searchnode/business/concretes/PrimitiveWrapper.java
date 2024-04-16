package org.aes.searchnode.business.concretes;

public class PrimitiveWrapper {
    public boolean isPrimitive(Object object) {
        return object instanceof Number ||
                object instanceof Boolean ||
                object instanceof Character ||
                object instanceof String;
    }
}
