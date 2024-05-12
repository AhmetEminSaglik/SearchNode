package org.aes.searchnode.config.prioritychar;

import org.aes.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.dataaccess.concretes.prioritychar.PriorityCharManagement;
import org.aes.searchnode.dataaccess.concretes.prioritychar.pool.PriorityCharPoolDAOImp;

public class ConfigPriorityChar {
    private static final PriorityCharPoolDAO priorityCharPoolDAO = new PriorityCharPoolDAOImp();
    private static final PriorityCharService priorityCharService = new PriorityCharManagement(priorityCharPoolDAO);

    public static PriorityCharService getPriorityCharService() {
        return priorityCharService;
    }

    public static PriorityCharPoolDAO getPriorityCharPoolDAO() {
        return priorityCharPoolDAO;
    }


}
