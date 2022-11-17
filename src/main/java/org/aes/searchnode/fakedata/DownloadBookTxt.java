package org.aes.searchnode.fakedata;


import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadBookTxt {
    private void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    private void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    public void download(FileFundamental fileFund) {
        String url = "https://www.gutenberg.org/cache/epub/" + fileFund.getFileName() + "/pg" + fileFund.getFileName() + fileFund.getExtension();

        fileFund.setFileName("pg" + fileFund.getFileName());
        try {
            downloadUsingNIO(url, fileFund.getCompletePath()/*"src\\main\\java\\org\\aes\\searchnode\\fakedata\\books\\pg1111112.txt"*/);

            downloadUsingStream(url, fileFund.getCompletePath());
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
