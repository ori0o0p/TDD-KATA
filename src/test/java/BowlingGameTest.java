import bowlinggame.BowlingGame;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    @Test
    public void testBowlingGameCreation() {
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.roll(1);
    }

}
