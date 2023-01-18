package org.ahmeteminsaglik.searchnode.business.concretes.utility;

import org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.ahmeteminsaglik.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

import java.util.List;

public class SNUtility {
    private PriorityCharService pcService = new PriorityCharManager();

    /* this class should use functions from utilityHelper and create bigger functions then atomics
     * And then SNManagement class should invoke some functions from here. Also SNManagement should have some basic
     * functions in itself otherwise this class may have too much lines
     * Logis is to code once and use it everywhere.
     * So for example getAllStartsWith() and getAllEndsWith() is same just a statement is changing and its location
     * so to dublicate rest of this statment is unnecessary and code smell.
     * Purpose is to destroy code smell and create greate code.
     *  */
   /* public static void clearNWDTVList(List<?> list) {
        list.clear();
    }*/

    public void addSNToIncreaseNWDTVList(List<SearchNode<?>> list, SearchNode<?> searchNode) {
        list.add(searchNode);
    }

    public static StringBuilder trimObject(String text) {
        return new StringBuilder(text.trim());
    }

    public static PriorityChar getPriorityCharOfGivenChar(SearchNode<?> searchNode, char c) {
        DataResult<PriorityChar> drPriorityChar = searchNode.getPcService().get(c);
        PriorityChar pc = drPriorityChar.getData();
        return pc;
    }
}
