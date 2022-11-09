package org.aes.searchnode.dataaccess.concretes.nextwaydireciton;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ErrorDataResult;
import org.aes.searchnode.core.utilities.SuccessDataResult;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.PriorityChar;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class NextWayDirectionList implements ReachableNextWayDirection {
    List<NextWayDirectionRequiredData> list = new ArrayList<>();

    @Override
    public DataResult<SearchNode> getNextWayOfChar(PriorityChar pc) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPriorityChar().getChar() == pc.getChar()){
//                System.out.println("LISTEDEN VERI CEKILIYOR : "+list.get(i));
                return new SuccessDataResult<>(list.get(i).getSearchNode(), "Data is retreived");
            }else{
//                System.out.println("Gelen char : "+pc.getChar()+" /// Listeden cekilen char : "+list.get(i).getPriorityChar().getChar());
            }
        }
        return new ErrorDataResult<>("Data is not found in " + getClass().getSimpleName());
    }

    @Override
    public DataResult<SearchNode> addPossibilityNWDNodeToReachableNWD(PriorityChar pc, SearchNode searchNode) {
//        System.out.println("!!!!! listee Veri ekleniyor : "+pc+"  /  "+searchNode);
        list.add(new NextWayDirectionRequiredData(pc, searchNode));
        return new SuccessDataResult<>("--> SearchNode is added to List");
    }


    @Override
    public void printAllDataOfSearchNode() {
//        System.out.println("List  Datas : ");
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i).getPriorityChar().getChar();
            SearchNode sn = list.get(i).getSearchNode();
            System.out.println(c + " : " + sn);
        }
//        System.out.println("List is over");
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }



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
}
