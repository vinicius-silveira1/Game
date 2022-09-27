import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        boolean gameIsRunning = true;
        
        // player variables
        int health = 100;
        int attack = 30;
        int shield = 10;
        int dodgeChance = 15; // per cent
        
        // enemy variables

        String[] enemies = { "wolf", "zombie", "thief", "skeleton", "witch" };

        int enemyMaxHealth = 100;
        int enemyAttackDamage = 25;

        // welcome
        System.out.println("Hello, what's your name?");
        String name = in.nextLine();
        System.out.println("Welcomo to the dungeon, " + name + "!");
        System.out.println("\nBut be careful...some people say that terrible creatures live ahead...");
        System.out.println("-----------------------------------------------------------------");    






        


        
    }
}
