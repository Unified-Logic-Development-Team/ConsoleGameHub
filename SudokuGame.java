import java.util.Optional;

/**
 * 
 * 
 * 
 * A number placement puzzle on a 9x9 grid.
 * The objective is to fill the grid with digits from 1 to 9 so that each
 * column, row, and 3x3 subgrid contains all digits without repetition.
 * <pre>
 * Implements puzzle validation and a playable UI.
 * May also generate puzzles.
 * </pre>
 * @version 1
 */
class SudokuGame implements Game {
    @Override
    public String getName() {
        return "Sudoku";
    }

    @Override
    public Optional<Integer> play() {
        System.out.println("[Playing Sudoku - Placeholder]");
        
        System.out.println("Welcome to Sudoku!");
        System.out.println("fill the grid with digits 1 to 9");
        System.out.print("so that each column and row and 3x3 subgrid");
        System.out.print("containts all digits without repetition");
        
        return Optional.empty();
    }
}
