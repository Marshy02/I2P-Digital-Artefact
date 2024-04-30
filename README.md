NPC Builder and Tracker for Dungeons & Dragons



Description

This application was designed to help a user create, amend, view and delete any number of Non-Player Characters for their TableTop RPG adventures.
It runs in the Command-Line-Interface, featuring a formatted menu system for the user to interact with in order to go about building and tracking NPCs.
These NPCs are saved in text files stored locally, so only the user can see their characters on their own device.



Pre-requisites

No external libraries are required to run and use this application, however it was developed using Java JDK 17 (Oracle OpenJDK version 17.0.8) and so this is recommended for use to run the programme.



User Story

Upon starting the application, the user is greeted and presented with a menu system containing 5 options outlined below.

OPTION 1 - Create a new Non-Player Character

        Selecting option 1 will present the user with a series of questions regarding the NPC being created, including suggestions for attributes with limited options.
        
        Please pay attention to these suggestions. Care has been taken to ensure the programme can handle most inputs, however inputting poor data may cause problems when creating the NPC.
        
        Completing this option will save the inputted details to a text file.
        
OPTION 2 - View information about an NPC

        Selecting option 2 will ask the user to enter the name of the NPC they wish to view. If an NPC is found, their details are then displayed to the user.
        
        If no NPC with that name is found, an error will inform the user of this and the programme will exit.
        
OPTION 3 - Edit information about an NPC

        Selecting option 3 will ask the user to enter the name of the NPC they wish to change an attribute of. If an NPC is found, the user is prompted to select an attribute to edit.
        
        After selecting an attribute, the user will be able to rewrite the value of that attribute and save over the existing NPC file.
        
OPTION 4 - Delete an NPC

        Selecting option 4 will ask the user to enter the name of the NPC they wish to delete. If an NPC is found, the user is asked to confirm deletion.
        
        If the user confirms, the NPC save file is deleted. If the user cancels, the save file remains.
        
OPTION 5 - Hear a bad D&D themed pun

        Selecting option 5 will display one of three puns to the user at random.
        
After completing any of the above options, the user will be asked if they wish to return to the menu or exit the programme.



This application is a solo project, now completed to an acceptable standard for submission as part of an academic assignment. No further development is planned.
