package service;

import model.Student;
import util.FileUtil;
import java.util.*;

public class StudentService {

    public void addStudent(Student student) {
        List<Student> students = FileUtil.readStudents();

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        FileUtil.writeStudents(students);
        System.out.println("Student added successfully!");
    }

    public void viewAllStudents() {
        List<Student> students = FileUtil.readStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        students.forEach(System.out::println);
    }

    public void searchStudent(int id) {
        List<Student> students = FileUtil.readStudents();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public void deleteStudent(int id) {
        List<Student> students = FileUtil.readStudents();

        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            FileUtil.writeStudents(students);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void editStudent(int id, String name, String course, double marks) {
        List<Student> students = FileUtil.readStudents();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setCourse(course);
                s.setMarks(marks);
                found = true;
                break;
            }
        }

        if (found) {
            FileUtil.writeStudents(students);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}
