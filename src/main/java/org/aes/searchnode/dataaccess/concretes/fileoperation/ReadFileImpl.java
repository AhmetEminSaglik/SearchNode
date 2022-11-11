package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.entities.concretes.FileFundamental;
import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractReadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileImpl extends AbstractReadFile {
  /*  public ReadFileImpl(FileFundamental fileFund) {
        super(fileFund);
    }*/

    @Override
    public void read() {
        try {
//            prepareFile();
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                readDataList.add(data);
            }
            reader.close();
        } catch (Exception e) {
            /*TODO
             * if a file is not found then this this error will be added to a error list and after all files'
             *  read, the errors will be append to something like errorFile.txt
             * */

            System.err.println("Exception :  " +getClass().getSimpleName()+ " : Error Message : " + e.getMessage());

        } finally {
            if (reader != null) {
                reader.close();
            }
//            clearList();
        }
    }

}
