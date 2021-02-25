package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.PriorityQueue;


/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T>  {

    private PriorityQueue<T> queue;
    private final int limit;

    /** * Constructs a new queue with a maximum size * @param limit the queue size*/
    public BQueue(int limit) {
        queue = new PriorityQueue<>();
        this.limit = limit;
    }

    /** * Inserts the specified element into the queue * Blocking operation if the queue is full * @param data the data to add to the queue*/
    public synchronized void offer(T data) throws InterruptedException {
        while(getSize() == getLimit()){
            System.out.println("Producer is waiting...");
            wait();
        }
        queue.offer(data);
        notifyAll();
    }

    /** * Retrieves and removes data from the head of the queue * Blocking operation if the queue is empty * @return the data from the head of the queue*/
    public synchronized T poll() throws InterruptedException {
        while (getSize() == 0) {
            System.out.println("Consumer is waiting...");
            wait();
        }
        notifyAll();
        System.out.println("Current size is " + getSize());
        return queue.poll();
    }

    /** * Gets the number of elements in the queue * @return the number of elements */
    public synchronized int getSize() {
        return queue.size();
    }

    /** * Gets the maximum number of elements that can be present in the queue * @return the maximum number of elements */
    public synchronized int getLimit() {
        return limit;
    }

}
