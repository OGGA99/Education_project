package education;

import education.exception.UserNotFoundException;
import education.model.Lesson;
import education.model.Student;
import education.model.User;
import education.model.UserType;
import education.storage.LessonStorage;
import education.storage.StudentStorage;
import education.storage.UserStorage;
import education.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class LessonStorageTest implements AllCommands {

    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage sr = new StudentStorage();
    static UserStorage us = new UserStorage();


    public static void main(String[] args) throws UserNotFoundException {


        boolean b = true;
        while (b) {
            UserCommands.printCommands();
            String commands = scanner.nextLine();
            switch (commands) {
                case EXIT:
                    b = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.err.println("Invalid command !");
            }
        }
    }

    private static void login() throws UserNotFoundException {
        System.out.println("Input email ");
        String email = scanner.nextLine();
        System.out.println("Input password");
        String password = scanner.nextLine();
        User user = null;
        try {
            user = UserStorage.GetByEmailOrPassword(email, password);
            if (user != null) {
                if (user.getType() == UserType.ADMIN) {
                    printAdminCommands();
                } else {
                    printUserCommands();
                }
            } else {
                System.err.println("Not Found");
            }
        } catch (UserNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String showEmail() {
        try {
            System.out.println("Input email ");
            String email = scanner.nextLine();

            if (UserStorage.getByEmail(email) != null) {
                System.err.println("This email is already in use! Try another email !");
                showEmail();
            } else {
                return email;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


    private static void register() {
        try {
            String email = showEmail();

            System.out.println("Input name ");
            String name = scanner.nextLine();
            System.out.println("Input surname ");
            String surname = scanner.nextLine();
            System.out.println("Input password ");
            String password = scanner.nextLine();
            System.out.println("Input type ( Admin or User ) ");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("Admin") || type.equalsIgnoreCase("User")) {
                User user = new User(name, surname, email, password, UserType.valueOf(type.toUpperCase(Locale.ROOT)));
                UserStorage.add(user);
                System.out.println("User was added");
                System.out.println();
            } else System.out.println("invalid Type !!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }


    private static void printUserCommands() {
        boolean isRun = true;
        while (isRun) {
            AllCommands.printUserCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    System.exit(0);
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    printStudents();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    printLessons();
                    break;
                case LOGOUT:
                    isRun = false;
                    break;
                default:
                    System.out.println("Invalid Command !");

            }
        }
    }

    private static void printAdminCommands() {
        boolean isRun = true;
        while (isRun) {
            AllCommands.printAdminCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    System.exit(0);
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    printStudents();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    printLessons();
                    break;
                case DELETE_LESSON_BY_NAME:
                    deleteLessonByName();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteStudentByEmail();
                    break;
                case LOGOUT:
                    isRun = false;
                    break;
                default:
                    System.out.println("Invalid Command !");
            }


        }

    }

    private static void initData(){
        StudentStorage.initData();
        LessonStorage.initData();
        UserStorage.initData();
    }


    private static void deleteStudentByEmail() {
        System.out.println("Input Student e-mail for delete");
        StudentStorage.print();
        String email = scanner.nextLine();
        Student student = StudentStorage.getByEmail(email);
        if (student != null) {
            StudentStorage.deleteStudentByEmail(student);
            System.out.println("Student Deleted");
        } else {
            System.err.println("Student is not found");
        }


    }


    private static void deleteLessonByName() {
        System.out.println("Input Lesson name for delete");
        String lessonName = scanner.nextLine();
        Lesson lesson = lessonStorage.getByLessonName(lessonName);
        if (lesson != null) {
            lessonStorage.deleteLessonByName(lesson);
            System.out.println("Lesson Deleted !");
        } else {
            System.err.println("Error");
        }

    }

    private static void printLessons() {
        System.out.println();
        LessonStorage.print();
        System.out.println();

    }

    private static void printStudentsByLesson() {
        System.out.println("Print lesson name for search Student");
        String lesson = scanner.nextLine();
        Student student = StudentStorage.getByLesson(lesson);
        System.out.println();

    }

    private static void printStudents() {
        System.out.println();
        StudentStorage.print();
        System.out.println();

    }

    private static void addStudent() {
        System.out.println("Input Student Name");
        String name = scanner.nextLine();
        System.out.println("Input Surname");
        String surname = scanner.nextLine();
        System.out.println("Input Age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Input e-mail");
        String email = scanner.nextLine();
        System.out.println("Input PhoneNumber");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Input Lesson");
        String lesson = scanner.nextLine();
        System.out.println("Input student birthday");
        Date date = null;
        try {
            date = DateUtil.stringToDate(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid Date Format !");
        }
        System.out.println();

        Student student = new Student(name, surname, age, email, phoneNumber, lesson, date);

        if (StudentStorage.getByEmail(student.getEmail()) != null) {
            System.err.println("This email already exists !");
        } else {
            StudentStorage.add(student);
            System.out.println("Student Added !");
            System.out.println();

        }

    }

    private static void addLesson() {
        System.out.println("Input Lesson name, Lecture Name, Duration, Price");
        String lessonDataStr = scanner.nextLine();
        String[] lessonData = lessonDataStr.split(",");
        if (lessonData.length == 4) {
            int Duration = Integer.parseInt(lessonData[2]);
            int Price = Integer.parseInt(lessonData[3]);
            Lesson lesson = new Lesson(lessonData[0], lessonData[1], Duration, Price);
            if (lessonStorage.getByLessonName(lesson.getLesson()) != null) {
                System.out.println("This Lesson name is already exists !");
            } else lessonStorage.add(lesson);
            System.out.println("Lesson added !");
            System.out.println();
        } else {
            System.err.println("Invalid Data !");
        }


    }

}

