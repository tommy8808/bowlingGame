package main.java;

public class Game {
	
	private int[] rolls = new int[20];
	private int total;
	private int[] frames = new int[10];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public Object getScore() {
		int firstFrame = 0;
		for(int frame = 0; frame < frames.length; frame++){
			frames[frame] += rolls[firstFrame] + rolls[firstFrame+1];
			if(isStrike(firstFrame)) {
				frames[frame] += rolls[firstFrame+2];
				firstFrame += 1;
			} else if(isSpare(firstFrame)){
				frames[frame] += rolls[firstFrame+2];
				firstFrame += 2;
			} else {
				firstFrame += 2;
			}
			total += frames[frame];
		}
		return total;
	}

	private boolean isSpare(int firstFrame) {
		return rolls[firstFrame] + rolls[firstFrame+1] == 10;
	}

	private boolean isStrike(int firstFrame) {
		return rolls[firstFrame] == 10;
	}

}
