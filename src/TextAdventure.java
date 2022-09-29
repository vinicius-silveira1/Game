import java.util.Scanner;
import java.util.Random;

public class TextAdventure {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        boolean gameIsRunning = true;
        
        // player variables
        int health = 100;
        int attack = 30;
        int shield = 30;
        int criticalChance = 35; // per cent
        int healthPots = 3;
        int healthPotHeal = 25;
        int healthPotDropChance = 45; // per cent
        int score = 0;

        
        
        // enemy variables

        String[] enemies = { "Wolf", "Spider", "Ghost", "Skeleton", "Witch" };

        int enemyMaxHealth = 100;
        int enemyAttack = 20;

        // welcome
        System.out.println("Hello warrior, what's your name?");
        String name = in.nextLine();
        System.out.println("\nWelcome to the dungeon, " + name + "!");
        System.out.println("\nBut be careful...some people say that terrible creatures live ahead...");
        System.out.println("------------------------------------------------------------------------");
        
        GAME: 
        while(gameIsRunning) {
            int enemyHealth = rand.nextInt(enemyMaxHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];

            System.out.println("You enter a dark cave and feel a cold chill...");
            System.out.println("\n\n\t# A " + enemy + " has appeared! #\n");

            while(enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Raise shield");
                System.out.println("\t3. Drink health pot");
                System.out.println("\t4. Run!");

                String input = in.nextLine();

                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attack);
                    int damageTaken = rand.nextInt(enemyAttack);
                    int criticalDamage = damageDealt * 2;
                    
                    if (rand.nextInt(100) <= criticalChance) {
                        health -= damageTaken;
                        enemyHealth -= criticalDamage;
                        System.out.println("\t>You hit the " + enemy + " for a powerful *" + criticalDamage + "* critical damage!");
                        System.out.println("\t>The " + enemy + " strikes you back for " + damageTaken + ". Ouch!");
                    } else {

                    health -= damageTaken;
                    enemyHealth -= damageDealt;
                    System.out.println("\t>You hit the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t>The " + enemy + " strikes you back for " + damageTaken + ". Ouch!");
                    }

                    if (health <= 0) {
                        System.out.println("\tYou too hurt to continue... better look for a healer.");
                        break;
                    }


                } else if (input.equals("2")) {
                    int damagePrevented = rand.nextInt(shield);
                    int damageTaken = rand.nextInt(enemyAttack) - damagePrevented;
                    if (damageTaken < 0) {
                        damageTaken = 0;
                    }
                    health -= damageTaken;

                    System.out.println("\t>The " + enemy + " hits you, but, as you raised your shield, you prevented " 
                    + damagePrevented + " damage and took only " + damageTaken + ". That was close!");

                    if (health <= 0) {
                        System.out.println("\tYou too hurt to continue... better look for a healer.");
                        break;
                    }

                } else if (input.equals("3")) {
                    if (healthPots > 0) {
                    health += healthPotHeal;
                    healthPots--; 
                    System.out.println("\t>You drank a health pot and healed " 
                    + healthPotHeal + " life. Now you got " + healthPots + " health pots left.");
                    } else if (healthPots <= 0) {
                        healthPots = 0;
                        System.out.println("\tYou ran out of health pots. Defeat enemies to have a chance of getting more.");
                        }
                        
                } else if (input.equals("4")) {
                    System.out.println("\tYou ran away from the " + enemy + "!");
                    continue GAME;

                } else  {
                    System.out.println("\tInvalid answer.");
                    
                }               
            }
            if (health <= 0) {
                System.out.println("\tYou're too weak too fight and leave the dungeon defeated... more luck next time.");
                break;
            }

            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("\n # " + enemy + " was defeated! Nice! # ");
            if (rand.nextInt(100) <= healthPotDropChance) {
              healthPots++;
              System.out.println(" # Wow!!! The " + enemy + " dropped a health pot! Now you got " + healthPots + " health pots.");  
            }
            System.out.println(" # You have " + health + " HP left. #");
            
            score++;
            
            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue adventure!");
            System.out.println("2. Exit dungeon.");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid answer.");
                input = in.nextLine();
            }
            
            
            if (input.equals("1")) {
                System.out.println("You continue your adventure...");

            } else if (input.equals("2")) {
                System.out.println("You left the dungeon sucessfully.");
                
                break;

            } 
        
        }

        System.out.println("\n\n#######################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("# YOUR SCORE: " + score + "       #");
        System.out.println("#######################");
    }    
}

