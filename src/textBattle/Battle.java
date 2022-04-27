package textBattle;
/** Battle class that houses our main method and the main implementation for battles between players and monsters
 * @author Mathias Foster
 * @author Imanol Herrero
 * @author Kevin Zou
 * @version 2.0
*/

import java.util.*;
public class Battle
{
    
    /**
     *  Main method that has all the implementation for a game battle.
     *  
     */
    public static void main(String[] args)
    {
    	Scanner input = new Scanner(System.in);
        int mode = 0; 
        int userInput;
        System.out.print("Type Player Name: ");
        String playerName = input.next();
        Item[] i=new Item[3];
        i[0]=new Item("Health potion");
        i[1]=new Item("Strength potion");
        i[2]=new Item();
        System.out.println("Choose a class for your character(1 for rogue)");
        userInput = input.nextInt();
        Player p = new Player(playerName, 80, 20, 30,25,i);
        while (userInput != 1)
        {
            System.out.println("That is not a valid response.");
            System.out.println("Choose a class for your character(press 1 for rogue)");
            userInput = input.nextInt(); 
        }
        if(userInput == 1)
        {
            p = new Rogue(playerName, i);
        }
        
        
        String[] monsterTypes = {"goblin", "chicken", "blob"}; 
        String monsterType = monsterTypes[(int) (Math.random() * 2)]; 
        Monster m = new Monster(monsterType, 50, 10, 15); 
        System.out.println("\n" + p + " has encountered a " + monsterType + "!"); 
        System.out.print(m);        
              
        startBattle(p, m); 
    }
    
    /** Starts a battle between a player and monster. Allows player to attack monster round by round until either player or monster dies.
     *  Successful battle results in players getting gold
     * @param a Monster enemy that represents Monster being attacked.
    */
    public static void startBattle(Player player, Monster monster)
    {
	    System.out.println();
	    int round = 1;
	    
	    while (player.getCurrentHealth() > 0 && monster.getCurrentHealth() > 0)
	    	{
		        System.out.println("++++++++++++++++++++++++++++++++++ ROUND " + round + " +++++++++++++++++++++++++++++++++");
		        System.out.println();
		        player.battleTurn(monster);
		        System.out.println();
		        round++;
	    	}
	    
	    if (player.getCurrentHealth() <=0)
	        System.out.println(player.getName() + " is dead.");
	    
	    if (monster.getCurrentHealth()<=0)
	    {
	       monster.die(player);
	    }
    }
    
}

