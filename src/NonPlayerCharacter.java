import java.util.ArrayList;
import java.util.Scanner;

public class NonPlayerCharacter {
    private String _name;
    private String _age;
    private String _gender;
    private String _race;
    private String _voice;
    private String _location;
    private String _category;

    private Scanner input = new Scanner(System.in);

    //Getters
    public String GetName() { return _name; }
    public String GetAge() { return _age; }
    public String GetGender() { return _gender; }
    public String GetRace() { return _race; }
    public String GetVoice() { return _voice; }
    public String GetLocation() { return _location; }
    public String GetCategory() { return _category; }

    public NonPlayerCharacter(String name, String age, String gender, String race, String voice, String location, String category){
        _name = name;
        _age = age;
        _gender = gender;
        _race = race;
        _voice = voice;
        _location = location;
        _category = category;
        System.out.println("Reached NPC Constructor 1");
    }

    public NonPlayerCharacter(){
        System.out.println("You've selected to build an NPC, please provide some information about them");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("What is this character's name?");
        _name = input.nextLine();
        System.out.println("How old are they?");
        _age = input.nextLine();
        System.out.println("What is their gender?");
        _gender = input.nextLine();
        System.out.println("What is their race? Please select one of the following options:" +
                "\nHuman\nElf\nDwarf");
        _race = input.nextLine();
        System.out.println("What do they sound like?");
        _voice = input.nextLine();
        System.out.println("Where will they be first encountered?");
        _location = input.nextLine();
        System.out.println("What category do they fall under? Please select one of the following options:" +
                "\nAllies\nEnemies\nService Providers\nQuest Givers\nNeutral Parties");
        _category = input.nextLine();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Reached NPC Constructor 2");
    }
}