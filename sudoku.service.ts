import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class SudokuService {
  private baseUrl = 'http://localhost:8080/api/sudoku';

  constructor(private http: HttpClient) {}

  solveSudoku(request: { grid: string[][] }): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/solve`, request);
  }
}
