package org.aes.searchnode.dpi.controllers;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.entities.PriorityChar;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchNodeTest {
    SearchNode<String> searchNode = new SearchNode<>();

    @BeforeEach
    public void initalizeSearchNodeDPI() {
        searchNode = new SearchNode<>();
    }

    static boolean errorOccured = false;

    @Test
    @Order(1)
    @DisplayName("1- Update Char")
    public void testUpdateCharacter() {
        updateCharItem('a', 'b', 'b');
        updateCharItem('a', 'c', 'b');
        updateCharItem('a', 'd', 'c');
        updateCharItem('c', 'e', 'b');
        updateCharItem('y', 'a', 'z');
        updateCharItem('b', 'a', 'f');// --> Burda hata var.  c'nin degeri 97.375 iken, ASCII koduna gore yani 99'a gore hesaplayip hesaplayip 97.5 buluyor. ama C'nin degeri
        updateCharItem('b', 'f', 'a');
        updateCharItem('a', 'g', 'h');
        updateCharItem('x', 'a', 'y');
        updateCharItem('a', 'x', 'y');

    }

    @Test
    @Order(2)
    @DisplayName("2- Update Char List")
    public void testUpdateCharacterList() {
        List<Character> list = new ArrayList<>();
        list.add('z');
        list.add('e');
        list.add('b');
        list.add('c');
        searchNode.updatePriorityChar(list, 'a');
        updatePriorityCharacterList('a', list);
    }

    @Test()
    @Order(3)
    @DisplayName("3- Next Priority Char")
    public void testGetNextPriorityCharOfGivenUpdateChar() {
        getNextCharOfGiven('a', 'b');
        getNextCharOfGiven('b', 'c');
        getNextCharOfGiven('c', 'd');
        getNextCharOfGiven('d', 'e');

        updateCharItem('a', 'b', 'b');
        getNextCharOfGiven('a', 'b');
        updateCharItem('a', 'c', 'b');
        getNextCharOfGiven('a', 'c');
        updateCharItem('a', 'd', 'c');
        getNextCharOfGiven('a', 'd');
        updateCharItem('c', 'e', 'b');
        getNextCharOfGiven('c', 'e');
        updateCharItem('y', 'a', 'z');
        getNextCharOfGiven('y', 'a');

        /*
        sn.updatePriorityChar('l', 'm');
        sn.updatePriorityChar('l', 'm');
        sn.updatePriorityChar('k', 'm');
        sn.updatePriorityChar('j', 'm');
        sn.updatePriorityChar('p', 'm');
        sn.updatePriorityChar('o', 'm');
        sn.updatePriorityChar('q', 'a');
        sn.updatePriorityChar('g', 'a');
        sn.updatePriorityChar('h', 'a');*/

    }

    @Test
    @Order(4)
    @DisplayName("4- Reset Char")
    public void testResetCharacter() {
        updateCharItem('a', 'b', 'b');
        updateCharItem('a', 'c', 'b');
        updateCharItem('a', 'd', 'c');
        updateCharItem('c', 'e', 'b');
        updateCharItem('y', 'a', 'z');
        resetCharItem('a');
        resetCharItem('b');
        resetCharItem('c');
        resetCharItem('d');
        resetCharItem('z');

//        updateCharItem('b', 'a', 'c');// --> Burda hata var.  c'nin degeri 97.375 iken, ASCII koduna gore yani 99'a gore hesaplayip hesaplayip 97.5 buluyor. ama C'nin degeri
    }

    @Test
    @Order(5)
    @DisplayName("5- Reset All Chars")
    public void testResetAllPriorityCharacterList() {
        searchNode.updatePriorityChar('b', 'a');
        searchNode.updatePriorityChar('c', 'a');
        searchNode.updatePriorityChar('d', 'a');
        searchNode.updatePriorityChar('y', 'a');
        searchNode.updatePriorityChar('z', 'a');
        List<Character> list = new ArrayList<>();
        list.add('z');
        list.add('e');
        list.add('b');
        list.add('c');
        searchNode.updatePriorityChar(list, 'e');
        updatePriorityCharacterList('a', list);
        searchNode.resetAllPriorityChars();
        list.add('y');
        list.add('z');
      /*  for (int i = 0; i < list.size(); i++) {
            double actual = searchNode.getPcService().get(list.get(i)).getData().getValue();
            double expected = list.get(i);
            Assertions.assertEquals(expected,actual);
        }*/
        printPriorityCharList("Reset PriorityCharList: ",list);
    }

    @Test
    @Order(6)
    @DisplayName("6- Any Error Occured During Testing")
    public void isErrorOccured() {
        Assertions.assertFalse(errorOccured);
    }


    private void updatePriorityCharacterList(char nextTo, List<Character> listWillBeUpdated) {
        searchNode.updatePriorityChar(listWillBeUpdated, nextTo);
        printPriorityCharList("Updated PriorityCharList : ", listWillBeUpdated);
    }

    private void printPriorityCharList(String prefixExplanation, List<Character> list) {
        StringBuilder sb = new StringBuilder(prefixExplanation + "PriorityCharList :");
        for (int i = 0; i < list.size(); i++) {
            char tmpChar = list.get(i);
            sb.append("[").append(tmpChar).append("=").append(searchNode.getPcService().get(tmpChar).getData().getValue() + "]");
        }
        System.out.println(sb);
    }

    private void updateCharItem(char nextTo, char willBeUpdated, char charValueOfBeforeCharacter) {
        double beforeCharValue = searchNode.getPcService().get(charValueOfBeforeCharacter).getData().getValue();
        double nextToCharValue = searchNode.getPcService().get(nextTo).getData().getValue();
        System.out.println("NextToChar: " + nextTo + "=" + nextToCharValue + "; BeforeChar: " + charValueOfBeforeCharacter + "=" + beforeCharValue);
        searchNode.updatePriorityChar(willBeUpdated, nextTo);
        PriorityChar pc = searchNode.getPcService().get(willBeUpdated).getData();
        double expected = (beforeCharValue + nextToCharValue) / 2;
        double actual = pc.getValue();
        printUpdatedCharacterData(Character.toString(willBeUpdated), Character.toString(nextTo), expected, actual);

        try {
            Assertions.assertEquals(expected, actual);
        } catch (AssertionFailedError e) {
            System.out.println("\u001B[31m" + "!!! ERROR OCCURED : Update Character \n" + e.getMessage() + "\u001B[0m");
            errorOccured = true;
        }

    }

    private void resetCharItem(char characterToReset) {
        double beforeResetValue = searchNode.getPcService().get(characterToReset).getData().getValue();
        searchNode.resetPriorityChar(characterToReset);
        double expected = (int) characterToReset;
        double actual = searchNode.getPcService().get(characterToReset).getData().getValue();
        printResetCharacterData(characterToReset, beforeResetValue, expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    private void getNextCharOfGiven(char givenChar, char expected) {
        char actual = searchNode.getPcService().getNextPriorityCharOfGiven(givenChar).getData().getChar();
        printNextPriorityCharOfGiven(givenChar, expected, actual);
        try {
            Assertions.assertEquals(expected, actual);
        } catch (AssertionFailedError e) {
            System.out.println("\u001B[31m" + "!!! ERROR OCCURED : getNextOfCharGiven\n" + e.getMessage() + "\u001B[0m");
            errorOccured = true;
        }
    }

    private void printUpdatedCharacterData(String updateChar, String after, double expected, double actual) {
        System.out.format("[%s] updated next to [%s] :Expected :  %s Actual : %s\n", updateChar, after, expected, actual);
    }

    private void printResetCharacterData(char resetChar, double beforeResetValue, double expected, double actual) {
        System.out.format("Reset Character Process : Before reset  [%s]=%s;  After Reset : Expected=%s ~ Actual=%s \n", resetChar, beforeResetValue, expected, actual);
    }

    private void printNextPriorityCharOfGiven(char givenChar, char expected, char actual) {
        System.out.format("[%s]'s next char is : Expected :  %s Actual : %s\n", givenChar, expected, actual);
    }
}
