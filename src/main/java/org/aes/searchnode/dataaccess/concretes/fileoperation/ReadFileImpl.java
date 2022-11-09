package org.aes.searchnode.dataaccess.concretes.fileoperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileImpl {
    public static void main(String[] args) {
        try {
            File myObj = new File("src/main/java/org/aes/searchnode/fakedata/worddata.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("string data.length() : "+data.length());
                System.out.println(data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
