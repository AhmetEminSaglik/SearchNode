package org.aes.searchnode;

import org.aes.searchnode.business.concretes.prioritychar.PriorityCharManager;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.dataaccess.concretes.priorityfield.PriorityFieldValue;
import org.aes.searchnode.entities.concretes.*;
import org.aes.searchnode.entities.example.Student;
import org.aes.searchnode.exception.ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException;
import org.aes.searchnode.exception.InvalidFieldOrFieldNameException;
import org.aes.searchnode.exception.NotFoundAnyDeclaredFieldException;
import org.aes.searchnode.exception.NotFoundRequestedFieldException;
import org.aes.searchnode.fakedata.DownloadBookTxt;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.WriteFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
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

    private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    static void downloadFile() {
        FileFundamental fileFund = new FileFundamental();
        int errCounter = 0;
        int i = 1; //70_000 te kaldim
        DownloadBookTxt downloadBookTxt = new DownloadBookTxt();
        while (true) {
//            fileFund.setPath("src\\main\\java\\org\\aes\\searchnode\\fakedata\\books\\");
            fileFund.setPath("src/main/resources/");
            fileFund.setFileName(i + "");
            fileFund.setFileExtension(".txt");
            try {

                downloadBookTxt.download(fileFund);
                System.out.println("file is Downloaded " + fileFund.getFileName());
                errCounter = 0;
            } catch (Exception e) {
                errCounter++;
                System.out.println("error occured : errCounter : " + errCounter + " Could not find any more data. Download is finished .");
            }
            if (errCounter == 10_000) {
                System.out.println("errCounter : " + errCounter + " Could not find any more data. Download is finished .");
                break;
            }
            if (i > 80_000) {
                System.out.println("Downloaded 10_000 files. It is enough for now.");
                break;
            }
            i++;
//            System.exit(0);
        }
    }

    public static void main(String[] args) throws NotFoundAnyDeclaredFieldException, NotFoundRequestedFieldException, ClassMatchFailedBetweenPriorityFieldOrderAndPriorityFieldValueException, InvalidFieldOrFieldNameException, InterruptedException {

        new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement());

        System.exit(0);


        downloadFile();
        JOptionPane.showMessageDialog(null, "indirme tamamlandi");
//        shutdownComputer();
//        System.exit(0);

//        FakeDataCreation fakeDataCreation = new FakeDataCreation();
//        fakeDataCreation.createData();
//        fakeDataCreation.read(fakeDataCreation.getBookFileFundementalList());
//        fakeDataCreation.fixValueInReadDataList(fakeDataCreation.getReadDataList());
//        System.exit(0);
//fakeDataCreation.createData();

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

//        FakeDataCreation fakeDataCreation = new FakeDataCreation();

//for(String tmp : wordList){
//        fakeDataCreation.clearDataInFile();
        List<FileFundamental> fileList = new ArrayList<>();
        for (int j = 1; j <= 3; j++) {
            fileList.add(new FileFundamental().setPath("src/main/java/org/aes/searchnode/fakedata/")
                    .setFileName("demo" + j)
                    .setFileExtension(".txt"));

        }
//        FileOperationFacade fileOpsFacade = fakeDataCreation.fileOpsFacade;
//        fakeDataCreation.clearDataInFile();
//        fileOpsFacade.read(fileList);
//        List<String> dataList = fileOpsFacade.getReadDataList();
//        System.out.println("list data size facade :  " + fileOpsFacade.getReadDataList().size());
//        FileFundamental fileToWrite = new FileFundamental().setPath("src/main/java/org/aes/searchnode/fakedata/")
//                .setFileName("demo-result")
//                .setFileExtension(".txt");
//
//        fileOpsFacade.write(fileToWrite, dataList);
//        System.out.println("list data size facade :  " + fileOpsFacade.getReadDataList().size());


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

    static void shutdownComputer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("shutdown -s -t 5");
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}