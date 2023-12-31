package org.aes.searchnode.dpi.controllers;

import org.aes.searchnode.testing.abstracts.CalculateDataStructorComplexity;
import org.aes.searchnode.testing.concretes.TestingArrayList;
import org.aes.searchnode.testing.concretes.TestingSearchNode;
import org.ahmeteminsaglik.fileoperation.business.abstracts.ReadFileService;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlgorithmComplexityTest {
    //    static TestingDataStructorFeature testDataStructor = null;
    private static FileOperationFacade fileOperationFacade;
    private static CalculateDataStructorComplexity calculateDataStructorComplexity;
    private static FileFundamental ffAllWords = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/")
            .setFileName("Word-Data-1_398_449")
            .setFileExtension(".txt");

    static String word_13_k = "word-data-13-985";
    static String word_279_k = "word-data-279-690";
    static String word_419_k = "word-data-419-535";
    static String word_466_k = "word-data-466-150";
    static String word_489_k = "word-data-489-458";
    static String word_699_k = "word-data-699-225";
    FileFundamental ffWordPool = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/mod-test-data/")
            .setFileExtension(".txt");
    FileFundamental ffWordsToSearch = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/mod-test-data/")
            .setFileName("test-data-mod-10")
            .setFileExtension(".txt");

    @BeforeEach
    public void resetTestingDataStructor() {
        calculateDataStructorComplexity = null;
    }

    @Test
    @Order(1)
    @DisplayName("1-SearchNode : Search 13_935 from 13_935")
    public void testSearchNode_Search_13_985_WordData_From_13_985_WordPool() {// mod 5
        ffWordPool.setFileName(word_13_k);
        ffWordsToSearch.setFileName(word_13_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();

//        testDataStructor.addData(allList);
//        testDataStructor.sort();
//
//        allList.clear();
//        ffWordsToSearch.setFileName(word_13_k);
//        allList.addAll(getWordListFromPath(ffWordsToSearch));
//        testDataStructor.search(allList);
    }

    @Test
    @Order(2)
    @DisplayName("1-ArrayList : Search  13_935 from 13_935")
    public void testArrrayList_Sort_BinarySearch_Search_13_985_WordData_From_13_985_WordPool() {// mod 5
        ffWordPool.setFileName(word_13_k);
        ffWordsToSearch.setFileName(word_13_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();

//        testDataStructor = new TestingArrayList();
//        testDataStructor.addData(allList);
//        testDataStructor.sort();
//        allList.clear();

//        allList.addAll(getWordListFromPath(ffWordsToSearch));
//        testDataStructor.search(allList);

    }

    @Test
    @Order(3)
    @DisplayName("2-SearchNode : Search 279_690 from 13_935")
    public void testSearchNode_Search_279_690_WordData_From_13_985_WordPool() {// mod 5
        ffWordPool.setFileName(word_13_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();
        /*ffWordPool.setFileName(word_13_k);
        List<String> allList = getWordListFromPath(ffWordPool);

        testDataStructor = new TestingSearchNode();
        testDataStructor.addData(allList);
        testDataStructor.sort();

        allList.clear();
        ffWordsToSearch.setFileName(word_279_k);
        allList.addAll(getWordListFromPath(ffWordsToSearch));
        testDataStructor.search(allList);
    */
    }

    @Test
    @Order(4)
    @DisplayName("2-ArrayList : Search 279_690 from 13_935")
    public void testArrrayList_Sort_BinarySearch_Search_279_690_WordData_From_13_985_WordPool() {// mod 5
        ffWordPool.setFileName(word_13_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();

        /*ffWordPool.setFileName(word_13_k);
        List<String> allList = getWordListFromPath(ffWordPool);

        testDataStructor = new TestingArrayList();
        testDataStructor.addData(allList);
        testDataStructor.sort();
        allList.clear();
        ffWordsToSearch.setFileName(word_279_k);

        allList.addAll(getWordListFromPath(ffWordsToSearch));
        testDataStructor.search(allList);*/
    }

    @Test
    @Order(5)
    @DisplayName("3-SearchNode : Search 13_935 from 279_690")
    public void testSearchNode_Search_13_985_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_279_k);
        ffWordsToSearch.setFileName(word_13_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();
        /*ffWordPool.setFileName(word_279_k);
        List<String> allList = getWordListFromPath(ffWordPool);

        testDataStructor = new TestingSearchNode();
        testDataStructor.addData(allList);
        testDataStructor.sort();

        allList.clear();
        ffWordsToSearch.setFileName(word_13_k);
        allList.addAll(getWordListFromPath(ffWordsToSearch));
        testDataStructor.search(allList);
    */
    }

    @Test
    @Order(6)
    @DisplayName("3-ArrayList : Search 13_935 from 279_690")
    public void testArrrayList_Sort_BinarySearch_Search_13_985_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_13_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();
        /*ffWordPool.setFileName(word_279_k);
        List<String> allList = getWordListFromPath(ffWordPool);

        testDataStructor = new TestingArrayList();
        testDataStructor.addData(allList);
        testDataStructor.sort();
        allList.clear();
        ffWordsToSearch.setFileName(word_13_k);

        allList.addAll(getWordListFromPath(ffWordsToSearch));
        testDataStructor.search(allList);*/
    }

    @Test
    @Order(7)
    @DisplayName("4-SearchNode : Search 279_690 from 279_690")
    public void testSearchNode_Search_279_690_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_279_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();
        /*ffWordPool.setFileName(word_279_k);
        List<String> allList = getWordListFromPath(ffWordPool);

        testDataStructor = new TestingSearchNode();
        testDataStructor.addData(allList);
        testDataStructor.sort();

        allList.clear();
        ffWordsToSearch.setFileName(word_279_k);
        allList.addAll(getWordListFromPath(ffWordsToSearch));
        testDataStructor.search(allList);
    */
    }

    @Test
    @Order(8)
    @DisplayName("4-ArrayList : Search 279_690 from 279_690")
    public void testArrrayList_Sort_BinarySearch_Search_279_690_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_279_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();
    }

    @Test
    @Order(9)
    @DisplayName("5-SearchNode : Search 419_535 from 279_690")
    public void testSearchNode_Search_419_535_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_279_k);
        ffWordsToSearch.setFileName(word_419_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();

    }

    @Test
    @Order(10)
    @DisplayName("5-ArrayList : Search 419_535 from 279_690")
    public void testArrrayList_Sort_BinarySearch_Search_419_535_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_419_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();
        /*ffWordPool.setFileName(word_279_k);
        List<String> allList = getWordListFromPath(ffWordPool);

        testDataStructor = new TestingArrayList();
        testDataStructor.addData(allList);
        testDataStructor.sort();
        allList.clear();
        ffWordsToSearch.setFileName(word_279_k);

        allList.addAll(getWordListFromPath(ffWordsToSearch));
        testDataStructor.search(allList);
    */
    }

    @Test
    @Order(11)
    @DisplayName("6-SearchNode : Search 279_690 from 419_535")
    public void testSearchNode_Search_279_690_WordData_From_419_535_WordPool() {// mod 10
        ffWordPool.setFileName(word_419_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();
        /*ffWordPool.setFileName(word_419_k);
        List<String> allList = getWordListFromPath(ffWordPool);

        testDataStructor = new TestingSearchNode();
        testDataStructor.addData(allList);
        testDataStructor.sort();

        allList.clear();
        ffWordsToSearch.setFileName(word_279_k);
        allList.addAll(getWordListFromPath(ffWordsToSearch));
        testDataStructor.search(allList);
    */
    }

    @Test
    @Order(12)
    @DisplayName("6-ArrayList : Search 279_690 from 419_535")
    public void testArrrayList_Sort_BinarySearch_Search_279_690_WordData_From_419_535_WordPool() {// mod 5
        ffWordPool.setFileName(word_419_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();
        /*        ffWordPool.setFileName(word_419_k);
        List<String> allList = getWordListFromPath(ffWordPool);

        testDataStructor = new TestingArrayList();
        testDataStructor.addData(allList);
        testDataStructor.sort();
        allList.clear();
        ffWordsToSearch.setFileName(word_279_k);

        allList.addAll(getWordListFromPath(ffWordsToSearch));
        testDataStructor.search(allList);
    */
    }

    @Test
    @Order(13)
    @DisplayName("7-SearchNode : Search 419_535 from 419_535")
    public void testSearchNode_Search_419_535_WordData_From_419_535_WordPool() {// mod 10
        ffWordPool.setFileName(word_419_k);
        ffWordsToSearch.setFileName(word_419_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();
    }

    @Test
    @Order(14)
    @DisplayName("7- ArrayList : Search 419_535 from 419_535")
    public void testArrrayList_Sort_BinarySearch_Search_419_535_WordData_From_419_535_WordPool() { // mod 10
        ffWordPool.setFileName(word_419_k);
        ffWordsToSearch.setFileName(word_419_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();
    }

    @Test
    @Order(15)
    @DisplayName("8-SearchNode : Search 1_398_449 from 1_398_449")
    public void testSearchNode_Search_1_398_449_WordData_From_1_398_449_WordPool() {// mod 10
//        ffWordPool.setFileName(ffWordPool);
//        ffWordsToSearch.setFileName(word_419_k);

        List<String> allList = getWordListFromPath(ffAllWords);
        List<String> searchList = getWordListFromPath(ffAllWords);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();
    }

    @Test
    @Order(16)
    @DisplayName("8- ArrayList : Search 1_398_449 from 1_398_449")
    public void testArrrayList_Sort_BinarySearch_Search_1_398_449_WordData_From_1_398_449_WordPool() { // mod 10
//        ffWordPool.setFileName(word_419_k);
//        ffWordsToSearch.setFileName(word_419_k);

        List<String> allList = getWordListFromPath(ffAllWords);
        List<String> searchList = getWordListFromPath(ffAllWords);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();
    }

    public static List<String> getWordListFromPath(FileFundamental fileFundamental) {
        ReadFileService readFileService = new ReadFileManagement(fileFundamental);
        readFileService.read();
        return readFileService.getReadDataList();
    }
}
