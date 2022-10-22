package org.aes.searchnode.entities.concretes;

public class NodeData {
    private Object data;// destination'a varilmis ise data'ya veri eklenir
    private int nextDirectionsTotalValueNumber; //burdan sonrasinda kac tane data varsa o sayi burada tutulur.
    private String locationStringAddress="";  // suanki konuma gelmek icin hangi degerlerden/char'lardan gecildiyse hepsinin sirayla yazilmis halidir.

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getNextDirectionsTotalValueNumber() {
        return nextDirectionsTotalValueNumber;
    }

    public void increaseNextDirectionsExistingTotalDataNumber(){
        nextDirectionsTotalValueNumber++;
    }
    public void decreaseNextDirectionsExistingTotalDataNumber(){
        nextDirectionsTotalValueNumber--;
    }
//    public void setNextDirectionsTotalValueNumber(int nextDirectionsTotalValueNumber) {
//        this.nextDirectionsTotalValueNumber = nextDirectionsTotalValueNumber;
//    }

    public String getLocationStringAddress() {
        return locationStringAddress;
    }

    public void setLocationStringAddress(String locationStringAddress) {
        this.locationStringAddress = locationStringAddress;
    }

    @Override
    public String toString() {
        return "NodeData{" +
                "data=" + data +
                ", nextDirectionsTotalValueNumber=" + nextDirectionsTotalValueNumber +
                ", locationStringAddress='" + locationStringAddress + '\'' +
                '}';
    }
}
