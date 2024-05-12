package deprecated;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@Deprecated
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlgorithmComplexityTest {/*
    private static CalculateDataStructorComplexity calculateDataStructorComplexity;
    private static SearchNodeDPI<String> searchNodeDPI;
    private static List<String> listPool;
    private static FileFundamental ffAllWords = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/DataToTest/")
            .setFileName("Word-Data-1_398_449")
            .setFileExtension(".txt");

    static String word_13_k = "word-data-13-985";
    static String word_279_k = "word-data-279-690";
    static String word_466_k = "word-data-466-150";
    FileFundamental ffWordPool = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/mod-test-data/")
            .setFileExtension(".txt");
    FileFundamental ffWordsToSearch = new FileFundamental()
            .setPath("src/main/java/org/aes/searchnode/fakedata/mod-test-data/")
//            .setFileName("test-data-mod-10")
            .setFileExtension(".txt");

    @BeforeEach
    public void initializeTestingDataStructor() {
        searchNodeDPI = new SearchNodeDPI<>();
        listPool = new ArrayList<>();
    }

    @AfterEach
    public void resetTestingDataStructor() {
        calculateDataStructorComplexity = null;
        listPool.clear();
    }

    @Test
    @Order(1)
    @DisplayName("1-SearchNode : Search 13_935 from 13_935")
    public void testSearchNode_Search_13_985_WordData_From_13_985_WordPool() {
        ffWordPool.setFileName(word_13_k);
        ffWordsToSearch.setFileName(word_13_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();

        searchNodeDPI.addAll(getWordListFromPath(ffWordPool));
        int result[] = resultSearchNodeSearchItems(searchList);

        int expected = 13_985;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    @DisplayName("1-ArrayList : Search  13_935 from 13_935")
    //@disabled
    public void testArrrayList_Sort_BinarySearch_Search_13_985_WordData_From_13_985_WordPool() {// mod 5
        ffWordPool.setFileName(word_13_k);
        ffWordsToSearch.setFileName(word_13_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();

        listPool.addAll(allList);
        int[] result = resultArraylistSearchItems(searchList);

        int expected = 13_985;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
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

        searchNodeDPI.addAll(getWordListFromPath(ffWordPool));
        int[] result = resultSearchNodeSearchItems(searchList);

        int expected = 13_985;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 265_705;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    @DisplayName("2-ArrayList : Search 279_690 from 13_935")
    //@disabled
    public void testArrrayList_Sort_BinarySearch_Search_279_690_WordData_From_13_985_WordPool() {// mod 5
        ffWordPool.setFileName(word_13_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();

        listPool.addAll(allList);
        int[] result = resultArraylistSearchItems(searchList);

        int expected = 13_985;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 265_705;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
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

        searchNodeDPI.addAll(getWordListFromPath(ffWordPool));
        int result[] = resultSearchNodeSearchItems(searchList);

        int expected = 13_985;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(6)
    @DisplayName("3-ArrayList : Search 13_935 from 279_690")
    ////@disabled
    public void testArrrayList_Sort_BinarySearch_Search_13_985_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_279_k);
        ffWordsToSearch.setFileName(word_13_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();

        listPool.addAll(allList);
        int[] result = resultArraylistSearchItems(searchList);

        int expected = 13_985;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
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

        searchNodeDPI.addAll(getWordListFromPath(ffWordPool));
        int result[] = resultSearchNodeSearchItems(searchList);

        int expected = 279_690;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(8)
    @DisplayName("4-ArrayList : Search 279_690 from 279_690")
    ////@disabled
    public void testArrrayList_Sort_BinarySearch_Search_279_690_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_279_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();

        listPool.addAll(allList);
        int result[] = resultArraylistSearchItems(searchList);

        int expected = 279_690;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(9)
    @DisplayName("5-SearchNode : Search 466_150 from 279_690")
    public void testSearchNode_Search_466_150_WordData_From_279_690_WordPool() {// mod 5
//        ffWordPool.setFileName(word_699_k);
//        ffWordsToSearch.setFileName(word_489_k);
        ffWordPool.setFileName(word_279_k);
        ffWordsToSearch.setFileName(word_466_k);


        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();

        searchNodeDPI.addAll(getWordListFromPath(ffWordPool));
        int result[] = resultSearchNodeSearchItems(searchList);

        int expected = 93_230;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 372_920;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(10)
    @DisplayName("5-ArrayList : Search 466_150 from 279_690")
    ////@disabled
    public void testArrrayList_Sort_BinarySearch_Search_466_150_WordData_From_279_690_WordPool() {// mod 5
        ffWordPool.setFileName(word_279_k);
        ffWordsToSearch.setFileName(word_466_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();

        listPool.addAll(allList);
        int result[] = resultArraylistSearchItems(searchList);

        int expected = 93_230;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 372_920;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(11)
    @DisplayName("6-SearchNode : Search 279_690 from 466_150")
    public void testSearchNode_Search_279_690_WordData_From_466_150_WordPool() {// mod 10
        ffWordPool.setFileName(word_466_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();

        searchNodeDPI.addAll(getWordListFromPath(ffWordPool));
        int result[] = resultSearchNodeSearchItems(searchList);

        int expected = 93_230;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 186_460;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(12)
    @DisplayName("6-ArrayList : Search 279_690 from 466_150")
    ////@disabled
    public void testArrrayList_Sort_BinarySearch_Search_279_690_WordData_From_466_150_WordPool() {// mod 5
        ffWordPool.setFileName(word_466_k);
        ffWordsToSearch.setFileName(word_279_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();

        listPool.addAll(allList);
        int result[] = resultArraylistSearchItems(searchList);

        int expected = 93_230;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 186_460;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }


    private static int[] resultSearchNodeSearchItems(List<String> searchList) {
        int[] result = new int[2];
        int foundData = 0;

        for (String tmp : searchList) {
            if (searchNodeDPI.search(tmp).isSuccess()) {
                foundData++;
            }
        }
        result[0] = foundData;
        result[1] = searchList.size() - foundData;

        System.out.println("result[0] : "+result[0]);
        System.out.println("result[1] : "+result[1]);
        return result;
    }

    private static int[] resultArraylistSearchItems(List<String> searchList) {
        int[] result = new int[2];
        int foundData = 0;
        Collections.sort(listPool);
        Object[] objectPool = listPool.toArray();
//        Arrays.binarySearch();
        for (Object tmpTxt : searchList) {
            int resultSearch = Arrays.binarySearch(objectPool, tmpTxt);
            if (resultSearch >= 0) {
                foundData++;
            }

        }
        result[0] = foundData;
        result[1] = searchList.size() - foundData;
        System.out.println("result[0] : "+result[0]);
        System.out.println("result[1] : "+result[1]);
        return result;
    }

    public static List<String> getWordListFromPath(FileFundamental fileFundamental) {
        ReadFileService readFileService = new ReadFileManagement(fileFundamental);
        readFileService.read();
        return readFileService.getReadDataList();
    }

  @Test
    @Order(13)
    @DisplayName("7-SearchNode : Search 13_985 from 466_150")
    public void testSearchNode_Search_13_985_WordData_From_466_150_WordPool() {// mod 10
        ffWordPool.setFileName(word_466_k);
        ffWordsToSearch.setFileName(word_13_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();
        calculateDataStructorComplexity = null;


      searchNodeDPI.addAll(getWordListFromPath(ffWordsToSearch));
        int result[] = resultSearchNodeSearchItems(searchList);

        int expected = 466_150;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = result[1];
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @Order(14)
    @DisplayName("7- ArrayList : Search 13_985 from 466_150")
    ////@disabled
    public void testArrrayList_Sort_BinarySearch_Search_13_985_WordData_From_466_150_WordPool() { // mod 10
        ffWordPool.setFileName(word_466_k);
        ffWordsToSearch.setFileName(word_13_k);

        List<String> allList = getWordListFromPath(ffWordPool);
        List<String> searchList = getWordListFromPath(ffWordsToSearch);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();
    }

    @Test
    @Order(15)
    @DisplayName("8-SearchNode : Search 466_150 from 13_985")
    public void testSearchNode_Search_466_150_WordData_From_13_985_WordPool() {// mod 10
//        ffWordPool.setFileName(ffAllWords);
//        ffWordsToSearch.setFileName(word_466_k);

        List<String> allList = getWordListFromPath(ffAllWords);
        List<String> searchList = getWordListFromPath(ffAllWords);
        System.out.println("All words : "+ffAllWords);
        calculateDataStructorComplexity = new TestingSearchNode(allList, searchList);
        calculateDataStructorComplexity.run();
        calculateDataStructorComplexity = null;


 searchNodeDPI.addAll(getWordListFromPath(ffAllWords));
        int result[] = resultSearchNodeSearchItems(searchList);

        int expected = 1_398_449;
        int actual = result[0];
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = result[1];
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(16)
    @DisplayName("8- ArrayList : Search 466_150 from 13_985")
    ////@disabled
    public void testArrrayList_Sort_BinarySearch_Search_466_150_WordData_From_13_985_WordPool() { // mod 10
//        ffWordPool.setFileName(word_466_k);
//        ffWordsToSearch.setFileName(word_466_k);

        List<String> allList = getWordListFromPath(ffAllWords);
        List<String> searchList = getWordListFromPath(ffAllWords);

        calculateDataStructorComplexity = new TestingArrayList(allList, searchList);
        calculateDataStructorComplexity.run();
    }


*/
}
