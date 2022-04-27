package textBattleTestSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import textBattle.Item;
import textBattle.Player;
import textBattle.Shop;

class shopTest {

	@Test
	void testSellItem() {
		String name = "Boaz The Noble";
		int maxHealth = 2000;
		int minDamage = 150;
		int maxDamage = 600; 
		int gold = 45230;
		Item[] inventory = new Item[3];
		
		Player test = new Player(name, maxHealth, minDamage, maxDamage, gold, inventory);
		Shop
	}

}
