package org.aes.searchnode.fakedata;

import org.aes.searchnode.business.concretes.DataCleariation;
import org.aes.searchnode.config.file.ConfigFileFundamental;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractReadFile;
import org.aes.searchnode.dataaccess.concretes.fileoperation.ReadFileImpl;
import org.aes.searchnode.dataaccess.concretes.fileoperation.ReadFileOperation;
import org.aes.searchnode.dataaccess.concretes.fileoperation.WriteFileOperation;
import org.aes.searchnode.entities.concretes.FileFundamental;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractWriteFile;
import org.aes.searchnode.dataaccess.concretes.fileoperation.WriteFileImpl;

import java.util.*;

public class FakeDataCreation {
    /*TODO buradaki read&write functionlar service olarak degistirilebilir/*/
    /*
     * read data, get uniqe data, write data
     * read and write
     * read multiple file, write one file --> reproduce&increase data
     * read same file write same file --> clear dublicated datas in file -----> read() write()
     *
     *
     *
     * read new file write new file           >> read(...) write(...)
     * read new file write old file           >> read(...) write()
     * read old file write new file           >> read() write(...)
     * read old file write old                >> read() write()
     * read multiple file write old file      >> read([...]) write()
     * read multiple file write new file      >> read([...]) write(...)
     *
     * read (...)
     * read()
     * read([...])
     *
     * write(...)
     * write()
     * */

    /*    final String path = "src/main/java/org/aes/searchnode/fakedata/";
        final String fileName = "testData";
        final String extension = ".txt";*/
    FileFundamental readFileFund;//= new FileFundamental();
    FileFundamental writeFileFund;//= new FileFundamental();


    List<String> listData = new ArrayList<>();
    ReadFileOperation readFile = new ReadFileOperation();
    WriteFileOperation writeFile = new WriteFileOperation();

    public void read() {
        listData.addAll(readFile.read());
    /*    if (readFileFund == null) {
            listData.addAll(readFile.read());
        } else {
            listData.addAll(readFile.read(readFileFund));
        }*/
    }

    public void read(FileFundamental fileFund) {
        listData.addAll(readFile.read(fileFund));
    }

    public void read(List<FileFundamental> fileFund) {
        listData.addAll(readFile.read(fileFund));
    }

    public void writeReadData() {
        writeFile.write(listData);
    }

    public void writeReadData(FileFundamental fileFund) {
        writeFile.write(fileFund, listData);
    }

    public void write(String text) {
        writeFile.write(text);
    }

    public void write(FileFundamental fileFund, String text) {
        writeFile.write(fileFund, text);
    }

    public void write(List<String> textList) {
        writeFile.write(textList.get(0));
        textList.remove(0);
        writeFile.append(textList);
    }

    public void write(FileFundamental fileFund, List<String> textList) {

        writeFile.write(textList.get(0));
        textList.remove(0);
        writeFile.append(fileFund, textList);
    }

    public void append(String text) {
        writeFile.append(text);
    }

    public void append(FileFundamental fileFund, String text) {
        writeFile.append(fileFund, text);
    }

    public void append(List<String> textList) {
        writeFile.append(textList);
    }

    public void append(FileFundamental fileFund, List<String> textList) {
        writeFile.append(fileFund, textList);
    }

    public void clearDataInFile() {
        DataCleariation dataCleariation = new DataCleariation();
        read();
        System.out.println("Read data : console check : ");
        Set<String> hashSet = new HashSet<>();
        for (String tmp : listData) {
            tmp = dataCleariation.clearData(tmp);
            if (tmp.length() > 3) {
                tmp = tmp.toLowerCase();
                tmp = dataCleariation.removeWildCards(tmp);
//                tmp = dataCleariation.removeWordsIfNotBelongsToEnglish(tmp);
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
        write(cleanList);
        System.out.println("hashset size : " + hashSet.size());

    }



   /* private String clearData(String text) {
        return text.trim();
    }*/

    public List<String> getListData() {
        return listData;
    }

    public void setListData(List<String> listData) {
        this.listData = listData;
    }

   /* public FileFundamental getReadFileFund() {
        return readFileFund;
    }

    public void setReadFileFund(FileFundamental readFileFund) {
        this.readFileFund = readFileFund;
    }

    public FileFundamental getWriteFileFund() {
        return writeFileFund;
    }

    public void setWriteFileFund(FileFundamental writeFileFund) {
        this.writeFileFund = writeFileFund;
    }*/
}
