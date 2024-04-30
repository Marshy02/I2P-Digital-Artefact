/*
FileIO.java
Authored by Daniel Marsh
File Interaction Functional Class to Write, Read and Delete files as parameterized functions are called from NPCMenu.
 */

package Functions;
import Objects.NonPlayerCharacter;
import java.io.*;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class FileIO {
                                                        //Declare folder for storing saved NPC files
    public static final String DIRECTORY_NON_PLAYER_CHARACTERS = "src" + File.separator + "Characters";

    public static void WriteToFile(NonPlayerCharacter npc){
        String fileName = npc.GetName() + ".txt";       //Generate a file using the inputted NPC's name
        File file = new File(DIRECTORY_NON_PLAYER_CHARACTERS, fileName);

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

    public static NonPlayerCharacter LoadNPCData(String npcName){
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
            int age = parseInt(bufferedReader.readLine());
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

    public static void DeleteNPCFile(String npcName){
        String fileName = DIRECTORY_NON_PLAYER_CHARACTERS + File.separator + npcName + ".txt";
        File file = new File(fileName);                 //Designates a file to check based on user's input

        if (!file.exists()){                            //Check NPC is saved
            System.err.println("File does not exist or could not be read");
        }
        else {                                          //Continue if NPC file exists
            if (file.delete()) {
                System.out.println("Deleted " + file.getName());
            } else {
                System.out.println("Failed to delete " + file.getName());
            }
        }
    }
}