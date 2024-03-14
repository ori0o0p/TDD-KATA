package bowlinggame;
/*
 TDD Bowling game KATA


*/
public class BowlingGame {
    private int[] total = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        total[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int i = 0;

        for(int frame = 0; frame < 10; frame++) {
            if (isSpare(i)) {
                score += 10 + total[i + 2];
                i += 2;
            }
            else if (isStrike(i)) {
                score += 10 + total[i + 2] + total[i + 1];
                i += 1;
            }
            else {
                score += total[i] + total[i + 1];
                i += 2;
            }
        }

        return score;
    }

    private Boolean isSpare(int i) {
        return total[i] + total[i + 1] == 10;
    }

    private Boolean isStrike(int i){
        return total[i] == 10;
    }

}
