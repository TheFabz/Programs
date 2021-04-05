import java.util.*;

public class UniqueWord implements Iterable<String>{

    private LinkedHashSet<String> uniqueSet;

    public UniqueWord(String chainString){
        String[] words = chainString.split(" ");
        uniqueSet = new LinkedHashSet<>();


        uniqueSet.addAll(Arrays.asList(words));
    }


    @Override
    public Iterator iterator() {
        return uniqueSet.iterator();
    }


}
