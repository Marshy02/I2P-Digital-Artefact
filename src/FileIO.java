import java.io.*;
import java.util.Scanner;
public class FileIO {
    public static final String DIRECTORY_NON_PLAYER_CHARACTERS = "src" + File.separator + "Characters";

    public static void WriteToFile(NonPlayerCharacter npc){
        String fileName = npc.GetName() + ".txt";
        File file = new File( DIRECTORY_NON_PLAYER_CHARACTERS, fileName);

        file.getParentFile().mkdirs();

        try{
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
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public static NonPlayerCharacter LoadNPCData(){
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Which NPC would you like to view details about?");
        String npcName = input.nextLine();

        String fileName = DIRECTORY_NON_PLAYER_CHARACTERS + File.separator + npcName + ".txt";
        File file = new File(fileName);

        if (!file.exists()){
            System.err.println("File does not exist or could not be read");
            return null;
        }

        try{
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
        }catch(IOException | NumberFormatException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}