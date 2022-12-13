package org.aes.searchnode.business.concretes.prioritychar;

import org.aes.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.aes.searchnode.config.prioritychar.ConfigPriorityChar;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.entities.concretes.PriorityChar;

public class PriorityCharManager implements PriorityCharService {
//    PriorityCharDAO priorityCharDAO = ConfigPriorityChar.getPriorityCharDAO();

    @Override
    public DataResult<PriorityChar> get(char c) {
        return priorityCharDAO.get(c);
    }

    @Override
    public Result reset(char c) {
        return priorityCharDAO.delete(c);
    }

    @Override
    public DataResult<PriorityChar> update(char c) {
        return priorityCharDAO.update(c);
    }
  /*  @Override
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
    }*/
}
