package org.aes.searchnode.dataaccess.concretes.prioritychar.pool;

import org.aes.searchnode.business.abstracts.prioritychar.NotifyPriorityCharIsUpdated;
import org.aes.searchnode.business.concretes.prioritychar.pool.PriorityCharPoolComparator;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.Result;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.entities.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.PriorityChar;
import org.aes.searchnode.entities.PriorityCharPool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityCharPoolDAOImp implements PriorityCharPoolDAO, NotifyPriorityCharIsUpdated { //DAO  provide a connection
    List<PriorityChar> list = PriorityCharPool.getList();
    PriorityCharPoolComparator priorityCharPoolComparator = new PriorityCharPoolComparator();
    List<NextWayDirectionRequiredData<?>> listToNotifyAfterUpdatePriorityChar = new ArrayList<>();

    private boolean sorted = false;

    @Override
    public PriorityChar getPriorityChar(char c) {
        if (!sorted) {
            sort(priorityCharPoolComparator);
            sorted = true;
        }
//        return binarySearch(c);
        return linearSearch(c);

    }

    private PriorityChar linearSearch(char c) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChar() == c) {
                return list.get(i); // return char with priority value code value
            }
        }
        return new PriorityChar(c, (int) c); // return char with ascii code value
    }


    @Override
    public DataResult<List<PriorityChar>> updatePriorityCharList(List<Character> characterList, char nextToThisChar) {
        sorted = false;
        for (Character c : characterList) {
            removePriorityChar(c);
        }
        PriorityChar nextPriorityChar = getPriorityChar(nextToThisChar);
        double charValueToAddBefore = getNextCharValue(nextPriorityChar);
        double increaseValueOfCharList = calculateIncreaseValueOfCharList(nextPriorityChar.getValue(), charValueToAddBefore, characterList.size());
        for (Character c : characterList) {
            System.out.println("List : " + c + " increaseValueOfCharList " + increaseValueOfCharList);
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
        return new SuccessDataResult<>(newPcList, "Priority chars are updated to list ");
    }

    private double calculateIncreaseValueOfCharList(double charToAddNext, double charValueToAddBefore, int characterListSize) {
        return (((charValueToAddBefore - charToAddNext))) / (characterListSize + 1);
    }

    @Override
    public void sort(Comparator<PriorityChar> comparator) {
        printPriorityPool();
        list.sort(comparator);
    }

    @Override
    public DataResult removePriorityChar(char c) {
        list.remove(getPriorityChar(c));
        printPriorityPool();
        updatePriorityChar();
        return new SuccessDataResult(getPriorityChar(c), "Priority char is removed");
    }

    @Override
    public Result removeAll() {
        list.clear();
        updatePriorityChar();
        return new SuccessDataResult("Priority char is removed");
    }


    @Override
    public DataResult<PriorityChar> updatePriorityChar(char c, char nextToThisChar) {
        sorted = false;

        removePriorityChar(c);
        PriorityChar nextPriorityChar = getPriorityChar(nextToThisChar);
        double charValueToAddBefore = getNextCharValue(nextPriorityChar);
        double newCharValue = calculateNewPriorityCharValue(nextPriorityChar.getValue(), charValueToAddBefore);
        PriorityChar newPc = new PriorityChar(c, newCharValue);
        list.add(newPc);
        sort(priorityCharPoolComparator);
        updatePriorityChar();
        printPriorityPool();
        return new SuccessDataResult<>(newPc, "Priority Char is updated");
    }

    @Override
    public void addToListToBeNotifedWhenPriorityCharIsUpdated(NextWayDirectionRequiredData<?> nextWayDirectionRequiredData) {
        listToNotifyAfterUpdatePriorityChar.add(nextWayDirectionRequiredData);
    }

    private double calculateNewPriorityCharValue(double beforeCharValue, double nextCharValue) {
        System.out.println("beforeCharValue: " + beforeCharValue);
        return (beforeCharValue + nextCharValue) / 2;
    }

    private void printPriorityPool() {
        if (list.size() == 0)
            return;
        System.out.println("----------> Priority Char Pool List Size :" + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private double getNextCharValue(PriorityChar pchar) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() > pchar.getValue()) {
                return list.get(i).getValue();
            }
        }
        return Math.floor(pchar.getValue() + 1);
    }

    @Override
    public void updatePriorityChar() {
        listToNotifyAfterUpdatePriorityChar.forEach(e -> e.updatePriorityChar());
    }
}
