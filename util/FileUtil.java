package util;

import model.Student;
import java.io.*;
import java.util.*;

public class FileUtil {

    private static final String FILE_NAME = "students.txt";

    public static List<Student> readStudents() {
        List<Student> students = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) file.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                ));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

        return students;
    }

    public static void writeStudents(List<Student> students) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Student s : students) {
                bw.write(s.toFileString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error writing file.");
        }
    }
}
