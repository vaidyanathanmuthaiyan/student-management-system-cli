import java.io.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private final ArrayList<Student> students = new ArrayList<>();
    private final String fileName = "students.txt";

    public StudentManagementSystem() { loadFromFile(); }

    public void addStudent(Student student) {
        if (findStudent(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) System.out.println(student);
    }

    public void updateStudent(int id, String name, int age, String course) {
        Student student = findStudent(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        saveToFile();
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id) {
        Student student = findStudent(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(student);
        saveToFile();
        System.out.println("Student deleted successfully.");
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) return student;
        }
        return null;
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                writer.write(student.getId() + "|" + student.getName() + "|" +
                             student.getAge() + "|" + student.getCourse());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }

    private void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4) {
                    students.add(new Student(
                        Integer.parseInt(data[0]), data[1],
                        Integer.parseInt(data[2]), data[3]
                    ));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading student data.");
        }
    }
}
