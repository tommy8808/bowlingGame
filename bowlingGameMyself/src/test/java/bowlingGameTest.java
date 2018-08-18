package test.java;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import main.java.Game;

public class bowlingGameTest {

	private Game game;

	@Before
	public void create() {
		game = new Game();
	}
	
	private void rollMany(int rollTimes, int pin) {
		for(int rollCount = 0; rollCount < rollTimes; rollCount++){
			game.roll(pin);
		}
	}
	
	private void spare() {
		game.roll(5);
		game.roll(5);
	}
	
	private void strike() {
		game.roll(10);
	}
	
	@Test
	public void gutterGame() {
		rollMany(20, 0);
		assertThat(game.getScore(), is(0));
	}
	
	@Test
	public void oneSpare() {
		spare();
		game.roll(3);
		rollMany(17, 0);
		assertThat(game.getScore(), is(16));
	}
	
	@Test
	public void oneStrike() {
		
		strike();
		game.roll(5);
		game.roll(3);
		
		rollMany(16, 0);
		assertThat(game.getScore(), is(26));
	}

	@Test
	public void allOne() {
		rollMany(20, 1);
		assertThat(game.getScore(), is(20));
	}

	@Test
	public void allStrike() {
		rollMany(12, 10);
		assertThat(game.getScore(), is(300));
	}

}
