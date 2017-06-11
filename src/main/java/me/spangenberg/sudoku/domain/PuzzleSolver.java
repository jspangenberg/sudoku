package me.spangenberg.sudoku.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

/**
 * Solves a {@link Grid}
 *
 * @author John Spangenberg
 */
public class PuzzleSolver {

    private static final int EMPTY = 0;

    private final int[] values;

    public PuzzleSolver() {
        this.values = generateUniqueRandomValues();
    }

    /**
     * Solves a Grid using back tracking.
     *
     * It takes the first valid value and goes on with this approach until the grid is solved or there is no
     * valid value left. In case there is no valid value left, without the grid being solved, it tracks back to
     * the last known valid value and tries another value.
     * The algorithm will always find a valid solution unless the initially provided puzzle is invalid!
     *
     * @param grid the {@link Grid} to solvable
     * @throws IllegalStateException in case the provided {@link Grid} is invalid.
     */
    public void solve(Grid grid) {
        boolean solvable = solve(grid, grid.getFirstEmptyCell());

        if (!solvable) {
            throw new GridNotSolvableException("Not solvable.");
        }
    }

    private boolean solve(Grid grid, Optional<Grid.Cell> cell) {
        if (!cell.isPresent()) {
            return true;
        }

        for (int value : values) {
            if (grid.isValidValueForCell(cell.get(), value)) {
                cell.get().setValue(value);
                if (solve(grid, grid.getNextEmptyCellOf(cell.get())))
                    return true;
                cell.get().setValue(EMPTY);
            }
        }

        return false;
    }

    private int[] generateUniqueRandomValues() {
        ArrayList<Integer> valueList = new ArrayList<>(9);

        for (int i = 1; i <= 9; i++) {
            valueList.add(i);
        }

        Collections.shuffle(valueList);
        return valueList.stream().mapToInt(i -> i).toArray();
    }

}
