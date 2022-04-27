package textBattle;
import java.util.*;

/** Represents a main player in the BattleText Game.
 * @author Mathias Foster
 * @author Imanol Herrero
 * @author Kevin Zou
 * @version 3.0
*/
public class Player
{
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int min_dmg;
    private int max_dmg;
    private int gold;
    private Item[] inventory;
    
    /** Creates an employee with the specified name.
     * @param name The player's name.
     * @param maxHealth The maximum health of the player.
     * @param min_dmg The minimum damage of the player's basic attack
     * @param max_dmg The maximum damage of the player's basic attack
     * @param gold The amount of gold that the player posseses
     * @param items Array of items that the player possesses
    */
    public Player(String name, int maxHealth, int min_dmg, int max_dmg, int gold, Item[] items)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        currentHealth = maxHealth;
        this.min_dmg = min_dmg;
        this.max_dmg = max_dmg;
        this.gold = gold;
        inventory = items;
    }

    /** Retrieves the player's current health.
     * @return an integer that represents current player health
    */
    public int getCurrentHealth()
    {
        return currentHealth;
    }

    /** Sets the player's current health.
     * @param an integer health that represents current player health
    */
    public void setCurrentHealth(int health)
    {
        currentHealth = health;
    }

    /** Retrieves the player's name.
     * @return an string that represents player's name
    */
    public String getName()
    {
        return name;
    }

    /** Retrieves the player's max health.
     * @return an integer that represents player's health
    */
    public int getMaxHealth()
    {
        return maxHealth;
    }

    /** Retrieves the player's gold amount.
     * @return an integer that represents player's name
    */
    public int getGold()
    {
        return gold;
    }

    /** Adds gold to the player's current gold amount.
     * @param an integer amt that represents the amount of gold being added
    */
    public void addGold(int amt)
    {
        gold += amt;
    }

    /** Retrieves the player's minimum damage.
     * @return an integer that represents player's minimum damage
    */
    public int getMinDamage()
    {
        return min_dmg;
    }

    /** Sets the player's minimum damage
     * @param an integer dmg that represents damage to set for minimum
    */
    public void setMinDamage(int dmg)
    {
        min_dmg = dmg;
    }

    /** Retrieves the player's maximum damage.
     * @return an integer that represents player's maximum damage
    */
    public int getMaxDamage()
    {
        return max_dmg;
    }

    /** Sets the player's minium damage
     * @param an integer dmg that represents damage to set for minimum
    */
    public void setMaxDamage(int dmg)
    {
        max_dmg = dmg;
    }

    /** Loops through and displays the player's current item inventory.
    */
    public void displayInventory(){
    	String output = "Your inventory contains:";
        for(int i = 0; i < inventory.length; i++){
            output = output + (" " + (i + 1) + ". " + inventory[i].getType());
        }
        System.out.println(output);
    }

    /** Allows the player to buy an item. Checks to see if player has an empty inventory slot and subtract gold and display player inventory if transaction is successful. 
     * @param a string itemChoice that represents item being purchased
    */
    public void buyItem(String itemChoice){
        Item purchased = new Item(itemChoice);
        int counter = 0;
        while(!inventory[counter].getType().equals("empty slot")){
            counter++;
            if(counter == inventory.length) {
            	break;
            }
        }
        if(counter == inventory.length){
            System.out.println("Not enough room!");
        }
        else{
            if(gold < purchased.getCost()){
                System.out.println("Not enough gold!");
            } 
            else{
                inventory[counter] = purchased;
                gold -= purchased.getCost();
                displayInventory();
            }
        }
    }

     /** Allows the player to use an item. Replaces used item with empty slot. 
     * @param a string indexChoice that represents index of item being used
    */
    public void use_item(int indexChoice){
        inventory[indexChoice].use(this);
        Item n=new Item("empty slot");
        inventory[indexChoice]=n;
    }

    /** Player ToString method that displays important info about player current condition.
     * @return a string that gives info about player name, maximum health, minimum damage, maximum damage.
    */
    public String toString()
    {
      return "Player " + name + " has a max health of " + maxHealth + " and has a damage range of " + min_dmg + " to " + max_dmg;
    } 
    
    public void attack(Monster enemy)
    {
        int damage = (int)((Math.random()*(max_dmg - min_dmg + 1)) + min_dmg);
        System.out.println(name + " attacks the " + enemy.getType() + " doing " + damage + " damage."); 
        enemy.receive_dmg(damage);
    }

    /** Allows the player to take damage from an attack.
     * @param a string itemChoice that represents item being purchased.
    */
    public void receive_dmg(int damage)
    {
        if (currentHealth-damage >= 0)
        {
            currentHealth -= damage;
        }
        else
        {
            currentHealth = 0;
        }
        System.out.println(name + " has " + currentHealth + " health left."); 
    }

    /** Allows the player to rest and restore a random amount of health.
    */
    public void rest() 
    {
        int healthRestore = (int)(Math.random() * 10 + 1);
        currentHealth += healthRestore;
        System.out.println(name + " has rested and restored" + healthRestore +  "health");
    }

    /** Helper method that checks to see if there are any empty slots in the player's item inventory.
     */
    public boolean checkForSpace()
    {
	String checker = "";
        
        for (int i = 0; i < inventory.length; i++)
        {
            checker = inventory[i].toString();
            if (checker == "empty slot")
            {
                return true;
            }
            else
            {
                checker = "";
            }
        }
        return false;
    }
    public void battleTurn(Monster enemy) {
    	displayInventory();
    	Scanner input = new Scanner(System.in);
    	int userInput = 0;
        System.out.println("Type an inventory slot number or 0 to attack: ");
        userInput = input.nextInt();
        if(userInput == 0)
        {
            System.out.println();
            attack(enemy);
        } 
        else 
        {
        	use_item(userInput - 1);
        }
        System.out.println();
        if(enemy.getCurrentHealth() !=0)
        {
            enemy.attack(this);
        }
    }
}

