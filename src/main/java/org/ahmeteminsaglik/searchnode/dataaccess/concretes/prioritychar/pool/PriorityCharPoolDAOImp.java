package org.ahmeteminsaglik.searchnode.dataaccess.concretes.prioritychar.pool;

import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityCharPool;

import java.util.Comparator;
import java.util.List;

public class PriorityCharPoolDAOImp implements PriorityCharPoolDAO { //DAO  provide a connection
    List<PriorityChar> list = PriorityCharPool.getList();

    @Override
    public PriorityChar getPriorityChar(char c) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChar() == c) {
                return list.get(i); // return char with priority value kod
            }
        }
        return new PriorityChar(c, (int) c); // return char with ascii kod
    }

    @Override
    public void sort(Comparator<PriorityChar> comparator) {
        list.sort(comparator);
    }

    @Override
    public void deletePriorityChar(char c) {

    }

    @Override
    public void updatePriorityChar(char c) {

    }
}
