package org.aes.searchnode.dataaccess.concretes.prioritychar.pool;

import org.aes.searchnode.business.concretes.prioritychar.pool.PriorityCharPoolComparator;
import org.aes.searchnode.dataaccess.abstracts.prioritychar.pool.PriorityCharPoolDAO;
import org.aes.searchnode.entities.concretes.PriorityChar;
import org.aes.searchnode.entities.concretes.PriorityCharPool;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PriorityCharPoolDAOImp implements PriorityCharPoolDAO { //DAO  provide a connection
    List<PriorityChar> list = PriorityCharPool.getList();
    PriorityCharPoolComparator priorityCharPoolComparator = new PriorityCharPoolComparator();

    @Override
    public PriorityChar getPriorityChar(char c) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChar() == c) {
                return list.get(i); // return char with priority value kod
            }
        }
        return new PriorityChar(c, (int) c); // return char with ascii kod
    }

    @Override
    public PriorityChar updatePriorityCharList(List<Character> characterList, char nextToThisChar) {
        PriorityChar charToAddNext = getPriorityChar(nextToThisChar);
        double charValueToAddBefore = getNextCharValue(charToAddNext);
        double increaseValueOfCharList = calculateIncreaseValueOfCharList(charToAddNext.getValue(), charValueToAddBefore, characterList.size());
        for (int i = 0; i < characterList.size(); i++) {
            list.add(new PriorityChar(characterList.get(i), charToAddNext.getValue() + increaseValueOfCharList * (i + 1)));
        }
        sort(priorityCharPoolComparator);
        printPriorityPool();
        return null;
    }

    private double calculateIncreaseValueOfCharList(double charToAddNext, double charValueToAddBefore, int characterListSize) {
        charToAddNext %= 1;
        charValueToAddBefore %= 1;
        return (((charValueToAddBefore - charToAddNext))) / (characterListSize + 1);
    }

    @Override
    public void sort(Comparator<PriorityChar> comparator) {
        list.sort(comparator);
    }

    @Override
    public void deletePriorityChar(char c) {

    }

    @Override
    public void updatePriorityChar(char c, char nextToThisChar) {
//        printPriorityPool();
        PriorityChar charToAddNext = getPriorityChar(nextToThisChar);
        double charValueToAddBefore = getNextCharValue(charToAddNext);
//        System.out.println("updatePriorityChar : ");
//        System.out.println("charToAddNext.getValue() : " + charToAddNext.getValue());
//        System.out.println(" charValueToAddBefore : " + charValueToAddBefore);
        double newCharValue = calculateNewPriorityCharValue(charToAddNext.getValue(), charValueToAddBefore);
        list.add(new PriorityChar(c, newCharValue));
        sort(priorityCharPoolComparator);
        printPriorityPool();
    }

    private double calculateNewPriorityCharValue(double beforeCharValue, double nextCharValue) {
        return (beforeCharValue + nextCharValue) / 2;
    }

//    private double calculateNewPriorityCharListValue(double beforeCharValue, double nextCharValue) {
//        return (beforeCharValue + nextCharValue) / 2;
//    }


    private void printPriorityPool() {
//        sort(priorityCharPoolComparator);
        System.out.println("----------> Priority Char Pool List Size :" + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private double getNextCharValue(PriorityChar pchar) {
        for (int i = 0; i < list.size(); i++) {
//            System.out.println("list.get(i).getValue() : " + list.get(i).getValue());
//            System.out.println("pchar.getValue() : " + pchar.getValue());
            if (list.get(i).getValue() > pchar.getValue()) {
                return list.get(i).getValue();
            }
        }
        return Math.floor(pchar.getValue() + 1);
    }
//    @Override
//    public void updatePriorityChar(char c) {
//
//    }
}
