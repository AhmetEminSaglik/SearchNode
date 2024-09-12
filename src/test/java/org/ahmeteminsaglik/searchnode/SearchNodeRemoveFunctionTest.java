package org.ahmeteminsaglik.searchnode;

import org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class SearchNodeRemoveFunctionTest {

    SearchNodeService<String> searchNode = new SearchNode<>();

    @BeforeEach
    public void initalizeSearchNodeDPI() {
        searchNode = new SearchNode<>();
    }

    @Test
    @Order(1)
    @DisplayName("Remove data not added before")
    public void removeNotAddedData() {
        searchNode.add("al");
        searchNode.add("ali");
        searchNode.add("alim");
        searchNode.remove("alim");
        int expected = 2;
        int actual = searchNode.getAll().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    @DisplayName("Remove single data")
    public void remove1Data() {
        String text = "alim";
        searchNode.add(text);
        String expectedData = text;
        String actualData = searchNode.search(text).getListDataInfo().get(0).getValue();

        Assertions.assertEquals(expectedData, actualData);

        searchNode.remove(text);
        int expected = 0;
        int actual = searchNode.getAll().size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    @DisplayName("Remove multi data")
    public void remove3DataFrom5Data() {
        searchNode.add("al");
        searchNode.add("ali");
        searchNode.add("alim");
        searchNode.add("abcde");
        searchNode.add("zeynep");

        int expected = 5;
        int actual = searchNode.getAll().size();
        Assertions.assertEquals(expected, actual);

        searchNode.remove("ali");
        expected = 4;
        actual = searchNode.getAll().size();
        Assertions.assertEquals(expected, actual);

        searchNode.remove("alim");
        expected = 3;
        actual = searchNode.getAll().size();
        Assertions.assertEquals(expected, actual);

        searchNode.remove("abcde");
        expected = 2;
        actual = searchNode.getAll().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    @DisplayName("Remove all data data")
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
        int actual = searchNode.getAll().size();
        Assertions.assertEquals(expected, actual);
        searchNode.removeAll(removeDataList);

        expected = 2;
        actual = searchNode.getAll().size();

        Assertions.assertEquals(expected, actual);

        searchNode.removeAll(removeDataList);
        expected = 2;
        actual = searchNode.getAll().size();

        Assertions.assertEquals(expected, actual);
    }


}