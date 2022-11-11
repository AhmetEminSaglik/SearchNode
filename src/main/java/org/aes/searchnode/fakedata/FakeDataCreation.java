package org.aes.searchnode.fakedata;

import org.aes.searchnode.business.concretes.DataCleariation;
import org.aes.searchnode.business.concretes.FileOperationFacade;
import org.aes.searchnode.config.file.ConfigFileFundamental;
import org.aes.searchnode.dataaccess.concretes.fileoperation.ReadFileManagement;
import org.aes.searchnode.dataaccess.concretes.fileoperation.WriteFileManagement;
import org.aes.searchnode.entities.concretes.FileFundamental;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FakeDataCreation {
    /*TODO buradaki read&write functionlar service olarak degistirilebilir/*/


    public FileOperationFacade fileOpsFacade = new FileOperationFacade(
            new WriteFileManagement(), new ReadFileManagement());

    public List<FileFundamental> getBookFileFundementalList() {
        List<FileFundamental> filePaths = new ArrayList<>();
        String directory = "src\\main\\java\\org\\aes\\searchnode\\fakedata\\books\\";
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

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePaths;
    }

    public void createData() {
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

        FileFundamental newFileFund = ConfigFileFundamental.getFileFundamental();
        newFileFund.setFileName("Words-From-Books-English-Readers");

        List<FileFundamental> pathList = getBookFileFundementalList();
        for (FileFundamental tmpFileFund : pathList) {
            read(tmpFileFund);
        }
        List<String> cleanReadDataList = clearReadDataList(fileOpsFacade.getReadDataList());
        write(newFileFund, cleanReadDataList);

//        read(newFileFund);
//        cleanReadDataList = clearReadDataList(fileOpsFacade.getReadDataList());
//        write(newFileFund, cleanReadDataList);

    }

    public List<String> clearReadDataList(List<String> readDataList) {
        DataCleariation dataCleariation = new DataCleariation();
//        fileOpsFacade.read();
//        System.out.println(getClass().getSimpleName() + " > Read data : console check : ");
        Set<String> hashSet = new HashSet<>();
        System.out.println("data line  size : " + readDataList.size());
        List<String> totalWords = new ArrayList<>();
        for (String tmp : readDataList) {
            tmp = dataCleariation.clearData(tmp);
//            if (tmp.length() > 3) {
            tmp = tmp.toLowerCase();
            tmp = dataCleariation.removeWildCards(tmp);
//            tmp = dataCleariation.removeWordsIfNotBelongsToEnglish(tmp);
            if (dataCleariation.hasMultipleWords(tmp)) {
                System.out.println("gelen data : "+tmp);
                List<String> newList = Arrays.stream(tmp.split(" ")).
                        filter(text -> !text.equals("")).
                        collect(Collectors.toList());

                hashSet.addAll(newList);
                totalWords.addAll(newList);
            } else {
                if (!tmp.trim().equals("")) {
                    hashSet.add(tmp);
                    totalWords.add(tmp);
                }
            }

//            }
        }

        System.out.println("hashset : " + hashSet.size());
        System.out.println("hashset contain space : " + hashSet.contains(""));
        System.out.println("hashset contain space : " + hashSet.contains(" "));
        System.out.println("hashset contain space : " + hashSet.contains("\n"));
        System.out.println("totalWords: " + totalWords.size());
//        System.out.println("------------------------------------");
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

}
