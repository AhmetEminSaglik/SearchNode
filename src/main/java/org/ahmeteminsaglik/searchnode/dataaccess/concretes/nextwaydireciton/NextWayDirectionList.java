package org.ahmeteminsaglik.searchnode.dataaccess.concretes.nextwaydireciton;

import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.utilities.DataResult;
import org.ahmeteminsaglik.searchnode.utilities.ErrorDataResult;
import org.ahmeteminsaglik.searchnode.utilities.SuccessDataResult;
import org.ahmeteminsaglik.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.ahmeteminsaglik.searchnode.dataaccess.comparator.ComparatorNextWayDirectionRequiredData;
import org.ahmeteminsaglik.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.ahmeteminsaglik.searchnode.entities.concretes.PriorityChar;
import java.util.ArrayList;
import java.util.Collections;
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
