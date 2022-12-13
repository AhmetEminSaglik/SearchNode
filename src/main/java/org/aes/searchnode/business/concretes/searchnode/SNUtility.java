package org.aes.searchnode.business.concretes.searchnode;

import java.util.List;

public class SNUtility {
    public static void clearNWDTVList(List<?> list) {
        list.clear();
    }

    public void addSNToIncreaseNWDTVList(List<SearchNode<?>> list, SearchNode<?> searchNode) {
        list.add(searchNode);
    }


}
