package me.spangenberg.sudoku.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author John Spangenberg
 */
public class Grid {

    private static final int GRID_LENGTH = 9;

    private final Cell[][] grid;

    private Grid(Cell[][] grid) {
        this.grid = grid;
    }

    public static Grid create(int[][] grid) {
        validateGrid(grid);

        List<List<Cell>> rows = new ArrayList<>();
        List<List<Cell>> columns = new ArrayList<>();
        List<List<Cell>> boxes = new ArrayList<>();
        Cell[][] cells = new Cell[GRID_LENGTH][GRID_LENGTH];

        populate(rows, columns, boxes);
        populateWithCells(grid, cells, rows, columns, boxes);
        populateWithOtherCells(rows, columns, boxes);

        return new Grid(cells);
    }


    public static Grid emptyGrid() {
        int[][] emptyGrid = new int[GRID_LENGTH][GRID_LENGTH];
        return Grid.create(emptyGrid);
    }

    public int getSize() {
        return grid.length;
    }


    public Cell getCell(int row, int column) {
        return grid[row][column];
    }

    public boolean isValidValueForCell(Cell cell, int value) {
        return  isValidValueInBox(cell, value) && isValidValueInRow(cell, value) && isValidValueInColumn(cell, value);
    }

    public Optional<Cell> getFirstEmptyCell() {
        Cell firstCell = grid[0][0];
        if (firstCell.isEmpty()) {
            return Optional.of(firstCell);
        }

        return getNextEmptyCellOf(firstCell);
    }

    public Optional<Cell> getNextEmptyCellOf(Cell cell) {
        Cell nextEmptyCell = null;

        while ((cell = cell.getNextCell()) != null) {
            if (!cell.isEmpty()) {
                continue;
            }

            nextEmptyCell = cell;
            break;
        }

        return Optional.ofNullable(nextEmptyCell);
    }

    private static void validateGrid(int[][] grid) {

        if(grid == null)
            throw new GridNotSolvableException("Grid is null.");

        if(grid.length != GRID_LENGTH)
            throw new GridNotSolvableException("Invalid number of rows.");

        for (int[] row : grid) {
            if (row.length != GRID_LENGTH) {
                throw new GridNotSolvableException("Invalid number of columns.");
            }

            for (int value : row) {
                if (value < 0 || value > GRID_LENGTH) {
                    throw new GridNotSolvableException("A cell must contain values from 0-9");
                }
            }
        }
    }

    private static void populate(List<List<Cell>> rows, List<List<Cell>> columns, List<List<Cell>> boxes) {
        for (int i = 0; i < GRID_LENGTH; i++) {
            rows.add(new ArrayList<Cell>());
            columns.add(new ArrayList<Cell>());
            boxes.add(new ArrayList<Cell>());
        }
    }

    private static void populateWithCells(int[][] grid, Cell[][] cells, List<List<Cell>> rows, List<List<Cell>> columns, List<List<Cell>> boxes) {
        Cell lastCell = null;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                Cell cell = new Cell(grid[row][column]);
                cells[row][column] = cell;

                rows.get(row).add(cell);
                columns.get(column).add(cell);
                boxes.get((row / 3) * 3 + column / 3).add(cell);

                if (lastCell != null) {
                    lastCell.setNextCell(cell);
                }

                lastCell = cell;
            }
        }
    }

    private static void populateWithOtherCells(List<List<Cell>> rows, List<List<Cell>> columns, List<List<Cell>> boxes) {
        for (int i = 0; i < GRID_LENGTH; i++) {
            List<Cell> row = rows.get(i);
            for (Cell cell : row) {
                List<Cell> otherRowCells = new ArrayList<>(row);
                otherRowCells.remove(cell);
                cell.setOtherRowCells(otherRowCells);
            }

            List<Cell> column = columns.get(i);
            for (Cell cell : column) {
                List<Cell> otherColumnCells = new ArrayList<>(column);
                otherColumnCells.remove(cell);
                cell.setOtherColumnCells(otherColumnCells);
            }

            List<Cell> box = boxes.get(i);
            for (Cell cell : box) {
                List<Cell> otherBoxes = new ArrayList<>(box);
                otherBoxes.remove(cell);
                cell.setOtherBoxCells(otherBoxes);
            }
        }
    }

    private boolean isValidValueInRow(Cell cell, int value) {
        return !getRowValuesOf(cell).contains(value);
    }

    private boolean isValidValueInColumn(Cell cell, int value) {
        return !getColumnValuesOf(cell).contains(value);
    }

    private boolean isValidValueInBox(Cell cell, int value) {
        return !getBoxValuesOf(cell).contains(value);
    }

    private Collection<Integer> getRowValuesOf(Cell cell) {
        List<Integer> rowValues = new ArrayList<>();
        for (Cell otherCell : cell.getOtherRowCells())
            rowValues.add(otherCell.getValue());
        return rowValues;
    }

    private Collection<Integer> getColumnValuesOf(Cell cell) {
        List<Integer> columnValues = new ArrayList<>();
        for (Cell otherCell : cell.getOtherColumnCells())
            columnValues.add(otherCell.getValue());
        return columnValues;
    }

    private Collection<Integer> getBoxValuesOf(Cell cell) {
        List<Integer> boxValues = new ArrayList<>();
        for (Cell otherCell : cell.getOtherBoxCells())
            boxValues.add(otherCell.getValue());
        return boxValues;
    }

    public static class Cell {
        private int value;

        private Collection<Cell> otherBoxCells;
        private Collection<Cell> otherRowCells;
        private Collection<Cell> otherColumnCells;

        private Cell nextCell;

        public Cell(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Collection<Cell> getOtherBoxCells() {
            return otherBoxCells;
        }

        public void setOtherBoxCells(Collection<Cell> otherBoxCells) {
            this.otherBoxCells = otherBoxCells;
        }

        public Collection<Cell> getOtherRowCells() {
            return otherRowCells;
        }

        public void setOtherRowCells(Collection<Cell> otherRowCells) {
            this.otherRowCells = otherRowCells;
        }

        public Collection<Cell> getOtherColumnCells() {
            return otherColumnCells;
        }

        public void setOtherColumnCells(Collection<Cell> otherColumnCells) {
            this.otherColumnCells = otherColumnCells;
        }

        public Cell getNextCell() {
            return nextCell;
        }

        public void setNextCell(Cell nextCell) {
            this.nextCell = nextCell;
        }

        public boolean isEmpty() {
            return value == 0;
        }
    }
}
