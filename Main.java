import model.Student;
import service.StudentService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    service.addStudent(new Student(id, name, course, marks));
                    break;

                case 2:
                    service.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    service.searchStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID to edit: ");
                    int editId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("New Marks: ");
                    double newMarks = sc.nextDouble();

                    service.editStudent(editId, newName, newCourse, newMarks);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    service.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
