package org.aes.searchnode.testing.concretes;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.aes.searchnode.testing.abstracts.CalculateDataStructorComplexity;
import org.aes.searchnode.testing.abstracts.TestingDataStructorFeature;

import java.util.ArrayList;
import java.util.List;

public class TestingSearchNode implements TestingDataStructorFeature, CalculateDataStructorComplexity {

    SearchNode<String> searchNode = new SearchNode<>();
    List<String> poolList = new ArrayList<>();
    List<String> searchList = new ArrayList<>();
    TimeCalculation timeCalculation = new TimeCalculation();

    public TestingSearchNode() {
    }

    public TestingSearchNode(List<String> poolList, List<String> searchList) {
        this.poolList = poolList;
        this.searchList = searchList;
    }

    @Override
    public void addData(List<String> list) {
        System.out.println("[SN] Word Pool Size : " + ReadableStringFormat.getReadableValueIntToString(list.size()));

        timeCalculation.start();
        for (String tmp : list) {
            searchNode.add(tmp);
        }
        timeCalculation.stop();
        printElapsedTime("[SN] SearchNode > Add Process", timeCalculation);
    }

    @Override
    public void sort() {
        timeCalculation.start();
        timeCalculation.stop();

        printElapsedTime("[SN] SearchNode > Sort Process", timeCalculation);
    }

    @Override
    public void search(List<String> list) {
        System.out.println("[SN] Search Data Size : " + ReadableStringFormat.getReadableValueIntToString(list.size()));

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
        System.out.println("[SN] Found Data Number : " + ReadableStringFormat.getReadableValueIntToString(foundTextNumber));
        System.out.println("[SN] Missing Data Number : " + ReadableStringFormat.getReadableValueIntToString(missingTextNumber));

        printElapsedTime("[SN] SearchNode > Search Process", timeCalculation);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

    }

    @Override
    public void run() {
        addData(poolList);
        sort();
        search(searchList);
    }
}
