import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
class DigitalArtefactMenu{
    private static Scanner input = new Scanner(System.in);
    //Declare global variables that can be used multiple times
    //String array for createNPC()
    private static String[] attributesNPC = new String [7];
    //Variables for editNPC()
    private static String changeAttribute;
    //Variables for dndPun()
    private static int randomPun;
    public static void main(String[] args){
        System.out.println("Hello and welcome to your D&D NPC Builder and Tracker!");

        //Get the user to pick an option from the menu
        //Loop the user until they wish to exit the system
        String stayOption = "Yes";
        while(!(stayOption.equals("No"))) {
            System.out.println("Please select one of the following options:" +
                    "\nOPTION 1 - Create a new Non-Player Character" +
                    "\nOPTION 2 - View information about your NPC" +
                    "\nOPTION 3 - Edit information about your NPC" +
                    "\nOPTION 4 - Hear a bad D&D themed pun");
            int userChoice = input.nextInt();
            input.nextLine();

            if (0 < userChoice && userChoice < 5) {     //Validate the menu option chosen is between 1 and 4
                switch (userChoice) {
                    case 1:                             //Allow the user to build an NPC
                        createNPC();
                        break;
                    case 2:                             //Display attributes of a built NPC
                        readNPC();
                        break;
                    case 3:                             //Amend attributes of an NPC
                        editNPC();
                        break;
                    case 4:                             //Display one of three bad puns for the user
                        dndPun();
                        break;
                }
                do {                                    //Loop until the user answers Yes or No
                    System.out.println("Do you wish to continue? (Yes/No)");
                    stayOption = input.nextLine();
                }
                while(!(stayOption.equals("Yes")) && !(stayOption.equals("No")));
            } else {                                    //Exit out if user chooses an option not between 1 and 4
                System.out.println("Invalid option chosen, please start again");
            }
        }
        System.out.println("The system will exit now, goodbye!");

        input.close();
    }

    public static void createNPC(){
        System.out.println("You've selected to build an NPC, please provide some information about them");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("What is this character's name?");
        attributesNPC[0] = input.nextLine();
        System.out.println("How old are they?");
        attributesNPC[1] = input.nextLine();
        System.out.println("What is their gender?");
        attributesNPC[2] = input.nextLine();
        System.out.println("What is their race? Please select one of the following options:" +
                "\nHuman\nElf\nDwarf");
        attributesNPC[3] = input.nextLine();
        System.out.println("What do they sound like?");
        attributesNPC[4] = input.nextLine();
        System.out.println("Where will they be first encountered?");
        attributesNPC[5] = input.nextLine();
        System.out.println("What category do they fall under? Please select one of the following options:" +
                "\nAllies\nEnemies\nService Providers\nQuest Givers\nNeutral Parties");
        attributesNPC[6] = input.nextLine();
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void readNPC(){
        System.out.println("You've selected to view details about " + attributesNPC[0]);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Name: " + attributesNPC[0]);
        System.out.println("Age: " + attributesNPC[1]);
        System.out.println("Gender: " + attributesNPC[2]);
        System.out.println("Race: " + attributesNPC[3]);
        System.out.println("Voice: " + attributesNPC[4]);
        System.out.println("Location: " + attributesNPC[5]);
        System.out.println("Category: " + attributesNPC[6]);
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void editNPC(){
        System.out.println("You've chosen to edit information about " + attributesNPC[0]);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Which attribute would you like to change?");
        changeAttribute = input.nextLine();
        switch (changeAttribute){
            case "Name":
                System.out.println("What would you like to change their name to?");
                attributesNPC[0] = input.nextLine();
                break;
            case "Age":
                System.out.println("How old should they be?");
                attributesNPC[1] = input.nextLine();
                break;
            case "Gender":
                System.out.println("What would you like to change their gender to?");
                attributesNPC[2] = input.nextLine();
                break;
            case "Race":
                System.out.println("What race should they be?");
                attributesNPC[3] = input.nextLine();
                break;
            case "Voice":
                System.out.println("How should they sound?");
                attributesNPC[4] = input.nextLine();
                break;
            case "Location":
                System.out.println("Where should they be?");
                attributesNPC[5] = input.nextLine();
                break;
            case "Category":
                System.out.println("What category of NPC should they fall under?");
                attributesNPC[6] = input.nextLine();
                break;
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void dndPun(){
        randomPun = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch (randomPun) {
            case 1:
                System.out.println("Why do paladins prefer chain mail? Because it’s holey armor.");
                break;
            case 2:
                System.out.println("Why do rogues prefer leather armor? Because it’s made of Hide.");
                break;
            case 3:
                System.out.println("I once heard of a Druid who could wield swords while using wild shape. She had a right to bear arms.");
                break;
        }
    }
}