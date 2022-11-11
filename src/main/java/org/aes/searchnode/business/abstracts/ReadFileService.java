package org.aes.searchnode.business.abstracts;

import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.List;

public interface ReadFileService {
    /*List<String>*/void read(FileFundamental fileFund);

    /*List<String>*/void read();

    /*List<String>*/void read(List<FileFundamental> files);

    List<String>  getReadDataList();

    void clearList();
}
