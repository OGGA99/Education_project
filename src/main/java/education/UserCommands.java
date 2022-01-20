package education;



public interface UserCommands {


        String EXIT = "0";
        String LOGIN = "1";
        String REGISTER = "2";



    static void printCommands() {
        System.out.println();
            System.out.println("\033[4;36m" + "Please input " + EXIT + " for exit");
            System.out.println("Please input " + LOGIN + " for login ");
            System.out.println("Please input " + REGISTER + " for register " + "\u001B[0m");
        System.out.println();

        }


}
