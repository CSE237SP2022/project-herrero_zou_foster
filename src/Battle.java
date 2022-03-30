/** Battle class that houses our main method and the main implementation for battles between players and monsters
 * @author Mathias Foster
 * @author Imanol Herrero
 * @author Kevin Zou
 * @version 1.0
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
        Item[] items = new Item[3];
        i[0]=new Item("Health potion");
        i[1]=new Item("Strength potion");
        i[2]=new Item();

        Player Greg = new Player("Greg", 1000, 50, 100, 5, items);
        Greg.toString();
        Greg.displayInventory();
        Greg.buyItem("Health potion");
        Greg.toString();
        Greg.use_item(1);
        Greg.toString();
    }
    
}
