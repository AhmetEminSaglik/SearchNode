package org.aes.searchnode.config.file;

import org.aes.searchnode.entities.concretes.FileFundamental;

public class ConfigFileFundamental {
    private ConfigFileFundamental() {
    }

    static final FileFundamental fileFundamental = new FileFundamental();
    static final String path = "src/main/java/org/aes/searchnode/fakedata/";
    static final String fileName = "demo";//test-data-only-word
    static final String extension = ".txt";

    public static FileFundamental getFileFundamental() {
        return fileFundamental.setPath(path).setFileName(fileName).setFileExtension(extension);
    }

}
