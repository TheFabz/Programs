import java.util.Iterator;
import java.util.LinkedList;

/**
 * Integer range iterator
 */
public class RangeList implements Iterable<Integer> {

    private LinkedList<Integer> list;
    public boolean isDescending;
    private int min;
    private int max;

    public RangeList(int min, int max) {
        this.min = min;
        this.max = max;


        list = new LinkedList<>();
        for(int i = min; i <= max; i++ ){
            list.add(i);
        }

    }

    public void remove(int item){ list.removeFirstOccurrence(item);}

    public int length(){
        return list.size();
    }

    public void setDescending(boolean setter) { isDescending = setter; }

    @Override
    public Iterator<Integer> iterator() {

        if (isDescending) {
            return list.descendingIterator();
        } else {
            return list.iterator();

        }


    }
}
