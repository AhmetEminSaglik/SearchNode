package org.aes.searchnode.business.concretes.searchnode.test;


import org.aes.searchnode.business.concretes.searchnode.data.DataArray;
import org.aes.searchnode.business.concretes.searchnode.utility.TestAlgorithmUtility;
import org.ahmeteminsaglik.API.concretes.DatabaseConnectionSN;
import org.ahmeteminsaglik.TestAlgorithm;
import org.ahmeteminsaglik.entity.WordProcessUsedTable;
import org.ahmeteminsaglik.enums.EnumDataStructor;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.junit.jupiter.api.*;
import org.ahmeteminsaglik.TestAlgorithmResult;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SmallDataTestAlgorithm {

    @Test
    @DisplayName("SearchNode - Small Data")
    @Order(1)
    void test_SearchNode_SmallData_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000.length; i++) {
            TestAlgorithmResult testAlgorithmResult = TestAlgorithmUtility.prepareTestAlgorithm(
                    DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][0],
                    DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][1]);
            TestAlgorithmUtility.testWithSearchNode(testAlgorithmResult);
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
            testAlgorithmResult = null;
        }
    }

    @Test
    @DisplayName("Hashmap - Small Data - No Sort - Hashmap Search")
    @Order(2)
    void test_HashMap_SmallData_NoSort_HashMapSearch_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000.length; i++) {
            TestAlgorithm testAlgorithm = new TestAlgorithm();
            TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

            //Set Algorithm structors
            testAlgorithmResult.setDataStructorProcess(EnumDataStructor.HASHMAP);
            testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.NO_SORT);
            testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.HASHMAP);
            //Set word tables
            WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
            wordProcessUsedTable.setEnumTotalWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][0]);
            wordProcessUsedTable.setEnumSearchWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][1]);
            // test algorithm
            testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
            testAlgorithm.test(testAlgorithmResult);
            // save database the result
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
        }
    }

    @Test
    @DisplayName("Array - Small Data - Merge Sort - Binary Search")
    @Order(3)
    void test_Array_SmallData_MergeSort_BinarySearch_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000.length; i++) {
            TestAlgorithm testAlgorithm = new TestAlgorithm();
            TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

            //Set Algorithm structors
            testAlgorithmResult.setDataStructorProcess(EnumDataStructor.ARRAY);
            testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.MERGE_SORT);
            testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.BINARY_SEARCH);
            //Set word tables
            WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
            wordProcessUsedTable.setEnumTotalWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][0]);
            wordProcessUsedTable.setEnumSearchWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][1]);
            // test algorithm
            testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
            testAlgorithm.test(testAlgorithmResult);
            // save database the result
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
        }
    }

    @Test
    @DisplayName("Array - Small Data - Merge Sort - Binary Search")
    @Order(4)
    void test_Array_SmallData_TTT_BinarySearch_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000.length; i++) {
            TestAlgorithm testAlgorithm = new TestAlgorithm();
            TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

            //Set Algorithm structors
            testAlgorithmResult.setDataStructorProcess(EnumDataStructor.ARRAY);
            testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.NO_SORT);
            testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.LINEAR_SEARCH);
            //Set word tables
            WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
            wordProcessUsedTable.setEnumTotalWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][0]);
            wordProcessUsedTable.setEnumSearchWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][1]);
            // test algorithm
            testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
            testAlgorithm.test(testAlgorithmResult);
            // save database the result
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
        }
    }

    @Test
    @DisplayName("ArrayList - Small Data - Selection Sort - Linear Search")
    @Order(5)
    void test_ArrayList_SmallData_TimSort_LinearSearch_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000.length; i++) {
            TestAlgorithm testAlgorithm = new TestAlgorithm();
            TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

            //Set Algorithm structors
            testAlgorithmResult.setDataStructorProcess(EnumDataStructor.ARRAYLIST);
            testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.SELECTION_SORT);
            testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.LINEAR_SEARCH);
            //Set word tables
            WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
            wordProcessUsedTable.setEnumTotalWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][0]);
            wordProcessUsedTable.setEnumSearchWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][1]);
            // test algorithm
            testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
            testAlgorithm.test(testAlgorithmResult);
            // save database the result
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
        }
    }


    @Test
    @DisplayName("ArrayList - Small Data - Insertion Sort - Binary Search")
    @Order(6)
    void test_ArrayList_SmallData_InsertionSort_LinearSearch_ComplexityCalculation_SaveDatabase() {
        for (int i = 0; i < DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000.length; i++) {
            TestAlgorithm testAlgorithm = new TestAlgorithm();
            TestAlgorithmResult testAlgorithmResult = new TestAlgorithmResult();

            //Set Algorithm structors
            testAlgorithmResult.setDataStructorProcess(EnumDataStructor.ARRAYLIST);
            testAlgorithmResult.setSortAlgorithmProcess(EnumSortAlgorithm.INSERTION_SORT);
            testAlgorithmResult.setSearchAlgorithmProcess(EnumSearchAlgorithm.BINARY_SEARCH);
            //Set word tables
            WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable();
            wordProcessUsedTable.setEnumTotalWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][0]);
            wordProcessUsedTable.setEnumSearchWordList(DataArray.SMALL_SMALL_wordTableArrBetween_50_and_1_000[i][1]);
            // test algorithm
            testAlgorithmResult.setWordProcessUsedTable(wordProcessUsedTable);
            testAlgorithm.test(testAlgorithmResult);
            // save database the result
            DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
            databaseConnectionSN.save(testAlgorithmResult);
        }
    }
}