/*
TestingObjects.java
Authored by Daniel Marsh
Testing Class to test Constructors, Getters and Setters for NPC Object in NonPlayerCharacter.
 */

package Tests;
import Objects.NonPlayerCharacter;
public class TestingObjects {
    private static NonPlayerCharacter testNPC;
    private static String name;
    private static int age;
    private static String gender;
    private static String race;
    private static String voice;
    private static String location;
    private static String category;

    public static void main(String[] args){
        testNPCConstructor();
        testNPCSetter();
    }

    public static void testNPCConstructor(){            //Testing Constructors and Getters with typical NPC data
        name = "Legolas";                        //Typical attributes to be read
        age = 2931;
        gender = "Male";
        race = "Elf";
        voice = "Elegant";
        location = "The Shire";
        category = "Allies";

        testNPC = new NonPlayerCharacter(name, age, gender, race, voice, location, category);

        String constructedName = testNPC.GetName();     //Attributes taken from Getters
        int constructedAge = testNPC.GetAge();
        String constructedGender = testNPC.GetGender();
        String constructedRace = testNPC.GetRace();
        String constructedVoice = testNPC.GetVoice();
        String constructedLocation = testNPC.GetLocation();
        String constructedCategory = testNPC.GetCategory();

        if(constructedName.equals(name)){               //Test for name constructed correctly
            System.out.println("Typical and constructed names match, test PASSED. " + name + ":" + constructedName);
        }
        else{
            System.out.println("Typical and constructed names do not match, test FAILED. " + name + ":" + constructedName);
        }

        if(constructedAge == age){                      //Test for age constructed correctly
            System.out.println("Typical and constructed ages match, test PASSED. " + age + ":" + constructedAge);
        }
        else{
            System.out.println("Typical and constructed ages do not match, test FAILED. " + age + ":" + constructedAge);
        }

        if(constructedGender.equals(gender)){           //Test for gender constructed correctly
            System.out.println("Typical and constructed genders match, test PASSED. " + gender + ":" + constructedGender);
        }
        else{
            System.out.println("Typical and constructed genders do not match, test FAILED. " + gender + ":" + constructedGender);
        }

        if(constructedRace.equals(race)){               //Test for race constructed correctly
            System.out.println("Typical and constructed races match, test PASSED. " + race + ":" + constructedRace);
        }
        else{
            System.out.println("Typical and constructed races do not match, test FAILED. " + race + ":" + constructedRace);
        }

        if(constructedVoice.equals(voice)){             //Test for voice constructed correctly
            System.out.println("Typical and constructed voices match, test PASSED. " + voice + ":" + constructedVoice);
        }
        else{
            System.out.println("Typical and constructed voices do not match, test FAILED. " + voice + ":" + constructedVoice);
        }

        if(constructedLocation.equals(location)){       //Test for location constructed correctly
            System.out.println("Typical and constructed locations match, test PASSED. " + location + ":" + constructedLocation);
        }
        else{
            System.out.println("Typical and constructed locations do not match, test FAILED. " + location + ":" + constructedLocation);
        }

        if(constructedCategory.equals(category)){       //Test for category constructed correctly
            System.out.println("Typical and constructed categories match, test PASSED. " + category + ":" + constructedCategory);
        }
        else{
            System.out.println("Typical and constructed categories do not match, test FAILED. " + category + ":" + constructedCategory);
        }
    }

    public static void testNPCSetter(){
        name = "Albus Dumbledore";                      //Typical attributes to be read
        age = 116;
        gender = "Male";
        race = "Human";
        voice = "Articulated";
        location = "Hogwarts";
        category = "Quest Givers";
        
        testNPC.SetName(name);
        testNPC.SetAge(age);
        testNPC.SetGender(gender);
        testNPC.SetRace(race);
        testNPC.SetVoice(voice);
        testNPC.SetLocation(location);
        testNPC.SetCategory(category);

        String setName = testNPC.GetName();             //Attributes taken from Getters
        int setAge = testNPC.GetAge();
        String setGender = testNPC.GetGender();
        String setRace = testNPC.GetRace();
        String setVoice = testNPC.GetVoice();
        String setLocation = testNPC.GetLocation();
        String setCategory = testNPC.GetCategory();

        if(setName.equals(name)){                       //Test for name set correctly
            System.out.println("Typical and set names match, test PASSED. " + name + ":" + setName);
        }
        else{
            System.out.println("Typical and set names do not match, test FAILED. " + name + ":" + setName);
        }

        if(setAge == age){                              //Test for age set correctly
            System.out.println("Typical and set ages match, test PASSED. " + age + ":" + setAge);
        }
        else{
            System.out.println("Typical names and set ages do not match, test FAILED. " + age + ":" + setAge);
        }

        if(setGender.equals(gender)){                   //Test for gender set correctly
            System.out.println("Typical and set genders match, test PASSED. " + gender + ":" + setGender);
        }
        else{
            System.out.println("Typical names and set genders do not match, test FAILED. " + gender + ":" + setGender);
        }

        if(setRace.equals(race)){                       //Test for race set correctly
            System.out.println("Typical and set races match, test PASSED. " + race + ":" + setRace);
        }
        else{
            System.out.println("Typical names and set races do not match, test FAILED. " + race + ":" + setRace);
        }

        if(setVoice.equals(voice)){                     //Test for voice set correctly
            System.out.println("Typical and set voices match, test PASSED. " + voice + ":" + setVoice);
        }
        else{
            System.out.println("Typical names and set voices do not match, test FAILED. " + voice + ":" + setVoice);
        }

        if(setLocation.equals(location)){               //Test for location set correctly
            System.out.println("Typical and set locations match, test PASSED. " + location + ":" + setLocation);
        }
        else{
            System.out.println("Typical names and set locations do not match, test FAILED. " + location + ":" + setLocation);
        }

        if(setCategory.equals(category)){               //Test for category set correctly
            System.out.println("Typical and set categories match, test PASSED. " + category + ":" + setCategory);
        }
        else{
            System.out.println("Typical names and set categories do not match, test FAILED. " + category + ":" + setCategory);
        }
    }
}
