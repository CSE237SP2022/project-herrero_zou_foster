package textBattleTestSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import textBattle.Item;
import textBattle.Player;
import textBattle.Shop;

class shopTest {

	String name = "Boaz The Noble";
	int maxHealth = 2000;
	int minDamage = 150;
	int maxDamage = 600; 
	int gold = 45230;
	Item[] inventory = new Item[3];
	
	Player test = new Player(name, maxHealth, minDamage, maxDamage, gold, inventory);
	int[] i = {1, 2, 3};
	Shop shop = new Shop(i);
	Item empty = new Item("empty slot");
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Test
	void testSellItemHealth() {
		Item healthPot = new Item("Health potion");
		assertEquals(shop.sellItem(1).getType(), healthPot.getType());
		
	}
	
	@Test
	void testSellItemStrength() {
		Item strengthPot = new Item("Strength potion");
		assertEquals(shop.sellItem(2).getType(), strengthPot.getType());
		
	}
	
	@Test
	void testSellItemMana() {
		Item manaPot = new Item("Mana potion");
		assertEquals(shop.sellItem(3).getType(), manaPot.getType());
		
	}
	
	@Test
	void testSellItemFailHealth() {
		int[] fail = {0, 0, 0};
		Shop failShop = new Shop(fail);
		assertEquals(failShop.sellItem(1).getType(), empty.getType());
	}
	
	@Test
	void testSellItemFailStrength() {
		int[] fail = {0, 0, 0};
		Shop failShop = new Shop(fail);
		assertEquals(failShop.sellItem(2).getType(), empty.getType());
	}
	
	@Test
	void testSellItemFailMana() {
		int[] fail = {0, 0, 0};
		Shop failShop = new Shop(fail);
		assertEquals(failShop.sellItem(3).getType(), empty.getType());
	}
	
}
