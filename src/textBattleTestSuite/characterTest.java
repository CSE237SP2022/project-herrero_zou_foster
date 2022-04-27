package textBattleTestSuite;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import textBattle.Item;
import textBattle.Monster;
import textBattle.Player;

class characterTest {
	
	String name = "Boaz The Noble";
	int maxHealth = 2000;
	int minDamage = 150;
	int maxDamage = 600; 
	int gold = 45230;
	Item[] inventory = new Item[3];
	
	Player test = new Player(name, maxHealth, minDamage, maxDamage, gold, inventory);
	
	Item sword = new Item("sword");
	Item bow = new Item("bow");
	Item healthPot = new Item("Health potion"); 
	
	@Test
	void testGetCurrentHealthMax() {
		assertEquals(test.getCurrentHealth(), maxHealth);
	}
	
	@Test
	void testSetCurrentHealth() {
		test.setCurrentHealth(20);
		assertEquals(test.getCurrentHealth(), 20);
	}
	
	@Test
	void testGetName() {
		assertEquals(test.getName(), name);
	}
	
	@Test
	void testGetMaxHealth() {
		assertEquals(test.getMaxHealth(), maxHealth);
	}
	
	@Test
	void testGetGold() {
		assertEquals(test.getGold(), gold);
	}
	
	@Test
	void testAddGold() {
		test.addGold(5353);
		assertEquals(test.getGold(), 45230 + 5353);
	}
	
	@Test
	void testGetMinDamage() {
		assertEquals(test.getMinDamage(), minDamage);
	}
	
	@Test
	void testSetMinDamage() {
		test.setMinDamage(53);
		assertEquals(test.getMinDamage(), 53);
	}
	
	@Test
	void testGetMaxDamage() {
		assertEquals(test.getMaxDamage(), maxDamage);
	}
	
	@Test
	void testSetMaxDamage() {
		test.setMaxDamage(53);
		assertEquals(test.getMaxDamage(), 53);
	}
	
	@Test
	void testDisplayInventory() {
		inventory[0] = sword;
		inventory[1] = bow;
		inventory[2] = healthPot;
		
		String correctOut = "Your inventory contains: 1. sword 2. bow 3. Health potion";
		assertEquals(test.displayInventory(), correctOut);
	}
	
	@Test
	void testBuyItem() {
		
	}
	
	@Test
	void testToString() {
		String correctOut = "Player " + name + " has a max health of " + maxHealth + " and has a damage range of " + minDamage + " to " + maxDamage;
		assertEquals(test.toString(), correctOut);
	}
	
	@Test
	void testReceiveDamageDead() {
		test.receive_dmg(2001);
		assertEquals(test.getCurrentHealth(), 0);
	}
	
	@Test
	void testReceiveDamageAlive() {
		test.receive_dmg(20);
		assertEquals(test.getCurrentHealth(), 1980);
	}
	
	

}
