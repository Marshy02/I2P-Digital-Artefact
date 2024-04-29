import java.io.*;
import java.util.Scanner;
public class FileIO {
                                                        //Declare folder for storing saved NPC files
    public static final String DIRECTORY_NON_PLAYER_CHARACTERS = "src" + File.separator + "Characters";
    public static Scanner input = new Scanner(System.in);

    public static void WriteToFile(NonPlayerCharacter npc){
        String fileName = npc.GetName() + ".txt";       //Generate a file using the inputted NPC's name
        File file = new File( DIRECTORY_NON_PLAYER_CHARACTERS, fileName);

        file.getParentFile().mkdirs();                  //Creates a new Characters directory if one does not exist

        try{                                            //Try to write each NPC attribute as a separate line in a text file
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(npc.GetName() + "\n");
            bufferedWriter.write(npc.GetAge() + "\n");
            bufferedWriter.write(npc.GetGender() + "\n");
            bufferedWriter.write(npc.GetRace() + "\n");
            bufferedWriter.write(npc.GetVoice() + "\n");
            bufferedWriter.write(npc.GetLocation() + "\n");
            bufferedWriter.write(npc.GetCategory() + "\n");

            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException e){                          //Catch any Input/Output errors
            System.err.println(e.getMessage());
        }
    }

    public static NonPlayerCharacter LoadNPCData(){
        System.out.println("Which NPC would you like to view details about?");
        String npcName = input.nextLine();

        String fileName = DIRECTORY_NON_PLAYER_CHARACTERS + File.separator + npcName + ".txt";
        File file = new File(fileName);                 //Designates a file to check based on user's input

        if (!file.exists()){                            //Checks if the file exists and errors out if not
            System.err.println("File does not exist or could not be read");
            return null;
        }

        try{                                            //Try to read each line of a found text file and assign them to NPC attributes
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String name = bufferedReader.readLine();
            String age = bufferedReader.readLine();
            String gender = bufferedReader.readLine();
            String race = bufferedReader.readLine();
            String voice = bufferedReader.readLine();
            String location = bufferedReader.readLine();
            String category = bufferedReader.readLine();

            bufferedReader.close();

            return new NonPlayerCharacter(name, age, gender, race, voice, location, category);
        }catch(IOException | NumberFormatException e){  //Catch Input/Output and Integer errors
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void DeleteNPCFile(){
        System.out.println("Which NPC would you like to delete?");
        String npcName = input.nextLine();
        String confirmDelete;

        String fileName = DIRECTORY_NON_PLAYER_CHARACTERS + File.separator + npcName + ".txt";
        File file = new File(fileName);                 //Designates a file to check based on user's input

        if (!file.exists()){                            //Check NPC is saved
            System.err.println("File does not exist or could not be read");
        }
        else {                                          //Continue if NPC file exists
            System.out.println("You've chosen to delete " + npcName + ", are you sure?");
            System.out.println("---------------------------------------------------------------------------");
            do {                                        //Loop until the user answers DELETE or CANCEL
                System.out.println("Please type DELETE to confirm or CANCEL to back out");
                confirmDelete = input.nextLine();
            }
            while(!(confirmDelete.equals("DELETE")) && !(confirmDelete.equals("CANCEL")));

            if (confirmDelete.equals("DELETE")) {       //Tries to delete NPC file if user selects DELETE
                if (file.delete()) {
                    System.out.println("Deleted " + file.getName());
                } else {
                    System.out.println("Failed to delete " + file.getName());
                }
            }
            else{                                       //Exits if user selects CANCEL
                System.out.println("Delete cancelled, " + npcName + " is still saved");
            }
        }
    }
}