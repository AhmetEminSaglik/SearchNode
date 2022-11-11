package org.aes.searchnode.config.prioritychar;

import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.dataaccess.concretes.prioritychar.PriorityCharDAOImp;
import org.aes.searchnode.dataaccess.concretes.prioritychar.pool.PriorityCharPoolDAOImp;

public class ConfigPriorityChar {
    private ConfigPriorityChar() {
    }
    public static PriorityCharDAO getPriorityCharDAO() {
        return new PriorityCharDAOImp(getPriorityCharPoolDAO());
    }

    public static PriorityCharPoolDAO getPriorityCharPoolDAO() {
        return new PriorityCharPoolDAOImp();
    }


}
