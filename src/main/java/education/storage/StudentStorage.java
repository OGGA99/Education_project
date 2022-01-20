package education.storage;

import education.model.Student;
import education.util.FileUtil;
import java.util.ArrayList;
import java.util.List;

public class StudentStorage {


    private static List<Student> students = new ArrayList<>();


    public static void add(Student student) {
        students.add(student);
        FileUtil.serializeStudents(students);
    }


    public static void print() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static Student getByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                System.out.println(student);
                return student;
            }
        }
        return null;
    }

    public static Student getByLesson(String lesson) {
        for (Student student : students) {
            if (student.getLesson().equals(lesson)) {
                System.out.println(student);
                return student;
            }
        }
        return null;
    }


    public static void deleteStudentByEmail(Student student) {
        try {
            for (Student student1 : students) {

                if (student.equals(student1)) {
                    students.remove(student1);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        FileUtil.serializeStudents(students);
    }

    public static void initData() {
        List<Student> studentList = FileUtil.deserializeStudents();
        if (studentList != null) {
            students = studentList;
        }
    }
}