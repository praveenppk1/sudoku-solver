import { Component } from '@angular/core';
import { SudokuBoardComponent } from './components/sudoku-board/sudoku-board.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [SudokuBoardComponent], // import the child component here
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {}
