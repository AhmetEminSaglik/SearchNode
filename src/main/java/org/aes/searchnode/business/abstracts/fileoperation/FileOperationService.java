package org.aes.searchnode.business.abstracts.fileoperation;

public abstract class FileOperationService {

    protected WriteFileService writeFileService;
    protected ReadFileService readFileService;

    protected FileOperationService(WriteFileService writeFileService, ReadFileService readFileService) {
        this.writeFileService = writeFileService;
        this.readFileService = readFileService;
    }

    public WriteFileService getWriteFileService() {
        return writeFileService;
    }

    public void setWriteFileService(WriteFileService writeFileService) {
        this.writeFileService = writeFileService;
    }

    public ReadFileService getReadFileService() {
        return readFileService;
    }

    public void setReadFileService(ReadFileService readFileService) {
        this.readFileService = readFileService;
    }
}
