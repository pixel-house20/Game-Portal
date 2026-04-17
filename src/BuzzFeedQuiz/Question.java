/* Irene Feng 10/12/2022
A question class with Answers.
 */
import java.util.Scanner;

public class Question {

    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[5];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category that corresponds to the answer
    Category ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:"
                    + this.possibleAnswers[i].label);
        }

        int ans;

        while (true) {
            System.out.println("Enter your choice (1-" + possibleAnswers.length + "):");

            if (sc.hasNextInt()) {
                ans = sc.nextInt();

                if (ans >= 1 && ans <= possibleAnswers.length) {
                    return possibleAnswers[ans - 1].cat;
                } else {
                    System.out.println("Number out of range.");
                }
            } else {
                System.out.println("Unrecognizable input. Please enter a number.");
                sc.next();
            }
        }

    }

}
