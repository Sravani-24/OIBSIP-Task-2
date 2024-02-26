package guess;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class GuessingGame 
{
    public static void main(String[] args) 
    {
        Random random=new Random();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the maximum number of guesses for each round: ");
        int maxGuesses=scanner.nextInt();
        System.out.print("Enter the number of rounds: ");
        int numRounds=scanner.nextInt();
        boolean playAgain=true;
        while(playAgain) 
        {
            for(int round=1;round<=numRounds;round++) 
            {
                int numberToGuess=random.nextInt(100)+1;
                int numGuesses=0;
                System.out.println("Welcome to Round "+round+"!");
                System.out.println("I'm thinking of a number between 1 and 100.");
                while(true) 
                {
                    if(numGuesses>=maxGuesses)
                    {
                        System.out.println("Sorry, you ran out of guesses! The number was " + numberToGuess + ".");
                        System.out.println();
                        break;
                    }
                    System.out.println("Guesses remaining: " + (maxGuesses - numGuesses));
                    System.out.print("Take a guess: ");
                    try 
                    {
                        int guess=scanner.nextInt();
                        numGuesses++; 
                        if(guess<1||guess>100) 
                        {
                        	System.out.println("Guess must be between 1 and 100! Please try again.");
                        }
                        if(guess==numberToGuess) 
                        {
                            int score=100-(numGuesses*10); 
                            System.out.println("You guessed it! The number was "+numberToGuess + ".");
                            System.out.println("Your score is "+score+".");
                            break;
                        } 
                        else if(guess<numberToGuess) 
                            System.out.println("Your guess is too low. Try again.");
                        else 
                            System.out.println("Your guess is too high. Try again.");
                    } 
                    catch(InputMismatchException e) 
                    {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next(); 
                    } 
                    catch(IllegalArgumentException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.out.println("Do you want to play another round? (yes/no)");
            scanner.nextLine(); 
            String answer=scanner.nextLine();
            playAgain=answer.equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing!");
        scanner.close(); 
    }
}
