package org.aes.searchnode.dataaccess.concretes.prioritychar.pool;

import org.aes.searchnode.business.abstracts.prioritychar.NotifyPriorityCharIsUpdated;
import org.aes.searchnode.business.concretes.prioritychar.pool.PriorityCharPoolComparator;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.core.utilities.SuccessResult;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.entities.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.PriorityChar;
import org.aes.searchnode.entities.PriorityCharPool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityCharPoolDAOImp implements PriorityCharPoolDAO, NotifyPriorityCharIsUpdated {
    private List<PriorityChar> list = PriorityCharPool.getList();
    private PriorityCharPoolComparator priorityCharPoolComparator = new PriorityCharPoolComparator();
    private List<NextWayDirectionRequiredData<?>> listToNotifyAfterUpdatePriorityChar = new ArrayList<>();

    @Override
    public PriorityChar getPriorityChar(char c) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChar() == c) {
                return list.get(i); // return char with priority value code
            }
        }
        return new PriorityChar(c, (int) c); // return char with ascii code
    }

    @Override
    public List<PriorityChar> getAll() {
        return list;
    }

    @Override
    public List<PriorityChar> updatePriorityCharList(List<Character> characterList, char nextToThisChar) {
        for (Character c : characterList) {
            removePriorityChar(c);
        }
        PriorityChar nextPriorityChar = getPriorityChar(nextToThisChar);
        double charValueToAddBefore = getNextPriorityChar(nextToThisChar).getValue();
        double increaseValueOfCharList = calculateIncreaseValueOfCharList(nextPriorityChar.getValue(), charValueToAddBefore, characterList.size());
        for (Character c : characterList) {
        }
        List<PriorityChar> newPcList = new ArrayList<>();
        for (int i = 0; i < characterList.size(); i++) {
            PriorityChar newPc = new PriorityChar(characterList.get(i), nextPriorityChar.getValue() + increaseValueOfCharList * (i + 1));
            list.add(newPc);
            newPcList.add(newPc);
        }
        sort(priorityCharPoolComparator);
        updatePriorityChar();
        printPriorityPool();
        return newPcList;
    }

    private double calculateIncreaseValueOfCharList(double charToAddNext, double charValueToAddBefore, int characterListSize) {
        return (((charValueToAddBefore - charToAddNext))) / (characterListSize + 1);
    }

    @Override
    public void sort(Comparator<PriorityChar> comparator) {
        list.sort(comparator);
    }

    @Override
    public Result removePriorityChar(char c) {
        list.remove(getPriorityChar(c));
        printPriorityPool();
        updatePriorityChar();
        return new SuccessResult("Priority char is removed");
    }

    @Override
    public Result removeAll() {
        list.clear();
        updatePriorityChar();
        return new SuccessResult("Priority char is removed");
    }


    @Override
    public PriorityChar updatePriorityChar(char c, char nextToThisChar) {
        removePriorityChar(c);
        PriorityChar nextPriorityChar = getPriorityChar(nextToThisChar);
        double charValueToAddBefore = getNextPriorityChar(nextToThisChar).getValue();
        double newCharValue = calculateNewPriorityCharValue(nextPriorityChar.getValue(), charValueToAddBefore);
        PriorityChar newPc = new PriorityChar(c, newCharValue);
        list.add(newPc);
        sort(priorityCharPoolComparator);
        updatePriorityChar();
        printPriorityPool();
        return newPc;
    }

    @Override
    public void addToListToBeNotifedWhenPriorityCharIsUpdated(NextWayDirectionRequiredData<?> nextWayDirectionRequiredData) {
        listToNotifyAfterUpdatePriorityChar.add(nextWayDirectionRequiredData);
    }

    private PriorityChar searchNextPcInPool(double min, double max) {
        for (int i = 0; i < list.size(); i++) {
            PriorityChar tmp = list.get(i);
            if (tmp.getValue() > min && tmp.getValue() <= max) {
                return tmp;
            }
        }
        if (isCeilValueCharContainedInPool((char) max)) {
            min = max;
            max++;
            return searchNextPcInPool(min, max);
        }
        return getPriorityChar((char) max);
    }

    private boolean isCeilValueCharContainedInPool(char ch) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChar() == ch) {
                return true;
            }
        }
        return false;
    }

    @Override
    public PriorityChar getNextPriorityChar(char c) {
        PriorityChar currentPc = getPriorityChar(c);
        double min = currentPc.getValue();
        double max = Math.ceil(currentPc.getValue());
        if (min == max) {
            max++;
        }
        return searchNextPcInPool(min, max);
}

    private double calculateNewPriorityCharValue(double beforeCharValue, double nextCharValue) {
        return (beforeCharValue + nextCharValue) / 2;
    }

    private void printPriorityPool() {
        if (list.size() == 0)
            return;
        for (int i = 0; i < list.size(); i++) {
        }
    }

    @Override
    public void updatePriorityChar() {
        listToNotifyAfterUpdatePriorityChar.forEach(e -> e.updatePriorityChar());
    }
}
