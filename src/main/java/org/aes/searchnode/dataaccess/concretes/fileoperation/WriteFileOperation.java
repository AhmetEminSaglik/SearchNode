package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractReadFile;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractWriteFile;
import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.List;

public class WriteFileOperation extends FileOperation {
    public void write(FileFundamental fileFund, String text) {
        AbstractWriteFile writeFile = new WriteFileImpl(fileFund);
        writeFile.write(text);
    }

    public void write(String text) {
        write(defaultFileFund, text);
    }

    public void write(List<String> textList) {
        for (String text : textList)
            write(text);
    }

    public void write(FileFundamental fileFund, List<String> textList) {
        for (String text : textList)
            write(fileFund, text);
    }

    public void append(FileFundamental fileFund, String text) {
        AbstractWriteFile writeFile = new WriteFileImpl(fileFund);
        writeFile.appendNextLine(text);
    }

    public void append(String text) {
        append(defaultFileFund, text);
    }

    public void append(List<String> textList) {
        for (String text : textList)
            append(text);
    }

    public void append(FileFundamental fileFund, List<String> textList) {
        for (String text : textList)
            append(fileFund, text);
    }

}
