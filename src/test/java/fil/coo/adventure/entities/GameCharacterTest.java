package fil.coo.adventure.entities;

import static org.junit.Assert.*;
import org.junit.Test;
import fil.coo.adventure.entities.GameCharacter;
import fil.coo.adventure.places.Room;

public abstract class GameCharacterTest {
	
	@Test
	public abstract void dieTest();
	
	@Test
	public void attackTest() {
		Room r = new Room();
		GameCharacter gc1 = this.createGameCharacter(100, 15);
		GameCharacter gc2 = new MockGameCharacter(100,15);
		gc1.moveTo(r);
		gc2.moveTo(r);
		r.addCharacter(gc1);
		r.addCharacter(gc2);
		gc1.attack(gc2);
		assertEquals(85, gc2.getLifePoints());
		this.specialInteraction(gc1,gc2);
	}

	@Test
	public void getLifePointsGivesLifePointsTest() {
		GameCharacter gc = this.createGameCharacter(100,15);
		assertTrue(gc.getLifePoints()==100);
		gc.loseLife(-50);
		assertTrue(gc.getLifePoints()==150);
	}
	
	@Test
	public void moveToMovesTheCharacterToRoomTest() {
		GameCharacter gc = this.createGameCharacter(100, 15);
		Room r1 = new Room();
		Room r2 = new Room();
		gc.moveTo(r1);
		assertTrue(gc.currentRoom()==r1);
		gc.moveTo(r2);
		assertTrue(gc.currentRoom()==r2);
	}
	
	@Test
	public void currentRoomIsCurrentRoomTest() {
		GameCharacter gc = this.createGameCharacter(100, 15);
		Room r1 = new Room();
		gc.moveTo(r1);
		assertTrue(gc.currentRoom()==r1);
	}
	
	@Test
	public void getStrengthReturnsActualStrengthPointsTest() {
		GameCharacter gc = this.createGameCharacter(100, 15);
		assertTrue(gc.getStrength()==15);
		gc = this.createGameCharacter(100, 20);
		assertTrue(gc.getStrength()==20);
	}
	
	@Test
	public void addStrengthAddsStrengthPointsTest() {
		GameCharacter gc = this.createGameCharacter(100, 15);
		assertTrue(gc.getStrength()==15);
		gc.addStrength(15);
		assertTrue(gc.getStrength()==30);
		gc.addStrength(10);
		assertTrue(gc.getStrength()==40);
	}
	
	@Test
	public void getGoldReturnsGoldOfCharacterTest() {
		GameCharacter gc = this.createGameCharacter(100, 15);
		assertTrue(gc.getGold()==0);
		gc.addGold(10);
		assertTrue(gc.getGold()==10);
	}
	
	@Test
	public void addGoldAddsGoldToCharacterStockTest() {
		GameCharacter gc = this.createGameCharacter(100, 15);
		int gold = gc.getGold();
		gc.addGold(20);
		assertEquals(gc.getGold(),gold+20);
		gc.addGold(15);
		assertEquals(gc.getGold(),gold+35);
	}
	
	@Test
	public void isAliveTellsIfCharacterIsActuallyAlive() {
		GameCharacter gc = this.createGameCharacter(100, 15);
		assertTrue(gc.isAlive());
		gc.loseLife(100);
		assertFalse(gc.isAlive());
	}
	
	@Test
	public void loseLifeMakesCharacterLoseLife() {
		GameCharacter gc = this.createGameCharacter(100, 15);
		assertTrue(gc.getLifePoints()==100);
		gc.loseLife(50);
		assertTrue(gc.getLifePoints()==50);
		gc.loseLife(25);
		assertTrue(gc.getLifePoints()==25);
	}
	
	
	protected abstract GameCharacter createGameCharacter(int lp, int sp);
	
	protected abstract void specialInteraction(GameCharacter attacker,GameCharacter attacked);
	
	protected class MockGameCharacter extends GameCharacter {
		public MockGameCharacter(int i, int j) {
			super(i,j);
		}
		@Override
		protected void hit() {
			return;
		}
		@Override
		protected void gotHitBy(GameCharacter attacker) {
			return;
		}
		@Override
		public void die() {
			return;
		}
		@Override
		public String description() {
			return "Mock character";
		}
		@Override
		public String name() {
			return "Bob";
		}
	}
	
}