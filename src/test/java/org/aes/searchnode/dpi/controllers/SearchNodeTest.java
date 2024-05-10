package org.aes.searchnode.dpi.controllers;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.entities.PriorityChar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchNodeTest {
    SearchNode<String> searchNode = new SearchNode<>();

    @BeforeEach
    public void initalizeSearchNodeDPI() {
        searchNode = new SearchNode<>();
    }

    @Test
    public void testUpdateCharacter() {
        updateCharItem('a', 'b', 'b');
        updateCharItem('a', 'c', 'b');
        updateCharItem('a', 'd', 'c');
        updateCharItem('c', 'e', 'b');
        updateCharItem('y', 'a', 'z');
//        updateCharItem('b', 'a', 'c');// --> Burda hata var.  c'nin degeri 97.375 iken, ASCII koduna gore yani 99'a gore hesaplayip hesaplayip 97.5 buluyor. ama C'nin degeri
    }

    @Test
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
    public void testGetNextPriorityChar_UpdateChar() {
        SearchNode<String> sn = new SearchNode<>();


        searchNode.resetAllPriorityChars();

        sn.updatePriorityChar('l', 'm');
        sn.updatePriorityChar('l', 'm');
        sn.updatePriorityChar('k', 'm');
        sn.updatePriorityChar('j', 'm');
        sn.updatePriorityChar('p', 'm');
        sn.updatePriorityChar('o', 'm');
        sn.updatePriorityChar('q', 'a');
        sn.updatePriorityChar('g', 'a');
        sn.updatePriorityChar('h', 'a');
//        printPCDao(sn);
        System.out.println(sn.getPcService().getNextPriorityCharOfGiven('g').getData());
    }

    @Test
    public void testResetAllPriorityCharacterList() {
        searchNode.updatePriorityChar('a', 'b');
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
        Assertions.assertEquals(expected, actual);

    }

    private void resetCharItem(char characterToReset) {
        double beforeResetValue=searchNode.getPcService().get(characterToReset).getData().getValue();
        searchNode.resetPriorityChar(characterToReset);
        double expected = (int) characterToReset;
        double actual = searchNode.getPcService().get(characterToReset).getData().getValue();
        printResetCharacterData(characterToReset,beforeResetValue, expected, actual);
        Assertions.assertEquals(expected, actual);
    }

    private static void printUpdatedCharacterData(String updateChar, String after, double expected, double actual) {
        System.out.format("[%s] updated next to [%s] :Expected :  %s Actual : %s\n", updateChar, after, expected, actual);
    }

    private static void printResetCharacterData(char resetChar,double beforeResetValue, double expected, double actual) {
        System.out.format("Reset Character Process : Before reset  [%s]=%s;  After Reset : Expected=%s ~ Actual=%s \n", resetChar, beforeResetValue, expected, actual);
    }
}
