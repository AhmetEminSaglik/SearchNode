package org.aes.searchnode;

import java.util.ArrayList;
import java.util.List;

public class NodeTypeConversion {
    public String convertTypeStringTobeReadyForProcessingData(int integer) {
        return Integer.toString(integer);
    }

    public List<String> convertTypeStringTobeReadyForProcessingData(List<Integer> integerList) {

        List<String> list = new ArrayList<>();
        for (Integer tmp : integerList)
            list.add(convertTypeStringTobeReadyForProcessingData(tmp));
        return list;
    } //
    /*yukaridaki integer'in listesini burda yapcaz
     * sonra  field kismini Integer  //ama veri String olarak islenecek
     *
     * String olanda field kismini String
     * type yok
     *
     * obje olanda ise musteriden objelerin listelemesini isticez  Onun icinde field alma class yazip, liste sekilinde dondurup
     * sirayla eklemesini isticez sonra o listeyi buraya yonlendirip ona gore  sirala islemi yapicaz
     * */

//    public String convertTypeToString(Integer integer)

}
