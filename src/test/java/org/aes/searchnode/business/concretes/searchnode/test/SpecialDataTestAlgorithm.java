package org.aes.searchnode.business.concretes.searchnode.test;


import org.aes.searchnode.business.concretes.searchnode.data.DataArray;
import org.aes.searchnode.business.concretes.searchnode.utility.TestAlgorithmUtility;
import org.ahmeteminsaglik.API.concretes.DatabaseConnectionSN;
import org.ahmeteminsaglik.TestAlgorithm;
import org.ahmeteminsaglik.TestAlgorithmResult;
import org.ahmeteminsaglik.entity.ComplexityConsept;
import org.ahmeteminsaglik.entity.WordProcessUsedTable;
import org.ahmeteminsaglik.enums.EnumDataStructor;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.enums.EnumWordTable;
import org.ahmeteminsaglik.readableformat.ReadableFormat;
import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.ComplexContent;
import org.junit.jupiter.api.*;

import javax.swing.plaf.TableHeaderUI;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpecialDataTestAlgorithm {


    @Test
    @DisplayName("Hashmap - Special Data - No Sort - Hashmap Search - 3_000_000 - 2_000_000")
    @Order(1)
    void test_HashMap_SpecialData_NoSort_HashMapSearch_ComplexityCalculation_SaveDatabase() {
        TestAlgorithm testAlgorithm = new TestAlgorithm();
        TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

        //Set Algorithm structors
        testAlgorithmResult.setDataStructorProcess(EnumDataStructor.HASHMAP);
        testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.NO_SORT);
        testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.HASHMAP);
        //Set word tables
        WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
        wordProcessUsedTable.setEnumTotalWordList(EnumWordTable.WORD_3_000_000);
        wordProcessUsedTable.setEnumSearchWordList(EnumWordTable.WORD_2_000_000);
        // test algorithm
        testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
        testAlgorithm.test(testAlgorithmResult);
        System.out.println(" \n - - - Hashmap - Special Data - No Sort - Hashmap Search - 3_000_000 - 2_000_000");
        printResult(testAlgorithmResult);
        // save database the result
//            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
//            databaseConnectionSN.save(testAlgorithmResult);
    }

    @Test
    @DisplayName("ArrayList - Special Data - Merge Sort - Binary Search - 3_000_000 - 2_000_000")
    @Order(2)
    void test_Array_SpecialData_MergeSort_BinarySearch_ComplexityCalculation_SaveDatabase() {
        TestAlgorithm testAlgorithm = new TestAlgorithm();
        TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

        //Set Algorithm structors
        testAlgorithmResult.setDataStructorProcess(EnumDataStructor.ARRAYLIST);
        testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.MERGE_SORT);
        testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.BINARY_SEARCH);
        //Set word
        WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
        wordProcessUsedTable.setEnumTotalWordList(EnumWordTable.WORD_3_000_000);
        wordProcessUsedTable.setEnumSearchWordList(EnumWordTable.WORD_2_000_000);
        // test algorithm
        testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
        testAlgorithm.test(testAlgorithmResult);
        System.out.println(" \n - - - ArrayList - Special Data - Merge Sort - Binary Search - 3_000_000 - 2_000_000");
        printResult(testAlgorithmResult);
        // save database the result
//            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
//            databaseConnectionSN.save(testAlgorithmResult);
    }

    @Test
    @DisplayName("SearchNode - Special Data - 3_000_000 - 2_000_000")
    @Order(3)
    void test_SearchNode_SpecialData_ComplexityCalculation_SaveDatabase() {
        TestAlgorithmResult testAlgorithmResult = TestAlgorithmUtility.prepareTestAlgorithm(
                EnumWordTable.WORD_3_000_000, EnumWordTable.WORD_2_000_000);
        TestAlgorithmUtility.testWithSearchNode(testAlgorithmResult);
        System.out.println(" \n - - - SearchNode - Special Data - 3_000_000 - 2_000_000");
        printResult(testAlgorithmResult);

//        DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
//        databaseConnectionSN.save(testAlgorithmResult);

    }

    private static void printResult(TestAlgorithmResult testAlgorithmResult) {
        System.out.println("Data Structor : " + getResult(testAlgorithmResult.getDataStructorComplexityConcept()));
        System.out.println("Sort algorithm  : " + getResult(testAlgorithmResult.getSortAlgorithmComplexityConcept()));
        System.out.println("Search  algorithm  : " + getResult(testAlgorithmResult.getSearchAlgorithmComplexityConcept()));
        System.out.println("found words  : " + ReadableFormat.getStringValue(testAlgorithmResult.getWordProcessStatistic().getFoundWord()));
        System.out.println("Missing words  : " + ReadableFormat.getStringValue(testAlgorithmResult.getWordProcessStatistic().getMissingWord()));
    }

    private static String getReadableFormat(long value) {
        return ReadableFormat.getStringValue(value);
    }

    private static String getResult(ComplexityConsept complexityConsept) {
        return "Elapsed Time : " + complexityConsept.getStopwatch().getElapsedTimeString() /*+ " | KB : " + getReadableFormat(complexityConsept.getMemoryUsage().getUsedMemoryKB())*/;
    }
}