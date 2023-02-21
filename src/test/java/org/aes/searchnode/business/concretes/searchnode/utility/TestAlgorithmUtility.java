package org.aes.searchnode.business.concretes.searchnode.utility;

import org.aes.searchnode.business.concretes.searchnode.SearchNode;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.entities.concretes.DataInfo;
import org.ahmeteminsaglik.MemoryUsage;
import org.ahmeteminsaglik.Stopwatch;
import org.ahmeteminsaglik.TestAlgorithmResult;
import org.ahmeteminsaglik.entity.WordProcessStatistics;
import org.ahmeteminsaglik.entity.WordProcessUsedTable;
import org.ahmeteminsaglik.enums.EnumDataStructor;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.enums.EnumWordTable;
import org.ahmeteminsaglik.utility.RetriveDataFromDBUtility;

import java.util.List;

public class TestAlgorithmUtility {
    public static void testWithSearchNode(TestAlgorithmResult testAlgorithmResult) {
        Stopwatch dataStructorStopWatch = testAlgorithmResult.getDataStructorComplexityConcept().getStopwatch();
        MemoryUsage dataStructorMemoryUsage = testAlgorithmResult.getDataStructorComplexityConcept().getMemoryUsage();

        Stopwatch sortAlgorithmStopWatch = testAlgorithmResult.getSortAlgorithmComplexityConcept().getStopwatch();
        MemoryUsage sortAlgorithmMemoryUsage = testAlgorithmResult.getSortAlgorithmComplexityConcept().getMemoryUsage();

        Stopwatch searchAlgorithmStopWatch = testAlgorithmResult.getSearchAlgorithmComplexityConcept().getStopwatch();
        MemoryUsage searchAlgorithmMemoryUsage = testAlgorithmResult.getSearchAlgorithmComplexityConcept().getMemoryUsage();

        EnumWordTable enumWordPool = testAlgorithmResult.getWordProcessUsedTable().getEnumTotalWordList();
        EnumWordTable enumSearchWordGroup = testAlgorithmResult.getWordProcessUsedTable().getEnumSearchWordList();
        List<String> wordPool = RetriveDataFromDBUtility.getWordListFromDatabaseInStringFormat(enumWordPool);
        List<String> searchWordList = RetriveDataFromDBUtility.getWordListFromDatabaseInStringFormat(enumSearchWordGroup);

        //Data-Structor Process
        TestComplexityCalculationUtility.start(dataStructorStopWatch, dataStructorMemoryUsage);
        SearchNode<String> searchNode = new SearchNode();
        searchNode.addAll(wordPool);
        TestComplexityCalculationUtility.stop(dataStructorStopWatch, dataStructorMemoryUsage);

        //Sort Algorithm Process
        TestComplexityCalculationUtility.start(sortAlgorithmStopWatch, sortAlgorithmMemoryUsage);
        TestComplexityCalculationUtility.stop(sortAlgorithmStopWatch, sortAlgorithmMemoryUsage);

        //Search Algorithm Process
        TestComplexityCalculationUtility.start(searchAlgorithmStopWatch, searchAlgorithmMemoryUsage);
        int foundWord = 0;
        int missingWord = 0;
        for (String word : searchWordList) {
            DataResult<DataInfo<String>> result = searchNode.search(word);
            if (result.isSuccess()) {
                foundWord++;
            } else {
                missingWord++;
            }
        }
        WordProcessStatistics wordProcessStatistics = new WordProcessStatistics(foundWord, missingWord);
        testAlgorithmResult.setWordProcessStatistic(wordProcessStatistics);
        TestComplexityCalculationUtility.stop(searchAlgorithmStopWatch, searchAlgorithmMemoryUsage);
        System.out.println("search algorithm   algorithm elapsed time : "+searchAlgorithmStopWatch.getElapsedTimeString());
    }

    public static TestAlgorithmResult prepareTestAlgorithm(EnumWordTable enumWordPool, EnumWordTable enumSearchWordGroup) {
        TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

        testAlgorithmResult.setDataStructorProcess(EnumDataStructor.SEARCHNODE_V1);
        testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.NO_SORT);
        testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.SEARCH_NODE);
        WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable(enumWordPool, enumSearchWordGroup);
        testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
        testAlgorithmResult.setComplexityConseptDataStructor(new Stopwatch(), new MemoryUsage());
        testAlgorithmResult.setComplexityConseptSortAlgorithm(new Stopwatch(), new MemoryUsage());
        testAlgorithmResult.setComplexityConseptSearchAlgorithm(new Stopwatch(), new MemoryUsage());

        return testAlgorithmResult;
    }
    public  static  void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
