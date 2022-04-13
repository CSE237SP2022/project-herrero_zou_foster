package textBattle;

/** Represents a main player in the BattleText Game.
 * @author Mathias Foster
 * @author Imanol Herrero
 * @author Kevin Zou
 * @version 1.0
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

    /** Sets the player's minium damage
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
    public String displayInventory(){
    	String output = "Your inventory contains:";
        for(int x = 0; x < inventory.length; x++){
            output = output + (" "+(x+1)+". "+inventory[x].getType());
        }
        return output;
    }

    /** Allows the player to buy an item. Checks to see if player has an empty inventory slot and subtract gold and display player inventory if transaction is successful. 
     * @param a string itemChoice that represents item being purchased
    */
    public void buyItem(String itemChoice){
        Item purchased = new Item(itemChoice);
        int counter = 0;
        while(!inventory[counter].getType().equals("empty slot")){
            counter++;
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

    /** Player ToString method that displays important info about player current condition.
     * @return a string that gives info about player name, maximum health, minimum damage, maximum damage.
    */
    public String toString()
    {
      return "Player " + name + " has a max health of " + maxHealth + " and has a damage range of " + min_dmg + " to " + max_dmg;
    } 

    /** Allows the player to take damage from an attack.
     * @param a string itemChoice that represents item being purchased
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
        System.out.println("Bob the Great has rested and restored" + healthRestore +  "health");
    }
}
