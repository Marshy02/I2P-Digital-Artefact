import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
class MenuSystem{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int currentYear = 2024;                     //Set the current year for calculating start year at user's job

        System.out.println("Hello and welcome to the programme!\n" +
                "Before we start, let's collect some information about you.");

        //Get user's first name
        System.out.println("What is your first name?");
        String firstName = input.nextLine();

        //Get user's surname
        System.out.println("What is your last name?");
        String lastName = input.nextLine();

        //Get user's workplace
        System.out.println("What company do you work for?");
        String company = input.nextLine();

        //Get user's time worked
        System.out.println("How many years have you worked there?");
        int timeWorked = input.nextInt();

        //Introduce programme
        System.out.println("Okay, all information has been gathered.\n" +
                "Welcome to the programme " + firstName + " " + lastName +
                ". Congratulations on working for " + company + " for " +
                timeWorked + " years.\nNow let's begin...");

        //Get the user to pick an option from the menu
        System.out.println("Please select one of the following options:" +
                "\nOPTION 1 - Remember your name" +
                "\nOPTION 2 - Remember where you work" +
                "\nOPTION 3 - Remember when you started work" +
                "\nOPTION 4 - Hear a bad pun");
        int userChoice = input.nextInt();

        if(0 < userChoice && userChoice < 5){       //Validate the menu option chosen is between 1 and 4
            switch(userChoice){
                case 1:                             //Display the user's full name
                    System.out.println("Your name is " + firstName + " " + lastName);
                    break;
                case 2:                             //Display the user's employer
                    System.out.println("You work at " + company);
                    break;
                case 3:                             //Display the year the user started at their current job
                    System.out.println("You started at " + company + " in " + (currentYear - timeWorked));
                    break;
                case 4:                             //Display one of three bad puns for the user
                    int randomPun = ThreadLocalRandom.current().nextInt(1,3 + 1);
                    switch(randomPun){
                        case 1:
                            System.out.println("I'm addicted to brake fluid, but it's okay because I can stop at any time.");
                            break;
                        case 2:
                            System.out.println("What do you call an alligator in a vest? An investigator.");
                            break;
                        case 3:
                            System.out.println("What did one eye say to the other? Just between you and me, something smells.");
                            break;
                    }
                    break;
            }
            System.out.println("The programme will exit now, goodbye!");
        }
        else{                                       //Exit out if user chooses an option not between 1 and 4
            System.out.println("Invalid option chosen, please start again");
        }

        input.close();
    }
}