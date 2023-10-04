package List;
import java.util.Scanner;
public class ToDoListTest {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // case that adds a task using todoList
                    System.out.println("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.println("Enter due date: ");
                    String dueDate = scanner.nextLine();

                    Task newTask = new Task(title, description, dueDate);
                    todoList.addTask(newTask);
                    System.out.println("Task added successfully.");
                    break;

                case 2:
                    // case to mark a task as complete using todoList
                    todoList.viewTasks();
                    System.out.println("Enter the index of the task to mark as complete: ");
                    int completeIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    todoList.markTaskAsComplete(completeIndex);
                    System.out.println("Task marked as complete.");
                    break;

                case 3:
                    // case to view tasks using todoList
                    todoList.viewTasks();
                    break;

                case 4:
                    // case to remove a task using todoList
                    todoList.viewTasks();
                    System.out.println("Enter the index of the task to remove: ");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    todoList.removeTask(removeIndex);
                    break;

                case 5:
                    // Exit the application
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
