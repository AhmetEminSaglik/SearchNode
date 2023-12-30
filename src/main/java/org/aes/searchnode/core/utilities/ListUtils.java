package org.aes.searchnode.core.utilities;

import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;

import java.util.List;

public class ListUtils {
    public static <T> String getItemListInString(int counter, List<T> list) {
        StringBuilder sbItem = new StringBuilder();
        for (T tmp : list) {
//            System.out.println("list size : "+list.size());
            for (int i = 0; i < list.size(); i++) {
//                sbItem.append("[" + counter + "] "+tmp).append("\n");
                sbItem.append("\n");
                for(int j=1;j< counter;j++)
                {
                    sbItem.append("    ");
                }
                sbItem.append("[" + counter + "] NextWayDirectionList{" +
//                        "list Items : [" + ListUtils.getItemListInString(counter, list) + "]" +
                        "list Items : [" + tmp + "]" +
//                sbItems.toString() +
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
        sbItems.append(getItemListInString(counter,list));
        return sbItems.toString();
    }
}
