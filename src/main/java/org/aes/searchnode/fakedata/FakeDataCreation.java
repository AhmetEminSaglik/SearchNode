package org.aes.searchnode.fakedata;

import org.aes.searchnode.business.concretes.DataCleariation;
import org.aes.searchnode.core.utilities.ReadableStringFormat;
import org.ahmeteminsaglik.fileoperation.business.abstracts.ReadFileService;
import org.ahmeteminsaglik.fileoperation.business.abstracts.WriteFileService;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.WriteFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class FakeDataCreation {
    /*TODO buradaki read&write functionlar service olarak degistirilebilir/*/


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
        String directory = "src\\main\\java\\org\\aes\\searchnode\\fakedata\\word\\"; //directory For String Data


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
                System.out.println("processed file :"+fileFundamental.getCompletePath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePaths;
    }

    static int hashsetSize = 0;
    static int listSize = 0;

    public void createData() {

//        System.out.println(getReadableValueIntToString(123));
//        System.out.println(getReadableValueIntToString(1234));
//        System.out.println(getReadableValueIntToString(123456));
//        System.out.println(getReadableValueIntToString(1234567));
//        System.exit(0);

        /**
         * get files
         *
         * read files
         * clear files
         * write files
         *
         * read files
         * clear files
         * write files
         * */

//        FileFundamental newFileFund = ConfigFileFundamental.getFileFundamental();
//        newFileFund.setFileName("Words-From-Books-English-Readers");

        FileFundamental newFileFund = new FileFundamental();
        newFileFund.setPath("C:\\Users\\USER\\Desktop\\SearchNodeGithub\\SearchNode\\src\\main\\java\\org\\aes\\searchnode\\fakedata\\");
        newFileFund.setFileName("clear-data");
        newFileFund.setFileExtension(".txt");


        int newFileIndex = 0;
        List<FileFundamental> pathList = getBookFileFundementalList();
        int modFile = 500;
        int lastMovedFolderIndex = 0;
        for (int i = 0; i < pathList.size(); i++) {
            System.out.println("file index : " + i);

            read(pathList.get(i));
            if ((i > 0 && i % modFile == 0) || i == (pathList.size() - 1)) {
                System.out.println("i : " + i + " pathsize : " + pathList.size());
                System.out.println("listedeki data sayisi : " + ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));
                newFileIndex++;
                newFileFund.setFileName("Processed-test-data");
                if (i > 0 || pathList.size() < modFile) {
                    System.out.println("temizlik oncesi data size : "+ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));
                    List<String> cleanReadDataList = fixValueInReadDataList(fileOpsFacade.getReadDataList());
                    System.out.println("temizlik Sonrasi data size : "+ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));

                    List<String> cleanReadDataList2 = fixValueInReadDataList(cleanReadDataList);
                    System.out.println("2. temizlik Sonrasi data size : "+ReadableStringFormat.getReadableValueIntToString(fileOpsFacade.getReadDataList().size()));
                    write(newFileFund, cleanReadDataList2);
                 /*   for (int j = lastMovedFolderIndex; j <= i; j++) {
                        String destinationPath = "src\\main\\java\\org\\aes\\searchnode\\fakedata\\old books\\";
                        moveFile(pathList.get(j), destinationPath);
                    }*/
                    lastMovedFolderIndex = i;

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

           /* for (FileFundamental tmpFileFund : pathList) {
                read(tmpFileFund);
            }*/


        }
//        read(newFileFund);
//        cleanReadDataList = clearReadDataList(fileOpsFacade.getReadDataList());
//        write(newFileFund, cleanReadDataList);

    }

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
            tmp = dataCleariation.clearData(tmp);
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
        hashsetSize = hashSet.size();
        listSize = totalWords.size();
//        System.out.println("hashset data : ");
//        hashSet.forEach(System.out::println);


        return new ArrayList<>(hashSet);
//        fileOpsFacade.write(cleanList);
//        System.out.println("hashset size : " + hashSet.size());

    }

    public void read(FileFundamental fileFund) {
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
