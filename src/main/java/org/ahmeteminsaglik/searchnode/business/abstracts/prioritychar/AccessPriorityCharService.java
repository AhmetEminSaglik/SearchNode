package org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar;

import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

public interface AccessPriorityCharService {
    DataResult<PriorityChar> get(char c);
}
