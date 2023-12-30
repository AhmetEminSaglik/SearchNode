package org.aes.searchnode.business.concretes.searchnode;

import org.aes.searchnode.Main;
import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.*;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchNodeManagement<T> implements SearchNodeService<T> {
    private static CustomLog log = new CustomLog(SearchNodeManagement.class);

    SearchNode<T> searchNode;
    SearchNode<T> movedLastSearchNodeConnection = null;

    public SearchNodeManagement(SearchNode<T> searchNode) {
        this.searchNode = searchNode;
    }

    @Override
    public Result addAll(List<T> list) {
        for (T t : list) {
            add(t);
        }
        return new SuccessResult();
    }

    private Result removeRecurcive(SearchNode<T> searchNode, StringBuilder sbText, int index) {
        log.info("searchnode : " + searchNode);
        log.info(index + " -> " + sbText.substring(0, index));
        SearchNode searchNodeNext = null;
        PriorityChar pc = null;
//            return new SuccessResult("There is not such as word");
        if (searchNode.getNodeData() != null) {
            log.info("searchNode.getNodeData().getLocationStringAddress() : " + searchNode.getNodeData().getLocationStringAddress());
            log.info(".contentEquals(sbText) : " + sbText);
            if (searchNode.getNodeData().getLocationStringAddress().contentEquals(sbText)) {
                System.out.println("searchNode SILINECEK DATA " + searchNode.getNodeData());
                log.info("Data is removed");
                searchNode.getNodeData().getListDataInfo().clear();
                System.out.println("searchNode SILINDIKTEN SONRA  DATA " + searchNode.getNodeData());
                return new SuccessResult("Data is removed");
            } else {
                log.info("Tekrardan recursive girecek");
            }
            char c = sbText.charAt(index);
            pc = searchNode.getPcService().get(c).getData();
            /*SearchNode<T> searchNodeNext*/
            searchNodeNext= searchNode.getReachableNWD().getNextSearchNodeWayOfChar(pc).getData();
            log.info("Recursive girmeden once SN : " + searchNode);
            if (searchNodeNext == null) {
                return new SuccessResult("There is not such as word");
            }
//            System.out.println("index  "+index+" / pc : "+pc);
            removeRecurcive(searchNodeNext, sbText, ++index);
//            System.out.println("index  "+index+" / pc : "+pc);
            /*if (searchNodeNext.getNodeData().getNextDirectionsTotalValueNumber() == 1) {
                searchNode.getReachableNWD().clearPc(pc);
                searchNode.getNodeData().decreaseNextWayDirectionTotalValue();
                log.info("SearchNode connection is removed");
                return new SuccessResult("SearchNode is removed");
            }*/

        }
        System.out.println(" recursivden geri adim atildi: " + (index - 1));

        searchNode.getNodeData().decreaseNextWayDirectionTotalValue();
        System.out.println("searchNode.getNodeData() : " + searchNode.getNodeData());
        if (searchNode.getNodeData().getNextDirectionsTotalValueNumber() <= 0) {
            System.out.println("recursive geri adim atildi. sonrakinda NWDTV 0 oldugu icin SILINECEK : Pc  : " + pc);

            System.out.println("Silinme ONCESI : " + searchNode.getReachableNWD().getAllDataOfSearchNode().size());
            if (searchNode.getReachableNWD().getAllDataOfSearchNode().size() > 0)
                System.out.println(searchNode.getReachableNWD().getAllDataOfSearchNode().get(0));
            searchNode.getReachableNWD().clearPc(pc);
            System.out.println("Silinme SONRASI : " + searchNode.getReachableNWD().getAllDataOfSearchNode().size());
        }
//        searchNode=dataResultSN.getData();

        return new SuccessResult();
    }

    @Override
    public Result remove(T t) {
//        clearNWDTVList();
        Object value = getValueOfObjectToBeProcess(t/*object, clazz*/);
        StringBuilder stringValue = new StringBuilder(value.toString().trim());
        stringValue = trimObject(stringValue.toString());
        if (stringValue.toString().equals("")) {
            return new ErrorResult("Empty or Space can not be deleted in SearchNode");
        } else {

            removeRecurcive(searchNode, stringValue, 0);
        }/*{
            removeRecurcive(searchNode, stringValue, 0);

            movedLastSearchNodeConnection = searchNode;
            log.info("--> BEFORE searchNode : " + searchNode);

            *//*if (movedLastSearchNodeConnection.getTotalItemNumber() == 1) {
                movedLastSearchNodeConnection.getReachableNWD().clearList();
                log.info("--> AFTER clear List  :" + searchNode);
            }*//*
            try {
                for (int i = 0; i < stringValue.length(); i++) {
                    if (movedLastSearchNodeConnection.getTotalItemNumber() == 1) {
                        movedLastSearchNodeConnection.getReachableNWD().clearList();
                        log.info("--> AFTER clear List  == 1 :" + searchNode);
                        searchNode.getNodeData().decreaseNextWayDirectionTotalValue();
                        return null;
                    } else if (movedLastSearchNodeConnection.getTotalItemNumber() > 1) {
                        PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
                        movedLastSearchNodeConnection.getReachableNWD().clearPc(pc);
                        log.info("--> AFTER clear PC >1  :" + searchNode);
                        return null;
                    }

//                    addSNToList(movedLastSearchNodeConnection);
                    PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
                    if (searchNode.getNodeData().getNextWayDirectionTotalValue() == 1) {
                        System.out.println();
//                        searchNode.getReachableNWD().getAllDataOfSearchNode().forEach(System.out::println);
                        System.out.println("<><> searchNode.getReachableNWD().getAllDataOfSearchNode().size() : " + searchNode.getReachableNWD().getAllDataOfSearchNode().size());
                        System.out.println(searchNode);
//                        searchNode.getReachableNWD().getAllDataOfSearchNode().remove(0);
                        searchNode.getReachableNWD().getAllDataOfSearchNode().remove(searchNode.getReachableNWD().getNextSearchNodeWayOfChar(pc));
                        System.out.println();
                        System.out.printf("<><> searchNode.getReachableNWD().getAllDataOfSearchNode().size() : " + searchNode.getReachableNWD().getAllDataOfSearchNode().size());
                        System.out.println();
//                        searchNode.getReachableNWD().getAllDataOfSearchNode().forEach(System.out::println);
                        return null;
                    }
                    DataResult<SearchNode<T>> drReachablNWD = moveReachableNWD(movedLastSearchNodeConnection, pc);
                    log.info("drReachablNWD : " + drReachablNWD);
                    if (drReachablNWD.isSuccess()) {
                        NodeData<T> nodeData = drReachablNWD.getData().getNodeData();
                        log.info("SONUC  : " + drReachablNWD);
                        if (nodeData.getNextDirectionsTotalValueNumber() == 0) {
                            log.info("--> ==0");
                        } else if (nodeData.getNextDirectionsTotalValueNumber() == 1) {
                            log.info("--> ==1");

                        } else {
                            log.info("--> >1");
                        }
                        stringValue.delete(0, i);
                        initializePossibilityNWD(t*//*,getPriorityCharOfGivenChar(stringBuilder.charAt(0))*//*);
                        movePossibilityNWD(value, stringValue);
                        break;
                    } else {
                        log.info("IF'e GIRMEDI ");
                    }
                    movedLastSearchNodeConnection = drReachablNWD.getData();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
//                return new ErrorDataResult<>(new NodeData<>() "Data is not found");
                System.exit(0);
            }
            if (searchNode.getpNWDQueue() != null) {
                Result result = transferPossibilityNWDToReachableNWD();
                if (result.isSuccess()) {
                    increaseNewAddedItemLocationsNWDTV();
                }
                clearPossibilityNWD();
            }
            if (t.toString().equals(movedLastSearchNodeConnection.getNodeData().getLocationStringAddress())) {
                DataResult<Integer> drNodeDataAddProgress = movedLastSearchNodeConnection.getNodeData().addData(t);
                if (drNodeDataAddProgress.getData().equals(NodeData.NEW_VALUE_IS_ADDED)) {
                    increaseNewAddedItemLocationsNWDTV();
                }
            }
        }*/

        return new SuccessResult("Data is added");

    }

    @Override
    public Result removeAll(List<T> list) {
        return null;
    }

    @Override
    public Result add(T t) {
        clearNWDTVList();
        Object value = getValueOfObjectToBeProcess(t/*object, clazz*/);
        StringBuilder stringValue = new StringBuilder(value.toString().trim());
        stringValue = trimObject(stringValue.toString());
        if (stringValue.toString().equals("")) {
            return new ErrorResult("Empty or Space can not added to SearchNode");
        } else {
            movedLastSearchNodeConnection = searchNode;
            try {
                for (int i = 0; i < stringValue.length(); i++) {
                    addSNToList(movedLastSearchNodeConnection);
//                    System.out.println("eklencek movedLastSearchNodeConnection : "+movedLastSearchNodeConnection.getNodeData());
                    PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
                    DataResult<SearchNode<T>> drReachablNWD = moveReachableNWD(movedLastSearchNodeConnection, pc);
                    if (!drReachablNWD.isSuccess()) {
                        stringValue.delete(0, i);
                        initializePossibilityNWD(t/*,getPriorityCharOfGivenChar(stringBuilder.charAt(0))*/);
                        movePossibilityNWD(value, stringValue);
                        break;
                    }
                    movedLastSearchNodeConnection = drReachablNWD.getData();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
            if (searchNode.getpNWDQueue() != null) {
                Result result = transferPossibilityNWDToReachableNWD();
                if (result.isSuccess()) {
                    increaseNewAddedItemLocationsNWDTV();
                }
                clearPossibilityNWD();
            }
            if (t.toString().equals(movedLastSearchNodeConnection.getNodeData().getLocationStringAddress())) {
                DataResult<Integer> drNodeDataAddProgress = movedLastSearchNodeConnection.getNodeData().addData(t);
                if (drNodeDataAddProgress.getData().equals(NodeData.NEW_VALUE_IS_ADDED)) {
                    increaseNewAddedItemLocationsNWDTV();
                }
            }
        }

        return new SuccessResult("Data is added");
    }

    @Override
    public DataResult<DataInfo<T>> search(String text) {
        movedLastSearchNodeConnection = searchNode;
        StringBuilder stringValue = new StringBuilder(text);
        for (int i = 0; i < stringValue.length(); i++) {
            PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
            DataResult<SearchNode<T>> drReachablNWD = moveReachableNWD(movedLastSearchNodeConnection, pc);
            if (drReachablNWD.isSuccess()) {
                DataResult<DataInfo<T>> drDataInfo = drReachablNWD.getData().getNodeData().search(text);
                if (drDataInfo.isSuccess()) {
                    return new SuccessDataResult<>(drDataInfo.getData(), "Data is found :" + drDataInfo.getData().getValue());
                }
                movedLastSearchNodeConnection = drReachablNWD.getData();
            } else {
                return new ErrorDataResult<>("Requested Data : " + text + " /1/ Data is not found");
            }
        }
        return new ErrorDataResult<>("Requested Data : " + text + " /2/ Data is not found");

    }

    @Override
    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<>(getAllData(searchNode));
    }

    @Override
    public DataResult<List<T>> getAllReverse() {
        List<T> list = getAllData(searchNode);
        Collections.reverse(list);
        return new SuccessDataResult<>(list);
    }

    @Override
    public DataResult<List<T>> getAllStartWith(String text) {
        SearchNode<T> currentSearchNode = searchNode;
        for (int i = 0; i < text.length(); i++) {
            DataResult<SearchNode<T>> dataResult = moveReachableNWD(currentSearchNode, getPriorityCharOfGivenChar(text.charAt(i)));
            if (dataResult.isSuccess()) {
                currentSearchNode = dataResult.getData();
            } else {

                return new ErrorDataResult<>(new ArrayList<>(), "Has not been added any text in this direction");
            }
        }
        return new SuccessDataResult<>(getAllData(currentSearchNode));

    }

    @Override
    public int getTotalItemNumber() {
        return searchNode.getNodeData().getNextWayDirectionTotalValue();
    }

    @Override
    public Result resetPriorityChar(char c) {
        return searchNode.resetPriorityChar(c);
    }

    @Override
    public Result resetAllPriorityChars() {
        return searchNode.resetAllPriorityChars();
    }

    @Override
    public Result updatePriorityChar(List<Character> cList, char nextToThisChar) {
        return searchNode.updatePriorityChar(cList, nextToThisChar);
    }

    @Override
    public Result updatePriorityChar(char c, char nextToThisChar) {
        return searchNode.updatePriorityChar(c, nextToThisChar);
    }


    private StringBuilder trimObject(String text) {
        return new StringBuilder(text.trim());
    }

    private PriorityChar getPriorityCharOfGivenChar(char c) {
        DataResult<PriorityChar> drPriorityChar = searchNode.getPcService().get(c);
        PriorityChar pc = drPriorityChar.getData();
        return pc;
    }

    private List<T> getAllData(SearchNode<T> searchNode) {
        List<T> list = new ArrayList<>();
        movedLastSearchNodeConnection = searchNode;
//        StringBuilder stringBuilder = new StringBuilder();
        addAllDataToList(list, searchNode);
        return list;
    }

    private void addAllDataToList(List<T> list, SearchNode<T> searchNode) {
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
        });
    }


    private Result transferPossibilityNWDToReachableNWD() {
        if (searchNode.getpNWDQueue() != null)
            movedLastSearchNodeConnection.getReachableNWD().addPossibilityNWDNodeToReachableNWD(searchNode.getpNWDQueue().getPcForFirstSNToConnectRootSN()
                    , searchNode.getpNWDQueue().getFirstSearchNodeToConnectRootSearchNode());
        return new SuccessResult();
    }

    DataResult<SearchNode<T>> moveReachableNWD(SearchNode<T> searchNode, PriorityChar pc) {
        DataResult<SearchNode<T>> dataResult = searchNode.getReachableNWD().getNextSearchNodeWayOfChar(pc);
        if (dataResult.isSuccess()) {
            movedLastSearchNodeConnection = dataResult.getData();
            return dataResult;
        }
        return new ErrorDataResult<>("Can not move in ReachableNWD. Because direction is not found.");
    }

    private void movePossibilityNWD(Object value, StringBuilder stringBuilder) throws Exception {
        for (int i = 0; i < stringBuilder.length(); i++) {
            PriorityChar pc = getPriorityCharOfGivenChar(stringBuilder.charAt(i));
            searchNode.getpNWDQueue().createNextWayPriorityChar(pc);
        }
    }

    private void clearPossibilityNWD() {
        searchNode.setpNWDQueue(null);
    }

    private void initializePossibilityNWD(Object data) {
        searchNode.setpNWDQueue(new PossibilityNextWayDirection(data, movedLastSearchNodeConnection));
    }

    Object getValueOfObjectToBeProcess(T t) {
        /*TODO  if Object is a custom object than index of priorityFieldName parameter must be dynamic
         *  pfOrder.getPriorityFieldName(index).getName()
         * */
        PriorityFieldOrder pfOrder = null;
        try {
            pfOrder = new PriorityFieldOrder(t.getClass());
            PriorityFieldValue pfValue = new PriorityFieldValue(pfOrder);
            String fieldName = pfOrder.getPriorityFieldName(1).getName();
            Object value = pfValue.getValueOfField(t, fieldName);
            return value;
        } catch (NotFoundAnyDeclaredFieldException |
                 ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException |
                 NotFoundRequestedFieldException | InvalidFieldOrFieldNameException e) {
            throw new RuntimeException(e);
        }
    }

    private void addSNToList(SearchNode<T> searchNodeToAdd) {
        searchNode.getsNListToIncreaseNWDTV().add(searchNodeToAdd);
    }
//    private  void deleteSN(Sea){
//
//
//    }

    private void increaseNewAddedItemLocationsNWDTV() {
//        log.info("searchNode.getsNListToIncreaseNWDTV() " + searchNode.getsNListToIncreaseNWDTV().size());
        for (SearchNode<T> tmp : searchNode.getsNListToIncreaseNWDTV()) {
//            log.info("_________________________eklencek searchNode.getNodeData(): " + searchNode.getNodeData());
            tmp.getNodeData().increaseNextWayDirectionTotalValue();
        }
    }

    private void clearNWDTVList() {
        searchNode.getsNListToIncreaseNWDTV().clear();
    }
}
