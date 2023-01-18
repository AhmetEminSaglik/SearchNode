package org.ahmeteminsaglik.searchnode.business.concretes.prioritychar;

import org.ahmeteminsaglik.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.utilities.Result;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

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
