import java.util.Scanner;

/**
 * Created by fhani on 6/30/2017.
 */
public class Lab6 {

    public static void main(String[] args) {
        String keepGoing = "";

        // 1. Display welcome message
        System.out.println("Welcome to the Pig Latin Translator!\n");

        do {
            // 2. prompt for user input
            System.out.println("Enter a line to be translated: ");

            // 3. get user input
            Scanner scnr = new Scanner(System.in);
            String userInput = scnr.nextLine();


            // 4. translate user input
            // 4.1 convert input to lowercase
            userInput = userInput.toLowerCase();
            userInput = userInput.replaceAll("'", "");
            if (userInput.isEmpty()) {
                System.out.println("Nothing entered.");
                keepGoing = "y"; // make it loop again if nothing is entered.
                continue;
            }

            if (userInput.contains("@")) { // checking for email address only - HOW TO INCLUDE ALL SYMBOLS
                System.out.println(userInput);
            }
            else {
                String result;
                if (isVowel(userInput)) {//vowels
                    result = piggifiedVowels(userInput);
                } else {
                    result = piggifiedConsonants(userInput);
                } //consonants

                // 5. display result
                System.out.println(result);
            }

            // 6. prompt user to play again
            System.out.println("Would you like to continue? (Y/N)");
            keepGoing = scnr.nextLine();
            //why did i not need a scnr garbage line here???????
            //scnr.nextLine(); --> caused loop to not work

        } while (keepGoing.equalsIgnoreCase("y") && (!keepGoing.equalsIgnoreCase("N")));
    }

    //translates a word using consonant pig latin logic
    private static String piggifiedVowels(String userInput) {
        String changedInput = userInput.concat("way");
        return changedInput;
    }


    //translates a word using vowel pig latin logic
    public static String piggifiedConsonants(String userInput) {
        String newWord = "";
        StringBuffer strBuffer = new StringBuffer(userInput);

        for (int i = 0; i < userInput.length(); ++i) {
            if ((userInput.charAt(i) == 'a') || (userInput.charAt(i) == 'e')
                    || (userInput.charAt(i) == 'i') || (userInput.charAt(i) == 'o')
                    || (userInput.charAt(i) == 'u')){

                strBuffer = strBuffer.append((strBuffer.subSequence(0, i)));
                strBuffer = strBuffer.append("ay");
                strBuffer.delete(0,i);
                newWord = strBuffer.toString();
                return newWord;
            }
        }
        return userInput;
    }


    /*Determines if a word starts with a vowel or consonant
     *  */
    public static boolean isVowel(String userInput) {
        if (userInput.charAt(0) == 'a' || userInput.charAt(0) == 'e' ||
                userInput.charAt(0) == 'i' || userInput.charAt(0) == 'o' ||
                userInput.charAt(0) == 'u') {
            return true; //other ways to do this -- regex
        }
        return false; //doesn't get to this because if statement true
    }
}


//TODO
//figure out how to apply to full sentences