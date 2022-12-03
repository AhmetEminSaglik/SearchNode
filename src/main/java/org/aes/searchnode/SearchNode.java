/*
package org.aes.searchnode;

import org.aes.searchnode.business.abstracts.prioritychar.PriorityCharService;
import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.config.reachablenextwaydirection.ConfigReachableNextWayDirection;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.abstracts.ReachableNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.DataInfo;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchNode<T> {
    */
/**
     * TODO : Search node'da fazlaca sayida kod var. Buradaki bir takim fonksiyonlar baska bir yerden cagrilabilir.
     *//*

 */
/*   private ReachableNextWayDirection reachableNWD = ConfigReachableNextWayDirection.getReachableNextWayDirectionObject();
    private NodeData nodeData = new NodeData();
    private PossibilityNextWayDirection pNWDQueue = null;
    PriorityCharService pcService = new PriorityCharManager();
    SearchNode<T> movedLastSearchNodeConnection = null;
    private List<SearchNode<T>> sNListToIncreaseNWDTV = new ArrayList<>();*//*


  */
/*  public void addAll(List<T> list) {
        list.forEach(item -> add(item));
    }

    public void add(T t *//*
*/
/*Object object, Class<?> clazz*//*
*/
/*) {

        clearNWDTVList();
        Object value = getValueOfObjectToBeProcess(t*//*
*/
/*object, clazz*//*
*/
/*);
        StringBuilder stringValue = new StringBuilder(value.toString().trim());
        stringValue = trimObject(stringValue.toString());
        if (stringValue.toString().equals("")) {
            System.err.println("empty or space can not added to SearchNode");
            return;
        } else {
            movedLastSearchNodeConnection = this;
            try {
                for (int i = 0; i < stringValue.length(); i++) {
                    addSNToList(movedLastSearchNodeConnection);
                    PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
                    DataResult<SearchNode<T>> drReachablNWD = movedLastSearchNodeConnection.moveReachableNWD(pc);
                    if (!drReachablNWD.isSuccess()) {
                        stringValue.delete(0, i);
                        initializePossibilityNWD(t*//*
*/
/*,getPriorityCharOfGivenChar(stringBuilder.charAt(0))*//*
*/
/*);
                        movePossibilityNWD(value, stringValue);
                        break;
                    }
                    movedLastSearchNodeConnection = drReachablNWD.getData();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
            if (pNWDQueue != null) {
//                System.out.println("pNWDQueue null degil : gelen String : " + t);
//                System.out.println("transfer yapilacak kelime : " + t);
                Result result = transferPossibilityNWDToReachableNWD();
                if (result.isSuccess()) {
                    increaseNewAddedItemLocationsNWDTV();
                    //printSizeOfAddedItems();
                }
                clearPossibilityNWD();
            }
            if (t.toString().equals(movedLastSearchNodeConnection.getNodeData().getLocationStringAddress())) {
//                System.out.println("daha once eklenmis olan bir kelime tekrar ekleneecek :" + t);
                DataResult<Integer> drNodeDataAddProgress = movedLastSearchNodeConnection.getNodeData().addData(t);
                if (drNodeDataAddProgress.getData().equals(NodeData.NEW_VALUE_IS_ADDED)) {
                    increaseNewAddedItemLocationsNWDTV();
                }
                //printSizeOfAddedItems();
            }
        }
    }*//*

*/
/*
    private StringBuilder trimObject(String text) {
        return new StringBuilder(text.trim());
    }

    private PriorityChar getPriorityCharOfGivenChar(char c) {
        DataResult<PriorityChar> drPriorityChar = pcService.getPriorityChar(c);
        PriorityChar pc = drPriorityChar.getData();
        return pc;
    }

    public DataResult<DataInfo> search(String text) {
        movedLastSearchNodeConnection = this;
        StringBuilder stringValue = new StringBuilder(text);
//        System.out.println("gelen arama degerleri text : "+text);
        for (int i = 0; i < stringValue.length(); i++) {
            PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
            DataResult<SearchNode<T>> drReachablNWD = movedLastSearchNodeConnection.moveReachableNWD(pc);
//            System.out.println(" drReachablNWD  :"+ drReachablNWD);
            if (drReachablNWD.isSuccess()) {
//                System.out.println("SUCCESSSSSSSSSSSSSS");
//                if (drReachablNWD.getData().getNodeData().getData() != null && drReachablNWD.getData().getNodeData().getData().equals(text)) {
                DataResult<DataInfo<T>> drDataInfo = drReachablNWD.getData().getNodeData().search(text);
//                System.out.println("drDataInfo : "+drDataInfo.toString());
//                System.out.println("LSA:  : "+movedLastSearchNodeConnection.getNodeData().getLocationStringAddress());
                if (drDataInfo.isSuccess()) {
//                    System.out.println("AES : drDataInfo.getData()  :" + drDataInfo.getData());
                    return new SuccessDataResult<>(drDataInfo.getData(), "Data is found :" + drDataInfo.getData().getValue());
                }
                movedLastSearchNodeConnection = drReachablNWD.getData();
            } else {
                return new ErrorDataResult<>("Requested Data : " + text + " /1/ Data is not found");
            }
        }
        return new ErrorDataResult<>("Requested Data : " + text + " /2/ Data is not found");
    }*//*


    */
