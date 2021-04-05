package AdvancedOOP.TodoList;

public class Main {

    public static void main(String[] args) {

        ToDoList test = new ToDoList();

        ToDoListItem test1 = new ToDoListItem(PriorityType.HIGH);
        ToDoListItem test2 = new ToDoListItem(PriorityType.MED);

        test.add(PriorityType.HIGH);
        test.add(PriorityType.HIGH);
        test.add(PriorityType.HIGH);
        test.add(PriorityType.LOW);
        test.add(PriorityType.MED);
        test.add(PriorityType.HIGH);
        test.add(PriorityType.MED);
        test.add(PriorityType.LOW);

        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();


    }


}
