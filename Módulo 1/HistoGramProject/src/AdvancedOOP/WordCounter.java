package AdvancedOOP;

import java.util.*;


public class WordCounter implements Iterable<String>{

    private final LinkedHashMap<String, Integer> hashMap;
    private int counter = 1;
    private String chainString;
    private String[] words;

        public WordCounter(String chainString) {

            this.chainString = chainString;

            words = chainString.split(" ");
            hashMap = new LinkedHashMap<>();

            for (String element : words) {
                if (hashMap.containsKey(element)) {
                    hashMap.put(element, (hashMap.get(element)+1));
                }
                else if (!hashMap.containsKey(element)) {
                    hashMap.put(element, 1);
                }


            }
        }

    @Override
    public Iterator<String> iterator() {
        return hashMap.keySet().iterator();
    }

    public int size(){
            return hashMap.size();
    }

    public Integer get(String o) {
            return hashMap.get(o);
    }


}




