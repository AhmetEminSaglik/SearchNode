package org.aes.searchnode;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SearchNode<String> sn = new SearchNode<>();
//        sn.add("abze", "2 characters");
//        sn.add("abcd", "4 characters");
//        sn.add("abcdef", "6 characters");
//        sn.add("bbb", "3 harfli");
//        sn.add("bbb", "2. kez 3 harfli");
//        sn.add("bbb", "2. kez 3 harfli");
//        sn.add("b", "3 harfli");
//        sn.add("bb", "3 harfli");
//        sn.add("aaa", "3 harfli");
//        sn.add("aa", "3 harfli");
//        sn.add("aaaa", "3 harfli");
//        sn.add("aaaa", "3 harfli");
        sn.add("a", "bbb");
        sn.add("b");
        sn.add("c");
        sn.add("d");
        sn.add("e");
        List<Character> characterList = new ArrayList<>();
        List<Character> characterList2 = new ArrayList<>();
//        sn.updatePriorityChar('9','1');
//        sn.updatePriorityChar('8','1');
//        sn.updatePriorityChar('7','1');
        characterList.add('a');
        characterList.add('b');
        characterList.add('c');
//        characterList2.add('d');
//        characterList2.add('e');
//        characterList2.add('f');
//        sn.updatePriorityChar(characterList, 'a');
//        sn.updatePriorityChar(characterList, 'b');
//        sn.updatePriorityChar(characterList, 'c');


//        sn.updatePriorityChar('a', 'z');
//        sn.updatePriorityChar('b', 'z');


//        sn.updatePriorityChar('e','z');
//        printAllValues(sn);
//        sn.update
//        sn.getPcService().getAll().getData().forEach(System.out::println);
//        sn.updatePriorityChar('a','d');
//        Result result=sn.update("data","b","c");
//        System.out.println("result : "+result);
//        sn.remove("bbb");
//        sn.search("zxccx").getData().getListDataInfo().size();

//        printPCDao(sn);
//        sn.updatePriorityChar('b', 'c');
//        sn.updatePriorityChar('f', 'c');
//        sn.updatePriorityChar('g', 'c');
//        sn.updatePriorityChar('d', 'c');
//        sn.updatePriorityChar('e', 'c');
//        sn.updatePriorityChar('l', 'c');
//        sn.updatePriorityChar('m', 'c');
//        sn.updatePriorityChar('a', 'k');

//        sn.updatePriorityChar('k','z');
//        printPCDao(sn);
//        System.out.println("k" + (int) 'k');
//        sn.updatePriorityChar('y','z');
//        sn.updatePriorityChar('1','2');
//        printPCDao(sn);
//        System.out.println(sn.getPcService().getNextPriorityChar('b').getData());
//        sn.getPcService().getNextPriorityChar('b');
//        sn.getPcService().getNextPriorityChar('c');

        /*for (int i = 97; i <= 122; i++) {
            System.out.print(i + "-)" + (char) i + "    ");
            if (i % 7 == 0) {
                System.out.println();
            }
        }*/
        /*
        sn.updatePriorityChar('z', 'a');
        System.out.println("total item number :" + sn.getTotalItemNumber());
        System.out.println("explanation : " + sn.getExplanationOf("ab"));
        sn.getAll().getData().forEach(System.out::println);*/
    }

    static void getNextPriorityChar() {
        SearchNode<String> sn = new SearchNode<>();
        sn.updatePriorityChar('l', 'm');
        sn.updatePriorityChar('l', 'm');
        sn.updatePriorityChar('k', 'm');
        sn.updatePriorityChar('j', 'm');
        sn.updatePriorityChar('p', 'm');
        sn.updatePriorityChar('o', 'm');
        sn.updatePriorityChar('q', 'a');
        sn.updatePriorityChar('g', 'a');
        sn.updatePriorityChar('h', 'a');
        printPCDao(sn);
        System.out.println(sn.getPcService().getNextPriorityChar('g').getData());
    }

    static void testUpdateExplanationList() {
        SearchNode<String> sn = new SearchNode<>();
        List<String> expList = new ArrayList<>();
        expList.add("1");
        expList.add("2");
        expList.add("3");
        expList.add("3");
        expList.add("3");
        sn.add("a");
        sn.add("b", "a");
        printAllValues(sn);
        sn.update("A", expList);
        printAllValues(sn);
    }

    static void printPCDao(SearchNode sn) {
        System.out.println("-----------------_");
        sn.getPcService().getAll().getData().forEach(e -> {
            System.out.println("char: " + e.getChar() + ":" + e.getValue());
        });
    }

    static void printAllValues(SearchNode<String> sn) {
        System.out.println("--------------------------------------");
        sn.getAll().getData().forEach(e -> {
            System.out.println(e.getTotalSameNum() + "-) " + e.getValue() + " : " + e.getExplanation());
        });
    }

}