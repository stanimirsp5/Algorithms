package searching.HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable1 {

    private Map<Integer,String> hashMap = new HashMap<>();
//    private List<Integer,String> hashList;

    public void add(String item){
       int hash = getHashCode(item);
       hashMap.put(hash, item);
    }
    public void get(String item){
        int hash = getHashCode(item);
       String currItem = hashMap.get(hash);
       if(currItem == null){
           System.out.println("No such item");
       }else{
           System.out.println("item found "+ currItem);
       }
    }
    public void list(){
        for (int i = 0; i < hashMap.size(); i++) {
            System.out.println(hashMap.values());
        }
    }

    private int getHashCode(String item){
        int hash = 0;
        for (int i = 0; i < item.length(); i++) {
            char character = item.charAt(i);
            hash += (int)character;
        }
        return hash;
    }
}
