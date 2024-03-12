import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
class DigitalArtefactMenu{
    private static Scanner input = new Scanner(System.in);
    //Declare global variables that can be used multiple times
    //Variables for createNPC()
    private static String firstNameNPC;
    private static String lastNameNPC;
    private static String ageNPC;
    private static String genderNPC;
    private static String voiceNPC;
    private static String locationNPC;
    private static String categoryNPC;
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
        System.out.println("What is this character's first name? If they have a middle name, please include that here");
        firstNameNPC = input.nextLine();
        System.out.println("What is this character's last name?");
        lastNameNPC = input.nextLine();
        System.out.println("How old are they?");
        ageNPC = input.nextLine();
        System.out.println("What is their gender?");
        genderNPC = input.nextLine();
        System.out.println("What do they sound like?");
        voiceNPC = input.nextLine();
        System.out.println("Where will they be first encountered?");
        locationNPC = input.nextLine();
        System.out.println("What category do they fall under? Please select one of the following options:" +
                "\nAllies\nEnemies\nService Providers\nQuest Givers\nNeutral Parties");
        categoryNPC = input.nextLine();
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void readNPC(){
        System.out.println("You've selected to view details about " + firstNameNPC);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Name: " + firstNameNPC + " " + lastNameNPC);
        System.out.println("Age: " + ageNPC);
        System.out.println("Gender: " + genderNPC);
        System.out.println("Voice: " + voiceNPC);
        System.out.println("Location: " + locationNPC);
        System.out.println("Category: " + categoryNPC);
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void editNPC(){
        System.out.println("You've chosen to edit information about " + firstNameNPC);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Which attribute would you like to change?");
        changeAttribute = input.nextLine();
        switch (changeAttribute){
            case "First name":
                System.out.println("What would you like to change their first name to?");
                firstNameNPC = input.nextLine();
                break;
            case "Last name":
                System.out.println("What would you like to change their last name to?");
                lastNameNPC = input.nextLine();
                break;
            case "Age":
                System.out.println("How old should they be?");
                ageNPC = input.nextLine();
                break;
            case "Gender":
                System.out.println("What would you like to change their gender to?");
                genderNPC = input.nextLine();
                break;
            case "Voice":
                System.out.println("How should they sound?");
                voiceNPC = input.nextLine();
                break;
            case "Location":
                System.out.println("Where should they be?");
                locationNPC = input.nextLine();
                break;
            case "Category":
                System.out.println("What category of NPC should they fall under?");
                categoryNPC = input.nextLine();
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