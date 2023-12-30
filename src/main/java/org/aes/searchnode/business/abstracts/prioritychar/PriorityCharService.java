package org.aes.searchnode.business.abstracts.prioritychar;

import org.aes.searchnode.config.prioritychar.ConfigPriorityChar;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.dataaccess.concretes.prioritychar.PriorityCharDAOImp;
import org.aes.searchnode.dataaccess.concretes.prioritychar.pool.PriorityCharPoolDAOImp;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.Comparator;
import java.util.List;

public interface PriorityCharService  extends  PriorityCharDAO{
}
