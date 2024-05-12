package org.aes.searchnode.business.concretes.prioritychar;

import org.aes.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.aes.searchnode.config.prioritychar.ConfigPriorityChar;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.entities.PriorityChar;

import java.util.List;

public class PriorityCharManager implements PriorityCharService {
    PriorityCharService pcService = ConfigPriorityChar.getPriorityCharService();

    @Override
    public PriorityChar getPc(char c) {
        return pcService.getPc(c);
    }

    @Override
    public List<PriorityChar> getAllPc() {
        return pcService.getAllPc();
    }

    @Override
    public Result add(char c, char nextToThisChar) {
        return pcService.add(c, nextToThisChar);
    }

    @Override
    public Result add(List<Character> cList, char nextToThisChar) {
        return pcService.add(cList, nextToThisChar);
    }

    @Override
    public Result remove(char c) {
        return pcService.remove(c);
    }

    @Override
    public Result removeAll() {
        return pcService.removeAll();
    }

    @Override
    public Result update(char c) {
        return pcService.update(c);
    }

    @Override
    public PriorityChar getNextPc(char c) {
        return pcService.getNextPc(c);
    }

}
