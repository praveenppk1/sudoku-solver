package com.sudoku.service;

import org.springframework.stereotype.Service;

@Service
public class SudokuService {
   // private final Solution solver = new Solution();

    public char[][] solveSudoku(char[][] board) {
        //solver.solveSudoku(board);
    	solve(board,0,0);
        return board;
    }
    
    public boolean solve(char [][] board,int row,int col){
        if(col==board[0].length){
            row++;
            col=0;
        }
        if(row==board.length) return true;

        if(board[row][col]!='.') return solve(board,row,col+1);

        for(char i='1';i<='9';i++){
            if(validNumber(board,row,col,i)){
                board[row][col]=i;
                if(solve(board,row,col+1)) return true;
                board[row][col]='.';
            }
        }
        return false;
    }

    public boolean validNumber(char[][] board,int row,int col,int num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num) return false;
            if(board[i][col]==num) return false;
            if(board[(row/3)*3+(i/3)][(col/3)*3+(i%3)]==num) return false;
        }
        return true;
    }
}