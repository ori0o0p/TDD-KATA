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
