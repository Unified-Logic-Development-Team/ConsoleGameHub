import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

/**
 * A word guessing game similar to Wordle.
 * The player has a limited number of attempts to guess a secret
 * 5-letter word.
 * After each guess, the game indicates whether the guess is correct.
 * <br />
 * The score is determined by how many attempts the player had remaining
 *   when they guessed the word correctly.
 * @version 1
 */
class WordGuessGame implements Game {

    /** Total number of guesses allowed. */
    private static final int MAX_GUESSES = 6;

    /** Total number of characters allowed. */
    private static final int CHARACTER_LIMIT = 5;

    /**
     * {@inheritDoc}
     * @return the game name
     */
    @Override
    public String getName() {
        return "Word Guess";
    }

    /**
     * Plays the game once. The secret is fixed to "APPLE" so tests
     * can be deterministic. Returns the remaining guesses as the score.
     *
     * @return an Optional score: remaining guesses on success, or 0 on failure
     */
    @Override
    public Optional<Integer> play() {
        System.out.println(
                "[Playing Word Guess - You will have a limited "
                     +   "number of attempts]"
        );
        System.out.println(
                "to guess a secret 5 letter word."
        );
        System.out.println(
                "After each guess, the game will indicate whether the guess"
                        + " is correct."
        );
        System.out.println(
                "Your score is the number of attempts remaining after a "
                + "correct guess."
        );

        // Deterministic secret for tests.
        final String secret = "APPLE";

        Scanner scanner = new Scanner(System.in);
        int guessesMade = 0;

        while (guessesMade < MAX_GUESSES) {
            System.out.print("Guess the word: ");

            String userGuess = scanner
                    .nextLine()
                    .trim()
                    .toUpperCase(Locale.ROOT);

            guessesMade++;

            // Reject input that contains numbers or is not 5 letters
            if (userGuess.length() != CHARACTER_LIMIT
                  ||  !userGuess.matches("[a-zA-Z]+")) {
                System.out.println("Please enter a 5-letter word.");
                guessesMade--;
            }

            if (userGuess.equals(secret)
                  && userGuess.length() == CHARACTER_LIMIT) {
                int remaining = MAX_GUESSES - guessesMade + 1;
                System.out.println("Correct! The word was " + secret + "!");
                return Optional.of(remaining);
            }

            // Compute unique letters in common (order of the secret).
            Set<Character> secretSet = new LinkedHashSet<>();
            for (char c : secret.toCharArray()) {
                if (Character.isLetter(c)) {
                    secretSet.add(c);
                }
            }

            Set<Character> guessSet = new HashSet<>();
            for (char c : userGuess.toCharArray()) {
                if (Character.isLetter(c)) {
                    guessSet.add(c);
                }
            }

            secretSet.retainAll(guessSet);

            StringBuilder sb = new StringBuilder();
            for (char c : secretSet) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(c);
            }

            // Show letters in common, only if guess
            // is 5 characters and contains only letters
            if (userGuess.length() == CHARACTER_LIMIT
                    && userGuess.matches("[a-zA-Z]+")) {
                System.out.println("Letters in common: " + sb);
            }
            System.out.println("Guesses made: " + guessesMade + "/6");
        }

        if (guessesMade >= MAX_GUESSES) {
            System.out.println("You're out of guesses. You lose. The word was "
                    + secret + ".");
        }

        // Out of attempts.
        return Optional.of(0);
    }
}
