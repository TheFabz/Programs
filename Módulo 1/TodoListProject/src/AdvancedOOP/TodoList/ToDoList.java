package AdvancedOOP.TodoList;

import java.util.PriorityQueue;

public class ToDoList {

    PriorityQueue<ToDoListItem> queue;

    public ToDoList() {
        queue = new PriorityQueue<>();
    }

    public void add(PriorityType priority){
        queue.add(new ToDoListItem(priority));
    }

    public void remove() {
        System.out.println(queue.remove());
    }

/*
    public boolean isListEmpty(){
        return queue.isEmpty();
    }

    public void getSize(){
        System.out.println(queue.size());
    }
*/

}
