import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    private static String[][] add = new String[0][0];
    private static int[][] marks = new int[0][0];

    public static void main(String[] args) {

        home();

    }

    public static void home() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|                  WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                      |");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("[1] Add New Student\t\t\t [2] Add New Student With Marks");
        System.out.println("[3] Add Marks\t\t\t\t [4] Update Student Details");
        System.out.println("[5] Update Marks\t\t\t [6] Delete Student ");
        System.out.println("[7] Print Student Details\t\t [8] Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamental\t [10] Best in Database Management System");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        int option = input.nextInt();
        clearConsole();

        switch (option) {
            case 1:
                addNewStudent();
                break;

            case 2:
                addNewStudentMarks();
                break;

            case 3:
                addMarks();
                break;

            case 4:
                updateStudent();
                break;

            case 5:
                updateMarks();
                break;

            case 6:
                deleteStudent();
                break;

            case 7:
                printstudentDetail();
                break;

            case 8:
                printStudentMarks();
                break;

            case 9:
                programmingFundemental();
                break;

            case 10:
                DtabaseManagemtSystem();
                break;

            default:
                System.out.println("Enter Valid Number");

        }

    }

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // handle the exception
            System.err.println(e.getMessage());
        }
    }

    public static void add() {
        String[][] temp = new String[add.length + 1][2];

        for (int i = 0; i < add.length; i++) {
            for (int j = 0; j < add[i].length; j++) {
                temp[i][j] = add[i][j];
            }
        }
        add = temp;

    }

    public static void marksGrow() {
        int[][] temp = new int[marks.length + 1][2];

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                temp[i][j] = marks[i][j];
            }
        }
        marks = temp;

    }

    // 1

    public static void addNewStudent() {
        L1: while (true) {
            clearConsole();
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                         ADD NEW STUDENT                        |");
            System.out.println("------------------------------------------------------------------");
            add();
            marksGrow();

            L2: while (true) {
                System.out.print("\nEnter Student ID\t: ");
                String id = input.next();

                for (int i = 0; i < add.length; i++) {
                    if (id.equals(add[i][0])) {
                        System.out.print("The Student ID already exists\n");
                        continue L2;
                    }
                }

                for (int j = 0; j < add.length; j++) {
                    if (add[j][0] == null) {
                        add[j][0] = id;

                        System.out.print("Enter Student Name\t: ");
                        add[j][1] = input.next();

                        System.out.print(
                                "\nStudent has been added successfully. Do you want to add a new student (Y/n):  ");
                        String answer = input.next();
                        if (answer.equals("Y") || answer.equals("y")) {
                            continue L1;
                        } else {
                            clearConsole();
                            home();
                            return;
                        }
                    }
                }
            }

        }

    }

    // 2
    public static void addNewStudentMarks() {

        L1: while (true) {
            clearConsole();
            System.out.println("------------------------------------------------------------------");
            System.out.println("|               ADD NEW STUDENT WITH MARKS                       |");
            System.out.println("------------------------------------------------------------------");
            add();
            marksGrow();

            L2: while (true) {
                System.out.print("\nEnter Student ID\t: ");
                String id = input.next();

                for (int i = 0; i < add.length; i++) {
                    if (id.equals(add[i][0])) {
                        System.out.print("The Student ID already exists\n");
                        continue L2;
                    }
                }

                for (int j = 0; j < add.length; j++) {
                    if (add[j][0] == null) {
                        add[j][0] = id;

                        System.out.print("Enter Student Name\t: ");
                        add[j][1] = input.next();

                        L3: while (true) {
                            System.out.print("\nProgramming Fundamentals Marks\t\t: ");
                            int prfMarks = input.nextInt();

                            for (int i = 0; i < marks.length; i++) {
                                if (prfMarks < 0 || prfMarks > 100) {
                                    System.out.print("Invalid marks, please enter correct marks.\n");
                                    continue L3;
                                }
                            }
                            marks[j][0] = prfMarks;

                            L4: while (true) {
                                System.out.print("Database Management System Marks\t: ");
                                int dbmMarks = input.nextInt();

                                for (int i = 0; i < marks.length; i++) {
                                    if (dbmMarks < 0 || dbmMarks > 100) {
                                        System.out.print("Invalid marks, please enter correct marks.\n");
                                        System.out.println();
                                        continue L4;
                                    }
                                }

                                marks[j][1] = dbmMarks;

                                System.out.print(
                                        "\nStudent has been added successfully. Do you want to add a new student (Y/n):  ");
                                String answer = input.next();
                                if (answer.equals("Y") || answer.equals("y")) {
                                    continue L1;
                                } else {
                                    clearConsole();
                                    home();
                                    return;
                                }

                            }

                        }
                    }

                }
            }
        }
    }

    // 3

    public static void addMarks() {

        L1: while (true) {
            clearConsole();
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                           ADD MARKS                            |");
            System.out.println("------------------------------------------------------------------");

            L2: while (true) {
                String studentId = "";
                boolean validId = false;

                while (!validId) {
                    System.out.print("\nEnter Student ID\t: ");
                    studentId = input.next();

                    for (int i = 0; i < add.length; i++) {
                        if (studentId.equals(add[i][0])) {
                            validId = true;
                            break;
                        }
                    }

                    if (!validId) {
                        System.out.print("Invalid Student ID. Do you want to search again? (y/n) :  ");
                        String yesno = input.next();
                        if (yesno.equals("y") || yesno.equals("Y")) {
                            continue L2;
                        } else {
                            clearConsole();
                            home();
                            return;
                        }
                    }

                }

                boolean studentFound = false;

                for (int i = 0; i < add.length; i++) {
                    if (studentId.equals(add[i][0])) {
                        studentFound = true;

                        System.out.println("Student Name\t\t: " + add[i][1]);
                        System.out.println();

                        if (marks[i][0] > 0) {
                            System.out.println(
                                    "This student's marks have been already added.\nIf you want to update the marks, please use [4] update marks option.");

                            System.out.print("\nDo you want to add marks for another student (Y/n):  ");
                            String answer = input.next();
                            if (answer.equals("Y") || answer.equals("y")) {
                                continue L1;
                            } else {
                                clearConsole();
                                home();
                                return;
                            }

                        }

                        L3: while (true) {

                            System.out.print("Programming Fundamentals Marks\t : ");
                            int prfMarks = input.nextInt();

                            if (prfMarks < 0 || prfMarks > 100) {
                                System.out.print("Invalid marks, please enter correct marks.\n\n");
                                continue L3;
                            }

                            L4: while (true) {
                                System.out.print("Database Management System Marks : ");
                                int dbmMarks = input.nextInt();

                                if (dbmMarks < 0 || dbmMarks > 100) {
                                    System.out.print("Invalid marks, please enter correct marks.\n\n");
                                    continue L4;
                                }

                                int studentIndex = i;
                                marks[studentIndex][0] = prfMarks;
                                marks[studentIndex][1] = dbmMarks;

                                System.out.print(
                                        "Marks have been added successfully. Do you want to add marks for another student (Y/n):  ");
                                String answer = input.next();
                                if (answer.equals("Y") || answer.equals("y")) {
                                    continue L1;
                                } else {
                                    clearConsole();
                                    home();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // 4

    public static void updateStudent() {

        L1: while (true) {
            clearConsole();
            System.out.println("----------------------------------------------------------------");
            System.out.println("|                 UPDATE STUDENT DETAILS                       |");
            System.out.println("----------------------------------------------------------------");

            L2: while (true) {

                String studentId = "";
                boolean validId = false;

                while (!validId) {
                    System.out.print("\nEnter Student ID : ");
                    studentId = input.next();

                    for (int i = 0; i < add.length; i++) {
                        if (studentId.equals(add[i][0])) {
                            validId = true;
                            break;
                        }
                    }

                    if (!validId) {
                        System.out.print("Invalid Student ID. Do you want to search again? (y/n) :  ");
                        String yesno = input.next();
                        if (yesno.equals("y") || yesno.equals("Y")) {
                            continue L2;
                        } else {
                            clearConsole();
                            home();
                            return;
                        }

                    }
                    for (int i = 0; i < add.length; i++) {
                        if (studentId.equals(add[i][0])) {
                            System.out.println("Student Name\t : " + add[i][1]);

                            System.out.print("\nEnter the new Student name : ");
                            add[i][1] = input.next();

                            System.out.print(
                                    "Student details has been updated successfully.\nDo you want to update another student detail? (y/n) : ");
                            String yesno = input.next();

                            if (yesno.equals("y") || yesno.equals("Y")) {
                                continue L1;
                            } else {
                                clearConsole();
                                home();
                                return;
                            }

                        }

                    }
                }

            }
        }
    }

    // 5

    public static void updateMarks() {

        L1: while (true) {
            clearConsole();
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                        UPDATE MARKS                            |");
            System.out.println("------------------------------------------------------------------");

            L2: while (true) {
                String studentId = "";
                boolean validId = false;

                while (!validId) {
                    System.out.print("\nEnter Student ID: ");
                    studentId = input.next();

                    for (int i = 0; i < add.length; i++) {
                        if (studentId.equals(add[i][0])) {
                            validId = true;
                            break;
                        }
                    }

                    if (!validId) {
                        System.out.print("Invalid Student ID. Do you want to search again? (y/n) :  ");
                        String yesno = input.next();
                        if (yesno.equals("y") || yesno.equals("Y")) {
                            continue L2;
                        } else {
                            clearConsole();
                            home();
                            return;
                        }

                    }

                    for (int i = 0; i < add.length; i++) {
                        if (studentId.equals(add[i][0])) {
                            System.out.println("Student Name\t: " + add[i][1]);

                            if (marks[i][0] == 0 && marks[i][1] == 0) {
                                System.out.println("\nThis student's marks yet to be added.");

                                System.out.print("\nDo you want to update marks for another student (Y/n):  ");
                                String answer = input.next();

                                if (answer.equals("Y") || answer.equals("y")) {
                                    continue L1;
                                } else {
                                    clearConsole();
                                    home();
                                    return;
                                }
                            } else {
                                System.out.println("\nProgramming Fundamentals Marks   : " + marks[i][0]);
                                System.out.println("Database Management system Marks : " + marks[i][1]);
                            }

                            L3: while (true) {
                                System.out.print("\nEnter new Programming Fundamentals Marks   : ");
                                int prfMarks = input.nextInt();

                                if (prfMarks < 0 || prfMarks > 100) {
                                    System.out.print("Invalid marks, please enter correct marks.\n");
                                    continue L3;
                                }
                                marks[i][0] = prfMarks;

                                L4: while (true) {
                                    System.out.print("Enter new Database Management system Marks : ");
                                    int dbmMarks = input.nextInt();

                                    if (dbmMarks < 0 || dbmMarks > 100) {
                                        System.out.print("Invalid marks, please enter correct marks.\n");
                                        continue L4;
                                    }
                                    marks[i][1] = dbmMarks;

                                    System.out.println("Marks have been updated successfully.");

                                    System.out.print("Do you want to update marks for another student (Y/n):  ");
                                    String answer = input.next();

                                    if (answer.equals("Y") || answer.equals("y")) {
                                        continue L1;
                                    } else {
                                        clearConsole();
                                        home();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }
    }

    public static void remove() {
        String[][] temp = new String[add.length - 1][2];
        int index = 0;

        for (int i = 0; i < add.length; i++) {
            if (add[i][0] != null && !add[i][0].equals("null")) {
                temp[index][0] = add[i][0];
                temp[index][1] = add[i][1];
                index++;
            }
        }

        add = temp;
    }

    public static void removeMarks() {
        int[][] temp = new int[marks.length - 1][2];

        L1: for (int i = 0; i < marks.length; i++) {
            if (marks[i][0] != 0) {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j][0] == 0) {
                        temp[j][0] = marks[i][0];
                        temp[j][1] = marks[i][1];
                        continue L1;
                    }
                }

            }
        }
        marks = temp;

    }

    // 6

    public static void deleteStudent() {
        L1: while (true) {
            clearConsole();
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                      DELETE STUDENT                            |");
            System.out.println("------------------------------------------------------------------");

            L2: while (true) {
                String studentId = "";
                boolean validId = false;

                while (!validId) {
                    System.out.print("\nEnter Student ID: ");
                    studentId = input.next();

                    for (int i = 0; i < add.length; i++) {
                        if (add[i][0] != null && add[i][0].equals(studentId)) {
                            validId = true;
                            break;
                        }
                    }

                    if (!validId) {
                        System.out.print("Invalid Student ID. Do you want to search again? (y/n) : ");
                        String yesno = input.next();
                        if (yesno.equals("y") || yesno.equals("Y")) {
                            continue L2;
                        } else {
                            clearConsole();
                            home();
                            return;
                        }
                    }
                }

                for (int i = 0; i < add.length; i++) {
                    if (add[i][0] != null && add[i][0].equals(studentId)) {
                        add[i][0] = null;
                        add[i][1] = null;
                        remove();
                        removeMarks();

                        System.out.print(
                                "Student has been deleted successfully.\nDo you want to delete another? (y/n) ");
                        String yesno = input.next();

                        if (yesno.equals("y") || yesno.equals("Y")) {
                            continue L1;
                        } else {
                            clearConsole();
                            home();
                            return;
                        }
                    }
                }
            }
        }
    }

    // 7
    public static void printstudentDetail() {

        L1: while (true) {
            clearConsole();
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                   PRINT STUDENT DETAILS                        |");
            System.out.println("------------------------------------------------------------------");

            L2: while (true) {

                String studentId = "";
                boolean validId = false;

                while (!validId) {
                    System.out.print("\nEnter Student ID: ");
                    studentId = input.next();

                    for (int i = 0; i < add.length; i++) {
                        if (studentId.equals(add[i][0])) {
                            validId = true;
                            break;
                        }
                    }

                    if (!validId) {
                        System.out.print("Invalid Student ID. Do you want to search again? (y/n) :  ");
                        String yesno = input.next();
                        if (yesno.equals("y") || yesno.equals("Y")) {
                            continue L2;
                        } else {
                            clearConsole();
                            home();
                            return;
                        }

                    }

                    for (int i = 0; i < add.length; i++) {
                        if (studentId.equals(add[i][0])) {
                            System.out.println("Student Name : " + add[i][1]);

                            if (marks[i][0] == 0 && marks[i][1] == 0) {
                                System.out.println("\nMarks yet to be added.");

                                System.out.print("\nDo you want to search another student details (Y/n):  ");
                                String answer = input.next();

                                if (answer.equals("Y") || answer.equals("y")) {
                                    continue L1;
                                } else {
                                    clearConsole();
                                    home();
                                    return;
                                }
                            } else {

                                int prfMarks = marks[i][0];
                                int dbmMarks = marks[i][1];
                                int totalMarks = prfMarks + dbmMarks;
                                double avgMarks = (double) totalMarks / 2;

                                String rankString;
                                if (totalMarks >= 100) {
                                    rankString = "1 (First)";
                                } else if (totalMarks >= 80) {
                                    rankString = "2 (Second)";
                                } else if (totalMarks >= 60) {
                                    rankString = "3 (Third)";
                                } else {
                                    rankString = "4 (Last)";
                                }

                                System.out.println("+---------------------------------+-------------------------+");
                                System.out.println(
                                        "|Programming Fundamentals Marks   |\t\t\t" + "  " + marks[i][0] + "|");
                                System.out.println(
                                        "|Database Management system Marks |\t\t\t" + "  " + marks[i][1] + "|");
                                System.out.println("|Total Marks \t\t\t  |\t\t\t" + " " + totalMarks + "|");
                                System.out.println("|Avg. Marks \t\t\t  |\t\t\t" + avgMarks + "|");
                                System.out.println("|Rank\t\t\t\t  |\t\t" + "   " + rankString + "|");
                                System.out.println("+---------------------------------+-------------------------+");

                                System.out.print("\nDo you want to search another student details (Y/n):  ");
                                String answer = input.next();

                                if (answer.equals("Y") || answer.equals("y")) {
                                    continue L1;
                                } else {
                                    clearConsole();
                                    home();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    // 8
    public static void printStudentMarks() {

        L1: while (true) {

            System.out.println("------------------------------------------------------------------");
            System.out.println("|                   PRINT STUDENTS' RANKS                        |");
            System.out.println("------------------------------------------------------------------");

            int[] totalMarks = new int[add.length];
            for (int i = 0; i < add.length; i++) {
                totalMarks[i] = marks[i][0] + marks[i][1];
            }

            // Sort students based on total marks and their original indices
            Integer[] indices = new Integer[add.length];
            for (int i = 0; i < add.length; i++) {
                indices[i] = i;
            }
            Arrays.sort(indices, Comparator.comparingInt((Integer i) -> totalMarks[i]).reversed());

            // Display ranks and student details
            System.out.println("+-------+-------+---------------+---------------+-----------+");
            System.out.println("| Rank  | ID    | Name          | Total Marks   | Avg. Marks|");
            System.out.println("+-------+-------+---------------+---------------+-----------+");

            int rank = 1;
            for (int i = 0; i < add.length; i++) {
                int index = indices[i];
                int studentTotalMarks = totalMarks[index];
                double studentAvgMarks = (double) studentTotalMarks / 2;

                System.out.printf("| %-5d | %-5s | %-13s | %-13d | %.2f     |\n", rank, add[index][0], add[index][1],
                        studentTotalMarks, studentAvgMarks);

                rank++;
            }

            System.out.println("+-------+-------+---------------+---------------+-----------+");

            System.out.print("Do you want to go back to main menu (Y/n):  ");
            String answer = input.next();

            if (answer.equals("Y") || answer.equals("y")) {
                clearConsole();
                home();
                return;
            } else {
                clearConsole();
                continue L1;
            }
        }
    }

    public static void programmingFundemental() {

        L1: while (true) {
            clearConsole();
            System.out.println("---------------------------------------------------------");
            System.out.println("|           BEST IN PROGRAMMING FUNDAMENTALS            |");
            System.out.println("---------------------------------------------------------");
            System.out.println();

            // Find students with added marks in Programming Fundamentals
            int count = 0;
            for (int i = 0; i < add.length; i++) {
                if (marks[i][0] != 0) {
                    count++;
                }
            }

            // Create arrays to store valid indices and corresponding marks
            int[] validIndices = new int[count];
            int[] pfMarks = new int[count];

            // Populate arrays with valid indices and Programming Fundamentals marks
            int index = 0;
            for (int i = 0; i < add.length; i++) {
                if (marks[i][0] != 0) {
                    validIndices[index] = i;
                    pfMarks[index] = marks[i][0];
                    index++;
                }
            }

            // Sort students based on Programming Fundamentals marks and their original
            // indices
            for (int i = 0; i < count; i++) {
                for (int j = i + 1; j < count; j++) {
                    if (pfMarks[i] < pfMarks[j]) {
                        int tempIndex = validIndices[i];
                        int tempMarks = pfMarks[i];
                        validIndices[i] = validIndices[j];
                        pfMarks[i] = pfMarks[j];
                        validIndices[j] = tempIndex;
                        pfMarks[j] = tempMarks;
                    }
                }
            }

            // Display students' details
            System.out.println("+-------+---------------+---------+-----------+");
            System.out.println("| ID    | Name          | PF Marks| DBMS Marks|");
            System.out.println("+-------+---------------+---------+-----------+");

            for (int i = 0; i < count; i++) {
                int stuIndex = validIndices[i];
                System.out.printf("| %-5s | %-13s | %-7d | %-9d |\n", add[stuIndex][0], add[stuIndex][1],
                        marks[stuIndex][0],
                        marks[stuIndex][1]);
            }

            System.out.println("+-------+---------------+---------+-----------+");

            System.out.print("\nDo you want to go back to the main menu? (Y/n): ");
            String answer = input.next();

            if (answer.equals("Y") || answer.equals("y")) {
                clearConsole();
                home();
                return;
            } else {
                clearConsole();
                continue L1;
            }
        }

    }

    public static void DtabaseManagemtSystem() {

        L1: while (true) {
            clearConsole();
            System.out.println("---------------------------------------------------------");
            System.out.println("|         BEST IN DATABASE MANAGEMENT SYSTEM            |");
            System.out.println("---------------------------------------------------------");
            System.out.println();

            // Find students with added marks in Database Management System
            int count = 0;
            for (int i = 0; i < add.length; i++) {
                if (marks[i][1] != 0) {
                    count++;
                }
            }

            // Create arrays to store valid indices and corresponding marks
            int[] validIndices = new int[count];
            int[] dbmsMarks = new int[count];

            // Populate arrays with valid indices and Database Management System marks
            int index = 0;
            for (int i = 0; i < add.length; i++) {
                if (marks[i][1] != 0) {
                    validIndices[index] = i;
                    dbmsMarks[index] = marks[i][1];
                    index++;
                }
            }

            // Sort students based on Database Management System marks and their original
            // indices
            for (int i = 0; i < count; i++) {
                for (int j = i + 1; j < count; j++) {
                    if (dbmsMarks[i] < dbmsMarks[j]) {
                        int tempIndex = validIndices[i];
                        int tempMarks = dbmsMarks[i];
                        validIndices[i] = validIndices[j];
                        dbmsMarks[i] = dbmsMarks[j];
                        validIndices[j] = tempIndex;
                        dbmsMarks[j] = tempMarks;
                    }
                }
            }

            // Display students' details
            System.out.println("+-------+---------------+-----------+--------+");
            System.out.println("| ID    | Name          | DBMS Marks| PF Marks|");
            System.out.println("+-------+---------------+-----------+--------+");

            for (int i = 0; i < count; i++) {
                int stuIndex = validIndices[i];
                System.out.printf("| %-5s | %-13s | %-9d | %-7d |\n", add[stuIndex][0], add[stuIndex][1],
                        marks[stuIndex][1],
                        marks[stuIndex][0]);
            }

            System.out.println("+-------+---------------+-----------+--------+");

            System.out.print("\nDo you want to go back to the main menu? (Y/n): ");
            String answer = input.next();

            if (answer.equals("Y") || answer.equals("y")) {
                clearConsole();
                home();
                return;
            } else {
                clearConsole();
                continue L1;
            }
        }

    }

}
