package org.aes.searchnode.dataaccess.abstracts.fileoperation;

import org.aes.searchnode.entities.concretes.FileFundamental;

import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractWriteFile {

    protected FileFundamental fileFundamental;
    private boolean appendEnable;

    public AbstractWriteFile(FileFundamental fileFundamental) {
        this.fileFundamental = fileFundamental;
    }

    public abstract void write(String text);

    public abstract void append(String text);

    public abstract void appendNextLine(String text);

    public FileFundamental getFileConfiguration() {
        return fileFundamental;
    }

    protected final void doProcess(String text) {
        try {
//            String path = fileFundamental.getPath();//"src/main/java/org/aes/searchnode/fakedata/";
            String filename = fileFundamental.getCompletePath();//path+"word-data.js";
            FileWriter fw = new FileWriter(filename, isAppendEnable()); //the true will append the new data otherwise false overwrites data

            fw.write(text);
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }

    public void setFileConfiguration(FileFundamental fileFundamental) {
        this.fileFundamental = fileFundamental;
    }

    protected void setAppendEnable(boolean appendEnable) {
        this.appendEnable = appendEnable;
    }

    public boolean isAppendEnable() {
        return appendEnable;
    }
}
