package org.aes.searchnode.testing;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;

import java.util.List;

public class TestingSearchNode implements TestingObjects {

    SearchNode<String> searchNode = new SearchNode<>();
    TimeCalculation timeCalculation = new TimeCalculation();

    @Override
    public void addData(List<String> list) {
        timeCalculation.start();
        for (String tmp : list) {
            searchNode.add(tmp);
        }
        timeCalculation.stop();
        printElapsedTime("  > SearchNode > data is ADDED ", timeCalculation);
    }

    @Override
    public void sort() {
        timeCalculation.start();
        timeCalculation.stop();

        printElapsedTime("  > SearchNode > SORTED ", timeCalculation);
    }

    @Override
    public void search(List<String> list) {
        int foundTextNumber = 0;
        int missingTextNumber = 0;
        timeCalculation.start();
        for (String tmpText : list) {
            DataResult dataResult = searchNode.search(tmpText);
            if (dataResult.isSuccess()) {
                foundTextNumber++;
            } else {
                missingTextNumber++;
            }
        }
        timeCalculation.stop();
        System.out.println("found Text Number : " + foundTextNumber);
        System.out.println("missing  Text Number : " + missingTextNumber);

        printElapsedTime("  > SearchNode >  SEARCHED ", timeCalculation);
    }
}
