package org.aes.searchnode.business.concretes.utility;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;

import java.util.List;

public class SNUtility {
    /* this class should use functions from utilityHelper and create bigger functions then atomics
    * And then SNManagement class should invoke some functions from here.
    * Logis is to code once and use it everywhere.
    * So for example getAllStartsWith() and getAllEndsWith() is same just a statement is changing and its location
    * so to dublicate rest of this statment is unnecessary and code smell.
    * Purpose is to destroy code smell and create greate code.
    *  */
    public static void clearNWDTVList(List<?> list) {
        list.clear();
    }

    public void addSNToIncreaseNWDTVList(List<SearchNode<?>> list, SearchNode<?> searchNode) {
        list.add(searchNode);
    }


}
