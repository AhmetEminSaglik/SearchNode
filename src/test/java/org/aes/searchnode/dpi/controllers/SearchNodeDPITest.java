package org.aes.searchnode.dpi.controllers;

import org.aes.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.entities.DataInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class SearchNodeDPITest {

    //    SearchNodeDPI<String> searchNodeDPI;
    SearchNodeService<String> searchNode = new SearchNode<>();

    @BeforeEach
    public void initalizeSearchNodeDPI() {
//        searchNodeDPI = new SearchNodeDPI<>();
        searchNode = new SearchNode<>();
    }

    @Test
    public void addStringDataToSearchNodeTest() {
        searchNode.add("Ahmet");
        int expected = 1;
        int actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);

        searchNode.add("Ahmet");
        expected = 1;
        actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);

        searchNode.add("SAĞLIK");
        expected = 2;
        actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addStringListToSearchNodeTest() {
        List<String> list = getStringListData();
        searchNode.addAll(list);
        int expected = list.size();
        int actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);

        searchNode.add("masa");
        searchNode.add("masa");
        searchNode.add("masa");
        searchNode.add("masa");
        expected = list.size() + 1;
        actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllSearchNodeDataIsSorted() {
        List<String> list = getStringListData();
        searchNode.addAll(list);
        int expected = list.size();
        int actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);

        Collections.sort(list);
//        List<String> listFromSearchNode =
        List<DataInfo<String>> dataInfoList = searchNode.getAll().getData();

        isGivenListDataSame(list, dataInfoList);
    }

    @Test
    public void getAllReverseSearchNodeDataIsSorted() {
        List<String> list = getStringListData();
        searchNode.addAll(list);
        int expected = list.size();
        int actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);

        Collections.sort(list);
        Collections.reverse(list);
        List<DataInfo<String>> listFromSearchNode = searchNode.getAllReverse().getData();

        isGivenListDataSame(list, listFromSearchNode);
    }

    @Test
    public void searchItemInSearchNodeTest() {
        List<String> list = getStringListData();
        searchNode.addAll(list);

        String item = list.get(0);
        String item2 = "şeftali";
        String item3 = "çilek";
        searchNode.add(item2);
        searchNode.add(item3);
        String actual = searchNode.search(item).getData().getListDataInfo().get(0).getValue();
        Assertions.assertEquals(item, actual);

        actual = searchNode.search(item2).getData().getListDataInfo().get(0).getValue();
        Assertions.assertEquals(item2, actual);

        actual = searchNode.search(item3).getData().getListDataInfo().get(0).getValue();
        Assertions.assertEquals(item3, actual);

    }

    @Test
    public void updatePriorityCharBeforeAddingItemToSearchNodeTest() {
        searchNode.updatePriorityChar('ş', 's');
        searchNode.updatePriorityChar('ç', 'c');

        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");
        List<DataInfo<String>> listFromSearchNode = searchNode.getAll().getData();
        Assertions.assertEquals("can", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());
    }


    @Test
    public void updatePriorityCharListBeforeAddingItemToSearchNodeTest() {
        List<Character> characterList = new ArrayList<>();
        characterList.add('ç');
        characterList.add('ş');

        searchNode.updatePriorityChar(characterList, 'a');

        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");
        List<DataInfo<String>> listFromSearchNode = searchNode.getAll().getData();
        Assertions.assertEquals("çilek", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("can", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(4).getValue());
    }


    @Test
    public void updatePriorityCharAfterAddingItemToSearchNodeTest() {
        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");

        searchNode.updatePriorityChar('ş', 's');
        searchNode.updatePriorityChar('ç', 'c');

        List<DataInfo<String>> listFromSearchNode = searchNode.getAll().getData();
        Assertions.assertEquals("can", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());
    }


    @Test
    public void updatePriorityCharListAfterAddingItemToSearchNodeTest() {
        List<Character> characterList = new ArrayList<>();
        characterList.add('ç');
        characterList.add('ş');


        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");

        searchNode.updatePriorityChar(characterList, 'a');

        List<DataInfo<String>> listFromSearchNode = searchNode.getAll().getData();
        Assertions.assertEquals("çilek", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("can", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(4).getValue());
    }


    @Test
    public void resetPriorityCharAfterAddingItemToSearchNodeTest() {
        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");

        searchNode.updatePriorityChar('ş', 's');
        searchNode.updatePriorityChar('ç', 'c');

        List<DataInfo<String>> listFromSearchNode = searchNode.getAll().getData();
        Assertions.assertEquals("can", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());

        searchNode.resetPriorityChar('ç');
        listFromSearchNode = searchNode.getAll().getData();
        Assertions.assertEquals("şeftali", listFromSearchNode.get(3).getValue());
//        Assertions.assertEquals("çilek", listFromSearchNode.get(4)getValue().);
    }

    @Test
    public void resetAllPriorityCharAfterAddingItemToSearchNodeTest() {
        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");

        searchNode.updatePriorityChar('ş', 's');
        searchNode.updatePriorityChar('ç', 'c');

        List<DataInfo<String>> listFromSearchNode = searchNode.getAll().getData();
        Assertions.assertEquals("can", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());

        searchNode.resetAllPriorityChars();
        listFromSearchNode = searchNode.getAll().getData();
        Assertions.assertEquals("çilek", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());
    }

    @Test
    public void getAllStartWithTest() {
        searchNode.addAll(getStringListData());
        List<DataInfo<String>> list = searchNode.getAllStartWith("al").getData();

        String expected = "ali";
        String actual = list.get(0).getValue();
        Assertions.assertEquals(expected, actual);
        expected = "alim";
        actual = list.get(1).getValue();
        Assertions.assertEquals(expected, actual);


        list = searchNode.getAllStartWith("s").getData();

        int expectedListSize = 3;
        int actualListSize = list.size();

        Assertions.assertEquals(expectedListSize, actualListSize);
    }

    private void isGivenListDataSame(List<String> listExpected, List<DataInfo<String>> listActual) {
        for (int i = 0; i < listExpected.size(); i++) {
            Assertions.assertEquals(listExpected.get(i), listActual.get(i).getValue());
        }

    }

    private List<String> getStringListData() {
        List<String> list = new ArrayList<>();
        list.add("ahmet");
        list.add("su");
        list.add("emin");
        list.add("emir");
        list.add("sağlık");
        list.add("ali");
        list.add("ses");
        list.add("alim");
        return list;
    }
}