package org.ahmeteminsaglik.searchnode.config.prioritychar;

import org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.prioritychar.PriorityCharManagement;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.prioritychar.pool.PriorityCharPoolDAOImp;

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
