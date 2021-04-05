package org.academiadecodigo.bootcamp.containers;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;
    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        Node iterator = head.getNext();
        int increment = 0;

        while(iterator != null){
            if(increment == index){
                return iterator.getData();
            }
            else{
                iterator = iterator.getNext();
                increment++;
            }
        }
        return iterator;
        //throw new UnsupportedOperationException();
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        Node iterator = head.getNext();
        int index= 0;

        while (iterator != null){

            if(iterator.getData().equals(data)){
                return index;
            }
            else{
                iterator = iterator.getNext();
                index++;
            }
        }
        return -1;
        //throw new UnsupportedOperationException();
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {

        Node iterator = head;

        while (iterator.getNext() != null){

            if(iterator.getNext().getData().equals(data)){

                iterator.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }
            else{
                iterator = iterator.getNext();
            }
        }
        return false;
        //throw new UnsupportedOperationException();
    }

    private class Node {

        private Object data;
        private Node batata;

        public Node(Object data) {
            this.data = data;
            batata = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return batata;
        }

        public void setNext(Node next) {
            this.batata = next;
        }
    }

}
