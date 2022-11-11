package org.aes.searchnode.dataaccess.concretes.fileoperation;

import org.aes.searchnode.dataaccess.abstracts.fileoperation.AbstractReadFile;

public class ReadFileImpl extends AbstractReadFile {

    @Override
    public void read() {
        try {
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
        }
    }

}
