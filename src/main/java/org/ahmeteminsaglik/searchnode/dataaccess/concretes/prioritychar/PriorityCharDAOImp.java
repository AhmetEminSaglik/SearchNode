package org.ahmeteminsaglik.searchnode.dataaccess.concretes.prioritychar;

import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.utilities.Result;
import org.ahmeteminsaglik.searchnode.utilities.SuccessDataResult;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.PriorityCharDAO;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;

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
    public DataResult update(char c) {
        return null;
    }

    @Override
    public DataResult<PriorityChar> reset(char c) {
        return null;
    }


}


