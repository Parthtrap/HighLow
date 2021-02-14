package HighLow;
import java.util.Random;
import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        int CurrentNumber, NextNumber, Score;
        boolean Flag = true, Game = true, again = true;
        char Choice;
        System.out.println("Welcome to the game of HighLow");
        Scanner Sc = new Scanner(System.in);
        Random Rand = new Random();
        while(again)
        {
            Game = true;
            Score = 0;
            NextNumber = Rand.nextInt(100);
            while (Game) {
                CurrentNumber = NextNumber;
                NextNumber = Rand.nextInt(100);
                System.out.println("\nYour current number is : " + CurrentNumber);
                System.out.println("Will the new number be Higher (H) or Lower (L)?");
                while (true) {
                    Choice = Sc.next().charAt(0);
                    if (Choice == 'H' || Choice == 'h') {
                        Flag = CurrentNumber < NextNumber;
                        break;
                    } else if (Choice == 'l' || Choice == 'L') {
                        Flag = CurrentNumber > NextNumber;
                        break;
                    } else
                        System.out.println("Enter H or L");
                }
                if (CurrentNumber == NextNumber)
                {
                    System.out.println("Wow... They are equal... 2 points for that one");
                    Score += 2;
                }
                else if (Flag) {
                    System.out.println("Correct, The new number was : " + NextNumber);
                    Score++;
                } else {
                    System.out.println("Whoops, The new number was : " + NextNumber);
                    Game = false;
                }
            }
            System.out.println("Your Final Score is : " + Score);
            System.out.println("Wanna play again? (Y/N)");
            Choice = Sc.next().charAt(0);
            switch (Choice) {
                case 'N':
                case 'n':
                    again = false;
                    break;
                default:
                    break;
            }
        }
        Sc.close();
    }
}
