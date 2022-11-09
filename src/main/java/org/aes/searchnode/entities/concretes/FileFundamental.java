package org.aes.searchnode.entities.concretes;

public class FileFundamental {
    String path;
    String fileName;
    String extension;


    public String getPath() {
        return path;
    }

    public FileFundamental setPath(String path) {
        this.path = path;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public FileFundamental setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public FileFundamental setFileExtension(String extension) {
        this.extension = extension;
        return this;
    }

    public String getCompletePath() {
        return path + fileName + extension;

    }


}
