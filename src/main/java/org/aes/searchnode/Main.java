package org.aes.searchnode;


import org.aes.searchnode.business.concretes.FileOperationFacade;
import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.entities.concretes.FileFundamental;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractReadFile;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractWriteFile;
import org.aes.searchnode.dataaccess.concretes.fileoperation.*;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.*;
import org.aes.searchnode.entities.example.Student;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;
import org.aes.searchnode.fakedata.FakeDataCreation;
//import org.aes.searchnode.fakedata.StringText;

import java.util.*;
import java.util.logging.Logger;

public class Main {
//    static PrimitiveWrapper primitiveWrapper = new PrimitiveWrapper();

    static void printList(Object[] objects, PriorityFieldValue priorityFieldValue, String fieldName) {
        System.out.println("----------------------------  ARRAY : ");
        System.out.println(objects.getClass().getSimpleName());
        try {

            for (Object tmp : objects) {
                System.out.println("Read value : " + priorityFieldValue.getValueOfField(tmp, fieldName));
                printPriorityCharOfText(priorityFieldValue.getValueOfField(tmp, fieldName).toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void printList(List<?> objects, PriorityFieldValue priorityFieldValue, String fieldName) {
        System.out.println("++++++++++++++++++++++++++++  LISTE : ");
        System.out.println(objects.getClass().getSimpleName());
        try {
            for (Object tmp : objects) {
                System.out.println("Read value : " + priorityFieldValue.getValueOfField(tmp, fieldName));
                printPriorityCharOfText(priorityFieldValue.getValueOfField(tmp, fieldName).toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void printPriorityCharOfText(String text) {
        PriorityCharManager priorityCharManager = new PriorityCharManager();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            DataResult<PriorityChar> dataResult = priorityCharManager.getPriorityChar(chars[i]);
//            System.out.println(dataResult.toString());
            System.out.println("PriorityChar : " + dataResult.getData() + " / message : " + dataResult.getMsg());
//            System.exit(0);
//            System.out.println("PriorityChar : "+);;

        }
    }

    static void printIntegerAscii() {

        System.out.println("0 : " + (int) ('0'));
        System.out.println("1 : " + (int) ('1'));
        System.out.println("2 : " + (int) ('2'));
        System.out.println("3 : " + (int) ('3'));
        System.out.println("4 : " + (int) ('4'));
        System.out.println("5 : " + (int) ('5'));
        System.out.println("6 : " + (int) ('6'));
        System.out.println("7 : " + (int) ('7'));
        System.out.println("8 : " + (int) ('8'));
        System.out.println("9 : " + (int) ('9'));
        System.exit(0);
    }


    public static void main(String[] args) throws NotFoundAnyDeclaredFieldException, NotFoundRequestedFieldException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException, InvalidFieldOrFieldNameException {
//        Logger logger=Logger.getLogger(Main.class.getName());
//        logger.info("log test");
//        Logger logger= Logger.getLogger("STRING VALLLLLL ");
//        logger.info("info");
//        logger.warning("warning");
//        logger.fine("fine");
//        logger.severe("severe");
//        System.exit(0);

        /*TODO suan yaklasik 83.500 veri var simdilik yeterli. searchNode'a bu verileri aktarip sirasiyla alip txt'ye yazdirmak istiyorum. */
        /*TODO
         *  test edilecek senaryo : bu karmasik listeyi hem search node ile random 100 kelime arama yapicaz, hem de liste ile arama yapicaz
         *  hem listeyi hem searchnode'u bastan sonra sirali yazdircaz.*/

        //FileFundamental fileFundWrite = new FileFundamental();
   /*
        fileFundWrite.setPath("src/main/java/org/aes/searchnode/fakedata/")
                .setFileName("demoWordData")
                .setFileExtension(".txt");
        AbstractWriteFile writeFile = new WriteFileImpl(fileFundWrite);
        writeFile.appendNextLine("try append1");

        FileFundamental fileFundRead = new FileFundamental();
        fileFundRead.setPath("src/main/java/org/aes/searchnode/fakedata/")
                .setFileName("demoWordData")
                .setFileExtension(".txt");
        AbstractReadFile readFile = new ReadFileImpl(fileFundRead);
        readFile.read();
        List<String> list = readFile.getReadDataList();
        System.out.println("read list : ");

        for(String tmp : list){
            System.out.println("data from list : " +tmp);
        }
*/


     /*   FakeDataCreation fakeData = new FakeDataCreation();
        fakeData.createData();
        FileFundamental readFileFund= new FileFundamental();
        readFileFund.setPath();
//        FileFundamental writeFileFund= new FileFundamental();
        fakeData.read(readFileFund);
        fakeData.writeReadData();
//        fakeData.setReadFileFund(readFileFund);
//        fakeData.setWriteFileFund(writeFileFund);*/


//        System.exit(0);
        /*TODO search kismi tamam gibi. diger fonksiyonlar eklenecek. ondan Sonrasina bakariz.*/
//        new OxfordAPITest();
//        System.exit(0);
        long memListStart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

      /*  StringText textData = new StringText();
        List<String> wordList = new ArrayList<>();
        for (String tmp : textData.textList) {
            wordList.addAll(Arrays.asList(tmp.split(" ")));

        }*/

        FakeDataCreation fakeDataCreation = new FakeDataCreation();

//for(String tmp : wordList){
//        fakeDataCreation.clearDataInFile();
        List<FileFundamental> fileList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            fileList.add(new FileFundamental().setPath("src/main/java/org/aes/searchnode/fakedata/")
                    .setFileName("demo" + i)
                    .setFileExtension(".txt"));

        }
        FileOperationFacade fileOpsFacade = fakeDataCreation.fileOpsFacade;
//        fakeDataCreation.clearDataInFile();
        fileOpsFacade.read(fileList);
        List<String> dataList = fileOpsFacade.getReadDataList();
        System.out.println("list data size facade :  " + fileOpsFacade.getReadDataList().size());
        FileFundamental fileToWrite = new FileFundamental().setPath("src/main/java/org/aes/searchnode/fakedata/")
                .setFileName("demo-result")
                .setFileExtension(".txt");

        fileOpsFacade.write(fileToWrite, dataList);
        System.out.println("list data size facade :  " + fileOpsFacade.getReadDataList().size());


//}
        System.exit(0);
//     SearchNode<String> SNStringTest = new SearchNode<>();


//        System.out.println("SNStringTest.getNodeData().getNextWayDirectionTotalValue() : " + SNStringTest.getNodeData().getNextWayDirectionTotalValue());
//        System.out.println(SNStringTest.getReachableNWD().getNextWayOfChar(new PriorityChar('a', (int) 'a')).getData().getReachableNWD().getNextWayOfChar(new PriorityChar('l', (int) 'l')).getData().getNodeData().getNextWayDirectionTotalValue());

        String[] text = {/*"K",*/"Kayseri", "Kayseri", "Çözüm", "Yemek", "Kalem", "Ulke", "Ingilizce"};
        Character[] characters = {'a', 'b', 'c', 'K'};
        Integer[] integers = {1, 111, 11, 2, -2, -0, 2};
        Student[] students = {
                new Student("Ahmet", "SAGLIK", 24, 1001),
                new Student("Omer", "Koramaz", 20, 1002),
                new Student("Aynur", "YILDIRIM", 25, 1003),
        };

    }
}