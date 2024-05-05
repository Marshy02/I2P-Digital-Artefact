/*
Main.java
Authored by Daniel Marsh
Main Class to Run to start the Menu Application.
 */

package Main;
import Functions.NPCMenu;

public class Main {
    public static void main(String[] args)
    {
        NPCMenu menu = new NPCMenu();
        menu.DisplayMenu();
    }
}