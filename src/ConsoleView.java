import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.DiceType;

public class ConsoleView implements GameView{
    private final Scanner in = new Scanner(System.in);

    @Override
    public boolean checkContinue() {        //Asks for user input and returns true if yes
        System.out.println("Would you like to continue on your quest (y/n)?");
        String check = in.nextLine();
        if(check.substring(0,1).equalsIgnoreCase("y")) return true;
        return false;
    }

    @Override
    public String displayMainMenu() {       //Requests user input from the menu options and returns the result
        System.out.print("What would you like to do? ");
        String action = in.nextLine();
        return action;
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing Knight Fight!\nGoodbye!\n");
    }

    @Override
    public void knightNotFound() {
        System.out.println("Knight not found!\n");
    }

    @Override
    public void listKnights(List<Knight> knights){  //Prints the Knights with their id number next to them    
        if(knights.size() == 0) System.out.println("No knights to list\n");

        else{
            for(int i = 1; i < knights.size() + 1; i ++){
                System.out.println(String.format("%d: %s", knights.get(i - 1).getId(), knights.get(i - 1).getName()));
            }
        } 
    }

    @Override
    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {       //Displays the Knights and Foes in two columns

        System.out.println("Our heroes come across the following monsters. Prepare for battle!");
        System.out.println(String.format("%-28s%s", "Knights", "Foes"));

        /*
        Explanation:
            knum and mnum are set to the size of each list
            the for loop runs while i < 4 because there can be no more than 4 players on either side
            if i is less than knum and mnum, then both are printed on a formatted line
            otherwise it checks to see what values are left and prints them
        */
        

        int knum = activeKnights.size();
        int mnum = monsters.size();

        for(int i = 0; i < 4; i++){
            if(i < knum && i < mnum){
                System.out.print(String.format("%-28s%s\n", activeKnights.get(i).getName(), monsters.get(i).getName()));
            }   
            else if(i < knum){
                System.out.print(String.format("%-28s%n", activeKnights.get(i).getName()));
            }
            else if(i < mnum){
                System.out.print(String.format("%-28s%s", "", monsters.get(i).getName()));
            }
            else System.out.println();
        }
    }

    @Override
    public void printBattleText(MOB dead) {     //Prints when a character dies
        System.out.println(String.format("%s was defeated!\n", dead.getName()));
    }

    @Override
    public void printDefeated() {
        System.out.println("All active knights have been defeated!\n");
    }

    @Override
    public void printFortunes(List<Knight> activeKnights) { //Prints the knight's name and then the fortune card they drew
        for(int i = 0; i < activeKnights.size(); i ++){
            System.out.println(activeKnights.get(i).getName() + " drew");
            System.out.println(activeKnights.get(i).getActiveFortune());
        }
    }

    @Override
    public void printHelp() {       //Help menu that lists all possible commands and the game rules
        String help = "";
        help += "Unsure what to do, here are some options:\n";
        help += "\tls or list all  - listing the knights\n";
        help += "\tlist active  - list the active knights knights only\n";
        help += "\tshow name or id - show the knight details card\n";
        help += "\tset active name or id - set knight as active (note: only 4 knights can be active)\n";
        help += "\tremove active name or id - remove a knight from active status (heals knight)\n";
        help += "\texplore or adventure or quest - find random monsters to fight\n";
        help += "\tsave filename - save the game to the file name (default: saveData.csv)\n";
        help += "\texit or goodbye - to leave the game\n\n";
        help += "Game rules: You can have four active knights. As long as they are active, they won't heal,\n";
        help += "but they can gain XP by going on adventures.\n";
        help += "When you make a knight inactive, they will heal. How many monsters can you defeat\n";
        help += "before, you have to heal?\n";
        System.out.println(help);
    }

    @Override
    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time.\n");
    }

    @Override
    public void showKnight(Knight knight) {     //Prints the selected knight's card
        System.out.println(knight.toString());
    }

    @Override
    public void splashScreen() {        //Custom Splash screen for the game
        String splash = "";
        splash += "+----------------------+\n";
        splash += String.format("|%5s%s%5s|\n", "","KNIGHT FIGHT","");
        splash += String.format("|%23s\n", "|");
        splash += String.format("|%23s\n", "|");
        splash += String.format("|%5s%s%5s|\n", "", "produced by:", "");
        splash += String.format("|%4s%s%3s|\n","","DJM Development","");
        splash += "+----------------------+\n";
        System.out.println(splash);
    }

public ConsoleView(){}

    public static void main(String[] args) {            ///TESTER METHOD    COMMENT OUT WHEN FINISHED
        ConsoleView cv = new ConsoleView();
    
        List<Knight> klst = new ArrayList<Knight>();
        List<MOB> mlst = new ArrayList<MOB>();

        Knight Eriu = new Knight(3, "Eriu", 32, 13, 2, DiceType.D10, 0);
        Knight Elaine = new Knight(10, "Elaine Pendragon", 35, 14, 2, DiceType.D8, 0);

        MOB Bruh = new MOB("Bruh Dragon", 69, 10, 5, DiceType.D8);
        MOB Bob = new MOB("Bobbeh", 69, 10, 5, DiceType.D8);
        MOB James = new MOB("James", 69, 10, 5, DiceType.D8);

        Fortune ftn = new Fortune("Merlin's Duck", 2, 5, 2, DiceType.D6);
        Fortune ftn2 = new Fortune("Dumbledoorknob", -4, 9, 1, DiceType.D20);

        Eriu.setActiveFortune(ftn);
        Elaine.setActiveFortune(ftn2);

        klst.add(Eriu);
        klst.add(Elaine);
        mlst.add(Bruh);
        mlst.add(Bob);
        mlst.add(James);


        cv.listKnights(klst);
        //cv.printBattleText(mlst, klst);
        //cv.showKnight(Eriu);
        //cv.printBattleText(Eriu);
        //cv.printFortunes(klst);
        //cv.splashScreen();
        //cv.printHelp();
    }
}
