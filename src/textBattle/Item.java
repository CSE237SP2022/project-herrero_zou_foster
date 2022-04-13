package textBattle;
/** Item class that represents items that players can purchase and store in inventory
 * @author Mathias Foster
 * @author Imanol Herrero
 * @author Kevin Zou
 * @version 1.0
*/
public class Item
{
    private String type;
    
    /** Creates an item with the specified type.
    * @param type a string that represents item type.
    */
    public Item(String type)
    {
        this.type = type;
    }
    public Item()
    {
        type = "empty slot";
    }

    public String getType(){
        return type;
    }

    public String toString()
    {
        return type;
    }

    /** Gets the cost of the desired item 
     * @return an integer that represents cost of item being purchased
    */
    public int getCost()
    {
        if(type.equals("Health potion"))
        {
            return 15;
        }
        if(type.equals("Strength potion"))
        {
            return 10;
        }
        return 0;
    }

    /** Allows the player to use an item. Current implementation for a health potion that boosts health and a strength potion that increases damage output. 
     * @param a player item that represents the player using the item
    */
    public void use(Player character)
    {
        if(type.equals("Health potion"))
        {
            if(character.getMaxHealth()<character.getCurrentHealth())
                character.setCurrentHealth(character.getMaxHealth());
            else 
                character.setCurrentHealth(character.getCurrentHealth()+15);
            System.out.println(character.getName()+" now has " + character.getCurrentHealth()+" health.");
        }
        if(type.equals("Strength potion"))
        {
            character.setMinDamage(character.getMinDamage()+10);
            character.setMaxDamage(character.getMaxDamage()+10);
            System.out.println(character.getName()+" can do more damage.");
        }
        if(type.equals("empty slot"))
        {
            System.out.println("That inventory slot is empty!");    
        }
    }
}
