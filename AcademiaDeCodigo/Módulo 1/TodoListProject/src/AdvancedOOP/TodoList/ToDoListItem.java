package AdvancedOOP.TodoList;

import java.util.Comparator;

public class ToDoListItem implements Comparable {

    private PriorityType priority;

    public ToDoListItem(PriorityType priority){
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        if (o.equals(PriorityType.HIGH)) {
            System.out.println("1");
            return 1;
        } else if (o.equals(PriorityType.MED)) {
            System.out.println("0");
            return 0;
        } else {
            System.out.println("-1");
            return -1;
        }
    }

    @Override
    public String toString(){
        if(priority.equals(PriorityType.HIGH)) {
            return "HIGH";
        }
        else if(priority.equals(PriorityType.MED)) {
            return "MED";
        }
        else{
            return "LOW";
        }
    }

}
