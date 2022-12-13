package org.aes.searchnode.business.abstracts.prioritychar;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.concretes.PriorityChar;

public interface AccessPriorityCharService {
    DataResult<PriorityChar> get(char c);
}
