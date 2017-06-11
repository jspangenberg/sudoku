package me.spangenberg.sudoku.domain;

import me.spangenberg.sudoku.form.GridForm;

/**
 * @author John Spangenberg
 */
public class GridConverter {

    public static void convertToGridForm(Grid grid, GridForm form) {
        form.setA1(grid.getCell(0, 0).getValue());
        form.setA2(grid.getCell(0, 1).getValue());
        form.setA3(grid.getCell(0, 2).getValue());
        form.setA4(grid.getCell(0, 3).getValue());
        form.setA5(grid.getCell(0, 4).getValue());
        form.setA6(grid.getCell(0, 5).getValue());
        form.setA7(grid.getCell(0, 6).getValue());
        form.setA8(grid.getCell(0, 7).getValue());
        form.setA9(grid.getCell(0, 8).getValue());

        form.setB1(grid.getCell(1, 0).getValue());
        form.setB2(grid.getCell(1, 1).getValue());
        form.setB3(grid.getCell(1, 2).getValue());
        form.setB4(grid.getCell(1, 3).getValue());
        form.setB5(grid.getCell(1, 4).getValue());
        form.setB6(grid.getCell(1, 5).getValue());
        form.setB7(grid.getCell(1, 6).getValue());
        form.setB8(grid.getCell(1, 7).getValue());
        form.setB9(grid.getCell(1, 8).getValue());

        form.setC1(grid.getCell(2, 0).getValue());
        form.setC2(grid.getCell(2, 1).getValue());
        form.setC3(grid.getCell(2, 2).getValue());
        form.setC4(grid.getCell(2, 3).getValue());
        form.setC5(grid.getCell(2, 4).getValue());
        form.setC6(grid.getCell(2, 5).getValue());
        form.setC7(grid.getCell(2, 6).getValue());
        form.setC8(grid.getCell(2, 7).getValue());
        form.setC9(grid.getCell(2, 8).getValue());

        form.setD1(grid.getCell(3, 0).getValue());
        form.setD2(grid.getCell(3, 1).getValue());
        form.setD3(grid.getCell(3, 2).getValue());
        form.setD4(grid.getCell(3, 3).getValue());
        form.setD5(grid.getCell(3, 4).getValue());
        form.setD6(grid.getCell(3, 5).getValue());
        form.setD7(grid.getCell(3, 6).getValue());
        form.setD8(grid.getCell(3, 7).getValue());
        form.setD9(grid.getCell(3, 8).getValue());

        form.setE1(grid.getCell(4, 0).getValue());
        form.setE2(grid.getCell(4, 1).getValue());
        form.setE3(grid.getCell(4, 2).getValue());
        form.setE4(grid.getCell(4, 3).getValue());
        form.setE5(grid.getCell(4, 4).getValue());
        form.setE6(grid.getCell(4, 5).getValue());
        form.setE7(grid.getCell(4, 6).getValue());
        form.setE8(grid.getCell(4, 7).getValue());
        form.setE9(grid.getCell(4, 8).getValue());

        form.setF1(grid.getCell(5, 0).getValue());
        form.setF2(grid.getCell(5, 1).getValue());
        form.setF3(grid.getCell(5, 2).getValue());
        form.setF4(grid.getCell(5, 3).getValue());
        form.setF5(grid.getCell(5, 4).getValue());
        form.setF6(grid.getCell(5, 5).getValue());
        form.setF7(grid.getCell(5, 6).getValue());
        form.setF8(grid.getCell(5, 7).getValue());
        form.setF9(grid.getCell(5, 8).getValue());

        form.setG1(grid.getCell(6, 0).getValue());
        form.setG2(grid.getCell(6, 1).getValue());
        form.setG3(grid.getCell(6, 2).getValue());
        form.setG4(grid.getCell(6, 3).getValue());
        form.setG5(grid.getCell(6, 4).getValue());
        form.setG6(grid.getCell(6, 5).getValue());
        form.setG7(grid.getCell(6, 6).getValue());
        form.setG8(grid.getCell(6, 7).getValue());
        form.setG9(grid.getCell(6, 8).getValue());

        form.setH1(grid.getCell(7, 0).getValue());
        form.setH2(grid.getCell(7, 1).getValue());
        form.setH3(grid.getCell(7, 2).getValue());
        form.setH4(grid.getCell(7, 3).getValue());
        form.setH5(grid.getCell(7, 4).getValue());
        form.setH6(grid.getCell(7, 5).getValue());
        form.setH7(grid.getCell(7, 6).getValue());
        form.setH8(grid.getCell(7, 7).getValue());
        form.setH9(grid.getCell(7, 8).getValue());

        form.setI1(grid.getCell(8, 0).getValue());
        form.setI2(grid.getCell(8, 1).getValue());
        form.setI3(grid.getCell(8, 2).getValue());
        form.setI4(grid.getCell(8, 3).getValue());
        form.setI5(grid.getCell(8, 4).getValue());
        form.setI6(grid.getCell(8, 5).getValue());
        form.setI7(grid.getCell(8, 6).getValue());
        form.setI8(grid.getCell(8, 7).getValue());
        form.setI9(grid.getCell(8, 8).getValue());

    }

