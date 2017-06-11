package me.spangenberg.sudoku.domain;

/**
 * @author John Spangenberg
 */
public class GridNotSolvableException extends RuntimeException {

    public GridNotSolvableException(String msg) {
        super(msg);
    }
}
