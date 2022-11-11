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
                /*System.out.println("getPath : "+fileFundamental.getPath());
                System.out.println("getFileName : "+fileFundamental.getFileName());
                System.out.println("getExtension : "+fileFundamental.getExtension());
                System.out.println("getCompletePath  : "+fileFundamental.getCompletePath());*/
                filePaths.add(fileFundamental);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePaths;
    }

    public void createData() {
        List<FileFundamental> pathList = getBookFileFundementalList();
        ConfigFileFundamental.getFileFundamental().setFileName("Words-From-Books-English-Readers");
        for (FileFundamental tmpFileFund : pathList) {
//            System.out.println("gelen fileFund : "+tmpFileFund.getCompletePath());
            /*StringBuilder stringBuilder = new StringBuilder(tmpPath);
            int pathEndIndex = stringBuilder.lastIndexOf("\\");
            int fileNameEndIndex = stringBuilder.lastIndexOf(".");
            System.out.println(tmpPath);*/
//            fileOpsFacade.read(new FileFundamental().setCompletePath(tmpPath));
            fileOpsFacade.read(tmpFileFund);
            fileOpsFacade.clearList();

        }
        fileOpsFacade.write(fileOpsFacade.getReadDataList());


    }

    public void clearDataInFile() {
        DataCleariation dataCleariation = new DataCleariation();
//        fileOpsFacade.read();
//        System.out.println(getClass().getSimpleName() + " > Read data : console check : ");
        Set<String> hashSet = new HashSet<>();
        for (String tmp : fileOpsFacade.getReadDataList()) {
            tmp = dataCleariation.clearData(tmp);
            if (tmp.length() > 3) {
                tmp = tmp.toLowerCase();
                tmp = dataCleariation.removeWildCards(tmp);
                tmp = dataCleariation.removeWordsIfNotBelongsToEnglish(tmp);
                if (dataCleariation.hasMultipleWords(tmp)) {
                    hashSet.addAll(Arrays.asList(tmp.split(" ")));
                } else {
                    hashSet.add(tmp);
                }
            }
        }
//        System.out.println("hashset data : ");
//        hashSet.forEach(System.out::println);

        List<String> cleanList = new ArrayList<>(hashSet);
        fileOpsFacade.write(cleanList);
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