    public static Grid convertToGrid(GridForm form, Grid grid) {

        grid.getCell(0,0).setValue(form.getA1());
        grid.getCell(0,1).setValue(form.getA2());
        grid.getCell(0,2).setValue(form.getA3());
        grid.getCell(0,3).setValue(form.getA4());
        grid.getCell(0,4).setValue(form.getA5());
        grid.getCell(0,5).setValue(form.getA6());
        grid.getCell(0,6).setValue(form.getA7());
        grid.getCell(0,7).setValue(form.getA8());
        grid.getCell(0,8).setValue(form.getA9());

        grid.getCell(1,0).setValue(form.getB1());
        grid.getCell(1,1).setValue(form.getB2());
        grid.getCell(1,2).setValue(form.getB3());
        grid.getCell(1,3).setValue(form.getB4());
        grid.getCell(1,4).setValue(form.getB5());
        grid.getCell(1,5).setValue(form.getB6());
        grid.getCell(1,6).setValue(form.getB7());
        grid.getCell(1,7).setValue(form.getB8());
        grid.getCell(1,8).setValue(form.getB9());

        grid.getCell(2,0).setValue(form.getC1());
        grid.getCell(2,1).setValue(form.getC2());
        grid.getCell(2,2).setValue(form.getC3());
        grid.getCell(2,3).setValue(form.getC4());
        grid.getCell(2,4).setValue(form.getC5());
        grid.getCell(2,5).setValue(form.getC6());
        grid.getCell(2,6).setValue(form.getC7());
        grid.getCell(2,7).setValue(form.getC8());
        grid.getCell(2,8).setValue(form.getC9());

        grid.getCell(3,0).setValue(form.getD1());
        grid.getCell(3,1).setValue(form.getD2());
        grid.getCell(3,2).setValue(form.getD3());
        grid.getCell(3,3).setValue(form.getD4());
        grid.getCell(3,4).setValue(form.getD5());
        grid.getCell(3,5).setValue(form.getD6());
        grid.getCell(3,6).setValue(form.getD7());
        grid.getCell(3,7).setValue(form.getD8());
        grid.getCell(3,8).setValue(form.getD9());

        grid.getCell(4,0).setValue(form.getE1());
        grid.getCell(4,1).setValue(form.getE2());
        grid.getCell(4,2).setValue(form.getE3());
        grid.getCell(4,3).setValue(form.getE4());
        grid.getCell(4,4).setValue(form.getE5());
        grid.getCell(4,5).setValue(form.getE6());
        grid.getCell(4,6).setValue(form.getE7());
        grid.getCell(4,7).setValue(form.getE8());
        grid.getCell(4,8).setValue(form.getE9());

        grid.getCell(5,0).setValue(form.getF1());
        grid.getCell(5,1).setValue(form.getF2());
        grid.getCell(5,2).setValue(form.getF3());
        grid.getCell(5,3).setValue(form.getF4());
        grid.getCell(5,4).setValue(form.getF5());
        grid.getCell(5,5).setValue(form.getF6());
        grid.getCell(5,6).setValue(form.getF7());
        grid.getCell(5,7).setValue(form.getF8());
        grid.getCell(5,8).setValue(form.getF9());

        grid.getCell(6,0).setValue(form.getG1());
        grid.getCell(6,1).setValue(form.getG2());
        grid.getCell(6,2).setValue(form.getG3());
        grid.getCell(6,3).setValue(form.getG4());
        grid.getCell(6,4).setValue(form.getG5());
        grid.getCell(6,5).setValue(form.getG6());
        grid.getCell(6,6).setValue(form.getG7());
        grid.getCell(6,7).setValue(form.getG8());
        grid.getCell(6,8).setValue(form.getG9());

        grid.getCell(7,0).setValue(form.getH1());
        grid.getCell(7,1).setValue(form.getH2());
        grid.getCell(7,2).setValue(form.getH3());
        grid.getCell(7,3).setValue(form.getH4());
        grid.getCell(7,4).setValue(form.getH5());
        grid.getCell(7,5).setValue(form.getH6());
        grid.getCell(7,6).setValue(form.getH7());
        grid.getCell(7,7).setValue(form.getH8());
        grid.getCell(7,8).setValue(form.getH9());

        grid.getCell(8,0).setValue(form.getI1());
        grid.getCell(8,1).setValue(form.getI2());
        grid.getCell(8,2).setValue(form.getI3());
        grid.getCell(8,3).setValue(form.getI4());
        grid.getCell(8,4).setValue(form.getI5());
        grid.getCell(8,5).setValue(form.getI6());
        grid.getCell(8,6).setValue(form.getI7());
        grid.getCell(8,7).setValue(form.getI8());
        grid.getCell(8,8).setValue(form.getI9());

        return grid;
    }
}
