package Tests;
import Objects.NonPlayerCharacter;
import Functions.*;
import java.io.*;
public class TestingFunctions {
    private static String name = "Newt";
    private static int age = 17;;
    private static String gender = "Male";
    private static String race = "Human";
    private static String voice = "Casual";
    private static String location = "The Glade";
    private static String category = "Allies";

    public static void main(String[] args){
        testFileWrite();
        testFileRead();
        testFileDelete();
    }

    public static void testFileWrite(){
        NonPlayerCharacter testWriteNPC = new NonPlayerCharacter(name, age, gender, race, voice, location, category);

        FileIO.WriteToFile(testWriteNPC);               //Write typical data to a new file
        File f = new File(FileIO.DIRECTORY_NON_PLAYER_CHARACTERS + File.separator + name + ".txt");
        if(f.exists()) {                                //Check if file was written
            System.out.println("WriteToFile function successfully wrote a new file, test PASSED. " + f.getPath());
        }
        else{
            System.out.println("File not found, WriteToFile did not write the file successfully, test FAILED.");
        }
    }

    public static void testFileRead() {
        NonPlayerCharacter testReadNPC = FileIO.LoadNPCData(name);

        String readName = testReadNPC.GetName();
        int readAge = testReadNPC.GetAge();
        String readGender = testReadNPC.GetGender();
        String readRace = testReadNPC.GetRace();
        String readVoice = testReadNPC.GetVoice();
        String readLocation = testReadNPC.GetLocation();
        String readCategory = testReadNPC.GetCategory();

        if (readName.equals(name)) {                      //Test for name written and read correctly
            System.out.println("Written and read names match, test PASSED. " + name + ":" + readName);
        } else {
            System.out.println("Written and read names do not match, test FAILED. " + name + ":" + readName);
        }

        if (readAge == age) {                             //Test for age written and read correctly
            System.out.println("Written and read ages match, test PASSED. " + age + ":" + readAge);
        } else {
            System.out.println("Written and read ages do not match, test FAILED. " + age + ":" + readAge);
        }

        if (readGender.equals(gender)) {                  //Test for gender written and read correctly
            System.out.println("Written and read genders match, test PASSED. " + gender + ":" + readGender);
        } else {
            System.out.println("Written and read genders do not match, test FAILED. " + gender + ":" + readGender);
        }

        if (readRace.equals(race)) {                      //Test for race written and read correctly
            System.out.println("Written and read races match, test PASSED. " + race + ":" + readRace);
        } else {
            System.out.println("Written and read races do not match, test FAILED. " + race + ":" + readRace);
        }

        if (readVoice.equals(voice)) {                    //Test for voice written and read correctly
            System.out.println("Written and read voices match, test PASSED. " + voice + ":" + readVoice);
        } else {
            System.out.println("Written and read voices do not match, test FAILED. " + voice + ":" + readVoice);
        }

        if (readLocation.equals(location)) {              //Test for location written and read correctly
            System.out.println("Written and read locations match, test PASSED. " + location + ":" + readLocation);
        } else {
            System.out.println("Written and read locations do not match, test FAILED. " + location + ":" + readLocation);
        }

        if (readCategory.equals(category)) {              //Test for category written and read correctly
            System.out.println("Written and read categories match, test PASSED. " + category + ":" + readCategory);
        } else {
            System.out.println("Written and read categories do not match, test FAILED. " + category + ":" + readCategory);
        }
    }

    public static void testFileDelete(){
        FileIO.DeleteNPCFile(name);
        File f = new File(FileIO.DIRECTORY_NON_PLAYER_CHARACTERS + File.separator + name + ".txt");
        if(f.exists()) {                                //Check if file was deleted
            System.out.println("DeleteNPCFile function did not delete the file successfully, test FAILED. " + f.getPath());
        }
        else{
            System.out.println("File not found, DeleteNPCFile deleted the file successfully, test PASSED.");
        }
    }
}
