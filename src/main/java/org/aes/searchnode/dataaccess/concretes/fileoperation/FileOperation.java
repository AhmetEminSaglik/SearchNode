package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.config.file.ConfigFileFundamental;
import org.aes.searchnode.entities.concretes.FileFundamental;

public abstract class FileOperation {
    protected FileFundamental defaultFileFund;

    public FileOperation() {
        this.defaultFileFund = ConfigFileFundamental.getFileFundamental();
    }


}
