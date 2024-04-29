import java.util.Scanner;

public class NonPlayerCharacter {
                                                        //Object variables for NPCs as String
    private String _name;
    private String _age;                                //Age as String due to no calculations placed on it
    private String _gender;
    private String _race;
    private String _voice;
    private String _location;
    private String _category;

                                                        //Getters
    public String GetName() { return _name; }
    public String GetAge() { return _age; }
    public String GetGender() { return _gender; }
    public String GetRace() { return _race; }
    public String GetVoice() { return _voice; }
    public String GetLocation() { return _location; }
    public String GetCategory() { return _category; }

                                                        //Setters
    public void SetName(String name) { _name = name; }
    public void SetAge(String age) { _age = age; }
    public void SetGender(String gender) { _gender = gender; }
    public void SetRace(String race) { _race = race; }
    public void SetVoice(String voice) { _voice = voice; }
    public void SetLocation(String location) { _location = location; }
    public void SetCategory(String category) { _category = category; }

                                                        //Constructor consuming attributes
    public NonPlayerCharacter(String name, String age, String gender, String race, String voice, String location, String category){
        _name = name;
        _age = age;
        _gender = gender;
        _race = race;
        _voice = voice;
        _location = location;
        _category = category;
    }

                                                        //Constructor prompting the user for inputs
    public NonPlayerCharacter(){
        Scanner input = new Scanner(System.in);
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
    }
}