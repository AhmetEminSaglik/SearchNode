package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
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
    public DataResult<SearchNode<T>> getNextWayOfChar(PriorityChar pc) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()) {
//                System.out.println("LISTEDEN VERI CEKILIYOR : "+list.get(i));
                return new SuccessDataResult<>(list.get(i).getSearchNode(), "Data is retreived");
            } else {
//                System.out.println("Gelen char : "+pc.getChar()+" /// Listeden cekilen char : "+list.get(i).getPriorityChar().getChar());
            }
        }
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
    }

    @Override
    public DataResult<SearchNode<T>> addPossibilityNWDNodeToReachableNWD(PriorityChar pc, SearchNode<T> searchNode) {
//        System.out.println("!!!!! listee Veri ekleniyor : "+pc+"  /  "+searchNode);
        list.add(new NextWayDirectionRequiredData(pc, searchNode));

        if(list.size()>1){
            System.out.println("-----------------------------------");
            System.out.println("siralama oncesi : ");
            list.forEach(e-> System.out.println(e));
        }



        if(list.size()>1){System.out.println("siralama sonrasi: ");
        list.forEach(e-> System.out.println(e));
        System.out.println("==========================================");}
        return new SuccessDataResult<>("--> SearchNode is added to List");
    }

    @Override
    public List<NextWayDirectionRequiredData> getAllDataOfSearchNode() {
        Collections.sort(list, new ComparatorNextWayDirectionRequiredData());
        return new ArrayList<>(list);
//        return null;
    }


    /*@Override
    public void printAllDataOfSearchNode() {
//        System.out.println("List  Datas : ");
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i).getPriorityChar().getChar();
            SearchNode sn = list.get(i).getSearchNode();
            System.out.println(c + " : " + sn);
        }
//        System.out.println("List is over");
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }*/

/*
    @Override
    public List<SearchNode<T>> getAll(SearchNode<T> searchNode) {
        */

    /**
     * getNextWayDirectionRequiredDataList--> fonksiyonu interface'de olmadigi icin erisemiyorum.
     *//*

        for (SearchNode<T> tmp : searchNode.get) {

        }


    }
*/



/*
    @Override
    public DataResult<SearchNode> addPossibilityNWDNodeToReachableNWD(PriorityChar pc) {
        return null;
    }
*/


//    @Override
//    public DataResult<SearchNode> createNextWayChar(PriorityChar pc) {
//        return null;
//    }
    @Override
    public int size() {
        System.out.println(list.size());
        return list.size();
    }

    public List<NextWayDirectionRequiredData> getNextWayDirectionRequiredDataList() {
        return new ArrayList<NextWayDirectionRequiredData>(list);
    }
}
