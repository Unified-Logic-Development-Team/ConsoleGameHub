import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for WordGuessGame.
 * @version 1
 */
public class WordGuessGameTest {

    @Test
    public void testCorrectGuessOnFirstTry() {
        String simulatedInput = "APPLE\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        assertEquals(10, result.get());

        System.setIn(originalIn);
    }

    @Test
    public void testIncorrectThenCorrectGuess() {
        String simulatedInput = "MANGO\nAPPLE\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        assertEquals(9, result.get());

        System.setIn(originalIn);
    }

    @Test
    public void testAllIncorrectGuesses() {
        String simulatedInput = "MANGO\nGRAPE\nPLUMB\nBERRY\nPEACH\nLEMON\nCHILI\nGUAVA\nOLIVE\nONION\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        WordGuessGame game = new WordGuessGame();
        Optional<Integer> result = game.play();

        assertTrue(result.isPresent());
        assertEquals(0, result.get());

        System.setIn(originalIn);
    }
}

