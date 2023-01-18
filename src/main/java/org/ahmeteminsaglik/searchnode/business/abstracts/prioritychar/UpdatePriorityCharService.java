package org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar;

import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.utilities.Result;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

public interface UpdatePriorityCharService {
    Result reset(char c);
    DataResult<PriorityChar> update(char c);
}
