package org.aes.searchnode;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;

public class Main {

    public static void main(String[] args) {

        SearchNode<String> sn = new SearchNode<>();
//        sn.add("abze", "2 characters");
//        sn.add("abcd", "4 characters");
//        sn.add("abcdef", "6 characters");
        sn.add("bbb");
        sn.add("b");
        sn.add("bb");
        sn.add("aaa");
        sn.add("aa");
        sn.add("aaaa");
        sn.add("aaaa");
        sn.getAll().getData().forEach(e -> {
            System.out.println(e.getValue());
        });
        /*
        sn.updatePriorityChar('z', 'a');
        System.out.println("total item number :" + sn.getTotalItemNumber());
        System.out.println("explanation : " + sn.getExplanationOf("ab"));
        sn.getAll().getData().forEach(System.out::println);*/
    }

}