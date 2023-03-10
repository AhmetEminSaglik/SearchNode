package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

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
import java.util.Comparator;
import java.util.List;


public class NextWayDirectionList<T> implements ReachableNextWayDirection<T> {
    private List<NextWayDirectionRequiredData<T>> list = new ArrayList<>();
    private static final ComparatorNextWayDirectionRequiredData comparatorNextWayDirectionRequiredData = new ComparatorNextWayDirectionRequiredData();

    @Override
    public DataResult<SearchNode<T>> getNextSearchNodeWayOfChar(PriorityChar pc) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()) {
                return new SuccessDataResult<>(list.get(i).getSearchNode(), "Data is retreived");
            }
        }
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
    }


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
