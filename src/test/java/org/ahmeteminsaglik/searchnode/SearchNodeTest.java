package org.ahmeteminsaglik.searchnode;

import org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.SearchNodeService;
import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;
import org.ahmeteminsaglik.searchnode.entities.DataInfo;
import org.ahmeteminsaglik.searchnode.entities.NodeData;
import org.junit.jupiter.api.*;

import java.util.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SearchNodeTest {

    SearchNodeService<String> searchNode = new SearchNode<>();

    @BeforeEach
    public void initalizeSearchNodeDPI() {
        searchNode = new SearchNode<>();
    }

    @Test
    @Order(1)
    @DisplayName("1-) Add multi data one by one")
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
    @Order(2)
    @DisplayName("2-) Add multi data with list")
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
    @Order(3)
    @DisplayName("3-) Get all data sorted")
    public void getAllSearchNodeDataIsSorted() {
        List<String> list = getStringListData();
        searchNode.addAll(list);
        int expected = list.size();
        int actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);

        Collections.sort(list);
        List<DataInfo<String>> dataInfoList = searchNode.getAll();

        isGivenListDataSame(list, dataInfoList);
    }

    @Test
    @Order(4)
    @DisplayName("4-) Get all data in reversed sorted")
    public void getAllReverseSearchNodeDataIsSorted() {
        List<String> list = getStringListData();
        searchNode.addAll(list);
        int expected = list.size();
        int actual = searchNode.getTotalItemNumber();
        Assertions.assertEquals(expected, actual);

        Collections.sort(list);
        Collections.reverse(list);
        List<DataInfo<String>> listFromSearchNode = searchNode.getAllReverse();

        isGivenListDataSame(list, listFromSearchNode);
    }

    @Test
    @Order(5)
    @DisplayName("5-) Search Item")
    public void searchItemInSearchNodeTest() {
        List<String> list = getStringListData();
        searchNode.addAll(list);

        String item = list.get(0);
        String item2 = "şeftali";
        String item3 = "çilek";
        searchNode.add(item2);
        searchNode.add(item3);
        String actual = searchNode.search(item).getListDataInfo().get(0).getValue();
        Assertions.assertEquals(item, actual);

        actual = searchNode.search(item2).getListDataInfo().get(0).getValue();
        Assertions.assertEquals(item2, actual);

        actual = searchNode.search(item3).getListDataInfo().get(0).getValue();
        Assertions.assertEquals(item3, actual);

    }

    @Test
    @Order(6)
    @DisplayName("6-) Update Priority Char")
    public void updatePriorityCharBeforeAddingItemToSearchNodeTest() {
        searchNode.updatePriorityChar('ş', 's');
        searchNode.updatePriorityChar('ç', 'c');

        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");
        List<DataInfo<String>> listFromSearchNode = searchNode.getAll();
        Assertions.assertEquals("can", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());
    }


    @Test
    @Order(7)
    @DisplayName("7-) Update Priority Char List - Before adding data")
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
        List<DataInfo<String>> listFromSearchNode = searchNode.getAll();
        Assertions.assertEquals("çilek", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("can", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(4).getValue());
    }


    @Test
    @Order(8)
    @DisplayName("8-) Update Priority Char - After adding data")
    public void updatePriorityCharAfterAddingItemToSearchNodeTest() {
        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");

        searchNode.updatePriorityChar('ş', 's');
        searchNode.updatePriorityChar('ç', 'c');

        List<DataInfo<String>> listFromSearchNode = searchNode.getAll();
        Assertions.assertEquals("can", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());
    }


    @Test
    @Order(9)
    @DisplayName("9-) Update Priority Char - After adding data")
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

        List<DataInfo<String>> listFromSearchNode = searchNode.getAll();
        Assertions.assertEquals("çilek", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("can", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(4).getValue());
    }


    @Test
    @Order(10)
    @DisplayName("10-) Reset Priority Char - After adding data")
    public void resetPriorityCharAfterAddingItemToSearchNodeTest() {
        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");

        searchNode.updatePriorityChar('ş', 's');
        searchNode.updatePriorityChar('ç', 'c');

        List<DataInfo<String>> listFromSearchNode = searchNode.getAll();
        Assertions.assertEquals("can", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());

        searchNode.resetPriorityChar('ç');
        listFromSearchNode = searchNode.getAll();
        Assertions.assertEquals("şeftali", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(4).getValue());
    }

    @Test
    @Order(11)
    @DisplayName("11-) Reset All Priority Char - After adding data")
    public void resetAllPriorityCharAfterAddingItemToSearchNodeTest() {
        searchNode.add("ahmet");
        searchNode.add("can");
        searchNode.add("çilek");
        searchNode.add("selim");
        searchNode.add("şeftali");

        searchNode.updatePriorityChar('ş', 's');
        searchNode.updatePriorityChar('ç', 'c');

        List<DataInfo<String>> listFromSearchNode = searchNode.getAll();
        Assertions.assertEquals("can", listFromSearchNode.get(1).getValue());
        Assertions.assertEquals("çilek", listFromSearchNode.get(2).getValue());
        Assertions.assertEquals("selim", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());

        searchNode.resetAllPriorityChars();
        listFromSearchNode = searchNode.getAll();
        Assertions.assertEquals("çilek", listFromSearchNode.get(3).getValue());
        Assertions.assertEquals("şeftali", listFromSearchNode.get(4).getValue());
    }

    @Test
    @Order(12)
    @DisplayName("12-) Get all data start with [al] ")
    public void getAllStartWithTest() {
        searchNode.addAll(getStringListData());
        List<DataInfo<String>> list = searchNode.getAllStartWith("al");
        String expected = "ali";
        String actual = list.get(0).getValue();
        Assertions.assertEquals(expected, actual);
        expected = "alim";
        actual = list.get(1).getValue();
        Assertions.assertEquals(expected, actual);


        list = searchNode.getAllStartWith("s");

        int expectedListSize = 3;
        int actualListSize = list.size();

        Assertions.assertEquals(expectedListSize, actualListSize);
    }

    @Test
    @Order(13)
    @DisplayName("13-) Search NodeData Test ")
    public void getSearchNodeDataTest() {
        searchNode.addAll(getStringListData());
        Set<DataInfo<String>> snAddedItemlist = new HashSet<>();
        searchNode.getAll().forEach(e -> snAddedItemlist.add(e));
        snAddedItemlist.forEach(e -> {
            NodeData<String> nodeData = searchNode.searchNodeData(e.getValue());
            String expected = e.getValue();
            String actual = nodeData.getLocationAddress();
            Assertions.assertEquals(expected, actual);
        });
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