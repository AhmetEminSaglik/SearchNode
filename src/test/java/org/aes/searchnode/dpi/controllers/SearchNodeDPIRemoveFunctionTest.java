package org.aes.searchnode.dpi.controllers;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.CustomLog;
import org.aes.searchnode.core.utilities.DataResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchNodeDPIRemoveFunctionTest {
    SearchNodeService<String> searchNode = new SearchNode<>();
    private static CustomLog log = new CustomLog(SearchNodeDPIRemoveFunctionTest.class);

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
        String text = "alim";
        searchNode.add(text);
        String expectedData = text;
        String actualData = searchNode.search(text).getData().getListDataInfo().get(0).getValue();

        Assertions.assertEquals(expectedData, actualData);


        searchNode.remove(text);
        int expected = 0;
        int actual = searchNode.getAll().getData().size();

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

        int expected = 5;
        int actual = searchNode.getAll().getData().size();
        Assertions.assertEquals(expected, actual);
        DataResult<List<String>> dr = searchNode.removeAll(removeDataList);

        expected = 2;
        actual = searchNode.getAll().getData().size();

        Assertions.assertEquals(expected, actual);

        searchNode.removeAll(removeDataList);
        expected = 2;
        actual = searchNode.getAll().getData().size();

        Assertions.assertEquals(expected, actual);
    }
}
