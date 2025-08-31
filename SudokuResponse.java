package com.sudoku.model;

public class SudokuResponse {
    private String[][] solvedGrid;
    private String message;

    public SudokuResponse(String[][] solvedGrid, String message) {
        this.solvedGrid = solvedGrid;
        this.message = message;
    }

    public String[][] getSolvedGrid() {
        return solvedGrid;
    }

    public String getMessage() {
        return message;
    }
}
