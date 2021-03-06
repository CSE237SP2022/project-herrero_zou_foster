package textBattle;
public class Monster {
	private String type;
	private int maxHealth;
	private int currentHealth;
	private int min_dmg;
	private int max_dmg;

	public Monster(String type, int maxHealth, int min_dmg, int max_dmg)
	{
		this.type = type;
		this.maxHealth = maxHealth;
		currentHealth = maxHealth;
		this.min_dmg = min_dmg;
		this.max_dmg = max_dmg;
	}

	public int getCurrentHealth()
	{
		return currentHealth;
	}
	public String getType()
	{
		return type;
	}
	public int getMaxHealth()
	{
		return maxHealth;
	}
	public int getMinDamage()
	{
		return min_dmg;
	}
	public int getMaxDamage()
	{
		return max_dmg;
	}
	public String toString()
	{
		return "The " + type + " has a max health of " + maxHealth + " and has a damage range of " + min_dmg + " to " + max_dmg;
	}   
	public void attack(Player enemy)
	{
		int damage = (int)((Math.random()*(max_dmg - min_dmg + 1)) + min_dmg);
		System.out.println("The " + type + " attacks " + enemy.getName() + " doing " + damage + " damage.");
		enemy.receive_dmg(damage);
	}
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
		System.out.println("The " + type + " has " + currentHealth + " health left.");
	}

	public void die(Player enemy){
		System.out.println("The " + getType() + " is dead.");
        	System.out.println();
        	System.out.println(enemy.getName() + " has defeated the " + getType());
        	int reward = (int)(Math.random()*50);
        	enemy.addGold(reward);
        	System.out.println(enemy.getName() + " gains " + reward +" gold");
	}
}
