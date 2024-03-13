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

        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }

        Assertions.assertEquals(bowlingGame.score(), 0);
    }

}
