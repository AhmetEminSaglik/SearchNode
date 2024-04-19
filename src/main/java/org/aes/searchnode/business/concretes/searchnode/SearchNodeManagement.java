package org.aes.searchnode.business.concretes.searchnode;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.core.utilities.*;
import org.aes.searchnode.dataaccess.concretes.nextwaydireciton.PossibilityNextWayDirection;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldOrder;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.*;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchNodeManagement<T> implements SearchNodeService<T> {
    SearchNode<T> searchNode;
    SearchNode<T> movedLastSearchNodeConnection = null;
//    private List<SearchNode<T>> sNListToIncreaseNWDTV = new ArrayList<>();
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

    private Result removeRecursive(SearchNode<T> searchNode, StringBuilder sbText, int index) {
        SearchNode<T> searchNodeNext = null;
        PriorityChar pc = null;
        Result result = null;
        NodeData<T> nodeData = searchNode.getNodeData();
        if (nodeData != null) {
            if (nodeData.getLocationAddress().contentEquals(sbText)) {
                String msg = "";
                if (!nodeData.getListDataInfo().isEmpty()) {
                    msg = ">> Data is removed : " + sbText;
                    searchNode.getNodeData().getListDataInfo().clear();
                    return new SuccessResult(msg);
                }
                msg = "Data is not found";
                return new ErrorResult(msg);
            }
            char c = sbText.charAt(index);
            pc = searchNode.getPcService().get(c).getData();
            searchNodeNext = searchNode.getReachableNWD().getNextSearchNodeWayOfChar(pc).getData();
            if (searchNodeNext == null) {
                return new ErrorDataResult<>(null, "There is not such as word");
            }
            result = removeRecursive(searchNodeNext, sbText, ++index);
        }

        if (result.isSuccess()) {
            searchNode.getNodeData().decreaseNextWayDirectionTotalValue();
        }
        if (searchNode.getNodeData().getNextDirectionsTotalValueNumber() <= 0) {
            searchNode.getReachableNWD().clearPc(pc);
            return new SuccessResult("Data is removed");
        }


        return new ErrorResult("Data deletion process is ended");
    }

    @Override
    public Result remove(T t) {
        Object value = getValueOfObjectToBeProcess(t);
        StringBuilder stringValue = new StringBuilder(value.toString().trim());
        stringValue = trimObject(stringValue.toString());
        Result result;
        if (stringValue.toString().equals("")) {
            return new ErrorResult("Empty or Space can not be deleted in SearchNode");
        } else {
            result = removeRecursive(searchNode, stringValue, 0);

        }
        return result;
    }

    @Override
    public DataResult<List<T>> removeAll(List<T> list) {
        List<T> removedData = new ArrayList<>();
        List<T> notFoundData = new ArrayList<>();
        for (T t : list) {
            if (remove(t).isSuccess()) {
                removedData.add(t);
            } else {
                notFoundData.add(t);
            }
        }
        String msg = "Removed Data size  :" + removedData.size() + ". Not found Data size  : " + notFoundData.size() + ". Removed data can be found in data.";
        DataResult<List<T>> result = new SuccessDataResult<>(removedData, msg);
        return result;
    }

    private String resetNullStringTypeValue(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

    @Override
    public Result update(T t, String oldExp, String newExp) {
        oldExp = resetNullStringTypeValue(oldExp);
        newExp = resetNullStringTypeValue(newExp);

        Object value = getValueOfObjectToBeProcess(t);
        StringBuilder path = getStringBuilderOfData(value);

        NodeData<T> nodeData = searchNodeData(path.toString()).getData();
        nodeData.update(path.toString(), oldExp, newExp);
        return new SuccessResult("Update is successfull");
    }

    @Override
    public Result update(T t, String oldExp, List<String> expList) {
        System.out.println("list Size : " + expList.size());
        if (expList.size() > 0) {
            update(t, oldExp, expList.get(0));
            expList.remove(0);
            if (expList.size() > 1) {
                expList.forEach(e -> add(t, e));
            }
        } else {
            return new ErrorResult("Explanation List is empty");
        }

        return new SuccessResult();
    }

    @Override
    public Result update(T t, List<String> expList) {
        return update(t, "", expList);
    }

    @Override
    public Result add(T t) {
        return add(t, "");
    }

    private StringBuilder getStringBuilderOfData(Object value) {
        StringBuilder stringValue = new StringBuilder(value.toString().trim());
        stringValue = trimObject(stringValue.toString());
        return stringValue;
    }

    @Override
    public Result add(T t, String explanation) {

        clearNWDTVList();
        Object value = getValueOfObjectToBeProcess(t);
        StringBuilder stringValue = getStringBuilderOfData(value);

        if (stringValue.toString().equals("")) {
            return new ErrorResult("Empty or Space can not added to SearchNode");
        } else {
            movedLastSearchNodeConnection = searchNode;
            try {
                for (int i = 0; i < stringValue.length(); i++) {
//                    System.out.println("onceki Node : " + searchNode.getNodeData().getLocationAddress());
//                    System.out.println("onceki Node : " + movedLastSearchNodeConnection.getNodeData().getLocationAddress());
                    addSNToList(movedLastSearchNodeConnection);
//                    System.out.println("movedLastSearchNodeConnection : "+movedLastSearchNodeConnection.getNodeData().getLocationAddress());
                    PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
                    DataResult<SearchNode<T>> drReachablNWD = moveReachableNWD(movedLastSearchNodeConnection, pc);
                    if (!drReachablNWD.isSuccess()) {
                        stringValue.delete(0, i);
                        initializePossibilityNWD(t, explanation/*,getPriorityCharOfGivenChar(stringBuilder.charAt(0))*/);
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
            if (t.toString().equals(movedLastSearchNodeConnection.getNodeData().getLocationAddress())) {
                DataResult<Integer> drNodeDataAddProgress = movedLastSearchNodeConnection.getNodeData().addData(t, explanation);
                if (drNodeDataAddProgress.getData().equals(NodeData.NEW_VALUE_IS_ADDED)) {
                    increaseNewAddedItemLocationsNWDTV();
                }
            }
        }

        return new SuccessResult("Data is added");

    }

    @Override
    public Result add(T t, List<String> expList) {
        expList.forEach(e -> add(t, e));
        return null;
    }

    @Override
    public DataResult<NodeData<T>> searchNodeData(String text) {

        movedLastSearchNodeConnection = searchNode;
        StringBuilder stringValue = new StringBuilder(text);
        for (int i = 0; i < stringValue.length(); i++) {
            PriorityChar pc = getPriorityCharOfGivenChar(stringValue.charAt(i));
            DataResult<SearchNode<T>> drReachablNWD = moveReachableNWD(movedLastSearchNodeConnection, pc);
            if (drReachablNWD.isSuccess()) {
                DataResult<NodeData<T>> drNodeData = drReachablNWD.getData().getNodeData().search(text);
                if (drNodeData.isSuccess()) {
                    return new SuccessDataResult<>(drNodeData.getData(), "Data is found :" + drNodeData.getData().getLocationAddress());
                }
                movedLastSearchNodeConnection = drReachablNWD.getData();
            } else {

                return new ErrorDataResult<>("Requested Data : " + text + " /1/ Data is not found");
            }
        }
        return new ErrorDataResult<>("Requested Data : " + text + " /2/ Data is not found");


    }

    @Override
    public List<NodeData<T>> getAllNodeData(String text) {
        List<NodeData<T>> nodeDataList = new ArrayList<>();
//        List<T> valueList = new ArrayList<>();
//        searchNode.getAll().getData().forEach(e -> valueList.add(e.getValue()));
        getAllNodeData(nodeDataList, searchNode);
        return nodeDataList;
    }

    public void getAllNodeData(List<NodeData<T>> list, SearchNode<T> searchNode) {
        list.add(searchNode.getNodeData());
        searchNode.getReachableNWD().getAllDataOfSearchNode().forEach(e -> getAllNodeData(list, e.getSearchNode()));
    }

    @Override
    public DataResult<NodeDataService<T>> search(String text) {
        DataResult<NodeData<T>> dataResult = searchNodeData(text);
        if (dataResult.isSuccess()) {
            NodeDataService<T> nodeDataService = new NodeDataService<>(searchNodeData(text).getData());
            return new SuccessDataResult<>(nodeDataService);
        }
        return new ErrorDataResult<>(null);
//        NodeDataService<T> nodeDataService = new NodeDataService<>(searchNodeData(text).getData());
//        return new SuccessDataResult<>(nodeDataService);
    }

    @Override
    public DataResult<NodeDataService<T>> getExplanationOf(String text) {
        //todo burda hata olabilir
        NodeDataService<T> nodeData = search(text).getData();
        DataResult<NodeDataService<T>> dataResult;
        if (nodeData != null) {
            dataResult = new SuccessDataResult(nodeData, "Data is found");
        } else {
            dataResult = new ErrorDataResult<>("Data is not found");
        }
        return dataResult;
    }

    @Override
    public DataResult<List<DataInfo<T>>> getAll() {
        return new SuccessDataResult<>(getAllData(searchNode));
    }

    @Override
    public DataResult<List<DataInfo<T>>> getAllReverse() {
        List<DataInfo<T>> list = getAllData(searchNode);
        Collections.reverse(list);
        return new SuccessDataResult<>(list);
    }

    @Override
    public DataResult<List<DataInfo<T>>> getAllStartWith(String text) {
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

    private List<DataInfo<T>> getAllData(SearchNode<T> searchNode) {
        List<DataInfo<T>> list = new ArrayList<>();
        movedLastSearchNodeConnection = searchNode;
//        StringBuilder stringBuilder = new StringBuilder();
        addAllDataToList(list, searchNode);
        return list;
    }

    private void addAllDataToList(List<DataInfo<T>> list, SearchNode<T> searchNode) {
        List<NextWayDirectionRequiredData<T>> currentSearchNodeNextWayDirectionRequiredData = searchNode.getReachableNWD().getAllDataOfSearchNode();
        List<DataInfo<T>> dataInfoList = searchNode.getNodeData().getListDataInfo();
        addEachDataOfNodeDataToList(list, dataInfoList);

        for (NextWayDirectionRequiredData<T> tmpNWDRD : currentSearchNodeNextWayDirectionRequiredData) {
            SearchNode<T> tmpSearchNode = tmpNWDRD.getSearchNode();
            addAllDataToList(list, tmpSearchNode);
        }

    }

    private void addEachDataOfNodeDataToList(List<DataInfo<T>> allDataList, List<DataInfo<T>> dataInfoList) {
        dataInfoList.forEach(e -> {
            allDataList.add(e);
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

    private void initializePossibilityNWD(Object data, String explanation) {
        searchNode.setpNWDQueue(new PossibilityNextWayDirection(data, explanation, movedLastSearchNodeConnection));
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

    private void addSNToList(SearchNode<T> searchNodeAdd) {
//        getsNListToIncreaseNWDTV().add(searchNode);
        searchNode.getsNListToIncreaseNWDTV().add(searchNodeAdd);
    }

    private void increaseNewAddedItemLocationsNWDTV() {
        for (SearchNode<T> tmp : searchNode.getsNListToIncreaseNWDTV()) {
            tmp.getNodeData().increaseNextWayDirectionTotalValue();
        }
    }

    private void clearNWDTVList() {
//        getsNListToIncreaseNWDTV().clear();
        searchNode.getsNListToIncreaseNWDTV().clear();
    }

    /*public List<SearchNode<T>> getsNListToIncreaseNWDTV() {
        return sNListToIncreaseNWDTV;
    }

    public void setsNListToIncreaseNWDTV(List<SearchNode<T>> sNListToIncreaseNWDTV) {
        this.sNListToIncreaseNWDTV = sNListToIncreaseNWDTV;
    }*/
}
