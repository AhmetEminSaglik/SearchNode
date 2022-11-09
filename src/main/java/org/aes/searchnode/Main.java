package org.aes.searchnode;


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
        /*TODO suan yaklasik 83.500 veri var simdilik yeterli. searchNode'a bu verileri aktarip sirasiyla alip txt'ye yazdirmak istiyorum. */


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
        fakeDataCreation.clearDataInFile();
        System.out.println("list data size : " + fakeDataCreation.getListData().size());

//}
        System.exit(0);
//        HashSet<String> set = new HashSet<>(wordList);
//        System.out.println("uniqe word/set size : " + set.size());

//        List<String> objectList = (List<String>) Arrays.asList(set.toArray());
//        System.out.println("objectList size :" + objectList.size());
        SearchNode<String> SNStringTest = new SearchNode<>();

 /*       for (String tmp : wordList) {
            SNStringTest.add(tmp);
        }*/
        System.out.println("SNStringTest.getNodeData().getNextWayDirectionTotalValue() : " + SNStringTest.getNodeData().getNextWayDirectionTotalValue());
        System.out.println(SNStringTest.getReachableNWD().getNextWayOfChar(new PriorityChar('a', (int) 'a')).getData().getReachableNWD().getNextWayOfChar(new PriorityChar('l', (int) 'l')).getData().getNodeData().getNextWayDirectionTotalValue());
        /*System.out.println("wordList : " + wordList.size());
        for (String tmp : wordList) {
            DataResult<DataInfo> dataResult = SNStringTest.search(tmp);
//            if (dataResult.getData() != null && dataResult.getData().getNumberOfhowManyTimesAddedThisValue() > 10) {
//                a++;
            System.out.println("Aranacak kelime :" + tmp);
            if (*//*tmp.trim().length()>0&&*//*dataResult.getData() != null) {
                System.out.println("Data search : " + tmp + " : --> " + dataResult.getData().getValue() + " : " + dataResult.getData().getNumberOfhowManyTimesAddedThisValue());
            }
            System.out.println("toplam obje sayisi : " + CreatedNWDSNNumberCalculation.getNodeNumber());
//            }

        }*/
       /* long memListfinish = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("memListStart : " + memListStart);
        System.out.println("memListfinish : " + memListfinish);
        System.out.println("memJustListefinish : " + memJustListefinish);
        System.out.println("memListfinish - memListStart " + ((memListfinish - memListStart)/1024));
        System.out.println("memJustListefinish - memListStart " + ((memJustListefinish - memListStart)/1024));
        double ratio=(double) (memListfinish - memListStart)/ (double) (memJustListefinish - memListStart);
        System.out.println("benim algoritma /sadece liste degeri  : " +ratio);
        System.out.println("benim algoritma suan icin "+ratio + " kat daha fazla memory yiyor (byte bazinda hesapladim yanlis bilmiyorsam)");
        System.out.println("test : contains(demoRandom) : "+SNStringTest.contains("demoRandom"));
        System.out.println("test : contains(say) : "+SNStringTest.contains("kavrami"));
        System.out.println("test : contains(say) : "+SNStringTest.search("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println("test : contains(say) : "+SNStringTest.search("kavra"));
        System.out.println(SNStringTest.getReachableNWD().getNextWayOfChar(new PriorityChar('a',(int)'a')).getData().getNodeData().getNextWayDirectionTotalValue());
//        System.out.println(SNStringTest.getReachableNWD().getNextWayOfChar(new PriorityChar('X',(int)'X')).getData().getReachableNWD().getNextWayOfChar(new PriorityChar('M',(int)'M')).getData().getReachableNWD().getNextWayOfChar(new PriorityChar('L',(int)'L')).getData().getNodeData().getLocationStringAddress());
//        System.out.println(SNStringTest.getReachableNWD().getNextWayOfChar(new PriorityChar('X',(int)'X')).getData().getReachableNWD().getNextWayOfChar(new PriorityChar('M',(int)'M')).getData().getReachableNWD().getNextWayOfChar(new PriorityChar('L',(int)'L')).getData().getNodeData().getListDataInfo().get(0).getValue());
        System.out.println(SNStringTest.getNodeData().getNextWayDirectionTotalValue());*/
//        System.out.println(SNStringTest.search("testing"));
//        System.out.println(SNStringTest.search("tost"));
//        System.out.println(SNStringTest.search("tos"));
//        System.out.println(SNStringTest.search("tost3"));
//        System.out.println(SNStringTest.search("tosted"));
//        System.out.println(SNStringTest.search("tosted2"));
//        System.out.println(SNStringTest);
//        System.out.println(SNStringTest.search("package"));
//        System.out.println(SNStringTest.search("response"));
//        System.out.println(SNStringTest.search("gorselini"));
//        System.out.println(SNStringTest.search("Chart"));
       /* for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).equals("package")) {
                System.out.println("Data is found : (" + i + ") : " + objectList.get(i));
            }
        }
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).equals("response")) {
                System.out.println("Data is found : (" + i + ") : " + objectList.get(i));
            }
        }
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).equals("gorselini")) {
                System.out.println("Data is found : (" + i + ") : " + objectList.get(i));
            }
        }
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).equals("Chart")) {
                System.out.println("Data is found : (" + i + ") : " + objectList.get(i));
            }*/
    }

    //        System.exit(0);
        /*System.out.println((int) ',');
        System.out.println((int) '.');
        System.out.println((int) '0');
        System.out.println((char) 47);
        System.out.println((int) '\\');
        System.exit(0);*/
    String[] text = {/*"K",*/"Kayseri", "Kayseri", "Çözüm", "Yemek", "Kalem", "Ulke", "Ingilizce"};
    Character[] characters = {'a', 'b', 'c', 'K'};
    Integer[] integers = {1, 111, 11, 2, -2, -0, 2};
    Student[] students = {
            new Student("Ahmet", "SAGLIK", 24, 1001),
            new Student("Omer", "Koramaz", 20, 1002),
            new Student("Aynur", "YILDIRIM", 25, 1003),
    };

}