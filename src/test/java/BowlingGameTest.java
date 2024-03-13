import bowlinggame.BowlingGame;
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

}
