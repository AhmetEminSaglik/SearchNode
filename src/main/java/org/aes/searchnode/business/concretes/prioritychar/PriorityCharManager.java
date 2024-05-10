package org.aes.searchnode.business.concretes.prioritychar;

import org.aes.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.aes.searchnode.config.prioritychar.ConfigPriorityChar;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.entities.PriorityChar;

import java.util.List;

public class PriorityCharManager implements PriorityCharService {
    PriorityCharDAO priorityCharDAO = ConfigPriorityChar.getPriorityCharDAO();

    @Override
    public DataResult<PriorityChar> get(char c) {
        return priorityCharDAO.get(c);
    }

    @Override
    public DataResult<List<PriorityChar>> getAll() {
        return priorityCharDAO.getAll();
    }

    @Override
    public Result add(char c, char nextToThisChar) {
        return priorityCharDAO.add(c, nextToThisChar);
    }

    @Override
    public Result add(List<Character> cList, char nextToThisChar) {
        return priorityCharDAO.add(cList, nextToThisChar);
    }

    @Override
    public Result remove(char c) {
        return priorityCharDAO.remove(c);
    }

    @Override
    public Result removeAll() {
        return priorityCharDAO.removeAll();
    }

    @Override
    public DataResult<PriorityChar> update(char c) {
        return priorityCharDAO.update(c);
    }

    @Override
    public DataResult<PriorityChar> getNextPriorityChar(char c) {
        return priorityCharDAO.getNextPriorityChar(c);
    }

}
