import java.util.Optional;

/**
 * A simplified console version of the classic Snake game.
 * The player controls a "snake" that moves around a grid, collecting food
 *   and growing in length.
 * The game ends if the snake runs into itself or the edge of the grid.
 * <pre>
 * Simulate the game board with a 2D array.
 * Display the game using text-based output.
 * </pre>
 * @version 1
 */
class SnakeGame implements Game {
    @Override
    public String getName() {
        return "Snake";
    }

    @Override
    public Optional<Integer> play() {
        System.out.println("Welcome, you are now playing Snake");
        System.out.println("Collect food to grow your snake");
        System.out.println("But be careful!");
        System.out.println("If you run into yourself or the edge of the grid, you lose!");
        System.out.println("Have fun!!!");
        return Optional.empty();
    }
}
