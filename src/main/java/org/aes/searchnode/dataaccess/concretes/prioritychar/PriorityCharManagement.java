package org.aes.searchnode.dataaccess.concretes.prioritychar;

import org.aes.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.core.utilities.SuccessResult;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.entities.PriorityChar;

import java.util.List;

public class PriorityCharManagement implements PriorityCharService {
    PriorityCharPoolDAO priorityCharPoolDAO;

    public PriorityCharManagement(PriorityCharPoolDAO priorityCharPoolDAO) {
        this.priorityCharPoolDAO = priorityCharPoolDAO;
    }

    @Override
    public PriorityChar getPc(char c) {
        PriorityChar pc = priorityCharPoolDAO.getPriorityChar(c);
        if (pc != null)
            return pc;
        return getPc(c);
    }

    @Override
    public List<PriorityChar> getAllPc() {
        return priorityCharPoolDAO.getAll();
    }


    @Override
    public Result add(char c, char nextToThisChar) {
        priorityCharPoolDAO.updatePriorityChar(c, nextToThisChar);
        return new SuccessResult("Priority Char value is updated :" + c);
    }


    @Override
    public Result add(List<Character> cList, char nextToThisChar) {
        priorityCharPoolDAO.updatePriorityCharList(cList, nextToThisChar);
        return new SuccessResult("Priority Char List Value is updated");
    }


    @Override
    public Result remove(char c) {
        priorityCharPoolDAO.removePriorityChar(c);
        return new SuccessResult();
    }

    @Override
    public Result removeAll() {
        return priorityCharPoolDAO.removeAll();
    }

    @Override
    public Result update(char c) {
        return null;
    }

    @Override
    public PriorityChar getNextPc(char c) {
        return priorityCharPoolDAO.getNextPriorityChar(c);
    }

}


