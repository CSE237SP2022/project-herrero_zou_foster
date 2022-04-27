package textBattle;
/** Represents a Warrior that possesses a shield that absorbs some damage.
 * @author Mathias Foster
 * @author Imanol Herrero
 * @author Kevin Zou
 * @version 3.0
*/
public class Warrior extends Player
{
    private double shieldStrength;
    public Warrior(String name, Item[]i)
    {
        super(name,110,5,15,25,i);
        shieldStrength = 0.3;
    }
    public void receive_dmg(int damage)
    {
        super.receive_dmg((int)(damage * (1.0 - shieldStrength)));
    }
}

