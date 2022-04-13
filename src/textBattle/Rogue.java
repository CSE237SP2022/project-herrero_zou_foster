package textBattle;

/** Represents a main player in the BattleText Game.
 * @author Mathias Foster
 * @author Imanol Herrero
 * @author Kevin Zou
 * @version 2.0
*/

public class Rogue extends Player{
	private double critChance;
    public Rogue(String name, Item[]i)
    {
        super(name,80, 20, 30,25,i);
        critChance = 0.5;
    }
    
    /** Retrieves the player's current health. Creates a random float between 0 and 1, if it is less than crit chance, then player does extra damage.
     * @param a Monster enemy that represents Monster being attacked.
    */
    public void attack(Monster enemy)
    {
        double crit = Math.random();
        if(crit <= critChance) 
        {
            System.out.println(getName() + " gets a critical hit!");
            int damage = (int)((Math.random()*(getMaxDamage() - getMinDamage() + 1)) + getMinDamage());
            System.out.println(getName() + " attacks the " + enemy.getType() + " doing " + damage + " damage."); 
            enemy.receive_dmg(damage*2); 
        }
        else
        {
            super.attack(enemy);
        }
    }
}
