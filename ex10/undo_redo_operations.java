import java.util.*;

public class UndoRedoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();

        while (true) {
            System.out.println("\n1. Action\n2. Undo\n3. Redo\n4. Display last action\n5. Exit");
            System.out.print("Choose any one: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Give action as input: ");
                    String action = sc.nextLine();
                    undoStack.push(action);
                    redoStack.clear();
                    break;

                case 2:
                    if (!undoStack.isEmpty()) {
                        String undone = undoStack.pop();
                        redoStack.push(undone);
                        System.out.println("Undone action: " + undone);
                    } else {
                        System.out.println("No last action");
                    }
                    break;

                case 3:
                    if (!redoStack.isEmpty()) {
                        String redone = redoStack.pop();
                        undoStack.push(redone);
                        System.out.println("Redone action: " + redone);
                    } else {
                        System.out.println("No action to redo");
                    }
                    break;

                case 4:
                    if (!undoStack.isEmpty())
                        System.out.println("Last action is: " + undoStack.peek());
                    else
                        System.out.println("No last action");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
