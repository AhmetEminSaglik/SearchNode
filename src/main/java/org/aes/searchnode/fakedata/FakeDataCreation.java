package org.aes.searchnode.fakedata;

import org.aes.searchnode.business.abstracts.fileoperation.ReadFileService;
import org.aes.searchnode.business.abstracts.fileoperation.WriteFileService;
import org.aes.searchnode.business.concretes.DataCleariation;
import org.aes.searchnode.business.concretes.FileOperationFacade;
import org.aes.searchnode.dataaccess.concretes.fileoperation.ReadFileManagement;
import org.aes.searchnode.dataaccess.concretes.fileoperation.WriteFileManagement;

import java.util.*;

public class FakeDataCreation {
    /*TODO buradaki read&write functionlar service olarak degistirilebilir/*/

    ReadFileService readFileService = new ReadFileManagement();
//    List<String> listData = readFileService.getReadDataList();//new ArrayList<>();// readFileService.getReadDataList();

    WriteFileService writeFileService = new WriteFileManagement();
    public FileOperationFacade fileOpsFacade = new FileOperationFacade(writeFileService, readFileService);

    public void clearDataInFile() {
        DataCleariation dataCleariation = new DataCleariation();
        fileOpsFacade.read();
        System.out.println("Read data : console check : ");
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
        System.out.println("hashset size : " + hashSet.size());

    }
  /*  public void read() {
        readFileService.read();
    }

    public void read(FileFundamental fileFund) {
        readFileService.read(fileFund);
    }

    public void read(List<FileFundamental> fileFund) {
        readFileService.read(fileFund);
    }

    public void writeReadData() {
        writeFileService.write(listData);
    }

    public void writeReadData(FileFundamental fileFund) {
        writeFileService.write(fileFund, listData);
    }

    public void write(String text) {
        writeFileService.write(text);
    }

    public void write(FileFundamental fileFund, String text) {
        writeFileService.write(fileFund, text);
    }

    public void write(List<String> textList) {
        writeFileService.write(textList.get(0));
        textList.remove(0);
        writeFileService.append(textList);
    }

    public void write(FileFundamental fileFund, List<String> textList) {

        writeFileService.write(fileFund,textList.get(0));
        textList.remove(0);
        writeFileService.append(fileFund, textList);
    }

    public void append(String text) {
        writeFileService.append(text);
    }

    public void append(FileFundamental fileFund, String text) {
        writeFileService.append(fileFund, text);
    }

    public void append(List<String> textList) {
        writeFileService.append(textList);
    }

    public void append(FileFundamental fileFund, List<String> textList) {
        writeFileService.append(fileFund, textList);
    }*/



/*
    public List<String> getListData() {
        return listData;
    }

    public void setListData(List<String> listData) {
        this.listData = listData;
    }*/

}
