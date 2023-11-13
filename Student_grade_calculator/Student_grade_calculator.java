package Student_grade_calculator;
import java.util.Scanner;

public class Student_grade_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of subjects for which grade to be calculated");
        int numOfSubjects = sc.nextInt();
        int TotalNoofMarks = 0;
        for(int i=1; i <= numOfSubjects; i++){
            System.out.print("Enter individual subject marks");
            int IndividualSubjectMarks = sc.nextInt();
            TotalNoofMarks += IndividualSubjectMarks;
        }
        double AveragePercentageOfMarks = (double) TotalNoofMarks / (numOfSubjects * 100) * 100;
        System.out.println("Total marks obtained is:" + TotalNoofMarks);
        System.out.println("Average percentage of marks:" + AveragePercentageOfMarks);
        System.out.println("Grade of a student is:" + GradeCalculation(AveragePercentageOfMarks));
        sc.close();
    }
    private static String GradeCalculation(double AveragePercentageOfMarks){
        if(AveragePercentageOfMarks >= 90){
            return "A";
        }
        else if(AveragePercentageOfMarks >= 80){
            return "B";
        }
         else if(AveragePercentageOfMarks >= 70){
            return "C";
         }
          else if(AveragePercentageOfMarks >= 60){
                return "D";
            }
            else {
                return "F";
            }
        }
    }