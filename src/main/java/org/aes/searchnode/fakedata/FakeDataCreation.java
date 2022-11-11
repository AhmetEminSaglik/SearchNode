package org.aes.searchnode.fakedata;

import org.aes.searchnode.business.concretes.DataCleariation;
import org.aes.searchnode.business.concretes.FileOperationFacade;
import org.aes.searchnode.dataaccess.concretes.fileoperation.ReadFileManagement;
import org.aes.searchnode.dataaccess.concretes.fileoperation.WriteFileManagement;
import org.aes.searchnode.entities.concretes.FileFundamental;
import java.util.*;

public class FakeDataCreation {
    /*TODO buradaki read&write functionlar service olarak degistirilebilir/*/


    public FileOperationFacade fileOpsFacade = new FileOperationFacade(
            new WriteFileManagement(), new ReadFileManagement());

    public void clearDataInFile() {
        DataCleariation dataCleariation = new DataCleariation();
        fileOpsFacade.read();
        System.out.println(getClass().getSimpleName() + " > Read data : console check : ");
        Set<String> hashSet = new HashSet<>();
        for (String tmp : fileOpsFacade.getReadDataList()) {
            tmp = dataCleariation.clearData(tmp);
            if (tmp.length() > 3) {
                tmp = tmp.toLowerCase();
                tmp = dataCleariation.removeWildCards(tmp);
                tmp = dataCleariation.removeWordsIfNotBelongsToEnglish(tmp);
                if (dataCleariation.hasMultipleWords(tmp)) {
                    hashSet.addAll(Arrays.asList(tmp.split(" ")));
                } else {
                    hashSet.add(tmp);
                }
            }
        }
//        System.out.println("hashset data : ");
//        hashSet.forEach(System.out::println);

        List<String> cleanList = new ArrayList<>(hashSet);
        fileOpsFacade.write(cleanList);
//        System.out.println("hashset size : " + hashSet.size());

    }

    public void read(FileFundamental fileFund) {
        fileOpsFacade.read(fileFund);
    }

    public void read(List<FileFundamental> fileFundList) {
        fileOpsFacade.read(fileFundList);
    }

    public void write(FileFundamental fileFund, String text) {
        fileOpsFacade.write(fileFund, text);
    }

    public void write(FileFundamental fileFund, List<String> textList) {
        fileOpsFacade.write(fileFund, textList);
    }

    public void append(FileFundamental fileFund, String text) {
        fileOpsFacade.append(fileFund, text);
    }

    public void append(FileFundamental fileFund, List<String> textList) {
        fileOpsFacade.append(fileFund, textList);
    }

}
