package com.sudoku.Controller;
import com.sudoku.model.SudokuRequest;
import com.sudoku.model.SudokuResponse;
import com.sudoku.service.SudokuService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sudoku")
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular frontend
public class SudokuController {

    private final SudokuService sudokuService;

    public SudokuController(SudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }

    @PostMapping("/solve")
    public SudokuResponse solve(@RequestBody SudokuRequest request) {
    	char[][] solved = sudokuService.solveSudoku(request.getGrid());
    	return new SudokuResponse(convertToStringGrid(solved), "Solved successfully");
    }
    
    private String[][] convertToStringGrid(char[][] board) {
        String[][] result = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = String.valueOf(board[i][j]);
            }
        }
        return result;
    }

}
