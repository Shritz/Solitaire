import java.util.Scanner;
import java.util.Random;


public class Solitaire {
    static Scanner in = new Scanner (System.in);
    public static void main (String[] args) {
        Deck myDeck = new Deck();
        int option = menu();
        Card C;
        while (option != 5) {
            if (option == 1) {
                System.out.println("New Deck is created!");
                myDeck = new Deck();
            } else if (option == 2) {
                myDeck.display();
            } else if (option == 3) {
                myDeck.shuffle();
                System.out.println("Your Deck has been shuffled!");
            } else if (option == 4) {
                System.out.println("\n Play Solitaire");
                int sum = 0;
                int a = 0;
                for (int x = 0; x < 52; x++) {
                    C = myDeck.deal();
                    C.display();
                    System.out.print(" ");
                    sum = sum + C.getValue();
                    if (isPrime(sum)) {
                        System.out.println("PRIME:" + sum);
                        sum = 0;
                        a++;
                    }
                }

                if (sum == 0) {
                    System.out.println("\nCongratulations");
                    System.out.println("You have won in " + a + "piles!");
                } else {
                    System.out.println("\nYou have lost!");
                }
            } else {
                System.out.println("Invalid input! Please try again.");
            }
            System.out.println();
            option = menu();


        }
    }

    public static int menu () {
        System.out.println("Welcome to Solitaire Prime!");
        System.out.println("1) New Deck");
        System.out.println("2) Display Deck");
        System.out.println("3) Shuffle Deck");
        System.out.println("4) Play Solitaire Prime");
        System.out.println("5) Exit");
        System.out.println("Please enter your option: ");
        int option = in.nextInt();
        return option;
    }

    public static boolean isPrime(int x) {
        boolean prime = true;
        if (x % 2 == 0 || x % 3 == 0 || x % 5 == 0 || x % 7 == 0 || x == 1)
        {
            prime = false;
        }

        else if (x == 2 || x == 3 || x == 5 || x == 7) {
            prime = true;
        }

        return prime;

    }
}

