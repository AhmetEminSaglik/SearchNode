package org.aes.searchnode;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.dpi.controllers.SearchNodeDPI;
import org.aes.searchnode.fakedata.FakeDataCreation;
import org.aes.searchnode.testing.TestingArrayList;
import org.aes.searchnode.testing.TestingSearchNode;
import org.aes.searchnode.testing.TimeCalculation;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
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

    static void printSearchNodeList(SearchNodeDPI<String> searchNodeTest) {
        System.out.println("----------------------------");
        List<String> list = searchNodeTest.getAll().getData();
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        SearchNodeDPI<String> searchNodeTest = new SearchNodeDPI<>();
        /*char a = 'a', b = 'b';
        List<Character> characterList = new ArrayList<>();
        characterList.add('z');
        characterList.add('b');
        characterList.add('a');
        characterList.add('a');
        System.out.println((int) a + "- a");
        System.out.println("e "+(int)'e');
        searchNodeTest.updatePriorityChar(characterList, 'e');
        searchNodeTest.updatePriorityChar('e', 'z');
        searchNodeTest.updatePriorityChar('d', 'b');
        searchNodeTest.updatePriorityChar('c', 'b');
        searchNodeTest.updatePriorityChar('k', 'b');
//        searchNodeTest.resetPriorityChar('e');
        List<Character> characterList2 = new ArrayList<>();
        characterList2.add('e');
        characterList2.add('q');
        characterList2.add('w');
        searchNodeTest.updatePriorityChar(characterList2, 't');

        searchNodeTest.add("first");
        printSlash();
        List<String> list = new ArrayList<>();
        list.add("ahmet");
        list.add("gazete");
        list.add("bolu");
        list.add("ceyhan");
        list.add("zeynep");
        list.add("mehmet");
        list.add("emir");

        searchNodeTest.addAll(list);
        printSlash();
        System.out.println(searchNodeTest.search("ahmet"));
        System.out.println(searchNodeTest.search("kerem"));
        printSlash();
        searchNodeTest.getAll().getData().forEach(System.out::println);
        printSlash();
        searchNodeTest.updatePriorityChar('g','a');
        searchNodeTest.getAll().getData().forEach(System.out::println);
        printSlash();

//        searchNodeTest.getAllReverse().getData().forEach(System.out::println);
//        printSlash();

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
        }
        System.out.println(searchNodeTest.search("ahmetcan"));
        System.out.println(searchNodeTest.search("ahmetemin"));


        System.exit(0);*/


        List<String> itemList = new ArrayList<>();
        itemList.add("ahmet");
        itemList.add("celal");
        itemList.add("çanakkale");
        itemList.add("zeynep");
        itemList.add("kayseri");
        itemList.add("çene");
//        searchNodeTest.updatePriorityChar('a', 'z');
        List<Character> characterList = new ArrayList<>();
        characterList.add('c');
        characterList.add('z');
        characterList.add('a');
        searchNodeTest.updatePriorityChar(characterList, 'ç');
        searchNodeTest.updatePriorityChar('z', 'c');
        searchNodeTest.addAll(itemList);
        searchNodeTest.updatePriorityChar('ç', 'c');
//        searchNodeTest.resetPriorityChar();

//        searchNodeTest.resetPriorityChar('z');
//        searchNodeTest.resetPriorityChar('z');
        printSearchNodeList(searchNodeTest);
        searchNodeTest.resetAllPriorityChar();
        printSearchNodeList(searchNodeTest);

//        searchNodeTest.resetPriorityChar('z');
//
//        printSearchNodeList(searchNodeTest);

    /*
        List<String> list = searchNodeTest.getAll().getData();

        for (String s : list) {
            System.out.println(s);
        }
*/

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

//        FileOperationFacade fofAllData = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(exampleDataFile));
//        fofAllData.read();
//        System.out.print("read data size : ");
//        printNumberReadableFormat(fofAllData.getReadDataList().size());
//        searchNodeTest.addAll(fofAllData.getReadDataList());
//        searchNodeTest.printSizeOfAddedItems();
//        List<String> listToSearch = new ArrayList<>();
//        FileFundamental fileFundSearchDataList = new FileFundamental().setPath("src\\main\\java\\org\\aes\\searchnode\\fakedata\\mod-test-data\\").setFileName("test-data-mod-20").setFileExtension(".txt");
//        FileOperationFacade fofSearchData = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(fileFundSearchDataList));
//        fofSearchData.read();


//        new Main().testArraylist(fofAllData, fofSearchData.getReadDataList());
//        new Main().testSearchNode(fofAllData, fofSearchData.getReadDataList());

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