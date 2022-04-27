package textBattleTestSuite;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import textBattle.Item;
import textBattle.Mage;
import textBattle.Monster;

class mageTest {

	@Test
	void testAttackFail() {
		Item[] inventory = new Item[10];
		Mage test = new Mage("Boaz",inventory);
		Monster test2 = new Monster("Troll", 150, 20, 30);
		test.setMana(0);
		test.attack(test2);
		assertEquals(test2.getCurrentHealth(), 150);
	}
	
	@Test
	void testAttackSuccess(){
		Item[] inventory = new Item[10];
		Mage test = new Mage("Boaz",inventory);
		Monster test2 = new Monster("Troll", 150, 20, 30);
		test.attack(test2);
		assertTrue(test2.getCurrentHealth() > test2.getMaxHealth() - 80 || test2.getCurrentHealth() <  test2.getMaxHealth() - 35);
		
	}
	
	@Test
	void testAttackSuccess2(){
		Item[] inventory = new Item[10];
		Mage test = new Mage("Boaz",inventory);
		Monster test2 = new Monster("Goblin", 300, 20, 30);
		test.attack(test2);
		assertTrue(test2.getCurrentHealth() > test2.getMaxHealth() - 80 || test2.getCurrentHealth() < test2.getMaxHealth() - 35);
		
	}

}
