package org.aes.searchnode.dataaccess.abstracts.fileoperation;

import org.aes.searchnode.entities.concretes.FileFundamental;

import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractWriteFile {

    protected FileFundamental fileFundamental;
    private boolean appendEnable;

    protected AbstractWriteFile(FileFundamental fileFundamental) {
        this.fileFundamental = fileFundamental;
    }

    public abstract void write(String text);

    public abstract void append(String text);

    public abstract void appendNextLine(String text);

    public FileFundamental getFileConfiguration() {
        return fileFundamental;
    }

    protected final void doProcess(String text) {
        String filename = fileFundamental.getCompletePath();
        try (FileWriter fw = new FileWriter(filename, isAppendEnable());) {//the true will append the new data otherwise false overwrites data
            fw.write(text);
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
