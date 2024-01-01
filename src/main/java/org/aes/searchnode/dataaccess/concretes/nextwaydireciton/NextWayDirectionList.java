package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.business.concretes.prioritychar.pool.PriorityCharPoolComparator;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.comparator.ComparatorNextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NextWayDirectionList<T> implements ReachableNextWayDirection<T> {
    //    boolean sorted = false;
    private static CustomLog log = new CustomLog(NextWayDirectionList.class);

    private List<NextWayDirectionRequiredData<T>> list = new ArrayList<>();
    private static final ComparatorNextWayDirectionRequiredData comparatorNextWayDirectionRequiredData = new ComparatorNextWayDirectionRequiredData();
    private boolean sorted = false;

    @Override
    public Result clearList() {
        list.clear();
        return new SuccessResult("All data is removed");
    }

    @Override
    public Result clearPc(PriorityChar pc) {
        String msg = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()) {
                list.remove(i);
                msg = pc + " Data is removed";
                return new SuccessDataResult<>(msg);
            }
        }
        msg = pc + "Data is not removed because is not found.";
        log.info(msg);
        return new ErrorResult(msg);
    }


    @Override
    public DataResult<SearchNode<T>> getNextSearchNodeWayOfChar(PriorityChar pc) {
        return linearSearch(list, pc);
//        return binarySearch(list, pc);
        /*
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()) {
                return new SuccessDataResult<>(list.get(i).getSearchNode(), "Data is retrieved");
            }
        }
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
    */
    }

    private DataResult<SearchNode<T>> linearSearch(List<NextWayDirectionRequiredData<T>> list, PriorityChar pc) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()) {
                return new SuccessDataResult<>(list.get(i).getSearchNode(), "Data is retrieved");
            }
        }
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
    }

    private DataResult<SearchNode<T>> binarySearch(List<NextWayDirectionRequiredData<T>> list, PriorityChar pc) {
        if (!sorted) {
//            System.out.println("sorted  pc :"+pc);
//            Collections.sort(list, comparatorNextWayDirectionRequiredData); // listeyi sırala
            sort();
            sorted = true;
        }
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).getPriorityChar().getChar() == pc.getChar()) {
                return new SuccessDataResult<>(list.get(mid).getSearchNode(), "Data is retrieved");
            } else if (list.get(mid).getPriorityChar().getChar() < pc.getChar()) {
                low = mid + 1; // sağ yarıyı ara
            } else {
                high = mid - 1; // sol yarıyı ara
            }
        }
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
    }
//    static PriorityCharPoolComparator comparator = new PriorityCharPoolComparator();

    /*private DataResult<SearchNode<T>> binarySearch(List<NextWayDirectionRequiredData<T>> list, PriorityChar pc) {
        if (!sorted) {
            System.out.println("Sortlanacak : " + sorted);
            Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
            sorted = true;
            System.out.println("Sortlandi : " + sorted);
        }
//        else {
//            System.out.println("elseye girdi");
//        }
//        System.out.println("BINARY SEARCH");

//        public static int binarySearch(String[] array, String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonIndex = comparator.compare(pc, list.get(mid).getPriorityChar());

            if (comparisonIndex == 0) {
                return new SuccessDataResult<>(list.get(comparisonIndex).getSearchNode(), "Data is retrieved");
            } else if (comparisonIndex < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
//        return -1;
//        }
    }*/

    @Override
    public DataResult<SearchNode<T>> addPossibilityNWDNodeToReachableNWD(PriorityChar pc, SearchNode<T> searchNode) {
//        if (sorted) {
        sorted = false;
//            System.out.println("SORT FALSE OLDU");
//        }
        list.add(new NextWayDirectionRequiredData<>(pc, searchNode));
//            Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
        return new SuccessDataResult<>("--> SearchNode is added to List");
    }

    @Override
    public List<NextWayDirectionRequiredData<T>> getAllDataOfSearchNode() {
        sort();
//        Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        System.out.println(list.size());
        return list.size();
    }

    public List<NextWayDirectionRequiredData<T>> getNextWayDirectionRequiredDataList() {
        return new ArrayList<>(list);
    }

    static int counter = 0;

    @Override
    public String toString() {
        Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
        StringBuilder text = new StringBuilder();
        list.forEach(e -> {
            text.append(e.getPriorityChar().getChar()).append(",");
        });
        if (text.length() > 1)
            text.deleteCharAt(text.length() - 1);
        return ">>>  NextWayDirectionList{" +
                "list= [" + text + "]}";
    }

    public String customToString() {
        if (!list.isEmpty()) {
            counter++;
            String toString = ListUtils.recursiveToString(list, counter);
            counter--;
            return toString;
        }
        return "";
    }

    void sort() {
        Collections.sort(list, comparatorNextWayDirectionRequiredData);
    }


}
