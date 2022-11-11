package org.aes.searchnode.business.concretes;

import org.aes.searchnode.business.abstracts.fileoperation.FileOperationService;
import org.aes.searchnode.business.abstracts.fileoperation.ReadFileService;
import org.aes.searchnode.business.abstracts.fileoperation.WriteFileService;

public class FileOperationManagement extends FileOperationService {

    public FileOperationManagement(WriteFileService writeFileService, ReadFileService readFileService) {
        super(writeFileService, readFileService);
    }
}
