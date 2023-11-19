package Student_grade_calculator;

import java.util.Scanner;
import java.util.InputMismatchException; //User is prompted to provide a integer value,if the value entered is negative or a string then InputMismatchException is thrown

public class Student_grade_calculator { // Student grade calculator class
    public static void main(String[] args) { // Compiler starts executing the program from the main method
        Scanner sc = new Scanner(System.in); // Scanner class used to take input from user.
        System.out.println("Enter the number of subjects for which grade to be calculated");
        int Total_Num_Of_Subjects = 0; // Intially number of subects is zero
        while (true) { // while(true) is used for infinite loop
            try {
                // Read the integer value from the user using scanner class
                Total_Num_Of_Subjects = sc.nextInt();

                if (Total_Num_Of_Subjects < 0) {
                    // Throw an exception if the integer is negative
                    throw new InputMismatchException();
                }

                break; // Exit the loop if the user entered a valid input
            } catch (InputMismatchException e) {
                // Display an error message if the user entered a invalid input
                System.out.println("Please enter a positive integer");

                // To prevent the infinite loop clear the input buffer
                sc.nextLine();
            }
        }
        int[] Subject_Marks = new int[Total_Num_Of_Subjects];
        int TotalNoofMarks = 0;

        // Loop through all the subjects
        for (int i = 0; i <= Total_Num_Of_Subjects - 1; i++) {
            // Keep asking for input until valid marks are entered.
            while (true) {
                System.out.print("Enter individual subject marks");
                try {
                    // After reading subject marks ansd store it in Subject_Marks Array
                    Subject_Marks[i] = sc.nextInt();
                    if (Subject_Marks[i] < 0) {
                        throw new InputMismatchException();
                    }

                    // Adds the individual subject marks
                    TotalNoofMarks += Subject_Marks[i];

                    // Exit the loop if input is valid
                    break;
                } catch (InputMismatchException e) {
                    // Handle exception for invalid input (non-integer or negative marks)
                    System.out.println("Please enter valid subject marks");
                    sc.nextLine();
                }
            }

        }
        double AveragePercentageOfMarks = (double) TotalNoofMarks / (Total_Num_Of_Subjects * 100) * 100;
        System.out.println("Total marks obtained is:" + TotalNoofMarks);
        System.out.println("Average percentage of marks:" + AveragePercentageOfMarks);

        // String builder is used when we need to concatenate or modify strings in a
        // loop
        StringBuilder grade = new StringBuilder(); // Creates a new Instance 'grade'

        // Use setGrade method to set the grade
        setGrade(AveragePercentageOfMarks, grade); // Calls the setGrade function and passes the input values to it.

        System.out.println("Grade of a student is:" + grade);

        // Closing the scanner class to release the resources
        sc.close();
    }

    // Calculating the grade based on average percentage of marks

    private static void setGrade(double AveragePercentageOfMarks, StringBuilder grade) {
        if (AveragePercentageOfMarks >= 90) {
            // Appending the calculated grade to the 'grade' StringBuilder
            grade.append("A");
        } else if (AveragePercentageOfMarks >= 80) {
            grade.append("B");
        } else if (AveragePercentageOfMarks >= 70) {
            grade.append("C");
        } else if (AveragePercentageOfMarks >= 60) {
            grade.append("D");
        } else {
            grade.append("F");
        }
    }
}