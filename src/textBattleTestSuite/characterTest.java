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
	Item empty = new Item("empty slot");
	
	
	@Test
	void testAddGold() {
		test.addGold(5353);
		assertEquals(test.getGold(), 45230 + 5353);
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
	void testBuyItemFull() {
		inventory[0] = sword;
		inventory[1] = bow;
		inventory[2] = healthPot;
		
		Item[] correct = {sword, bow, healthPot};
		test.buyItem("strength potion");
		assertArrayEquals(inventory, correct);
	}
	
	@Test
	void testBuyItemHealth() {
		inventory[0] = sword;
		inventory[1] = bow;
		inventory[2] = empty;
		
		test.buyItem("Health potion");
		String correct = "Health potion";
		assertEquals(correct, inventory[2].getType());
	}
	
	@Test 
	void testBuyItemStrength() {
		inventory[0] = empty;
		inventory[1] = empty;
		inventory[2] = empty;
		
		test.buyItem("Strength potion");
		String correct = "Strength potion";
		assertEquals(correct, inventory[0].getType());
	}
	
	@Test
	void testBuyItemMana() {
		inventory[0] = empty;
		inventory[1] = empty;
		inventory[2] = empty;
		
		test.buyItem("Mana strength");
		String correct = "Mana strength";
		assertEquals(correct, inventory[0].getType());
	}
	
	@Test
	void testBuyItemPoor() {
		Player poor = new Player(name, maxHealth, minDamage, maxDamage, 5, inventory);
		inventory[0] = empty;
		inventory[1] = empty;
		inventory[2] = empty;
		
		poor.buyItem("Health potion");
		String correct = "empty slot";
		assertEquals(correct, inventory[0].getType());
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
	
	@Test 
	void testRest() {
		test.receive_dmg(20);
		test.rest();
		assertTrue(test.getCurrentHealth() > 1981 || test.getCurrentHealth() < 1991);
	}
	

}
