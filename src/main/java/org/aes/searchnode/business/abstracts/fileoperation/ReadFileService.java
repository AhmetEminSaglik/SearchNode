package org.aes.searchnode.business.abstracts.fileoperation;

import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.List;

public interface ReadFileService {
    /** read destination file
     * */
    void read(FileFundamental fileFund);

    /** read <b>Configured File</b>  file. This file can be configure in <b>ConfigFileFundamental</b>
     * */
    void read();

    /** read different files
     * */
    void read(List<FileFundamental> files);

    /** returns list of keep read data */
    List<String> getReadDataList();

    /**
     * This function clears list that involves data which is added by read in different files
     * <b>Note</b> : List must be created in ReadFileService. (Here it is ReadFileManagement class )
     * */
    void clearList();
}
