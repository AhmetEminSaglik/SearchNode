package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.business.abstracts.ReadFileService;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractReadFile;
import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.ArrayList;
import java.util.List;

public class ReadFileManagement extends FileOperation implements ReadFileService {
    List<String> listData = new ArrayList<>();

    @Override
    public void read(FileFundamental fileFund) {
        AbstractReadFile readFile = new ReadFileImpl(fileFund);
        readFile.read();
        listData.addAll(readFile.getReadDataList());
        System.out.println("OKUNAN DEGER SONRASI SIZE : "+listData.size());
//        return listData;

    }

    @Override
    public void read() {
        read(defaultFileFund);
//        return read(defaultFileFund);
    }

    @Override
    public void read(List<FileFundamental> files) {
        for (FileFundamental fileFund : files) {
            read(fileFund);
        }
//        return listData;
    }

    @Override
    public List<String> getReadDataList() {
        return listData;
    }

    @Override
    public void clearList() {
        listData.clear();
    }

}
