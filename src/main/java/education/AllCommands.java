package education;

public interface AllCommands {

    String LOGIN = "1";
    String REGISTER = "2";


    String EXIT = "0";
    String ADD_LESSON = "1";
    String ADD_STUDENT = "2";
    String PRINT_STUDENTS = "3";
    String PRINT_STUDENTS_BY_LESSON = "4";
    String PRINT_LESSONS = "5";
    String DELETE_LESSON_BY_NAME = "6";
    String DELETE_STUDENT_BY_EMAIL = "7";
    String LOGOUT = "8";

    static void printUserCommands() {
        System.out.println("\033[4;36m" + "Input " + EXIT + " For exit !");
        System.out.println("Input " + ADD_LESSON + " For add Lesson");
        System.out.println("Input " + ADD_STUDENT + " For add Student");
        System.out.println("Input " + PRINT_STUDENTS + " For print Student's list");
        System.out.println("Input " + PRINT_STUDENTS_BY_LESSON + " For print Students by Lesson");
        System.out.println("Input " + PRINT_LESSONS + " For print Lesson's");
        System.out.println("Input " + LOGOUT + " For LOGOUT" + "\033[4;32m");
        System.out.println("");
    }

    static void printAdminCommands() {
        System.out.println("\033[4;36m" + "Input " + EXIT + " For exit !");
        System.out.println("Input " + ADD_LESSON + " For add Lesson");
        System.out.println("Input " + ADD_STUDENT + " For add Student");
        System.out.println("Input " + PRINT_STUDENTS + " For print Student's list");
        System.out.println("Input " + PRINT_STUDENTS_BY_LESSON + " For print Students by Lesson");
        System.out.println("Input " + PRINT_LESSONS + " For print Lesson's");
        System.out.println("Input " + DELETE_LESSON_BY_NAME + " For delete lesson by name");
        System.out.println("Input " + DELETE_STUDENT_BY_EMAIL + " For delete student by e-mail");
        System.out.println("Input " + LOGOUT + " For LOGOUT" + "\033[4;32m");
        System.out.println("");
    }


}
