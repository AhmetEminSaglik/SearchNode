package org.aes.searchnode.business.concretes;

import org.aes.searchnode.business.abstracts.FileOperationService;
import org.aes.searchnode.business.abstracts.ReadFileService;
import org.aes.searchnode.business.abstracts.WriteFileService;
import org.aes.searchnode.dataaccess.concretes.fileoperation.WriteFileImpl;
import org.aes.searchnode.dataaccess.concretes.fileoperation.WriteFileManagement;

public class FileOperationManagement extends FileOperationService {



    public FileOperationManagement(WriteFileService writeFileService, ReadFileService readFileService) {
        super(writeFileService, readFileService);
    }
}
