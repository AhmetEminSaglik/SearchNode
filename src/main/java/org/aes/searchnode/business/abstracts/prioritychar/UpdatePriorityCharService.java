package org.aes.searchnode.business.abstracts.prioritychar;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.concretes.PriorityChar;

public interface UpdatePriorityCharService {
    Result reset(char c);
    DataResult<PriorityChar> update(char c);
}
