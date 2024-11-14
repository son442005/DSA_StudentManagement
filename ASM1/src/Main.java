import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        MyList myList = new MyList();
        int choice;

        do {
            System.out.println("======= Student Management =======");
            System.out.println("1. Add student");
            System.out.println("2. Edit student");
            System.out.println("3. Delete student");
            System.out.println("4. Sort students by marks");
            System.out.println("5. Sort students by name");
            System.out.println("6. Search student by ID");
            System.out.println("7. Display all students");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter student ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter student marks: ");
                        double marks = sc.nextDouble();
                        myList.add(new Student(id, name, marks));
                        System.out.println("Student added successfully!");
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter correct data types.");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter student ID to edit: ");
                        int editId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new marks: ");
                        double newMarks = sc.nextDouble();
                        myList.editStudent(editId, newName, newMarks);
                        System.out.println("Student updated successfully!");
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter correct data types.");
                        sc.nextLine();
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter student ID to delete: ");
                        int deleteId = sc.nextInt();
                        myList.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully!");
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a valid student ID.");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    myList.sortStudentsById();
                    System.out.println("Students sorted by marks!");
                    break;
                case 5:
                    myList.sortStudentsByName();
                    System.out.println("Students sorted by name!");
                    break;
                case 6:
                    try {
                        System.out.print("Enter student ID to search: ");
                        int searchId = sc.nextInt();
                        Student foundStudent = myList.searchStudent(searchId);
                        if (foundStudent != null) {
                            System.out.println("Found: " + foundStudent);
                        } else {
                            System.out.println("Student not found!");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a valid student ID.");
                        sc.nextLine();
                    }
                    break;
                case 7:
                    System.out.println("Student List:");
                    myList.traverse();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        } while (choice != 0);

        sc.close();
    }
}
