

import Game.GameWriteable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz implements GameWriteable {

    static Scanner sc = new Scanner(System.in);
    private int score = 0;

    @Override
    public String getGameName() {
        return "Book Genre Quiz";
    }

    @Override
    public void play() {
        gameIntro();

        // Create Categories
        Category fantasy = new Category("Fantasy",
                "You are imaginative and drawn to magical worlds.");
        Category horror = new Category("Horror",
                "You are intrigued by fear and the unknown.");
        Category mystery = new Category("Mystery",
                "You love solving puzzles and uncovering truth.");
        Category thriller = new Category("Thriller",
                "You enjoy fast-paced excitement.");
        Category dystopian = new Category("Dystopian",
                "You question systems and value justice.");

        // Create Questions
       // Question q1 = new Question("What's your ideal weekend plan?");
        Question q1 = new Question("What's your ideal weekend plan?");
        q1.possibleAnswers[0] = new Answer("Attend a protest", dystopian);
        q1.possibleAnswers[1] = new Answer("Explore abandoned places", horror);
        q1.possibleAnswers[2] = new Answer("Watch true crime", mystery);
        q1.possibleAnswers[3] = new Answer("Relax at a café", fantasy);
        q1.possibleAnswers[4] = new Answer("Go skydiving", thriller);

        Question q2 = new Question("Pick a setting:");
        q2.possibleAnswers[0] = new Answer("Underground bunker", dystopian);
        q2.possibleAnswers[1] = new Answer("Floating city", fantasy);
        q2.possibleAnswers[2] = new Answer("High-tech city", thriller);
        q2.possibleAnswers[3] = new Answer("Isolated woods", horror);
        q2.possibleAnswers[4] = new Answer("Mysterious island", mystery);

                Question q3 = new Question("How do you handle problems?");

        q3.possibleAnswers[0] = new Answer("Face them head-on, even if it scares you", horror);
        q3.possibleAnswers[1] = new Answer("Break the system and rebuild it", dystopian);
        q3.possibleAnswers[2] = new Answer("Think outside the box and imagine new solutions", fantasy);
        q3.possibleAnswers[3] = new Answer("Act fast and trust your instincts", thriller);
        q3.possibleAnswers[4] = new Answer("Analyze every detail until the answer appears ", mystery);

        Question q4 = new Question("What would you do if you were left in a new world?");

        q4.possibleAnswers[0] = new Answer("Look for ancient ruins to explore", thriller);
        q4.possibleAnswers[1] = new Answer("Seek out magic and allies to understand the new world", fantasy);
        q4.possibleAnswers[2] = new Answer("Secure resources and learn about both the good and the bad of the society", dystopian);
        q4.possibleAnswers[3] = new Answer("Stay alert and investigate who or what brought you there", mystery);
        q4.possibleAnswers[4] = new Answer("Find safety fast and avoid whatever lurks in the dark", horror);
        //make these extra questions 

        Question q5 = new Question("What emotion drives you the most?");
        q5.possibleAnswers[0] = new Answer("Excitement", thriller);
        q5.possibleAnswers[1] = new Answer("Adrenaline rush", horror);
        q5.possibleAnswers[2] = new Answer("wonder", fantasy);
        q5.possibleAnswers[3] = new Answer("Righteous anger", dystopian);
        q5.possibleAnswers[4] = new Answer("Curiosity", mystery);

        Question q6 = new Question("What would you do if you found a locked, mysterious box?");
        q6.possibleAnswers[0] = new Answer("Open it and see what is inside", horror);
        q6.possibleAnswers[1] = new Answer("Check if it was planted by some 'evil' force ", dystopian);
        q6.possibleAnswers[2] = new Answer("Try to crack it open with tools", thriller);
        q6.possibleAnswers[3] = new Answer("leave it thinking its pandora's box", fantasy);
        q6.possibleAnswers[4] = new Answer("Examine clues around it before deciding", mystery);
        Question q7 = new Question("pick an ultimate plot twist.");
        q7.possibleAnswers[0] = new Answer("An ancient force comes to earth and changes everything", fantasy);
        q7.possibleAnswers[1] = new Answer("The government has been lying for generations", dystopian);
        q7.possibleAnswers[2] = new Answer("The ally was the villain in disguise", thriller);
        q7.possibleAnswers[3] = new Answer("The answer was hidden in plain sight", mystery);
        q7.possibleAnswers[4] = new Answer("The monster was human all along", horror);
        Question q8 = new Question("Pick the atmosphere you're most drawn to.");
        q8.possibleAnswers[0] = new Answer("Eerie, quiet, and suspenseful", horror);
        q8.possibleAnswers[1] = new Answer("Mythical and whimsical", fantasy);
        q8.possibleAnswers[2] = new Answer("Stark, gritty, and intense", dystopian);
        q8.possibleAnswers[3] = new Answer("Calm, cerebral, and layered", mystery);
        q8.possibleAnswers[4] = new Answer("Fast-paced, sharp, and urgent", thriller);

        Question[] qList = {q1, q2, q3, q4, q5, q6, q7, q8};

        // Ask questions (reuse your Question.ask)
        for (Question q : qList) {
            Category c = q.ask(sc);
            c.points++;
            score++; // score = number of answered questions
        }

        Category[] cList = { dystopian, horror, mystery, fantasy, thriller };

        List<Integer> winners = getMostPopularCatIndex(cList);

        System.out.println("\nYou are:\n");

        for (int w : winners) {
            System.out.println("- " + cList[w].label);
            System.out.println("  " + cList[w].description + "\n");
        }
    }

    public static void gameIntro() {
        System.out.println("=== Book Genre Quiz ===");
        System.out.println("Enter numbers 1-5 to answer.\n");

        while (!sc.hasNextInt()) {
            System.out.println("Enter a number to start.");
            sc.next();
        }
        sc.nextInt(); // consume start input
    }

    public static List<Integer> getMostPopularCatIndex(Category[] counts){
int max = 0;

        for (Category c : counts) {
            if (c.points > max) {
                max = c.points;
            }
        }

        List<Integer> winners = new ArrayList<>();

        for (int i = 0; i < counts.length; i++) {
            if (counts[i].points == max) {
                winners.add(i);
            }
        }

        return winners;

    }
   

    

    @Override
    public String getScore() {
        return String.valueOf(score);
    }

    @Override
    public boolean isHighScore(String score, String currentHighScore) {
        if (currentHighScore == null) return true;

        try {
            return Integer.parseInt(score) > Integer.parseInt(currentHighScore);
        } catch (Exception e) {
            return true;
        }
    }
}
// /*
//  * Irene Feng Nov 2022
//  * This is the class where we create the Quiz and run it. It has the main method.  
//  */
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;
// import java.util.Scanner;

