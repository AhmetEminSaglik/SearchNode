package org.aes.searchnode.dataaccess.abstracts.fileoperation;

import org.aes.searchnode.entities.concretes.FileFundamental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractReadFile {
    protected File file;
    protected Scanner reader;
    protected List<String> readDataList = new ArrayList<>();
    protected FileFundamental fileFund;

    public AbstractReadFile(FileFundamental fileFund) {
        this.fileFund = fileFund;
    }

    public abstract void read();

    public List<String> getReadDataList() {
        return readDataList;
    }

    protected void prepareFile() throws FileNotFoundException {
        file = new File(fileFund.getCompletePath());
        reader = new Scanner(file);
    }

    public FileFundamental getFileFund() {
        return fileFund;
    }

    public void setFileFund(FileFundamental fileFund) {
        this.fileFund = fileFund;
    }
    protected void clearList() {
        readDataList.clear();
    }
}
