package org.aes.searchnode.dataaccess.concretes.prioritychar.pool;

import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.entities.concretes.PriorityChar;
import org.aes.searchnode.entities.concretes.PriorityCharPool;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PriorityCharPoolDAOImp implements PriorityCharPoolDAO {
    List<PriorityChar> list = PriorityCharPool.getPcList();

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
}
