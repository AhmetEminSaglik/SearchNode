package org.aes.searchnode.config.prioritychar;

import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.dataaccess.concretes.prioritychar.PriorityCharDAOImp;
import org.aes.searchnode.dataaccess.concretes.prioritychar.pool.PriorityCharPoolDAOImp;

public class ConfigPriorityChar {
    static PriorityCharPoolDAO priorityCharPoolDAO = new PriorityCharPoolDAOImp();
    static PriorityCharDAO priorityCharDAO = new PriorityCharDAOImp(priorityCharPoolDAO);

    public  PriorityCharDAO getPriorityCharDAO() {
        return priorityCharDAO;
    }

    public  PriorityCharPoolDAO getPriorityCharPoolDAO() {

        return priorityCharPoolDAO;
    }


}
