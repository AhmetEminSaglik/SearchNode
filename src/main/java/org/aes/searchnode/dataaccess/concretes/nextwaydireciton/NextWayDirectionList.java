package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.business.concretes.prioritychar.pool.PriorityCharPoolComparator;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.comparator.ComparatorNextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NextWayDirectionList<T> implements ReachableNextWayDirection<T> {
    private List<NextWayDirectionRequiredData<T>> list = new ArrayList<>();
    private static final ComparatorNextWayDirectionRequiredData comparatorNextWayDirectionRequiredData = new ComparatorNextWayDirectionRequiredData();

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
//        System.out.println("LINEAR SEARCH");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()) {
                return new SuccessDataResult<>(list.get(i).getSearchNode(), "Data is retrieved");
            }
        }
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());

    }

    static PriorityCharPoolComparator comparator = new PriorityCharPoolComparator();

    /*private DataResult<SearchNode<T>> binarySearch(List<NextWayDirectionRequiredData<T>> list, PriorityChar pc) {
        Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
        System.out.println("BINEARY SEARCH");

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
        list.add(new NextWayDirectionRequiredData(pc, searchNode));
        /*if (list.size() > 1) {
            System.out.println("sort onces : ");
            list.forEach(e -> {
                System.out.println(e);
            });
            Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
            System.out.println("sort sonrasi : ");
            list.forEach(e -> {
                System.out.println(e);
            });
            System.out.println("===================================");
        }*/
        return new SuccessDataResult<>("--> SearchNode is added to List");
    }

    @Override
    public List<NextWayDirectionRequiredData<T>> getAllDataOfSearchNode() {
        Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
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
}
