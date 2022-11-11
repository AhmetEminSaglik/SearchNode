package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.business.abstracts.fileoperation.ReadFileService;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractReadFile;
import org.aes.searchnode.entities.concretes.FileFundamental;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileManagement extends FileOperation implements ReadFileService {
    List<String> listData = new ArrayList<>(); // keeps all read data even if they are in different files.
    AbstractReadFile readFileImp = new ReadFileImpl();

    @Override
    public void read(FileFundamental fileFund) {
        System.out.println("gelen file : "+fileFund.getCompletePath());

        try {
            readFileImp.prepareFileToRead(fileFund);
            readFileImp.read();
            listData.addAll(readFileImp.getReadDataList());
            readFileImp.clearList();
        } catch (FileNotFoundException e) {
            /** TODO
             *  an error and solutioun should be add here
             *  and remove throw error here*/
            throw new RuntimeException(e);
        }
    }

    @Override
    public void read() {
        read(defaultFileFund);
    }

    @Override
    public void read(List<FileFundamental> files) {
        for (FileFundamental fileFund : files) {
            read(fileFund);
        }
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
