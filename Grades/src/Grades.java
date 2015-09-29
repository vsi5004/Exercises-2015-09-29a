
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Repeatedly prompt the user to enter a grade.
 * 
 * The grade must be between 0 and 100; or it can be equal to -1.
 * Entering a -1 means the user has finished entering grades.
 * 
 * Output to the user
 * - How many grades the user entered
 * - The average of the grades
 * - Error messages when appropriate
 * 
 * Sample interaction:
 * 
 * Enter a grade: 70
 * Enter a grade: 75
 * Enter a grade: 101
 * Error. Grade must be between 0 and 100; or -1 to finish
 * Enter a grade: -1
 * 
 * You entered 2 grades. The average is 72.5
 */
public class Grades {

    public static void main(String[] args) {
        System.out.println("Please enter a series of grades ranging from 0 to 100. When finished, enter -1");
        String input = null;
        int grade = 0;
        int gradeTotal = 0;
        int gradeCounter = 0;
        double gradeAverage = 0;

        //loop runs until user enters the exit value as a grade
        while (grade != -1) {
            try {
                System.out.print("Enter a grade: ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                input = bufferedReader.readLine();
                grade = Integer.parseInt(input);
                if (grade < 101 && grade > -1) {
                    gradeCounter++;
                    gradeTotal += grade;
                } else if (grade != -1) {
                    System.out.println("Error. Grade must be between 0 and 100; or -1 to finish.");
                }

            } catch (NumberFormatException ex) {
                System.out.println("Not a number !");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //takes average of all grades, rounds to two places
        gradeAverage = round2((double) gradeTotal / gradeCounter);
        //checks if there were actually any grades entered
        if (gradeCounter == 0) {
            System.out.println("You did not enter any grades, there is no average.");
        } else {
            System.out.println("You entered " + gradeCounter + " grades. The average is " + gradeAverage);
        }
    }

    //rounds decimal number to two places
    public static double round2(double value) {
        double result = value * 100;
        result = Math.round(result);
        result = result / 100;
        return result;
    }

}
