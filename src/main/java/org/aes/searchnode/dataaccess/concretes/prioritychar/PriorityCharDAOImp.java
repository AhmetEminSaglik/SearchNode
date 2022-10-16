package org.aes.searchnode.dataaccess.concretes.prioritychar;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.entities.concretes.PriorityChar;
import org.aes.searchnode.entities.concretes.PriorityCharPool;

import java.util.List;

public class PriorityCharDAOImp implements PriorityCharDAO {
    PriorityCharPoolDAO priorityCharPoolDAO;

    public PriorityCharDAOImp(PriorityCharPoolDAO priorityCharPoolDAO) {
        this.priorityCharPoolDAO = priorityCharPoolDAO;
    }

    @Override
    public DataResult get(char c) {
        PriorityChar pc = getChar(c);
        if (pc != null)
            return new SuccessDataResult(pc, "PriorityChar value is retrieved");
        return new SuccessDataResult(c, "ASCII value retrieved");
    }

    @Override
    public Result add(char c, char nextToThisChar) {

        return null;
    }


    @Override
    public Result add(List<Character> cList, char nextToThisChar) {
        return null;
    }


    @Override
    public Result delete(char c) {
        return null;
    }

    @Override
    public Result update(char c) {
        return null;
    }

    private PriorityChar getChar(char c) {
        return priorityCharPoolDAO.getPriorityChar(c);
    }

}


