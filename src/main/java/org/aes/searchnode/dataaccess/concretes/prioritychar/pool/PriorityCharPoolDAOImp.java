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

public class PriorityCharPoolDAOImp implements PriorityCharPoolDAO, NotifyPriorityCharIsUpdated {
    //    private static final Logger log = LoggerFactory.getLogger(PriorityCharPoolDAOImp.class); //DAO  provide a connection
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
    public DataResult<List<PriorityChar>> getAll() {
        return new SuccessDataResult<>(list);
    }

    // Todo this function has bug, here will be refactored
    @Override
    public DataResult<List<PriorityChar>> updatePriorityCharList(List<Character> characterList, char nextToThisChar) {
        for (Character c : characterList) {
            removePriorityChar(c);
        }
//        Todo Burda character listesini gonderirken problem yasaniyor
        PriorityChar nextPriorityChar = getPriorityChar(nextToThisChar);
        double charValueToAddBefore = getNextCharValue(nextPriorityChar);
//        double charValueToAddBefore = getNextPriorityCharOfGiven(nextToThisChar).getData().getValue();//getNextCharValue(nextPriorityChar);
//        System.out.println(">>>>>>>>>>>>>>charValueToAddBefore : "+charValueToAddBefore);
        double increaseValueOfCharList = calculateIncreaseValueOfCharList(nextPriorityChar.getValue(), charValueToAddBefore, characterList.size());
        for (Character c : characterList) {
//            System.out.println("List : " + c + " increaseValueOfCharList " + increaseValueOfCharList);
        }
        List<PriorityChar> newPcList = new ArrayList<>();
        for (int i = 0; i < characterList.size(); i++) {
            PriorityChar newPc = new PriorityChar(characterList.get(i), nextPriorityChar.getValue() + increaseValueOfCharList * (i + 1));
            list.add(newPc);
            newPcList.add(newPc);
        }
        sort(priorityCharPoolComparator);
        updatePriorityChar();
//        log.info("charList is updated:");
//        System.out.println("charList is updated:");
        printPriorityPool();
        return new SuccessDataResult<>(newPcList, "Priority chars are updated to list ");
    }

    private double calculateIncreaseValueOfCharList(double charToAddNext, double charValueToAddBefore, int characterListSize) {
        return (((charValueToAddBefore - charToAddNext))) / (characterListSize + 1);
    }

    @Override
    public void sort(Comparator<PriorityChar> comparator) {
        list.sort(comparator);
    }

    @Override
    public DataResult removePriorityChar(char c) {
//        System.out.println("pc : "+getPriorityChar(c).getChar()+" : "+getPriorityChar(c).getValue());
        list.remove(getPriorityChar(c));
//        log.info("'c' is removed :");
//        System.out.println(c+"' is removed :");
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
        removePriorityChar(c);
        PriorityChar nextPriorityChar = getPriorityChar(nextToThisChar);
        double charValueToAddBefore = getNextCharValue(nextPriorityChar);
//        double charValueToAddBefore = getNextPriorityCharOfGiven(nextToThisChar).getData().getValue();
        double newCharValue = calculateNewPriorityCharValue(nextPriorityChar.getValue(), charValueToAddBefore);
        PriorityChar newPc = new PriorityChar(c, newCharValue);
        list.add(newPc);
        sort(priorityCharPoolComparator);
        updatePriorityChar();
//        log.info("\'" + c+ "' is updated:");
//        System.out.println("\'" + c+ "' is updated:");
        printPriorityPool();
        return new SuccessDataResult<>(newPc, "Priority Char is updated");
    }

    @Override
    public void addToListToBeNotifedWhenPriorityCharIsUpdated(NextWayDirectionRequiredData<?> nextWayDirectionRequiredData) {
        listToNotifyAfterUpdatePriorityChar.add(nextWayDirectionRequiredData);
    }

