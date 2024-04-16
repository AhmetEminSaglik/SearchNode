package org.aes.searchnode.config.prioritychar;

import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.dataaccess.concretes.prioritychar.PriorityCharDAOImp;
import org.aes.searchnode.dataaccess.concretes.prioritychar.pool.PriorityCharPoolDAOImp;

public class ConfigPriorityChar {
    private static final PriorityCharPoolDAO priorityCharPoolDAO = new PriorityCharPoolDAOImp();
    private static final PriorityCharDAO priorityCharDAO = new PriorityCharDAOImp(priorityCharPoolDAO);

    public static PriorityCharDAO getPriorityCharDAO() {
        return priorityCharDAO;
    }

    public static PriorityCharPoolDAO getPriorityCharPoolDAO() {
        return priorityCharPoolDAO;
    }


}
