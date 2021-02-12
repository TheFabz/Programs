import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Integer range iterator
 */
public class Range implements Iterable<Integer> {

    public boolean isDescending;
    private int min;
    private int max;
    private LinkedList<Integer> dump;


    public Range(int min, int max) {
        this.min = min;
        this.max = max;
        dump = new LinkedList<>();
    }

    public void remove(int item){
        dump.add(item);
    }

    public boolean contains(Integer o){
        return dump.contains(o);
    }

    public void setDescending(boolean setter){
        isDescending = setter;
    }


    public Iterator<Integer> iterator() {

        return new Iterator() {

            @Override
            public boolean hasNext() {
                    return min <= max;
            }

            @Override
            public Integer next() {

                    if (isDescending) {
                        return max--;
                    }
                    else{
                        return min++;
                    }
                }


        };

    }

}
