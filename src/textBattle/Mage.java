package textBattle;
public class Mage extends Player
{
    private int mana;
    public Mage(String name, Item[]i)
    {
        super(name,60, 35, 45,25,i);
        mana = 10;
    }
    public void setMana(int m)
    {
        mana = m;
    }
    public int getMana()
    {
        return mana;
    }
    public void attack(Monster enemy)
    {
        if(mana <= 0)
        {
            System.out.println("Not enough mana.");
        }
        else
        {
            int damage = (int) (Math.random() * super.getMaxDamage() + super.getMinDamage()); 
            enemy.receive_dmg(damage); 
            System.out.println(super.getName() + " attacks " + enemy.getType() + " doing " + damage + " damage.");
            mana--;
            System.out.println(super.getName() + " has " + mana + " mana left.");
        }
    }
}
