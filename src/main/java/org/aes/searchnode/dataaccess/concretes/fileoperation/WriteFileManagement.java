package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.business.abstracts.WriteFileService;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractWriteFile;
import org.aes.searchnode.entities.concretes.FileFundamental;
import java.util.List;

public class WriteFileManagement extends FileOperation implements WriteFileService {

    @Override
    public void write(String text) {
        write(defaultFileFund, text);
    }
    @Override
    public void write(List<String> textList) {
        writeFirstIndex(defaultFileFund, textList);
        appendListTextInForLoop(defaultFileFund, 1, textList);
    }
    @Override
    public void write(FileFundamental fileFund, String text) {
        AbstractWriteFile writeFile = new WriteFileImpl(fileFund);
        writeFile.write(text);
    }
    @Override
    public void write(FileFundamental fileFund, List<String> textList) {
        writeFirstIndex(fileFund, textList);
        appendListTextInForLoop(fileFund, 1, textList);
    }
    @Override
    public void append(String text) {
        append(defaultFileFund, text);
    }
    @Override
    public void append(List<String> textList) {
        appendListTextInForLoop(defaultFileFund, 0, textList);
    }
    @Override
    public void append(FileFundamental fileFund, String text) {
        AbstractWriteFile writeFile = new WriteFileImpl(fileFund);
        writeFile.appendNextLine(text);
    }
    @Override
    public void append(FileFundamental fileFund, List<String> textList) {
        appendListTextInForLoop(fileFund, 0, textList);
    }
    private void appendListTextInForLoop(FileFundamental fileFund, int startIndex, List<String> textList) {
        for (int i = startIndex; i < textList.size(); i++) {
            append(fileFund, textList.get(i));
        }
    }
    private void writeFirstIndex(FileFundamental fileFund, List<String> textList) {
        write(fileFund, textList.get(0));
    }
}
