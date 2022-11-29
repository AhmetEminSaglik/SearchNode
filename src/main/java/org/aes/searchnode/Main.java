package org.aes.searchnode;

import com.sun.source.tree.LiteralTree;
import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.testing.TestingArrayList;
import org.aes.searchnode.testing.TestingSearchNode;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.WriteFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final FileFundamental exampleDataFile = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/")
            .setFileName("Word-Data-1_398_449")
            .setFileExtension(".txt");

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(15000);
        FileOperationFacade fofAllData = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(exampleDataFile));
        fofAllData.read();
        System.out.print("read data size : ");
        printNumberReadableFormat(fofAllData.getReadDataList().size());

        List<String> listToSearch = new ArrayList<>();
        FileFundamental fileFundSearchDataList = new FileFundamental().setPath("src\\main\\java\\org\\aes\\searchnode\\fakedata\\mod-test-data\\").setFileName("test-data-mod-100").setFileExtension(".txt");
        FileOperationFacade fofSearchData = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement(fileFundSearchDataList));
        fofSearchData.read();
        new Main().testArraylist(fofAllData, fofSearchData.getReadDataList());
        System.out.println("Arraylis is over");
        Thread.sleep(5000);
        new Main().testSearchNode(fofAllData, fofSearchData.getReadDataList());
        System.out.println("searchNode is over");
        Thread.sleep(15000);





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
//        testingArrayList.clear();
    }

    void testSearchNode(FileOperationFacade fofAllData, List<String> listToSearch) {
        TestingSearchNode testingSearchNode = new TestingSearchNode();
        testingSearchNode.addData(fofAllData.getReadDataList());
        testingSearchNode.sort();
        testingSearchNode.search(listToSearch);
//        testingSearchNode.clear();

    }

    static void printNumberReadableFormat(int val) {
        System.out.println(ReadableStringFormat.getReadableValueIntToString(val));

    }
}