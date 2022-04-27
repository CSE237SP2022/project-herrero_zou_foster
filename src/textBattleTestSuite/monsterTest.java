package textBattleTestSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import textBattle.Item;
import textBattle.Monster;
import textBattle.Player;

class monsterTest {
	
	String type = "ogre";
	int maxHealth = 2000;
	int minDamage = 150;
	int maxDamage = 600; 
	
	Monster test = new Monster(type, maxHealth, minDamage, maxDamage);
	

	@Test
	void testGetCurrentHealthMax() {
		assertEquals(test.getCurrentHealth(), maxHealth);
	}
	
	@Test
	void testGetType() {
		assertEquals(test.getType(), type);
	}
	
	@Test
	void testGetMaxHealth() {
		assertEquals(test.getMaxHealth(), maxHealth);
	}
	
	@Test
	void testGetMinDamage() {
		assertEquals(test.getMinDamage(), minDamage);
	}
	
	@Test
	void testGetMaxDamage() {
		assertEquals(test.getMaxDamage(), maxDamage);
	}
	
	@Test
	void testToString() {
		String correctOut = "The " + type + " has a max health of " + maxHealth + " and has a damage range of " + minDamage + " to " + maxDamage;
		assertEquals(test.toString(), correctOut);
	}
	
	@Test
	void testAttack() {
		Item[] inventory = new Item[3];
		Player die = new Player("Greb the Useless", 1000, 20, 30, 40, inventory);
		test.attack(die);
		assertTrue(die.getCurrentHealth() > 549 || die.getCurrentHealth() < 1000);
	}
	
	@Test
	void testAttack2() {
		Item[] inventory = new Item[3];
		Player die = new Player("Greb the Useless", 1500, 20, 30, 40, inventory);
		test.attack(die);
		assertTrue(die.getCurrentHealth() > 1049 || die.getCurrentHealth() < 1500);
	}
	@Test
	void testReceiveDmgDeath() {
		test.receive_dmg(2500);
		assertEquals(test.getCurrentHealth(), 0);
	}
	
	@Test
	void testReceiveDmgAlive() {
		test.receive_dmg(447);
		assertEquals(test.getCurrentHealth(), 1553);
	}

}
