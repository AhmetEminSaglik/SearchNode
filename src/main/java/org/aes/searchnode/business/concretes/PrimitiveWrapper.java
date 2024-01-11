package org.aes.searchnode.business.concretes;

import java.math.BigDecimal;

public class PrimitiveWrapper {
    public boolean isPrimitive(Object object) {
        if (object instanceof Number ||
                object instanceof Boolean ||
                object instanceof Character ||
                object instanceof String) {
            return true;
        }
        return false;
    }
}
