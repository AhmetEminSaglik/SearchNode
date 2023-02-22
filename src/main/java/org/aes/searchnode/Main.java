package org.aes.searchnode;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.fakedata.FakeDataCreation;
import org.aes.searchnode.testing.TestingArrayList;
import org.aes.searchnode.testing.TestingHashmap;
import org.aes.searchnode.testing.TestingSearchNode;
import org.aes.searchnode.testing.TimeCalculation;
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

    static void printSlash() {
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
/*//        SearchNodeService<String> searchNodeTest = new SearchNodeAPI<>();
        SearchNodeService<String> searchNodeTest = new SearchNode<>();

        searchNodeTest.add("first");
        printSlash();
        List<String> list = new ArrayList<>();
        list.add("ahmet");
        list.add("zeynep");
        list.add("ah");
        searchNodeTest.addAll(list);
        searchNodeTest.add("version 1");
        List<String> allData = searchNodeTest.getAll().getData();
        allData.forEach(System.out::println);
        System.exit(0);
        searchNodeTest.addAll(list);
        printSlash();
//        System.out.println(searchNodeTest.search("ahmet"));
//        System.out.println(searchNodeTest.search("kerem"));
        printSlash();
        searchNodeTest.getAll().getData().forEach(System.out::println);
        printSlash();

        searchNodeTest.getAllReverse().getData().forEach(System.out::println);
        printSlash();

//        searchNodeTest.printSizeOfAddedItems();

        List<String> startWith = new ArrayList<>();
        String startWithText = "f";
        DataResult<List<String>> dataResult = searchNodeTest.getAllStartWith(startWithText);

        System.out.println("words start with : " + startWithText);
        if (dataResult.isSuccess()) {
            List startWithList = dataResult.getData();
            startWithList.forEach(System.out::println);
        } else {
            System.out.println("error : " + dataResult.getMsg());
        }*/
//        System.out.println(searchNodeTest.search("ah"));
//        System.out.println(searchNodeTest.search("ahmet"));


/*        System.out.println("SearchNode NWDTV : " + searchNodeTest.getTotalItemNumber());
        System.out.println("SearchNode NWDTV : " + searchNodeTest.getReachableNWD().getNextSearchNodeWayOfChar(searchNodeTest.getPcService().getPriorityChar('a').getData()).getData()
//                .getReachableNWD().getNextSearchNodeWayOfChar(searchNodeTest.getPcService().getPriorityChar('h').getData()).getData()
//                .getReachableNWD().getNextSearchNodeWayOfChar(searchNodeTest.getPcService().getPriorityChar('m').getData()).getData()
                .getNodeData().getLocationStringAddress());
        System.out.println("SearchNode NWDTV : " + searchNodeTest.getReachableNWD().getNextSearchNodeWayOfChar(searchNodeTest.getPcService().getPriorityChar('a').getData()).getData()
//                .getReachableNWD().getNextSearchNodeWayOfChar(searchNodeTest.getPcService().getPriorityChar('h').getData()).getData()
//                .getReachableNWD().getNextSearchNodeWayOfChar(searchNodeTest.getPcService().getPriorityChar('m').getData()).getData()
                .getNodeData().getNextWayDirectionTotalValue());*/

//        System.exit(0);

       /* TimeCalculation timeCalculation = new TimeCalculation();
        timeCalculation.start();
        FileFundamental fileFund = new FileFundamental().setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/").setFileName("Word-Data-1_398_449").setFileExtension(".txt");
        FileOperationFacade fileOperationFacade = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(fileFund));
        fileOperationFacade.read();
        timeCalculation.stop();
        timeCalculation.printElapsedTime();*/

        //bulunan txt sayisi : filePaths.size() : 40881
//        FakeDataCreation fakeDataCreation = new FakeDataCreation();
//        fakeDataCreation.getBookFileFundementalList();

        SearchNodeService<String> searchNodeTest = new SearchNode<>();

        FileOperationFacade fofAllData = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(exampleDataFile));
        fofAllData.read();
//        System.out.print("read data size : ");
        printNumberReadableFormat(fofAllData.getReadDataList().size());
        searchNodeTest.addAll(fofAllData.getReadDataList());
//        searchNodeTest.printSizeOfAddedItems();
//        List<String> listToSearch = new ArrayList<>();
        FileFundamental fileFundSearchDataList = new FileFundamental().setPath("src\\main\\java\\org\\aes\\searchnode\\fakedata\\mod-test-data\\").setFileName("test-data-mod-100").setFileExtension(".txt");
        FileOperationFacade fofSearchData = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(fileFundSearchDataList));
        fofSearchData.read();


//        new Main().testSearchNode(fofAllData, fofSearchData.getReadDataList());
//        System.out.println("-----------------------------------------------------------------------------------------");
//        new Main().testHashMap(fofAllData, fofSearchData.getReadDataList());
//        System.out.println("-----------------------------------------------------------------------------------------");
        new Main().testArraylist(fofAllData, fofSearchData.getReadDataList());

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
    void testHashMap(FileOperationFacade fofAllData, List<String> listToSearch){
        TestingHashmap testingHashmap = new TestingHashmap();
        testingHashmap.addData(fofAllData.getReadDataList());
        testingHashmap.sort();
        testingHashmap.search(listToSearch);
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