package org.aes.searchnode.business.concretes;

import org.aes.searchnode.business.abstracts.fileoperation.FileOperationService;
import org.aes.searchnode.business.abstracts.fileoperation.ReadFileService;
import org.aes.searchnode.business.abstracts.fileoperation.WriteFileService;
import org.aes.searchnode.entities.concretes.FileFundamental;

import java.util.List;


/**
 * A library to process read and write functions */
public class FileOperationFacade implements ReadFileService, WriteFileService {
    FileOperationService fileOperationService;
    WriteFileService writeFileService;
    ReadFileService readFileService;

    public FileOperationFacade(WriteFileService writeFileService, ReadFileService readFileService) {
        fileOperationService = new FileOperationManagement(writeFileService, readFileService);
        this.writeFileService = writeFileService;
        this.readFileService = readFileService;
    }

    public FileOperationFacade(FileOperationService fileOperationService) {
        this(fileOperationService.getWriteFileService(), fileOperationService.getReadFileService());
    }

    @Override
    public void read(FileFundamental fileFund) {
        readFileService.read(fileFund);
    }

    @Override
    public void read() {
        readFileService.read();
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
