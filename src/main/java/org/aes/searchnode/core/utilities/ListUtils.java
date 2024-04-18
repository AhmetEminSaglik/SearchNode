package org.aes.searchnode.core.utilities;

import java.util.List;

public class ListUtils {
    public static <T> String getItemListInString(int counter, List<T> list) {
        StringBuilder sbItem = new StringBuilder();
        for (T tmp : list) {
            for (int i = 0; i < list.size(); i++) {
                sbItem.append("\n");
                for (int j = 1; j < counter; j++) {
                    sbItem.append("    ");
                }
                sbItem.append("[" + counter + "] NextWayDirectionList{" +
                        "list Items : [" + tmp + "]" +
                        '}');
            }
        }
        return sbItem.toString();
    }

    public static <T> String recursiveToString(List<T> list, int counter) {
        StringBuilder sbItems = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            sbItems.append(" ");
        }
        sbItems.append(getItemListInString(counter, list));
        return sbItems.toString();
    }
}
