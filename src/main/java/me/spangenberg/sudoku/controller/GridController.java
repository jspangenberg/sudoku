package me.spangenberg.sudoku.controller;

import me.spangenberg.sudoku.domain.*;
import me.spangenberg.sudoku.form.GridForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author John Spangenberg
 */
@Controller
public class GridController {

    @Value("${emptycells:40}")
    private int emptyCells;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String showGrid(GridForm form) {
        GridGenerator generator = new GridGenerator();
        Grid grid = generator.generate(emptyCells);
        GridConverter.convertToGridForm(grid, form);
        return "playgrid";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST, params = "action=new")
    public String newGrid(GridForm form) {
        return showGrid(form);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST, params = "action=solve")
    public String solveGrid(GridForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            form.setCheckResult("Cells can only contain digits from 0-9");
            return "playgrid";
        }

        GridGenerator generator = new GridGenerator();
        Grid grid = generator.generate(0);
        PuzzleSolver solver = new PuzzleSolver();
        try {
            solver.solve(GridConverter.convertToGrid(form, grid));
        } catch(GridNotSolvableException e) {
            form.setCheckResult("Puzzle is not solvable. Start a new game.");
        }
        GridConverter.convertToGridForm(grid, form);

        return "playgrid";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST, params = "action=check")
    public String checkGrid(GridForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            form.setCheckResult("Cell can only contain digits from 0-9");
            return "playgrid";
        }

        GridGenerator generator = new GridGenerator();
        Grid grid = generator.generate(81);
        GridConverter.convertToGrid(form, grid);

        int gridSize = grid.getSize();

        form.setCheckResult("Great! You solved the puzzle.");
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                Grid.Cell cell = grid.getCell(row, column);
                if (!grid.isValidValueForCell(cell, cell.getValue())) {
                    form.setCheckResult("Bummer! Try it with a new game.");
                    break;
                }
            }
        }

        return "playgrid";
    }



}
