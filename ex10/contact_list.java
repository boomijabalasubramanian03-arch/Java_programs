import java.util.*;

public class ContactList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> contacts = new HashMap<>();

        while (true) {
            System.out.println("\n1. Add Contact\n2. View Contact\n3. Update Contact\n4. Delete Contact\n5. Display All\n6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    contacts.put(name, phone);
                    System.out.println("Contact added.");
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    name = sc.nextLine();
                    System.out.println("Phone: " + contacts.getOrDefault(name, "Not found"));
                    break;

                case 3:
                    System.out.print("Enter name to update: ");
                    name = sc.nextLine();
                    if (contacts.containsKey(name)) {
                        System.out.print("Enter new phone: ");
                        phone = sc.nextLine();
                        contacts.put(name, phone);
                        System.out.println("Updated successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    name = sc.nextLine();
                    if (contacts.remove(name) != null)
                        System.out.println("Deleted successfully.");
                    else
                        System.out.println("Contact not found.");
                    break;

                case 5:
                    System.out.println("\nAll Contacts:");
                    for (Map.Entry<String, String> entry : contacts.entrySet())
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
