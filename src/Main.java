import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    system.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    system.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Course: ");
                    String newCourse = scanner.nextLine();
                    system.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    system.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    Student student = system.findStudent(searchId);
                    System.out.println(student != null ? student : "Student not found.");
                    break;

                case 6:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
