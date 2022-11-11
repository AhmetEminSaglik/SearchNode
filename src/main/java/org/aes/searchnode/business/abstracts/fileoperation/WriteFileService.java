package org.aes.searchnode.business.abstracts.fileoperation;

import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.List;

public interface WriteFileService {

    /**
     * write text to <b>Configured File</b>  file. This file can be configure in <b>ConfigFileFundamental</b>
     * */
    void write(String text);
    /**
     * write textList to <b>Configured File</b> file. This file can be configure in <b>ConfigFileFundamental</b>
     * */
    void write(List<String> textList);
    /**
     * write text to destination file.
     * */
    void write(FileFundamental fileFund, String text);
    /**
     * write textList to destination file.
     * */
    void write(FileFundamental fileFund, List<String> textList);

    /**
     * append text to <b>Configured File</b>  file. This file can be configure in <b>ConfigFileFundamental</b>
     * */
    void append(String text);
    /**
     * append textList to <b>Configured File</b> file. This file can be configure in <b>ConfigFileFundamental</b>
     * */
    void append(List<String> textList);
    /**
     * append text to destination file.
     * */
    void append(FileFundamental fileFund, String text);
    /**
     * append textList to destination file.
     * */
    void append(FileFundamental fileFund, List<String> textList);

}
