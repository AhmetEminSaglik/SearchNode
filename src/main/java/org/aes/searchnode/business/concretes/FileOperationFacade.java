package org.aes.searchnode.business.concretes;

import org.aes.searchnode.business.abstracts.FileOperationService;
import org.aes.searchnode.business.abstracts.ReadFileService;
import org.aes.searchnode.business.abstracts.WriteFileService;
import org.aes.searchnode.dataaccess.concretes.fileoperation.ReadFileManagement;
import org.aes.searchnode.dataaccess.concretes.fileoperation.WriteFileManagement;
import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.List;

public class FileOperationFacade implements ReadFileService, WriteFileService {
    FileOperationService fileOperationService;
    WriteFileService writeFileService;
    ReadFileService readFileService;
//    private List<String> listData;

    public FileOperationFacade(WriteFileService writeFileService, ReadFileService readFileService) {
        fileOperationService = new FileOperationManagement(writeFileService, readFileService);
        this.writeFileService = writeFileService;
        this.readFileService = readFileService;
//        listData = readFileService.getReadDataList();
    }

    public FileOperationFacade(FileOperationService fileOperationService) {
        this(fileOperationService.getWriteFileService(), fileOperationService.getReadFileService());
    }

    @Override
    public void read(FileFundamental fileFund) {
        readFileService.read(fileFund);
//        return null;
    }

    @Override
    public void read() { /* burayi facade yapip fakeDataCreation'i kaldircam. orada sadece bu facade functionlarini kullanacam.*/
        readFileService.read();
//        return getReadDataList();
    }

    @Override
    public void read(List<FileFundamental> files) {
        readFileService.read(files);
    }

    @Override
    public List<String> getReadDataList() {
        return readFileService.getReadDataList();
    }

    @Override
    public void clearList() {
        readFileService.clearList();
    }

    @Override
    public void write(String text) {
        writeFileService.write(text);
    }

    @Override
    public void write(List<String> textList) {
        writeFileService.write(textList);
    }

    @Override
    public void write(FileFundamental fileFund, String text) {
        writeFileService.write(fileFund, text);
    }

    @Override
    public void write(FileFundamental fileFund, List<String> textList) {
        writeFileService.write(fileFund, textList);
    }

    @Override
    public void append(String text) {
        writeFileService.append(text);
    }

    @Override
    public void append(List<String> textList) {
        writeFileService.append(textList);
    }

    @Override
    public void append(FileFundamental fileFund, String text) {
        writeFileService.append(fileFund, text);
    }

    @Override
    public void append(FileFundamental fileFund, List<String> textList) {
        writeFileService.append(fileFund, textList);
    }
}
