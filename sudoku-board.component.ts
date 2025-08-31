import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // for [(ngModel)]
import { SudokuService } from '../../services/sudoku.service';

@Component({
  selector: 'app-sudoku-board',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './sudoku-board.component.html',
  styleUrls: ['./sudoku-board.component.css']
})
export class SudokuBoardComponent {
  board: string[][] = Array.from({ length: 9 }, () => Array(9).fill(""));

  constructor(private sudokuService: SudokuService) {}

  solveSudoku() {
    const requestBoard = this.board.map(r => r.map(c => c === "" ? "." : c));
    this.sudokuService.solveSudoku({ grid: requestBoard }).subscribe({
      next: (res) => (this.board = res.solvedGrid),
      error: (err) => {
        console.error('Error solving sudoku:', err);
        alert('Sudoku cannot be solved or server error!');
      }
    });
  }

  clearBoard() {
    this.board = Array.from({ length: 9 }, () => Array(9).fill(""));
  }
}
