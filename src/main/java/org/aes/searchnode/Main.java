package org.aes.searchnode;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.dpi.controllers.SearchNodeDPI;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void printSlash(int... a) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    static void printSearchNodeList(SearchNode<String> searchNode) {
        System.out.println("----------------------------");

        searchNode.getAllNodeData("").forEach(System.out::println);
        System.out.println("============================+++");

    }

    public static void main(String[] args) {

        SearchNode<String> sntest = new SearchNode<>();
//        sntest.add("ahmet");
//        sntest.add("ahmete");
        System.out.println("eklencek kelime :ahenk");
//        sntest.add("a");
        sntest.add("ahenk");
        printSearchNodeList(sntest);

        System.out.println("eklencek kelime :ahmet ");
        sntest.add("ahmet");
        printSearchNodeList(sntest);

        System.out.println("eklencek kelime :zb");
        sntest.add("zb");

        printSearchNodeList(sntest);

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("total item number :" + sntest.getTotalItemNumber());
//        sntest.remove("ah");
//        System.out.println("REMOVEDDD ");
        System.out.println("total item number :" + sntest.getTotalItemNumber());
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
//        sntest.add("ahmete");
//        System.out.println("-----------___");
//        sntest.search("ahm");
//        System.out.println("-----------___");
//        sntest.search("Ahmet");
//        System.out.println("-----------___");
//        System.out.println(sntest.searchNodeData("Ahmet"));;
//        System.out.println(sntest.searchNodeData("AhmetEmin"));;
//        System.out.println(")__+__+_+_+_+__+_+_");
        System.out.println("total item number :" + sntest.getTotalItemNumber());
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        sntest.getAllNodeData("").forEach(System.out::println);
//        printSearchNodeList(sntest);
//        sntest.search("AhmetEminSaglik");

        System.exit(0);

        SearchNodeDPI<String> sn = new SearchNodeDPI<>();
        sn.add("AAA", "A");
        sn.add("AAA", "E");
        sn.add("AAA", "Z");
        sn.add("Long");
        sn.add("Live");
        sn.add("Long");
        sn.add("Live");
        sn.add("Long");
        sn.add("Live");

        List<String> list = new ArrayList<>();
        sn.add("Palestina");
        sn.add("Crush");
        sn.add("Zionism");

        list.add("Innocent Babies are killed");
        list.add("Innocent Children are killed");
        list.add("Innocent Women are killed");
        list.add("Innocent Men are killed");

        sn.update("AAA", "Z", "T");

        sn.update("Palestina", "", list);
//        printSearchNodeList(sn);

        /*DataResult dataResult = searchNodeTest.search("Ahmet");
        if (dataResult.isSuccess()) {
            System.out.println("Data is found : " + dataResult.getData());
        } else {
            System.out.println("Data is not found :" + dataResult.getData());
        }
        dataResult=searchNodeTest.searchExplanationOf("Ahmet");
        System.out.println("dataResult For Explanation of Ahmet:" + dataResult.getData());
*/

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

/*

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
        searchNodeTest.resetAllPriorityChars();
        printSearchNodeList(searchNodeTest);
*/

    }

    static void printNumberReadableFormat(int val) {
        System.out.println(ReadableStringFormat.getReadableValueIntToString(val));
    }


}