/*

                TODO
                    En son burda ileri adimdaki Searchnodelari alip datalari varsalisteye ekleyip devam etme uzerinde calisiyordum
    *//*

 */
/*   public List<T> getAll() {
//        setConfigOrderBy(OrderBy.ASC);
        return getAllData(this);
    }*//*

*/
/*
    public List<T> getAllReverse() {
//        setConfigOrderBy(OrderBy.DESC);

        List<T> list = getAllData(this);
        Collections.reverse(list);
        return list;
//        return getAllData();
    }*//*

*/
/*
    public DataResult<List<T>> getAllStartWith(String text) {
        SearchNode<T> currentSearchNode = this;
        for (int i = 0; i < text.length(); i++) {
            DataResult<SearchNode<T>> dataResult = currentSearchNode.moveReachableNWD(getPriorityCharOfGivenChar(text.charAt(i)));
            if (dataResult.isSuccess()) {
                currentSearchNode = dataResult.getData();
            } else {

                return new ErrorDataResult<>(new ArrayList<>(), "Has not been added any text in this direction");
            }
        }
        return new SuccessDataResult<>(getAllData(currentSearchNode));

    }*//*

//    private void setConfigOrderBy(OrderBy orderBy) {
//        ConfigOrderBy.setOrderByNextWayDirectionRequiredData(orderBy);
//    }

*/
/*    private List<T> getAllData(SearchNode<T> searchNode) {
        List<T> list = new ArrayList<>();
        movedLastSearchNodeConnection = searchNode;
        StringBuilder stringBuilder = new StringBuilder();
        addAllDataToList(list, searchNode);
        return list;
    }*//*


    //TODO simdi listenin siralanmasi lazim. ondan sonra duzgun bir sekilde veriler cekilebilir
*/
/*    private void addAllDataToList(List<T> list, SearchNode<T> searchNode) {
        List<NextWayDirectionRequiredData<T>> currentSearchNodeNextWayDirectionRequiredData = searchNode.getReachableNWD().getAllDataOfSearchNode();
        List<DataInfo<T>> dataInfoList = searchNode.getNodeData().getListDataInfo();
        addEachDataOfNodeDataToList(list, dataInfoList);

        for (NextWayDirectionRequiredData<T> tmpNWDRD : currentSearchNodeNextWayDirectionRequiredData) {
            SearchNode<T> tmpSearchNode = tmpNWDRD.getSearchNode();
            addAllDataToList(list, tmpSearchNode);
        }

    }

    private void addEachDataOfNodeDataToList(List<T> allDataList, List<DataInfo<T>> dataInfoList) {
        dataInfoList.forEach(e -> {
            allDataList.add(e.getValue());
//            System.out.println("eklenen data  : " + e);
        });
    }


    private Result transferPossibilityNWDToReachableNWD() {
        if (pNWDQueue != null)
            movedLastSearchNodeConnection.getReachableNWD().addPossibilityNWDNodeToReachableNWD(pNWDQueue.getPcForFirstSNToConnectRootSN()
                    , pNWDQueue.getFirstSearchNodeToConnectRootSearchNode());
        return new SuccessResult();
    }

    DataResult<SearchNode<T>> moveReachableNWD(PriorityChar pc) {
        DataResult<SearchNode<T>> dataResult = reachableNWD.getNextSearchNodeWayOfChar(pc);
        if (dataResult.isSuccess()) {
            movedLastSearchNodeConnection = dataResult.getData();
            return dataResult;
        }
        return new ErrorDataResult<>("Can not move in ReachableNWD. Because direction is not found.");
    }

    private void movePossibilityNWD(Object value, StringBuilder stringBuilder*//*
*/
/*PriorityChar pc*//*
*/
/*) throws Exception {

        for (int i = 0; i < stringBuilder.length(); i++) {
            PriorityChar pc = getPriorityCharOfGivenChar(stringBuilder.charAt(i));
            pNWDQueue.createNextWayChar(pc);
//            DataResult<SearchNode> dataResult = pNWDQueue.createNextWayChar(pc);
//            System.out.println("dataResult : " + dataResult.toString());
        }
    }

    private void clearPossibilityNWD() {
        pNWDQueue = null;
    }

    private void initializePossibilityNWD(Object data*//*
*/
/*,PriorityChar pc*//*
*/
/*) {
        pNWDQueue = new PossibilityNextWayDirection(data, movedLastSearchNodeConnection*//*
*/
/*,pc*//*
*/
/**//*
*/
/*, movedLastSearchNodeConnection*//*
*/
/*);
    }*//*


    */
