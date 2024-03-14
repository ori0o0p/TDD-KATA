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
        setRolls(bowlingGame, 20, 0);

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

    @Test
    public void oneSpare() {
        BowlingGame bowlingGame = createNewBowlingGame();

        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(3);

        setRolls(bowlingGame, 17, 0);
        Assertions.assertEquals(bowlingGame.score(), 16);
    }

    @Test
    public void oneStrike() {
        BowlingGame bowlingGame = createNewBowlingGame();

        bowlingGame.roll(10);
        bowlingGame.roll(5);
        bowlingGame.roll(3);
        setRolls(bowlingGame, 16, 0);

        Assertions.assertEquals(bowlingGame.score(), 26);
    }

    @Test
    public void perfectGame() {
        BowlingGame bowlingGame = createNewBowlingGame();

        setRolls(bowlingGame, 12, 10);
        Assertions.assertEquals(bowlingGame.score(), 300);
    }

    @Test
    public void when10FrameGetSpareCanMoreRoll() {
        BowlingGame bowlingGame = createNewBowlingGame();

        setRolls(bowlingGame, 18, 0);
        setRolls(bowlingGame, 2, 5); // spare
        bowlingGame.roll(3); // more roll

        Assertions.assertEquals(bowlingGame.score(), 13);
    }

    private void setRolls(BowlingGame bowlingGame, int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            bowlingGame.roll(pins);
        }
    }

}
