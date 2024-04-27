import java.io.*;
import java.util.ArrayList;
public class FileIO {
    public static final String DIRECTORY_NON_PLAYER_CHARACTERS = "src" + File.separator + "Characters";

    public static void WriteToFile(NonPlayerCharacter npc){
        System.out.println("Reached WriteToFile");
        String fileName = npc.GetName() + ".txt";
        File file = new File( DIRECTORY_NON_PLAYER_CHARACTERS, fileName);
        System.out.println("File to Write to: " + file);

        file.getParentFile().mkdirs();

        try{
            System.out.println("Reached Try to Write");
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

    public static ArrayList<NonPlayerCharacter> AccessNPCDetails(){
        ArrayList<NonPlayerCharacter> NPCs = new ArrayList<>();

        File directory = new File(DIRECTORY_NON_PLAYER_CHARACTERS);
        File[] files = directory.listFiles();

        if(files == null){
            System.err.println("Directory does not exist or couldn't be read.");
            return NPCs;
        }

        try{
            for(File file : files)
            {
                System.out.println("Trying to Read and fill ArrayList");
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String name = bufferedReader.readLine();
                String age = bufferedReader.readLine();
                String gender = bufferedReader.readLine();
                String race = bufferedReader.readLine();
                String voice = bufferedReader.readLine();
                String location = bufferedReader.readLine();
                String category = bufferedReader.readLine();

                NonPlayerCharacter NPC = new NonPlayerCharacter(name, age, gender, race, voice, location, category);
                NPCs.add(NPC);
                bufferedReader.close();
            }
            return NPCs;
        }catch(IOException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static NonPlayerCharacter LoadNPCData(String npcName){
        System.out.println("Reached LoadNPCData");
        String fileName = DIRECTORY_NON_PLAYER_CHARACTERS + File.separator + npcName + ".txt";
        File file = new File(fileName);
        System.out.println("File to Read: " + fileName + " - " + file);

        if (!file.exists()){
            System.err.println("File does not exist or could not be read");
            return null;
        }

        try{
            System.out.println("Trying to Read in LoadNPCData");
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