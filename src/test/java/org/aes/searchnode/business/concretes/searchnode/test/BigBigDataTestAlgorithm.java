package org.aes.searchnode.business.concretes.searchnode.test;


import org.aes.searchnode.business.concretes.searchnode.data.DataArray;
import org.aes.searchnode.business.concretes.searchnode.utility.TestAlgorithmUtility;
import org.ahmeteminsaglik.API.concretes.DatabaseConnectionSN;
import org.ahmeteminsaglik.TestAlgorithm;
import org.ahmeteminsaglik.TestAlgorithmResult;
import org.ahmeteminsaglik.entity.WordProcessUsedTable;
import org.ahmeteminsaglik.enums.EnumDataStructor;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BigBigDataTestAlgorithm {

    @Test
    @DisplayName("SearchNode - Big-Big Data")
    @Order(1)
    void test_SearchNode_Big_BigData_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000.length; i++) {
            TestAlgorithmResult testAlgorithmResult = TestAlgorithmUtility.prepareTestAlgorithm(
                    DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000[0][0],
                    DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000[0][1]);
            TestAlgorithmUtility.testWithSearchNode(testAlgorithmResult);
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
            testAlgorithmResult = null;
            TestAlgorithmUtility.sleep(3_500);
        }
    }

    @Test
    @DisplayName("Hashmap - Big-Big Data - No Sort - Hashmap Search")
    @Order(2)
    void test_HashMap_Big_BigData_NoSort_HashMapSearch_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000.length; i++) {
            TestAlgorithm testAlgorithm = new TestAlgorithm();
            TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

            //Set Algorithm structors
            testAlgorithmResult.setDataStructorProcess(EnumDataStructor.HASHMAP);
            testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.NO_SORT);
            testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.HASHMAP);
            //Set word tables
            WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
            wordProcessUsedTable.setEnumTotalWordList(DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000[i][0]);
            wordProcessUsedTable.setEnumSearchWordList(DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000[i][1]);
            // test algorithm
            testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
            testAlgorithm.test(testAlgorithmResult);
            // save database the result
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
            TestAlgorithmUtility.sleep(1_500);
        }
    }

    @Test
    @DisplayName("Array - Big-Big Data - Merge Sort - Binary Search")
    @Order(3)
    void test_Array_Big_BigData_MergeSort_BinarySearch_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000.length; i++) {
            TestAlgorithm testAlgorithm = new TestAlgorithm();
            TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

            //Set Algorithm structors
            testAlgorithmResult.setDataStructorProcess(EnumDataStructor.ARRAY);
            testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.MERGE_SORT);
            testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.BINARY_SEARCH);
            //Set word tables
            WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
            wordProcessUsedTable.setEnumTotalWordList(DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000[i][0]);
            wordProcessUsedTable.setEnumSearchWordList(DataArray.BIG_BIG_WordTableArrBetween_10_000_and_1_000_000[i][1]);
            // test algorithm
            testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
            testAlgorithm.test(testAlgorithmResult);
            // save database the result
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
            TestAlgorithmUtility.sleep(1_500);
        }
    }

}