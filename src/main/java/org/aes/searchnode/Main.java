package org.aes.searchnode;

import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.testing.TestingArrayList;
import org.aes.searchnode.testing.TestingSearchNode;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.WriteFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final FileFundamental exampleDataFile = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/")
            .setFileName("Word-Data-1_398_449")
            .setFileExtension(".txt");

    public static void main(String[] args) {


        SearchNode<String> searchNodeTest = new SearchNode<>();
        List<String> list = new ArrayList<>();
        list.add("ahmet");
        list.add("zeynep");
        list.add("ahmetemin");
        list.add("ah");

        list.add("emin");
        list.add("emine");
        list.add("test");
        list.add("test");
        searchNodeTest.addAll(list);
        System.out.println(searchNodeTest.search("test").toString());
        System.out.println(searchNodeTest.search("random").toString());
        System.out.print("searchNode total added value : ");
        searchNodeTest.printSizeOfAddedItems();

//        searchNodeTest.add("test");
        System.out.println(searchNodeTest.search("test").toString());
        System.out.println(searchNodeTest.search("random").toString());
        System.out.print("searchNode total added value : ");
        searchNodeTest.printSizeOfAddedItems();

        System.out.println("--------------------------");
        searchNodeTest.getAllReverse().forEach(e -> {
            System.out.println(e);
        });
        System.out.println("::::::::::::::::::::::::::::::::::::");

        searchNodeTest.getAll().forEach(e -> {
            System.out.println(e);
        });
       /* TimeCalculation timeCalculation = new TimeCalculation();
        timeCalculation.start();
        FileFundamental fileFund = new FileFundamental().setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/").setFileName("Word-Data-1_398_449").setFileExtension(".txt");
        FileOperationFacade fileOperationFacade = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(fileFund));
        fileOperationFacade.read();
        timeCalculation.stop();
        timeCalculation.printElapsedTime();*/


//        searchNodeTest.add("Ahmet");
//        searchNodeTest.add("ahmetemin");
//        searchNodeTest.add("emin");
//        searchNodeTest.add("emine");

//        searchNodeTest.getReachableNWD().printAllDataOfSearchNode();
//        searchNodeTest.getReachableNWD().printAllDataOfSearchNode();
//        System.out.println(searchNodeTest.search("ahmetemin"));

//        System.out.println(searchNodeTest.search("test").toString());
//        System.out.println(searchNodeTest.search("random").toString());
        System.exit(0);
//        TimeCalculation timeCalculation = new TimeCalculation();
//        timeCalculation.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        timeCalculation.stop();
//        timeCalculation.printElapsedTime();
//        System.exit(0);

        FileOperationFacade fofAllData = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(exampleDataFile));
        fofAllData.read();
        System.out.print("read data size : ");
        printNumberReadableFormat(fofAllData.getReadDataList().size());

        List<String> listToSearch = new ArrayList<>();
        FileFundamental fileFundSearchDataList = new FileFundamental().setPath("src\\main\\java\\org\\aes\\searchnode\\fakedata\\mod-test-data\\").setFileName("test-data-mod-20").setFileExtension(".txt");
        FileOperationFacade fofSearchData = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(fileFundSearchDataList));
        fofSearchData.read();
//        new Main().testArraylist(fofAllData, fofSearchData.getReadDataList());
        new Main().testSearchNode(fofAllData, fofSearchData.getReadDataList());




/*
        for (int iMod = 5; iMod <= 20; iMod = iMod*2) {
//            mod = i;
            for (int j = 0; j < fof.getReadDataList().size(); j++) {
                if (j % iMod == 0) {
                    listToSearch.add(fof.getReadDataList().get(j));
                }
            }
            FileFundamental modDataFile = new FileFundamental()
                    .setPath("src\\main\\java\\org\\aes\\searchnode\\fakedata\\mod-test-data\\")
                    .setFileName("test-data-mod-" + iMod)
                    .setFileExtension(".txt");
            fof.setWriteFileService(new WriteFileManagement(modDataFile));
            fof.write(listToSearch);
//            System.exit(0);
        }*/
      /*  List<String> listToSearch = new ArrayList<>();
        listToSearch.add("congregashun");
        listToSearch.add("leutseligen");
        listToSearch.add("portrays");
        listToSearch.add("leutseligen");
        listToSearch.add("scammonia");
        listToSearch.add("intuitionsfilosofi");

        new Main().testArraylist(fof,listToSearch);
        System.out.println("-----------------");
        new Main().testSearchNode(fof,listToSearch);*/
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
}