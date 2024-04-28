import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
public class NPCMenu {
    Scanner input = new Scanner(System.in);
    FileIO readNPC = new FileIO();
    public void DisplayMenu(){
        System.out.println("Hello and welcome to your D&D NPC Builder and Tracker!");
        System.out.println("---------------------------------------------------------------------------");


        //Get the user to pick an option from the menu
        //Loop the user until they wish to exit the system
        String stayOption = "Yes";
        while(!(stayOption.equals("No")) && !(stayOption.equals("no")) && !(stayOption.equals("N")) && !(stayOption.equals("n"))) {
            System.out.println("""
                    Please select one of the following options:
                    OPTION 1 - Create a new Non-Player Character
                    OPTION 2 - View information about an NPC
                    OPTION 3 - Edit information about an NPC
                    OPTION 4 - Delete an NPC
                    OPTION 5 - Hear a bad D&D themed pun""");
            int userChoice = input.nextInt();
            input.nextLine();

            if (0 < userChoice && userChoice < 6) {     //Validate the menu option chosen is between 1 and 4
                NonPlayerCharacter npcDetails;
                switch (userChoice) {
                    case 1:                             //Allow the user to build an NPC
                        npcDetails = new NonPlayerCharacter();
                        FileIO.WriteToFile(npcDetails);
                        break;
                    case 2:                             //Display attributes of a built NPC
                        ReadNPC();
                        break;
                    case 3:                             //Amend attributes of an NPC
                        EditNPC();
                        break;
                    case 4:                             //Delete an NPC from file
                        System.out.println("---------------------------------------------------------------------------");
                        FileIO.DeleteNPCFile();
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                    case 5:                             //Display one of three bad puns for the user
                        System.out.println("---------------------------------------------------------------------------");
                        dndPun();
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                }
                do {                                    //Loop until the user answers Yes or No, accepting similar formats
                    System.out.println("Do you wish to continue? (Yes/No)");
                    stayOption = input.nextLine();
                }
                while(!(stayOption.equals("Yes")) && !(stayOption.equals("No")) &&
                !(stayOption.equals("yes")) && !(stayOption.equals("no")) &&
                !(stayOption.equals("Y")) && !(stayOption.equals("N")) &&
                !(stayOption.equals("y")) && !(stayOption.equals("n")));
            } else {                                    //Exit out if user chooses an option not between 1 and 4
                System.out.println("Invalid option chosen, please start again");
            }
        }
        System.out.println("The system will exit now, goodbye!");

        input.close();
    }

    public void EditNPC(){
        NonPlayerCharacter editNPC = readNPC.LoadNPCData();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("You've chosen to edit information about " + editNPC.GetName());
        System.out.println("Which attribute would you like to change?");
        String changeAttribute = input.nextLine();
        switch (changeAttribute){
            case "Name":
                System.out.println("What would you like to change their name to?");
                editNPC.SetName(input.nextLine());
                break;
            case "Age":
                System.out.println("How old should they be?");
                editNPC.SetAge(input.nextLine());
                break;
            case "Gender":
                System.out.println("What would you like to change their gender to?");
                editNPC.SetGender(input.nextLine());
                break;
            case "Race":
                System.out.println("What race should they be?");
                editNPC.SetRace(input.nextLine());
                break;
            case "Voice":
                System.out.println("How should they sound?");
                editNPC.SetVoice(input.nextLine());
                break;
            case "Location":
                System.out.println("Where should they be?");
                editNPC.SetLocation(input.nextLine());
                break;
            case "Category":
                System.out.println("What category of NPC should they fall under?");
                editNPC.SetCategory(input.nextLine());
                break;
        }
        FileIO.WriteToFile(editNPC);
        System.out.println("---------------------------------------------------------------------------");
    }

    public void ReadNPC(){
        NonPlayerCharacter displayNPC = readNPC.LoadNPCData();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("You've selected to view details about " + displayNPC.GetName());
        System.out.println("Name: " + displayNPC.GetName());
        System.out.println("Age: " + displayNPC.GetAge());
        System.out.println("Gender: " + displayNPC.GetGender());
        System.out.println("Race: " + displayNPC.GetRace());
        System.out.println("Voice: " + displayNPC.GetVoice());
        System.out.println("Location: " + displayNPC.GetLocation());
        System.out.println("Category: " + displayNPC.GetCategory());
        System.out.println("---------------------------------------------------------------------------");
    }

    public void dndPun(){
        int randomPun = ThreadLocalRandom.current().nextInt(1, 3 + 1);
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