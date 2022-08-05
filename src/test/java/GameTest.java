import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Player p1 = new Player("playerName1", 2);
    Player p2 = new Player("playerName2", 1);
    Player p3 = new Player("playerName3", 1);
    Game gamers = new Game();

    @BeforeEach
    public void b4EachTest() {
        gamers.register(p1);
        gamers.register(p2);
        gamers.register(p3);
    }

    @Test
    public void shouldReturn1() {
        assertEquals(1, gamers.round("playerName1", "playerName2"));
    }

    @Test
    public void shouldReturn2() {
        assertEquals(2, gamers.round("playerName2", "playerName1"));
    }

    @Test
    public void shouldReturn0() {
        assertEquals(0, gamers.round("playerName2", "playerName3"));
    }

    @Test
    public void shouldThrowExceptionIfNoPlayer1() {
        assertThrows(NotRegisteredException.class, () -> {
            gamers.round("playerName11", "playerName2");
        });
    }

    @Test
    public void shouldThrowExceptionIfNoPlayer2() {
        assertThrows(NotRegisteredException.class, () -> {
            gamers.round("playerName1", "playerName22");
        });
    }
}
