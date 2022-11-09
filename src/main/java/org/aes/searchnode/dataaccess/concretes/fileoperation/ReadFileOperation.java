package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractReadFile;
import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.ArrayList;
import java.util.List;

public class ReadFileOperation extends FileOperation {
    List<String> listData = new ArrayList<>();

    public List<String> read(FileFundamental fileFund) {
        AbstractReadFile readFile = new ReadFileImpl(fileFund);
        readFile.read();
        listData.addAll(readFile.getReadDataList());
        return listData;

    }

    public List<String> read() {
        return read(defaultFileFund);
    }

    public List<String> read(List<FileFundamental> files) {
        for (FileFundamental fileFund : files) {
            read(fileFund);
        }
        return listData;
    }

    public void clearList() {
        listData.clear();

    }

}
