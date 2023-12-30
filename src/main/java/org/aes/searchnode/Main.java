package org.aes.searchnode;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
//import org.aes.searchnode.core.utilities.CustomLog;
import org.aes.searchnode.core.utilities.CustomLog;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.dataaccess.comparator.ComparatorNextWayDirectionRequiredData;
import org.aes.searchnode.dpi.controllers.SearchNodeDPI;
import org.aes.searchnode.entities.concretes.NextWayDirectionRequiredData;
import org.aes.searchnode.fakedata.FakeDataCreation;
import org.aes.searchnode.testing.TestingArrayList;
import org.aes.searchnode.testing.TestingSearchNode;
import org.aes.searchnode.testing.TimeCalculation;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static CustomLog log = new CustomLog(Main.class);

    static final FileFundamental exampleDataFile = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/")
            .setFileName("Word-Data-1_398_449")
            .setFileExtension(".txt");

    static void printSlash() {
        log.info("-------------------------------------------");
    }

    static void printSearchNodeList(SearchNodeDPI<String> searchNodeTest) {
        System.out.println("----------------------------");
        List<String> list = searchNodeTest.getAll().getData();
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void printSearchNodeData(SearchNode<String> searchNode) {
        log.info("----------------------------------> SearchNode");
        log.info("seachnode  NodeData : " + searchNode.getNodeData());
        log.info("seachnode  getTotalItemNumber : " + searchNode.getTotalItemNumber());
    }

    private static void printAllNodesOfSearchNode(SearchNode<String> searchNode) {
        log.info("Recursive SearchNode : " + searchNode.getNodeData());
        searchNode.getReachableNWD().getAllDataOfSearchNode().forEach(e -> {
            SearchNode<String> tmp = e.getSearchNode();
            printAllNodesOfSearchNode(tmp);
        });
    }

    static SearchNode<String> searchNodeTest = new SearchNode<>();

    public static void addData(String data) {
        searchNodeTest.add(data);
        log.info('`' + data + "` eklendi");
        log.info("searchNodeTest total item value :" + searchNodeTest.getTotalItemNumber());
//        printAllNodesOfSearchNode(searchNodeTest);
    }

    public static void main(String[] args) {
        String name = "ali";
        addData("alim");
        addData("al");
//        addData("aliye");
        addData(name);
        printSlash();
        searchNodeTest.remove(name);
        searchNodeTest.remove(name);
        searchNodeTest.remove(name);
        searchNodeTest.remove(name);
        searchNodeTest.remove(name);
//        log.info("SEARCH : " + name + " result : " + searchNodeTest.search(name));
        printSlash();
        log.info(searchNodeTest.getNodeData().toString());//        searchNodeTest.remove(name);
        printSlash();
        printAllNodesOfSearchNode(searchNodeTest);
    }

    void testArraylist(FileOperationFacade fofAllData, List<String> listToSearch) {
        TestingArrayList testingArrayList = new TestingArrayList();
        testingArrayList.addData(fofAllData.getReadDataList());
        testingArrayList.sort();
        testingArrayList.search(listToSearch);
    }

    void testSearchNode(FileOperationFacade fofAllData, List<String> listToSearch) {
        TestingSearchNode testingSearchNode = new TestingSearchNode();
        testingSearchNode.addData(fofAllData.getReadDataList());
        testingSearchNode.sort();
        testingSearchNode.search(listToSearch);
    }

    static void printNumberReadableFormat(int val) {
        System.out.println(ReadableStringFormat.getReadableValueIntToString(val));
    }

    static void readFile() {
        TimeCalculation timeCalculation = new TimeCalculation();
        timeCalculation.start();
        FakeDataCreation fakeDataCreation = new FakeDataCreation();
        fakeDataCreation.createDataWithSearchNode();
        fakeDataCreation.read(fakeDataCreation.getBookFileFundementalList().get(0));
        System.out.println("txt'ten okunan file : " + ReadableStringFormat.getReadableValueIntToString(fakeDataCreation.fileOpsFacade.getReadDataList().size()));
        timeCalculation.stop();
        timeCalculation.printElapsedTime();
    }
}