package textBattle;

/** Shop class that represents a shop that players can visit and purchase items for their inventory
 * @author Mathias Foster
 * @author Imanol Herrero
 * @author Kevin Zou
 * @version 3.0
*/

import java.util.Scanner;

public class Shop
{
    private int[] inventory;
    
    public Shop(int[]i)
    {
         inventory =i;
    }
    
    /**Sells item to player after checking that inventory has enough in stock
     * @return an Item represents item being sold.
    */
    public Item sellItem(int n)
    {
        if(inventory[n - 1] > 0)
        {
        	 if(n == 1) {
        		 Item sold = new Item("Health potion");
        		 return sold;
        	 }
        	 else if(n == 2) {
        		 Item sold = new Item("Strength potion");
        		 return sold;
        	 }
        	 else if(n == 3) {
        		 Item sold = new Item("Mana potion");
        		 return sold;
        	 }
        }
        else{
        	System.out.println("No more of that item available, sorry");
        }
        return new Item("empty slot");
    }
    
    public void displayInventory()
    {
        System.out.println("1. health potions: " + inventory[0] + ";" + " 2. strength potions: " + inventory[1] + ";" + " 3. mana potions " + inventory[2] + ";" + " 4. leave store" + ";");
    }
    
    /**Allows the player to browse the shop and actually purchase items, checking if players have enough gold and inventory space
     * @param an Player that represents main character. 
    */
    public void browse(Player character)
    {
        Scanner input = new Scanner(System.in); 
        System.out.println("Welcome to the shop " + character.getName() +  "! Here is our current inventory: " ); 
        int choice; 
        boolean inShop = true; 
        
        while (inShop)
        {
            displayInventory(); 
            System.out.println("Which item would you like to purchase: "); 
            choice = input.nextInt(); 
            while (choice < 1 || choice > 4)
            {
                System.out.println("Not a valid selection. Choose again: ");
                choice = input.nextInt(); 
            }
            if(choice == 4) {
            	System.out.println("Thanks for shopping!");
                inShop = false; 
            }
            else if (character.canShop())
            {
            	if(choice != 4 || choice != 3) {
            		character.buyItem(sellItem(choice).getType()); 
            	}
            	else if(choice == 3) {
            		if (character instanceof Mage)
                    {
                    	character.buyItem(sellItem(choice).getType());
                    }
                    else
                    {
                        System.out.println("You cannot buy a mana potion -- you aren't a mage."); 
                    }
            	}
                
            }
        }
    }
}
