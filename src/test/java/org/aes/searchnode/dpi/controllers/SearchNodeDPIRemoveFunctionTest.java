package org.aes.searchnode.dpi.controllers;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchNodeDPIRemoveFunctionTest {
    SearchNodeService<String> searchNode = new SearchNode<>();

    @BeforeEach
    public void initalizeSearchNodeDPI() {
//        searchNodeDPI = new SearchNodeDPI<>();
        searchNode = new SearchNode<>();
    }

    @Test
    public void removeNotAddedData() {
        searchNode.add("al");
        searchNode.add("ali");
        searchNode.add("alim");
        searchNode.remove("alim");
        int expected = 2;
        int actual = searchNode.getAll().getData().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void remove1Data() {
        searchNode.add("alim");
        searchNode.remove("alim");
        int expected = 0;
        int actual = searchNode.getAll().getData().size();
        System.out.println(searchNode.search("alim"));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void remove3DataFrom5Data() {
        searchNode.add("al");
        searchNode.add("ali");
        searchNode.add("alim");
        searchNode.add("abcde");
        searchNode.add("zeynep");

        int expected = 5;
        int actual = searchNode.getAll().getData().size();
        Assertions.assertEquals(expected, actual);

        searchNode.remove("ali");
        expected = 4;
        actual = searchNode.getAll().getData().size();
        Assertions.assertEquals(expected, actual);

        searchNode.remove("alim");
        expected = 3;
        actual = searchNode.getAll().getData().size();
        Assertions.assertEquals(expected, actual);

        searchNode.remove("abcde");
        expected = 2;
        actual = searchNode.getAll().getData().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveAll() {
        searchNode.add("al");
        searchNode.add("ali");
        searchNode.add("alim");
        searchNode.add("abcde");
        searchNode.add("zeynep");

        List<String> removeDataList = new ArrayList<>();
        removeDataList.add("ali");
        removeDataList.add("abcde");
        removeDataList.add("zeynep");
        for (String e : searchNode.getAll().getData()) {
            System.out.println("Data : " + e);
        }
        System.out.println("--------------------------");

        int expected = 5;
        int actual = searchNode.getAll().getData().size();
        Assertions.assertEquals(expected, actual);
        DataResult<List<String>> dr = searchNode.removeAll(removeDataList);


        for (String e : searchNode.getAll().getData()) {
            System.out.println("Data : " + e);
        }
        System.out.println("--------------------------");


        System.out.println("Msg : "+dr.getMsg());
        System.out.println("Is Succes  : "+dr.isSuccess());
        for (String datum : dr.getData()) {
            System.out.println("silinen degerler olsa gerek  :" + datum);
        }
        expected = 2;
        actual = searchNode.getAll().getData().size();

        Assertions.assertEquals(expected, actual);

        for (String e : searchNode.getAll().getData()) {
            System.out.println("Data : " + e);
        }
        System.out.println("--------------------------");
        searchNode.removeAll(removeDataList);
        expected = 2;
        actual = searchNode.getAll().getData().size();


        for (String e : searchNode.getAll().getData()) {
            System.out.println("e : " + e);
        }
        Assertions.assertEquals(expected, actual);


    }
}