/*Object getValueOfObjectToBeProcess(T t*//*
*/
/*Object o, Class<?> clazz*//*
*/
/*) {
        *//*
*/
/*TODO  if Object is a custom object than index of priorityFieldName parameter must be dynamic
         *  pfOrder.getPriorityFieldName(index).getName()
         * *//*
*/
/*
        PriorityFieldOrder pfOrder = null;
        try {
            pfOrder = new PriorityFieldOrder(t.getClass());

            PriorityFieldValue pfValue = new PriorityFieldValue(pfOrder);
            String fieldName = pfOrder.getPriorityFieldName(1).getName();
            Object value = pfValue.getValueOfField(t, fieldName);
            //System.out.println(" Returning Value Of Object : " + value);
            return value;

        } catch (NotFoundAnyDeclaredFieldException |
                 ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException |
                 NotFoundRequestedFieldException | InvalidFieldOrFieldNameException e) {
            throw new RuntimeException(e);
        }
    }

    public ReachableNextWayDirection getReachableNWD() {
        return reachableNWD;
    }

    public void setReachableNWD(ReachableNextWayDirection reachableNWD) {
        this.reachableNWD = reachableNWD;
    }

    public NodeData<T> getNodeData() {
        return nodeData;
    }

    public void setNodeData(NodeData<T> nodeData) {
        this.nodeData = nodeData;
    }

    public PossibilityNextWayDirection<T> getpNWDQueue() {
        return pNWDQueue;
    }

    public void setpNWDQueue(PossibilityNextWayDirection<T> pNWDQueue) {
        this.pNWDQueue = pNWDQueue;
    }

    private void addSNToList(SearchNode<T> searchNode) {
        sNListToIncreaseNWDTV.add(searchNode);
    }

    private void increaseNewAddedItemLocationsNWDTV() {
        for (SearchNode<T> tmp : sNListToIncreaseNWDTV) {
//            System.out.println("increaseNextWayDirectionTotalValue olan LSA : " + tmp.getNodeData().getLocationStringAddress());
            tmp.getNodeData().increaseNextWayDirectionTotalValue();
        }

    }

    private void clearNWDTVList() {
        sNListToIncreaseNWDTV.clear();
    }

    public void printSizeOfAddedItems() {
        System.out.println("Total Items in SearchNode : " + ReadableStringFormat.getReadableValueLongToString(getNodeData().getNextWayDirectionTotalValue()));
    }

    @Override
    public String toString() {
        return "SearchNode{" +
                "nodeData=" + nodeData +
                '}';
    }*//*

}

*/
