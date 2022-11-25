package org.aes.searchnode.fakedata;

import org.aes.searchnode.SearchNode;
import org.aes.searchnode.business.concretes.DataCleariation;
import org.aes.searchnode.core.utilities.DataResult;
import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.ahmeteminsaglik.fileoperation.business.abstracts.ReadFileService;
import org.ahmeteminsaglik.fileoperation.business.abstracts.WriteFileService;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.WriteFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FakeDataCreation {
//    public FileOperationFacade fileOpsFacade = new FileOperationFacade(
//            new WriteFileManagement(), new ReadFileManagement());

    FileOperationFacade fileOpsFacade;

    public FakeDataCreation() {
        WriteFileService writeFileService = new WriteFileManagement();
        ReadFileService readFileService = new ReadFileManagement();
        fileOpsFacade = new FileOperationFacade(writeFileService, readFileService);
    }

    public List<FileFundamental> getBookFileFundementalList() {
        List<FileFundamental> filePaths = new ArrayList<>();
//        String directory = "src\\main\\java\\org\\aes\\searchnode\\fakedata\\books\\";
//        String directory = "src\\main\\java\\org\\aes\\searchnode\\fakedata\\newWords\\"; //directoryForCreatedWords
//        String directory = "src\\main\\java\\org\\aes\\searchnode\\fakedata\\word\\"; //directory For String Data
//        String directory = "D:\\Bootcamp\\enginDemiroglu\\javacamp\\course-6-springBoot\\books\\"; //directory For String Data
        String directory = "src/main/java/org/aes/searchnode/backupWordData/usedSearchNode/"; //directory For String Data

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(FileSystems.getDefault().getPath(directory));
            for (Path path : directoryStream) {
                FileFundamental fileFundamental = new FileFundamental();
                String nameWithExtension = path.getFileName().toString();
                String fileName = nameWithExtension.substring(0, nameWithExtension.lastIndexOf("."));
                String extension = nameWithExtension.substring(nameWithExtension.lastIndexOf("."));

                fileFundamental.setPath(directory);
                fileFundamental.setFileName(fileName);
                fileFundamental.setFileExtension(extension);
                filePaths.add(fileFundamental);
//                System.out.println("fileFund : "+fileFundamental.getCompletePath());
//                System.out.println("filePaths : "+filePaths.get(0).getCompletePa th());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePaths;
    }


    public void createDataWithSearchNode() {
        SearchNode<String> searchNode = new SearchNode<>();
//        FileOperationFacade fileOpsFacade = new FileOperationFacade(new WriteFileManagement(), new ReadFileManagement());
        FileFundamental newFileFund = new FileFundamental();
//        newFileFund.setPath("C:\\Users\\USER\\Desktop\\SearchNodeGithub\\SearchNode\\src\\main\\java\\org\\aes\\searchnode\\fakedata\\");
//        newFileFund.setFileName("clear-data");
        newFileFund.setPath("src/main/java/org/aes/searchnode/backupWordData/usedSearchNode/");
//        newFileFund.setFileName("data-first-20_000-books");
//        newFileFund.setFileName("20_000-35_000-books");
//        newFileFund.setFileName("35_000-50_000-books");
        newFileFund.setFileName("all-Uniqe-Text-from-40_881-books");
//        newFileFund.setFileName("data-between-10_000-20_000-books");
        newFileFund.setFileExtension(".txt");
        int mod = 0;
        List<FileFundamental> pathList = getBookFileFundementalList();
        final int bookMod = 250;
        for (int i = 0; i < pathList.size(); i++) {
//            System.out.println("path (0) : "+pathList.get(i).getCompletePath());

            read(pathList.get(i));
            System.out.println("Process File :  " + ReadableStringFormat.getReadableValueIntToString((i + 1)) + " | " + ReadableStringFormat.getReadableValueIntToString(pathList.size()) + " | ");
            mod++;
            if (mod % bookMod == bookMod - 1) {
//            System.out.println(" --> line sayisi : " + ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));
//            System.exit(0);
                List<String> cleanReadDataList = fileOpsFacade.getReadDataList();
//            System.out.println(" fileOpsFacade.getReadDataList() size : " + ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));
//            System.out.println(" cleanReadDataList size : " + cleanReadDataList.size());
//            while (fixedValuesInReadDataList == true) {
                cleanReadDataList = fixValueInReadDataListForSearchNode(cleanReadDataList);
//            System.out.println("Total word  : " + ReadableStringFormat.getReadableValueIntToString(cleanReadDataList.size()) + " number from this book");

                //            }
                searchNode.addAll(new ArrayList<>(cleanReadDataList));
//            searchNode.getAll().forEach(e-> System.out.println(e));
//            cleanReadDataList = null;
                fileOpsFacade.clearList();
                searchNode.printSizeOfAddedItems();
//                System.exit(0);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//                if (i >= 50_000) {
//                JOptionPane.showMessageDialog(null, " 100 book read");

//                }
            /*if(i>=100){
                fileOpsFacade.write(newFileFund, searchNode.getAll());
                return;
            }*/
            }

        }
//        if (i >= pathList.size() - 1) {
            System.out.println("Dosyaya yaziliyor. Sonrasinda program durdurulacak file : \n" + newFileFund.getCompletePath());
            fileOpsFacade.write(newFileFund, searchNode.getAll());
//            return;
//        }
/**
 * while(FileExist)
 * {
 * read
 * clear
 * add
 * }
 * */
    }

    private boolean isTextLengthLargerThan3(String text) {
        return text.length() > 3;

    }

    public List<String> fixValueInReadDataListForSearchNode(List<String> readDataList) {
        DataCleariation dataCleariation = new DataCleariation();
        HashSet<String> hashSet = new HashSet<>();
        //List<String> totalWords2 = new ArrayList<>();
        for (String tmp : readDataList) {
            tmp = dataCleariation.trimData(tmp);
//            tmp = dataCleariation.removeWildCards(tmp);
//            System.out.println("islem yapiacak data : "+tmp);
//            System.out.println("tmp before remove : "+tmp);
            //DataResult<String> dataResult = dataCleariation.removeWordsIfNotBelongsToEnglish(tmp);
            tmp = tmp.toLowerCase();
            tmp = dataCleariation.removeWordsIfNotBelongsToEnglish(tmp);
//            fixedValuesInReadDataList = dataResult.isSuccess();
//            System.out.println("tmp after remove : "+tmp );

//            tmp = dataResult.getData();
//                System.out.println("islem yapiacak data : " + tmp);
            if (tmp != null) {
                if (dataCleariation.hasMultipleWords(tmp)) {
                    List<String> newList = Arrays.stream(tmp.split(" ")).
                            filter(text -> !text.trim().equals("") && isTextLengthLargerThan3(text)).
                            collect(Collectors.toList());
                    hashSet.addAll(newList);//totalWords.addAll(newList);
                } else {
                    if (!tmp.trim().equals("") && isTextLengthLargerThan3(tmp)) {
                        hashSet.add(tmp);//totalWords.add(tmp);
                    }
                }
            }

        }

//        System.out.println("hashset : " + ReadableStringFormat.getReadableValueIntToString(hashSet.size()));
//        System.out.println("totalWords: " + ReadableStringFormat.getReadableValueIntToString(totalWords.size()));
//        System.out.println("hashset data : ");
//        hashSet.forEach(System.out::println);


//        return new ArrayList<>(hashSet);
//        fileOpsFacade.write(cleanList);
//        System.out.println("hashset size : " + hashSet.size());

        return new ArrayList<>(hashSet);//totalWords;
    }
/*       todo broken
    public void createData() {

//        System.out.println(getReadableValueIntToString(123));
//        System.out.println(getReadableValueIntToString(1234));
//        System.out.println(getReadableValueIntToString(123456));
//        System.out.println(getReadableValueIntToString(1234567));
//        System.exit(0);

        */

    /**
     * get files
     * <p>
     * read files
     * clear files
     * write files
     * <p>
     * read files
     * clear files
     * write files
     *//*

//        FileFundamental newFileFund = ConfigFileFundamental.getFileFundamental();
//        newFileFund.setFileName("Words-From-Books-English-Readers");

        FileFundamental newFileFund = new FileFundamental();
        newFileFund.setPath("C:\\Users\\USER\\Desktop\\SearchNodeGithub\\SearchNode\\src\\main\\java\\org\\aes\\searchnode\\fakedata\\");
        newFileFund.setFileName("clear-data");
        newFileFund.setFileExtension(".txt");


        int newFileIndex = 0;
        List<FileFundamental> pathList = getBookFileFundementalList();
        int modFile = 500;
//        int lastMovedFolderIndex = 0;
        for (int i = 0; i < pathList.size(); i++) {
            System.out.println("file index : " + i);

            read(pathList.get(i));
            if ((i > 0 && i % modFile == 0) || i == (pathList.size() - 1)) {
                System.out.println("i : " + i + " pathsize : " + pathList.size());
                System.out.println("listedeki data sayisi : " + ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));
                newFileIndex++;
                newFileFund.setFileName("Processed-test-data");
                if (i > 0 || pathList.size() < modFile) {
                    System.out.println("temizlik oncesi data size : " + ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));
                    List<String> cleanReadDataList = fixValueInReadDataList(fileOpsFacade.getReadDataList());
                    System.out.println("temizlik Sonrasi data size : " + ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));

                    List<String> cleanReadDataList2 = fixValueInReadDataList(cleanReadDataList);
                    System.out.println("2. temizlik Sonrasi data size : " + ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));
                    write(newFileFund, cleanReadDataList2);
                 *//*   for (int j = lastMovedFolderIndex; j <= i; j++) {
                        String destinationPath = "src\\main\\java\\org\\aes\\searchnode\\fakedata\\old books\\";
                        moveFile(pathList.get(j), destinationPath);
                    }*//*
//                    lastMovedFolderIndex = i;

                    fileOpsFacade.clearList();
                    try {
                        System.out.println("Temizlendikten sonraki listedeki data sayisi : " + fileOpsFacade.getReadDataList().size());
                        System.out.println(i + " out of  " + (pathList.size() - 1) + " is read remaining files number : " + (pathList.size() - i));
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                        throw new RuntimeException(e);
                    }
                }

            }

           *//* for (FileFundamental tmpFileFund : pathList) {
                read(tmpFileFund);
            }*//*


        }
//        read(newFileFund);
//        cleanReadDataList = clearReadDataList(fileOpsFacade.getReadDataList());
//        write(newFileFund, cleanReadDataList);

    }*/
    private void moveFile(FileFundamental fileFund, String destinationPath) {
        File file = new File(fileFund.getCompletePath());
        fileFund.setPath(destinationPath);
        boolean result = file.renameTo(new File(fileFund.getCompletePath()));
        if (!result) {
            System.err.println("### FILE  MOVE ERROR : " + result);
        } else {
            System.out.println(fileFund.getFileName() + "   >>>  MOVED SUCCESSFUL : " + result);
        }

    }
/*
        todo broken
    public List<String> fixValueInReadDataList(List<String> readDataList) {
        DataCleariation dataCleariation = new DataCleariation();
//        fileOpsFacade.read();
//        System.out.println(getClass().getSimpleName() + " > Read data : console check : ");
        Set<String> hashSet = new HashSet<>();
        System.out.println("data line  size : " + ReadableStringFormat.getReadableValueIntToString(readDataList.size()));
        List<String> totalWords = new ArrayList<>();
        for (String tmp : readDataList) {
//            System.out.println("======================================");
//            System.out.println("islem yapiacak data : " + tmp);
            tmp = dataCleariation.trimData(tmp);
//            System.out.println("islem yapiacak data : "+tmp);
            if (tmp.length() > 3) {
                tmp = tmp.toLowerCase();
//            System.out.println("islem yapiacak data : "+tmp);
                tmp = dataCleariation.removeWildCards(tmp);
//            System.out.println("islem yapiacak data : "+tmp);
                tmp = dataCleariation.removeWordsIfNotBelongsToEnglish(tmp);
//                System.out.println("islem yapiacak data : " + tmp);
                if (dataCleariation.hasMultipleWords(tmp)) {
//                System.out.println("gelen data : "+tmp);
                    List<String> newList = Arrays.stream(tmp.split(" ")).
                            filter(text -> !text.equals("")).
                            collect(Collectors.toList());


                    hashSet.addAll(newList);
//                    System.out.println("patlamadan onceki totalWords : " + totalWords.size() + " eklencek olan size : " + newList.size());
                    totalWords.addAll(newList);
                } else {
                    if (!tmp.trim().equals("")) {
                        hashSet.add(tmp);
                        totalWords.add(tmp);
                    }
                }

            }
        }

        System.out.println("hashset : " + ReadableStringFormat.getReadableValueIntToString(hashSet.size()));
        System.out.println("totalWords: " + ReadableStringFormat.getReadableValueIntToString(totalWords.size()));
//        System.out.println("hashset data : ");
//        hashSet.forEach(System.out::println);


        return new ArrayList<>(hashSet);
//        fileOpsFacade.write(cleanList);
//        System.out.println("hashset size : " + hashSet.size());

    }
*/

    public void read(FileFundamental fileFund) {
//        System.out.println("!!!gelen fileFund : "+fileFund.getCompletePath());
        fileOpsFacade.read(fileFund);
    }

    public void read(List<FileFundamental> fileFundList) {
        fileOpsFacade.read(fileFundList);
    }

    public void write(FileFundamental fileFund, String text) {
        fileOpsFacade.write(fileFund, text);
    }

    public void write(FileFundamental fileFund, List<String> textList) {
        fileOpsFacade.write(fileFund, textList);
    }

    public void append(FileFundamental fileFund, String text) {
        fileOpsFacade.append(fileFund, text);
    }

    public void append(FileFundamental fileFund, List<String> textList) {
        fileOpsFacade.append(fileFund, textList);
    }

    public List<String> getReadDataList() {
        return fileOpsFacade.getReadDataList();
    }

}