// import Game.GameWriteable;

// import java.util.HashMap;

// public class Quiz implements  GameWriteable {

//     static Scanner sc = new Scanner(System.in);

//     public static void main(String[] args) throws Exception {
//         // Create Categories
//         //change these 
//         Category fantasy = new Category("Fantasy",
//                 "You are imaginative, adventurous, and drawn to worlds full of magic and possibility. You believe anything is achievable with will power and courage.");
//         Category horror = new Category("Horror", "You appear calm on the surface, but you're fascinated by the darker side of life. You enjoy the trill of facing what others fear.");
//         Category mystery = new Category("Mystery",
//                 "You are observant, clever, and curious. You love solving puzzles and uncovering hidden truths wherever you go.");
//         Category thriller = new Category("Thriller", "You crave excitement and tension. Fast-paced challenges energize you, and you stay sharp when staeks are high.");
//         Category dystopian = new Category("Dystopian", "You question authority and notice flaws in systems others ignore. You value freedom, justice, and imagining how the world could be better.");

//         // Create Questions
//         Question q1 = new Question("What's your ideal weekend plan");
//         q1.possibleAnswers[0] = new Answer("Attending a protest or community event", dystopian);
//         q1.possibleAnswers[1] = new Answer("Exploring an abandoned building", horror);
//         q1.possibleAnswers[2] = new Answer("Watching true-crime documentaries", mystery);
//         q1.possibleAnswers[3] = new Answer("visting a quaint little café and daydreaming", fantasy);
//         q1.possibleAnswers[4] = new Answer("Going rock climbing or skydiving", thriller);

//         Question q2 = new Question("Pick a setting you'd love to live in");
//         q2.possibleAnswers[0] = new Answer("A futuristic underground bunker", dystopian);
//         q2.possibleAnswers[1] = new Answer("A floating city among the clouds", fantasy);
//         q2.possibleAnswers[2] = new Answer("A high-tech metropolis full of secrets", thriller);
//         q2.possibleAnswers[3] = new Answer("In the woods a good distance away from a town or city", horror);
//         q2.possibleAnswers[4] = new Answer("An island sectioned of from the rest of the world", mystery);

//         Question q3 = new Question("How do you handle problems?");

//         q3.possibleAnswers[0] = new Answer("Face them head-on, even if it scares you", horror);
//         q3.possibleAnswers[1] = new Answer("Break the system and rebuild it", dystopian);
//         q3.possibleAnswers[2] = new Answer("Think outside the box and imagine new solutions", fantasy);
//         q3.possibleAnswers[3] = new Answer("Act fast and trust your instincts", thriller);
//         q3.possibleAnswers[4] = new Answer("Analyze every detail until the answer appears ", mystery);

