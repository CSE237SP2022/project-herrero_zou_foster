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
        int mode = 0; 
        Player player = characterSelect();
        
        int[] shopStock = {5, 5, 5};
        Shop shop = new Shop(shopStock);
        playGame(player, shop, mode);
        
    }
    
    public static int mode(Player character)
    {
        Scanner input = new Scanner(System.in); 
        System.out.println("What would you like to do? (1 battle; 2 shop; 3 rest; 4 quit): ");
        int modeSelection = input.nextInt();        
        while (modeSelection < 1 || modeSelection > 4)
        {
            System.out.println("Not a valid action.");
            System.out.println("What would you like to do? (1 battle; 2 shop; 3 rest; 4 quit): ");
            modeSelection = input.nextInt(); 
        }
        if (modeSelection == 1) 
        {
            if (character.getCurrentHealth() <= 0)
            {
                System.out.println("You do not have enough health to do battle right now.");
                return 0;
            }
            else
            {
                return 1;
            }
        }
        else if (modeSelection == 2) // shop
        {
            if (character.canShop())
            {
            	return 2;
            }
            else
            {
                return 0;
            }
        }
        
        else if (modeSelection == 3) 
        {
            if (character.getCurrentHealth() == character.getMaxHealth())
            {
                System.out.println("You are at max health already.");
                return 0;
            }
            else
            {
                return 3;
            }
        }
        else
        {
            System.out.println("Thanks for playing!"); 
            return 4; 
        }
    }
    
    public static void playGame(Player p, Shop shop, int mode) 
    {
    	while (mode != 4)
        {
            mode = mode(p); 
            if (mode == 1)
            {
                Monster m = monsterSelect(p);      
                startBattle(p, m); 
            }
            else if (mode == 2)
            {
                shop.browse(p);
            }
            else if (mode == 3)
            {
                p.rest(); 
            }
        }
    }
    
    /** Allows the player to choose a class and name.
     * @return a Player object that represents the main player.
    */
    public static Player characterSelect() 
    {
    	int userInput;
    	Item[] i = new Item[3];
        i[0]=new Item("Health potion");
        i[1]=new Item("Strength potion");
        i[2]=new Item();
    	Scanner input = new Scanner(System.in);
    	System.out.print("Type Player Name: ");
        String playerName = input.next();
    	System.out.println("Choose a class for your character(1 for warrior; 2 for rogue; 3 for mage): ");
        userInput = input.nextInt();
        Player p;
        while (userInput< 1|| userInput > 3)
        {
            System.out.println( "That is not a valid response.");
            System.out.println("Choose a class for your character(1 for warrior; 2 for rogue; 3 for mage): ");
            userInput = input.nextInt(); 
        }
        if(userInput == 1)
        {
            p = new Warrior(playerName, i);
        }
        else if(userInput == 2)
        {
            p = new Rogue(playerName, i);
        }
        else 
        {
            p = new Mage(playerName, i);
        }
        return p;
    }
    
    public static Monster monsterSelect(Player p) 
    {
    	String[] monsterTypes = {"goblin", "chicken", "blob"}; 
        String monsterType = monsterTypes[(int) (Math.random() * 2)]; 
        Monster enemy = new Monster(monsterType, 50, 10, 15); 
        System.out.println("\n" + p + " has encountered a " + monsterType + "!"); 
        System.out.print(enemy); 
        return enemy;
    }
    
    /** Starts a battle between a player and monster. Allows player to attack monster round by round until either player or monster dies.
     *  Successful battle results in players getting gold.
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
