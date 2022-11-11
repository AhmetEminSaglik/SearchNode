package org.aes.searchnode.business.abstracts;

import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.List;

public interface WriteFileService {
    void write(String text);
    void write(List<String> textList);
    void write(FileFundamental fileFund, String text);
    void write(FileFundamental fileFund, List<String> textList);
    void append(String text);
    void append(List<String> textList);
    void append(FileFundamental fileFund, String text);
    void append(FileFundamental fileFund, List<String> textList);

}
