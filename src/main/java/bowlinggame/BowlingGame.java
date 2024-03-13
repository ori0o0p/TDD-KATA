package bowlinggame;

public class BowlingGame {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int totalScore = 0;

        for (int i = 0; i < rolls.length; i++) {
            totalScore += rolls[i];
        }

        return totalScore;
    }

}
