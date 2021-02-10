package AdvancedOOP.TodoList;

public class Main {

    public static void main(String[] args) {

        ToDoList test = new ToDoList();

        test.add(PriorityType.HIGH);
        test.add(PriorityType.HIGH);
        test.add(PriorityType.HIGH);
        test.add(PriorityType.LOW);
        test.add(PriorityType.MED);
        test.add(PriorityType.HIGH);
        test.add(PriorityType.MED);



        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();

    }


}
