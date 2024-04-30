import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
import static java.lang.Integer.parseInt;

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

            if (0 < userChoice && userChoice < 6) {     //Validate the menu option chosen is between 1 and 6
                NonPlayerCharacter npcDetails;
                switch (userChoice) {
                    case 1:                             //Allow the user to build an NPC
                        System.out.println("---------------------------------------------------------------------------");
                        npcDetails = new NonPlayerCharacter();
                        FileIO.WriteToFile(npcDetails);
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                    case 2:                             //Display attributes of a built NPC
                        System.out.println("---------------------------------------------------------------------------");
                        ReadNPC();
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                    case 3:                             //Amend attributes of an NPC
                        System.out.println("---------------------------------------------------------------------------");
                        EditNPC();
                        System.out.println("---------------------------------------------------------------------------");
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

    public void ReadNPC(){                              //Method for displaying details about a chosen NPC
        NonPlayerCharacter displayNPC = readNPC.LoadNPCData();
        System.out.println("You've selected to view details about " + displayNPC.GetName());
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Name: " + displayNPC.GetName());
        System.out.println("Age: " + displayNPC.GetAge());
        System.out.println("Gender: " + displayNPC.GetGender());
        System.out.println("Race: " + displayNPC.GetRace());
        System.out.println("Voice: " + displayNPC.GetVoice());
        System.out.println("Location: " + displayNPC.GetLocation());
        System.out.println("Category: " + displayNPC.GetCategory());
    }

    public void EditNPC(){                              //Method for editing attributes of a chosen NPC
        NonPlayerCharacter editNPC = readNPC.LoadNPCData();
        String changeAttribute;
        int tempAge = 0;
        String tempRace;
        String tempCategory;
        System.out.println("You've chosen to edit information about " + editNPC.GetName());
        System.out.println("---------------------------------------------------------------------------");
        do{                                             //Loop the user until they select a valid attribute to edit
            System.out.println("Which attribute would you like to change?");
            changeAttribute = input.nextLine();
        } while(!(changeAttribute.equals("Name")) && !(changeAttribute.equals("Age")) && !(changeAttribute.equals("Gender"))
                && !(changeAttribute.equals("Race")) && !(changeAttribute.equals("Voice"))
                && !(changeAttribute.equals("Location")) && !(changeAttribute.equals("Category")));

        switch (changeAttribute){                       //Allow the user to change a chosen attribute
            case "Name":
                String fileName = FileIO.DIRECTORY_NON_PLAYER_CHARACTERS + File.separator + editNPC.GetName() + ".txt";
                File file = new File(fileName);
                file.delete();                          //Delete file with old name so duplicates are not stored under multiple names

                String tempName;
                do{                                     //Loop the user to prevent null value input
                    System.out.println("What would you like to change their name to?");
                    tempName = input.nextLine();
                } while(tempName.isEmpty());

                editNPC.SetName(tempName);
                break;
            case "Age":
                do{                                     //Loop the user until a valid age is inputted
                    try{
                        System.out.println("How old should they be?");
                        tempAge = parseInt(input.nextLine());
                    } catch(NumberFormatException e) {  //Displays a meaningful error message if the user enters anything but a number
                        System.err.println(e.getMessage() + "\nAge will be set to 0, please add a valid age in OPTION 3 - Edit information about an NPC");
                    }
                } while(tempAge < 0);
                editNPC.SetAge(tempAge);
                break;
            case "Gender":
                String tempGender;
                do{                                     //Loop the user to prevent null value input
                    System.out.println("What would you like to change their gender to?");
                    tempGender = input.nextLine();
                } while(tempGender.isEmpty());

                editNPC.SetGender(tempGender);
                break;
            case "Race":
                do{                                     //Loop the user until a valid race is inputted
                    System.out.println("What race should they be? Please select one of the following options:" +
                            "\nHuman\nElf\nDwarf");
                    tempRace = input.nextLine();
                } while(!(tempRace.equals("Human")) && !(tempRace.equals("Elf")) && !(tempRace.equals("Dwarf")));
                editNPC.SetRace(tempRace);
                break;
            case "Voice":
                String tempVoice;
                do{                                     //Loop the user to prevent null value input
                    System.out.println("How should they sound?");
                    tempVoice = input.nextLine();
                } while (tempVoice.isEmpty());

                editNPC.SetVoice(tempVoice);
                break;
            case "Location":
                String tempLocation;
                do{                                     //Loop the user to prevent null value input
                    System.out.println("Where should they be?");
                    tempLocation = input.nextLine();
                } while(tempLocation.isEmpty());

                editNPC.SetLocation(tempLocation);
                break;
            case "Category":
                do{                                     //Loop the user until a valid category is inputted
                    System.out.println("What category of NPC should they fall under? Please select one of the following options:" +
                            "\nAllies\nEnemies\nService Providers\nQuest Givers\nNeutral Parties");
                    tempCategory = input.nextLine();
                } while(!(tempCategory.equals("Allies")) && !(tempCategory.equals("Enemies")) && !(tempCategory.equals("Service Providers"))
                        && !(tempCategory.equals("Quest Givers")) && !(tempCategory.equals("Neutral Parties")));
                editNPC.SetCategory(tempCategory);
                break;
        }
        FileIO.WriteToFile(editNPC);                    //Write updated details to selected file
    }

    public void dndPun(){                               //Method for displaying a D&D-themed pun
        int randomPun = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        String[] puns = {"Why do paladins prefer chain mail? Because it’s holey armor.", "Why do rogues prefer leather armor? Because it’s made of Hide.", "I once heard of a Druid who could wield swords while using wild shape. She had a right to bear arms."};
        switch (randomPun) {                            //Outputs one of three puns at random
            case 1:
                System.out.println(puns[0]);
                break;
            case 2:
                System.out.println(puns[1]);
                break;
            case 3:
                System.out.println(puns[2]);
                break;
        }
    }
}