package textBattle;
public class Shop{
    private int[] inventory;
    
    public Shop(int[]i)
    {
         inventory =i;
    }
    public Item sellItem(int n)
    {
        if(inventory[n] == 0)
        {
             Item x = new Item("health potion");
             return x;
        }
        else if(inventory[n] == 1)
        {
            Item x = new Item("strength potion");
            return x;
        }
        else if(inventory[n] == 2)
        {
            Item x = new Item("mana potion");
            return x;
        }
        Item empty = new Item("empty slot");
        return empty;        
    }
    public void displayInventory()
    {
        System.out.println("1. health potions: " + inventory[0] + ";" + " 2. strength potions: " + inventory[1] + ";" + " 3. mana potions " + inventory[2] + ";");
    }
}
