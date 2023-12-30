package org.aes.searchnode.dpi.controllers;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
