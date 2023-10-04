package List;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Task> tasks;
    private static final String TASKS_FILE = "tasks.ser"; // File to store tasks
    public ToDoList() {
        loadTasksFromFile();
    }
    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }
    public void markTaskAsComplete(int index) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            saveTasksToFile();
        } else {
            System.out.println("Invalid task index.");
        }
    }
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                String status = task.isCompleted() ? "Completed" : "Not Completed";
                System.out.println(i + ". " + task.getTitle() + " - " + status);
            }
        }
    }
    public void removeTask(int index) {
        if (isValidIndex(index)) {
            tasks.remove(index);
            saveTasksToFile();
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }
    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
    private void loadTasksFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(TASKS_FILE))) {
            tasks = (List<Task>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // If the file doesn't exist 
            tasks = new ArrayList<>();
        }
    }
    private void saveTasksToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TASKS_FILE))) {
            out.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}
