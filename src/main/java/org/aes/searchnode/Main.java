package org.aes.searchnode;

import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.fakedata.FakeDataCreation;
import org.aes.searchnode.testing.TestingArrayList;
import org.aes.searchnode.testing.TestingSearchNode;
import org.aes.searchnode.testing.TimeCalculation;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.WriteFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final FileFundamental exampleDataFile = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/")
            .setFileName("Word-Data-1_398_449")
            .setFileExtension(".txt");

    public static void main(String[] args) {
//        System.out.println((int)']');
//        System.exit(0);
//        String text="3 tane txt dosyasi var. hepsini searchNode'a aktaramiyorum/ Heap yetmiyor. Bunlari okuyup Hashset'e aktarmaliyim. Sonrasinda yazdircam. ";
//        JOptionPane.showMessageDialog(null,text);
//        System.exit(0);
        TimeCalculation timeCalculation = new TimeCalculation();
        timeCalculation.start();
        FakeDataCreation fakeDataCreation = new FakeDataCreation();
        fakeDataCreation.createDataWithSearchNode();

        fakeDataCreation.read(fakeDataCreation.getBookFileFundementalList().get(0));

        System.out.println("txt'ten okunan file : "+ReadableStringFormat.getReadableValueIntToString(fakeDataCreation.fileOpsFacade.getReadDataList().size()));

        timeCalculation.stop();
        timeCalculation.printElapsedTime();

        System.out.println();
        System.exit(0);
//        for (int i = 48; i < 122; i++) { //48 57 65 90   97 122
//            System.out.println(i + " : " + (char) i);
//        }
//        System.exit(0);
//        List<Integer> intList = new ArrayList<>();
//        intList.add(1);
//
//        intList.add(2);
//        intList.add(2);
//        intList.add(3);
//        List<String> StringList = new ArrayList<>();
//        StringList.add("a");
//        StringList.add("b");
//        StringList.add("c");
//        StringList.add("d");
//        Collections.binarySearch(StringList, "a");
//

//        System.out.println(Collections.binarySearch(intList, 2));
//        System.exit(0);
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
        searchNodeTest.printSizeOfAddedItems();

//System.exit(0);
//        System.out.println("--------------------------");
//        searchNodeTest.getAllReverse().forEach(e -> {
//            System.out.println(e);
//        });
//        System.out.println("::::::::::::::::::::::::::::::::::::");
//
//        searchNodeTest.getAll().forEach(e -> {
//            System.out.println(e);
//        });
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
}