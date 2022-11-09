package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.entities.concretes.FileFundamental;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractWriteFile;

public class WriteFileImpl extends AbstractWriteFile {
    public WriteFileImpl(FileFundamental fileFundamental) {
        super(fileFundamental);
    }

    @Override
    public void write(String text) {
        setAppendEnable(false);
        doProcess(text);
    }

    @Override
    public void append(String text) {
        setAppendEnable(true);
        doProcess(text);
    }

    @Override
    public void appendNextLine(String text) {
        text="\n"+text;
        append(text);


    }

}
