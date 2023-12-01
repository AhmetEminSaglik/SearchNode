package org.aes.searchnode.dataaccess.concretes.prioritychar;

import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.core.utilities.SuccessResult;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.List;

public class PriorityCharDAOImp implements PriorityCharDAO {
    PriorityCharPoolDAO priorityCharPoolDAO;

    public PriorityCharDAOImp(PriorityCharPoolDAO priorityCharPoolDAO) {
        this.priorityCharPoolDAO = priorityCharPoolDAO;
    }

    @Override
    public DataResult get(char c) {
        PriorityChar pc = priorityCharPoolDAO.getPriorityChar(c);
        if (pc != null)
            return new SuccessDataResult(pc, "PriorityChar value is retrieved");
        return new SuccessDataResult(c, "ASCII value retrieved");
    }

    @Override
    public Result add(char c, char nextToThisChar) {
//        PriorityChar pc = priorityCharPoolDAO.getPriorityChar(nextToThisChar);
        priorityCharPoolDAO.updatePriorityChar(c, nextToThisChar);
        return new SuccessResult("Priority Char value is updated :" + c);
    }


    @Override
    public Result add(List<Character> cList, char nextToThisChar) {
//        PriorityChar pc = priorityCharPoolDAO.getPriorityChar(nextToThisChar);
        priorityCharPoolDAO.updatePriorityCharList(cList, nextToThisChar);
        return new SuccessResult("Priority Char List Value is updated :");
    }


    @Override
    public Result delete(char c) {
        return null;
    }

    @Override
    public DataResult update(char c) {
        return null;
    }


}


