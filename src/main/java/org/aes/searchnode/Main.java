package org.aes.searchnode;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.entities.DataInfo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchNodeService<String> sns = new SearchNode<>();
        SearchNode<String> sn = new SearchNode<>();
        List<String> listString = new ArrayList<>();
        List<Character> listChar = new ArrayList<>();
        String explanaton = "explanation";
        String data = "text";
        char c = 'c';

        sns.add("ali");
        sns.add("alim");
        sns.add("ayse");
        List<DataInfo<String>> list = sns.getAllStartWith("al");
        list.forEach(System.out::println);
        System.exit(0);

        sn.add(data);
        sns.add(data);

        sn.add(data, explanaton);
        sns.add(data, explanaton);

        sn.add(data, listString);
        sns.add(data, listString);

        sn.addAll(listString);
        sns.addAll(listString);


        sn.search(data);
        sns.search(data);

        sn.getExplanationOf(data);
        sns.getExplanationOf(data);


        sn.getTotalItemNumber();
        sns.getTotalItemNumber();

        sn.getAllPc();
        sns.getAllPc();

        sn.getAllReverse();
        sns.getAllReverse();

        sn.getAllStartWith(data);
        sns.getAllStartWith(data);


        sn.searchNodeData(data);
        sns.searchNodeData(data);

        sn.getAllNodeData(data);
        sns.getAllNodeData(data);


        sn.update(data, explanaton, explanaton);
        sns.update(data, explanaton, explanaton);

        sn.update(data, explanaton, listString);
        sns.update(data, explanaton, listString);

        sn.update(data, listString);
        sns.update(data, listString);

        sn.resetPriorityChar(c);
        sns.resetPriorityChar(c);

        sn.resetAllPriorityChars();
        sns.resetAllPriorityChars();

        sn.updatePriorityChar(listChar, c);
        sns.updatePriorityChar(listChar, c);

        sn.updatePriorityChar(c, c);
        sns.updatePriorityChar(c, c);


        sn.remove(data);
        sns.remove(data);

        sn.removeAll(listString);
        sns.removeAll(listString);

        sn.getAllPc();
    }

    static void printPCDao(SearchNode sn) {
        System.out.println("-----------------_");
//        sn.getAllPc().forEach(e -> {
//            System.out.println("char: " + e.getChar() + ":" + e.getValue());
//        });
    }

    static void printAllValues(SearchNode<String> sn) {
        System.out.println("--------------------------------------");
        sn.getAllPc().forEach(e -> {
//            System.out.println(e.getTotalSameNum() + "-) " + e.getValue() + " : " + e.getExplanation());
        });
    }

}