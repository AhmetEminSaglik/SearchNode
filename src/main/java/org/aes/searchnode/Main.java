package org.aes.searchnode;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.CustomLog;
import org.aes.searchnode.dpi.controllers.SearchNodeDPI;
import org.ahmeteminsaglik.fileoperation.business.abstracts.ReadFileService;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.util.HashSet;
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

    private static FileFundamental fileFundamental = new FileFundamental()
//            .setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/")
            .setPath("src/main/java/org/aes/searchnode/fakedata/mod-test-data/")
//            .setFileName("word-data-699-225")
            .setFileExtension(".txt");


    public static List<String> getWordListFromPath(FileFundamental fileFundamental) {
        ReadFileService readFileService = new ReadFileManagement(fileFundamental);
        readFileService.read();
        return readFileService.getReadDataList();
    }

    public static void main(String[] args) {
        SearchNode<String> sn = new SearchNode<>();
        sn.add("ali");
        sn.add("veli");
        sn.add("veli");
        sn.add("veli");
        sn.add("mustafa");
        sn.add("ahmet");

        printSlash();
        sn.getAll().getData().forEach(System.out::println);
        printSlash();
        sn.getAll().getData().forEach(System.out::println);
        printSlash();
        sn.removeAll(sn.getAll().getData());
        printSlash();
        sn.getAll().getData().forEach(System.out::println);
    }
}