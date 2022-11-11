package org.aes.searchnode.dataaccess.abstracts.fileoperation;

import org.aes.searchnode.entities.concretes.FileFundamental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This abstract class reads file and keeps data in list. Every file will be read needs an initialization (which is <b> ReadFileImp </b>) of this abstract class. */
public abstract class AbstractReadFile {
    protected File file;
    protected Scanner reader;
    protected List<String> readDataList = new ArrayList<>(); // keeps read data only destination file
    protected FileFundamental fileFund;

    public abstract void read();

    public List<String> getReadDataList() {
        return readDataList;
    }

    public void prepareFileToRead(FileFundamental fileFund) throws FileNotFoundException {
        file = new File(fileFund.getCompletePath());
        reader = new Scanner(file);
    }

    public FileFundamental getFileFund() {
        return fileFund;
    }

    public void setFileFund(FileFundamental fileFund) {
        this.fileFund = fileFund;
    }
    /**
     * This functions clear AbstractReadfile datList. Because this abstract's implementation
     * keeps data in one list even if it reads from different files*/
    public void clearList() {
        readDataList.clear();
    }
}
