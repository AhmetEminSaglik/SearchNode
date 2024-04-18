package org.aes.searchnode.core.utilities;

import java.util.List;

public class ListUtil {
    public synchronized static String toString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(e ->
                sb.append(e).append(","));
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
