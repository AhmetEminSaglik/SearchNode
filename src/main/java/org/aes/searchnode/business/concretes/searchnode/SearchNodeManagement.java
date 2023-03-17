package org.aes.searchnode.business.concretes.searchnode;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.DataInfo;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.entities.concretes.NodeData;
import org.aes.searchnode.entities.concretes.PriorityChar;
import org.aes.searchnode.entities.example.Student;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchNodeManagement<T> implements SearchNodeService<T> {
    SearchNode<T> rootSearchNode;
    SearchNode<T> movedLastSearchNodeConnection = null;
    private List<SearchNode<?>> snListToIncreaseNWDTV = new ArrayList<>();
    SNUtility snUtility = new SNUtility();

    public SearchNodeManagement(SearchNode<T> rootSearchNode) {
        this.rootSearchNode = rootSearchNode;
    }

    @Override
    public Result addAll(List<T> list) {
        for (T t : list) {
            add(t);
        }
        return new SuccessResult();
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
            movedLastSearchNodeConnection = rootSearchNode;
            try {
                for (int i = 0; i < stringValue.length(); i++) {
                    addSNToList(movedLastSearchNodeConnection);
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
            if (rootSearchNode.getPNWDQueue() != null) {
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
        movedLastSearchNodeConnection = rootSearchNode;
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
        return new SuccessDataResult<>(getAllData(rootSearchNode));
    }

    @Override
    public DataResult<List<T>> getAllReverse() {
        List<T> list = getAllData(rootSearchNode);
        Collections.reverse(list);
        return new SuccessDataResult<>(list);
    }

    @Override
    public DataResult<List<T>> getAllStartWith(String text) {
        SearchNode<T> currentSearchNode = rootSearchNode;
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
    public long getTotalItemNumber() {
        return rootSearchNode.getNodeData().getNextWayDirectionTotalValue();
    }


    private StringBuilder trimObject(String text) {
        return new StringBuilder(text.trim());
    }

    private PriorityChar getPriorityCharOfGivenChar(char c) {
        DataResult<PriorityChar> drPriorityChar = rootSearchNode.getPcService().getPriorityChar(c);
        PriorityChar pc = drPriorityChar.getData();
        return pc;
    }

    private List<T> getAllData(SearchNode<T> searchNode) {
        List<T> list = new ArrayList<>();
        movedLastSearchNodeConnection = searchNode;
        StringBuilder stringBuilder = new StringBuilder();
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
        if (rootSearchNode.getPNWDQueue() != null)
            movedLastSearchNodeConnection.getReachableNWD().addPossibilityNWDNodeToReachableNWD(rootSearchNode.getPNWDQueue().getPcForFirstSNToConnectRootSN()
                    , rootSearchNode.getPNWDQueue().getFirstSearchNodeToConnectRootSearchNode());
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
            rootSearchNode.getPNWDQueue().createNextWayChar(pc);
        }
    }

    private void clearPossibilityNWD() {
        rootSearchNode.setPNWDQueue(null);
    }

    private void initializePossibilityNWD(Object data) {
        rootSearchNode.setPNWDQueue(new PossibilityNextWayDirection(data, movedLastSearchNodeConnection));
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

    private void addSNToList(SearchNode<T> searchNode) {
        snUtility.addSNToIncreaseNWDTVList(snListToIncreaseNWDTV, searchNode);
    }

    private void increaseNewAddedItemLocationsNWDTV() {
        for (SearchNode<?> tmp : snListToIncreaseNWDTV) {
            tmp.getNodeData().increaseNextWayDirectionTotalValue();
        }
    }

    private void clearNWDTVList() {
        SNUtility.clearNWDTVList(snListToIncreaseNWDTV);
    }

}