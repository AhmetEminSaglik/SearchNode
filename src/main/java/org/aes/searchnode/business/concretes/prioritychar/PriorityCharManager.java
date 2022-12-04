package org.aes.searchnode.business.concretes.prioritychar;

import org.aes.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.concretes.PriorityChar;

public class PriorityCharManager implements PriorityCharService {

    @Override
    public DataResult<PriorityChar> getPriorityChar(char c) {
        return priorityCharDAO.get(c);
    }

    @Override
    public Result deletePriorityChar(char c) {
        return priorityCharDAO.delete(c);
    }

    @Override
    public DataResult<PriorityChar>  updatePriorityChar(char c) {
        return priorityCharDAO.update(c);
    }
}