//         Question q4 = new Question("What would you do if you were left in a new world?");

//         q4.possibleAnswers[0] = new Answer("Look for ancient ruins to explore", thriller);
//         q4.possibleAnswers[1] = new Answer("Seek out magic and allies to understand the new world", fantasy);
//         q4.possibleAnswers[2] = new Answer("Secure resources and learn about both the good and the bad of the society", dystopian);
//         q4.possibleAnswers[3] = new Answer("Stay alert and investigate who or what brought you there", mystery);
//         q4.possibleAnswers[4] = new Answer("Find safety fast and avoid whatever lurks in the dark", horror);
//         //make these extra questions 

//         Question q5 = new Question("What emotion drives you the most?");
//         q5.possibleAnswers[0] = new Answer("Excitement", thriller);
//         q5.possibleAnswers[1] = new Answer("Adrenaline rush", horror);
//         q5.possibleAnswers[2] = new Answer("wonder", fantasy);
//         q5.possibleAnswers[3] = new Answer("Righteous anger", dystopian);
//         q5.possibleAnswers[4] = new Answer("Curiosity", mystery);

//         Question q6 = new Question("What would you do if you found a locked, mysterious box?");
//         q6.possibleAnswers[0] = new Answer("Open it and see what is inside", horror);
//         q6.possibleAnswers[1] = new Answer("Check if it was planted by some 'evil' force ", dystopian);
//         q6.possibleAnswers[2] = new Answer("Try to crack it open with tools", thriller);
//         q6.possibleAnswers[3] = new Answer("leave it thinking its pandora's box", fantasy);
//         q6.possibleAnswers[4] = new Answer("Examine clues around it before deciding", mystery);
//         Question q7 = new Question("pick an ultimate plot twist.");
//         q7.possibleAnswers[0] = new Answer("An ancient force comes to earth and changes everything", fantasy);
//         q7.possibleAnswers[1] = new Answer("The government has been lying for generations", dystopian);
//         q7.possibleAnswers[2] = new Answer("The ally was the villain in disguise", thriller);
//         q7.possibleAnswers[3] = new Answer("The answer was hidden in plain sight", mystery);
//         q7.possibleAnswers[4] = new Answer("The monster was human all along", horror);
//         Question q8 = new Question("Pick the atmosphere you're most drawn to.");
//         q8.possibleAnswers[0] = new Answer("Eerie, quiet, and suspenseful", horror);
//         q8.possibleAnswers[1] = new Answer("Mythical and whimsical", fantasy);
//         q8.possibleAnswers[2] = new Answer("Stark, gritty, and intense", dystopian);
//         q8.possibleAnswers[3] = new Answer("Calm, cerebral, and layered", mystery);
//         q8.possibleAnswers[4] = new Answer("Fast-paced, sharp, and urgent", thriller);

//         // For each question, ask, read input, store answer.
//     gameIntro();
//         Question[] qList = {q1, q2, q3, q4, q5, q6, q7, q8};
//         for (Question q : qList) {
//             Category c = q.ask(sc);
//            //change this to HashMaps
//             c.points++;

//         }
//         Category[] cList = {dystopian, horror, mystery, fantasy, thriller};
//         //printing the winners(aka what book genre you are)
//         List<Integer> allWinners = getMostPopularCatIndex(cList);

//         System.out.println("\nIf you were a book Genre, you would be:");

//         for (int w : allWinners) {
//             System.out.println("- " + cList[w].label);
//             System.out.println("  " + cList[w].description);
//             System.out.println();
//         }

//     }

//     public static void gameIntro() {

//         System.out.println("What Genre  of book are you?");
//         System.out.println("You get to choose numbers 1-5 for every question. Enter a number to play!");

//         if (!sc.hasNextInt()) {
//             System.out.println("Unidentifiable input. Please enter a number to play.\n");
//             sc.next();
//             gameIntro();
//             return;
//         }

//         int start = sc.nextInt();
//     }

//     // returns the index that is the max
//     // the tie breaker is the first Category that has the count is the "max" :/ 
//     public static List<Integer> getMostPopularCatIndex(Category[] counts) {
//         int maxCount = 0;
//         //finding all winners

//         for (Category c : counts) {
//             if (c.points > maxCount) {
//                 maxCount = c.points;
//             }
//         }
//     //collecting the winners  
//         List<Integer> findingWinners = new ArrayList<>();
//         for (int i = 0; i < counts.length; i++) {
//             if (counts[i].points == maxCount) {
//                 findingWinners.add(i);
//             }
//         }

//         return findingWinners;
//     }

// }
