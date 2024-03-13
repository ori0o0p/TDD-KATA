import bowlinggame.BowlingGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    private BowlingGame createNewBowlingGame() {
        return new BowlingGame();
    }

    @Test
    public void canRoll() {
        BowlingGame bowlingGame = createNewBowlingGame();

        bowlingGame.roll(1);
    }

    @Test
    public void gutterGame() {
        BowlingGame bowlingGame = createNewBowlingGame();
        int rolls = 20;
        int pins = 0;

        setRolls(bowlingGame, rolls, pins);

        Assertions.assertEquals(bowlingGame.score(), 0);
    }

    @Test
    public void isScore18() {
        BowlingGame bowlingGame = createNewBowlingGame();

        bowlingGame.roll(7);
        bowlingGame.roll(2);
        bowlingGame.roll(8);
        bowlingGame.roll(1);

        Assertions.assertEquals(bowlingGame.score(), 18);
    }

    private void setRolls(BowlingGame bowlingGame, int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            bowlingGame.roll(pins);
        }
    }

}