    // Todo this function has bug, here will be refactored
    private PriorityChar getPcBetweenGivenValues(double minBound, double maxBound) {
//        System.out.println(" getPcBetweenGivenValues> min : " + minBound + " / max : " + maxBound);
        for (int i = 0; i < list.size(); i++) {
            PriorityChar tmp = list.get(i);
            if (tmp.getValue() > minBound && tmp.getValue() < maxBound) {
                System.out.println("BURASDI DONUYOR tmp : " + tmp.getChar());
                return tmp;
            }
            System.out.println("tmp : " + tmp.getChar() + " " + tmp.getValue());
            if (list.get(i).getValue() >= maxBound) {
                System.out.println("CIKISS 1");
//                System.out.println("bos donucek");
                return null;
            }
        }
//        System.out.println("CIKISS 2 bounds : " + minBound + "-" + maxBound);

        return null;

    }
    // Todo this function has bug, here will be refactored
    private DataResult<PriorityChar> searchPcPoolAndASCII(double minBound, double maxBound) {
//        System.out.println("gelen min-max bounds:" + minBound + "-" + maxBound);
        for (int i = 0; i < list.size(); i++) {
            PriorityChar tmp = list.get(i);
            System.out.println(" searchPcPoolAndASCII > " + tmp.getChar() + " " + tmp.getValue());
            if (tmp.getChar() == ((char) Math.ceil(minBound)) || tmp.getChar() == ((char) Math.ceil(maxBound))) {
                System.out.println(">>>>>>>>>>>>  tmp.getChar() == minbound " + tmp.getChar() + " " + tmp.getValue() + " " + minBound + "  (char)? " + ((char) Math.ceil(minBound)));
                PriorityChar pc = getPcBetweenGivenValues(minBound, maxBound);
                if (pc != null) {
                    return new SuccessDataResult<>(pc);
                }
                System.out.println("++ flor olucak");

                return searchPcPoolAndASCII(maxBound, maxBound + 1);
            }
        }
//        return searchPcPoolAndASCII(maxBound,maxBound+1);
//        System.out.println("buradan doncuek getPriorityChar((char) maxBound)" + getPriorityChar((char) maxBound));
        return new SuccessDataResult<>(getPriorityChar((char) minBound));
        /*
         * a 97
         * b 98
         * c 99
         * d 100
         * e 101
         * f 102
         * */

    }

    // Todo this function has bug, here will be refactored
    @Override
    public DataResult<PriorityChar> getNextPriorityCharOfGiven(char c) {
//        System.out.println(" ? SONRASI BULUNACAK char :[" + c + "] value : " + getPriorityChar(c).getValue());
        PriorityChar currentPc = getPriorityChar(c);
        double minBound = currentPc.getValue();
        double maxBound = (int) Math.ceil(currentPc.getValue());
        if (maxBound == minBound) {
            maxBound++;
        }
        System.out.println("Current pc  value " + currentPc.getValue() + "  minBound: " + minBound + "  maxBound : " + maxBound);
        PriorityChar foundPc = getPcBetweenGivenValues(minBound, maxBound);
        if (foundPc != null) {
            return new SuccessDataResult<>(foundPc);
        }
//        System.out.println("found pc null : >> searchPcPoolAndASCII ");
        return searchPcPoolAndASCII(minBound, maxBound);
//        for (int i = 0; i < list.size(); i++) {
//            if (currentPc.getValue() - list.get(i).getValue())
                /*if (list.get(i).getValue() > currentPc.getValue()) {
                    System.out.println(" --> BULUNAN DEGER Gelen char [" + c + "]'in sonraki char'i :[[" + list.get(i).getChar() + "]] value : " + list.get(i).getValue());
                    return new SuccessDataResult<>(list.get(i));

                }*/
//        }
        /*
         * cde --> a
         * b-> e      -->  acdeb  [97.???]
         * 98 X , 99 X 100 X
         * */
        /*PriorityChar pc = (getPriorityChar((char) (Math.floor((int) c + 1))));
        System.out.println(" XX Sonrasi BULUNAMAYIAN [" + c + "] in sonraki char'i BULUNAMADI +1 DONUCEK :[" + pc.getChar() + "]" + pc.getValue());
        System.out.println("X?X?X?X currentPc : " + currentPc.getChar() + " : " + currentPc.getValue());
        return new SuccessDataResult<>(getPriorityChar((char) (Math.floor((int) c + 1))));*/
    }

    private double calculateNewPriorityCharValue(double beforeCharValue, double nextCharValue) {
        return (beforeCharValue + nextCharValue) / 2;
    }

    private void printPriorityPool() {
        if (list.size() == 0)
            return;
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
        }
    }

    // Todo this function has bug, here will be refactored
    private double getNextCharValue(PriorityChar pchar) {
//        System.out.println("list size " +pchar.getChar()+" : "+pchar.getValue());
        for (int i = 0; i < list.size(); i++) {
//            System.out.println("list.get(i).getValue() :"+list.get(i).getValue()+" pchar.getValue() : "+ pchar.getValue());
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
