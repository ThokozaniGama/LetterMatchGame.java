/*
Developed by Thokozani Gama

Pseudocode:
This programs asks the user to enter the junk input.
It sorts the junk input in ascending order according to ASCII conversion.
It prompts the user to search for a specific word without character replacement from the junk.
It provides a feedback.
*/

import java.util.Scanner; // Import the Scanner class for user input
import java.util.Arrays;    // Used for array primitive data char[]
import java.util.ArrayList; // Used for arrayList object


void menu()
{
    System.out.println("1. Match the next word.");
    System.out.println("0. Exit the game.\n");
}

void main() {

    // Create a Scanner object (similar to preparing cin)
    Scanner cin = new Scanner(System.in);
    int player;
    do {
        menu(); // Display the menu
        System.out.print("Enter your choice: ");
        player = cin.nextInt();

       if (player == 1) {

           // 1. Reading String input
           System.out.print("Enter the junk: ");
           String stringInput = cin.nextLine();

           // Convert the string into a primitive char[] array
           char[] alphabetArray = stringInput.toCharArray(); //Original junk

           // Sorts the entire array by ASCII values instantly
           Arrays.sort(alphabetArray);

           String sortedWord = new String(alphabetArray);

           // Print the array to verify the result
           System.out.println("You entered: " + sortedWord);

           // Put the sorted junk characters into an ArrayList so we can use .remove()/without replacement
           ArrayList<Character> alphabetList = new ArrayList<>(); // Clone for the original junk
           for (char ch : alphabetArray) {
               alphabetList.add(ch);
           }

           System.out.print("Search for a word: ");
           String search = cin.next();
           char[] searchArray = search.toCharArray();

           // This array object will store the temporary word
           ArrayList<Character> temp = new ArrayList<>();

           // Check the search word from the junk without replacement
           for (char searchChar : searchArray) {
               for (int n = 0; n < alphabetList.size(); n++) {
                   if (searchChar == alphabetList.get(n)) {
                       temp.add(searchChar);
                       alphabetList.remove(n); // Without replacement
                       break;
                   }
               }
           }

           // Using a quick loop (Very clean and easy to read)
           StringBuilder sb2 = new StringBuilder();
           for (char ch : temp) {
               sb2.append(ch);
           }
           String searchWord = sb2.toString();
           if (searchWord.equals(search)) { //Used .equals() to compare string
               System.out.println(searchWord + " was found.");
           } else {
               System.out.println(search + " was not found.");
           }

       }
       else if(player == 0){
           System.out.println("You exited the game, Bye!");
       }
    }while(player != 0);

    // Always close the scanner when done
    cin.close();
}
