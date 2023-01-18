package org.ahmeteminsaglik.searchnode.config.prioritychar;

import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.prioritychar.PriorityCharDAOImp;
import org.ahmeteminsaglik.searchnode.dataaccess.concretes.prioritychar.pool.PriorityCharPoolDAOImp;

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
