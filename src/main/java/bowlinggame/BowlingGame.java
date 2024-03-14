package bowlinggame;

/*
 TDD Bowling game KATA

1. 총 10프레임 진행하며, 한 프레임에 2회 공을 굴릴 수 있는 기회가 주어진다.
2. 핀 1개는 1점이다.
3. 스페어는 기본 10점 + 다음 프레임 1구
4. 스트라이크는 기본 10점 + 다음 프레임 1구 + 2구
5. 10 프레임에 스트라이크나 스페어가 나오면 최대 3번 공을 굴릴 수 있다.

*/
public class BowlingGame {
    private int[] total = new int[21];
    private int currentRoll = 0;
    private int frameIndex = 0;

    public void roll(int pins) {
        total[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;

        for(int frame = 0; frame < 10; frame++) {
            if (isSpare()) {
                score += 10 + spareBonus();
                frameIndex += 2;
            }
            else if (isStrike()) {
                score += 10 + strikeBonus();
                frameIndex += 1;
            }
            else {
                score += total[frameIndex] + total[frameIndex + 1];
                frameIndex += 2;
            }
        }

        return score;
    }

    private Boolean isSpare() {
        return total[frameIndex] + total[frameIndex + 1] == 10;
    }

    private Boolean isStrike(){
        return total[frameIndex] == 10;
    }

    private Integer spareBonus() {
        return total[frameIndex + 2];
    }

    private Integer strikeBonus() {
        return total[frameIndex + 2] + total[frameIndex + 1];
    }

}
