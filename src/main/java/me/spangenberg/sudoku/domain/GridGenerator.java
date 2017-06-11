package me.spangenberg.sudoku.domain;

import java.util.Random;

/**
 * Generates a new {@link Grid}
 *
 * @author John Spangenberg
 */
public class GridGenerator {

    private PuzzleSolver solver;

    public GridGenerator() {
        this.solver = new PuzzleSolver();
    }

    /**
     * Generates a new {@link Grid} and erases a number of randomly selected cells
     * @param numberOfCellsToErase The number of cells to be erased.
     * @return
     */
    public Grid generate(int numberOfCellsToErase) {
        Grid grid = Grid.emptyGrid();
        solver.solve(grid);
        eraseCells(grid, numberOfCellsToErase);
        return grid;
    }

    private void eraseCells(Grid grid, int numberOfCellsToErase) {
        Random random = new Random();
        for (int i = 0; i < numberOfCellsToErase; i++) {
            int row = random.nextInt(9);
            int column = random.nextInt(9);

            Grid.Cell cell = grid.getCell(row, column);
            if (!cell.isEmpty()) {
                cell.setValue(0);
            } else {
                i--;
            }
        }
    }

}
