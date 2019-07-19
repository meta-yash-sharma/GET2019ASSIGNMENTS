package RecursionAssignment;

public class NQueenProblem {
	
	
	/**
	 * Creates An N×N chessboard , And place Queen in such position that no two queens 
	 * attack each other  (Thus, a solution requires that no two queens share the 
	 * same row, column, or diagonal). 
	 * @param gridSize The Size of checkBox you want to place Queen in such that 
	 * no two queens attack each other. 
	 * @return returns True if The above condition is possible in NxN chessboard otherwise
	 * false.
	 */
	public boolean placeQueens(int gridSize){
		
		boolean queenInBoard = false;
		//If Grid is 1*1 or 2*2 or 3*3 then solution is not possible as, 
		//In 1*1 or 2*2 grid, Queen placed in 1st row at any position will attack queen placed at all the positions in row 2. 
		//In 3*3 grid, Queen placed in 1st row and 2nd row for all combinations position will attack queen placed at all the positions in row 3. 
		if(gridSize<4){ 
			System.out.println("No Solution available");
		}
		else {
			int[][] board = new int[gridSize][gridSize];
			queenInBoard = placeAllQueens(board, 0);
			//printBoard(board);
		}
		return queenInBoard;
	}
	
	
	/**
	 * place 1 in such position that no two One's share the same row, column, or diagonal
	 * and All other places of matrix are given value 0.
	 * @param board an empty NxN Integer matrix
	 * @param row An Integer Value that Stores the value of row of matrix.
	 * @return returns True if The above condition is possible in NxN chessboard otherwise false.
	 */
	private static boolean placeAllQueens(int board[][], int row){
		if(row>=board.length){
		   return true;
		}
		boolean isAllQueensPlaced = false;
		for (int j = 0; j < board.length; j++) {
			if(isSafe(board, row, j)){
		    board[row][j] = 1;
		    isAllQueensPlaced = placeAllQueens(board, row+1); 
		    }
			if(isAllQueensPlaced){
		    break; 
		    }
			else {
		    board[row][j] = 0; 
		    }
		}
	return isAllQueensPlaced;
	}
	
	
	/**
	 * Check Whether the current place of matrix can satisfy the condition that no two 
	 * One's share the same row, column, or diagonal 
	 * @param board An integer NxN matrix.
	 * @param row An integer value which store the row value of current index user is working.
	 * @param col An integer value which store the column value of current index user is working
	 * @return true if the current place satisfy the condition, otherwise false.
	 */
	private static boolean isSafe(int board[][], int row, int col) {
		
		//Check Left Upper Diagonal
		for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 1){
		    return false; 
		    }
		}
		//Check Right Upper Diagonal
		for (int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
			if(board[i][j] == 1){
		    return false; 
		    }
		}
		//Check in same Column
		for (int i = row-1; i >= 0; i--) { 
			if(board[i][col] == 1){
		    return false; 
		    }
		} 
		return true; 
	}
	
	/**
	 * Display an NxN matrix such that All the 1 are replaced by Q and all the o by "_"
	 * @param board An integer matrix
	 */
	/*
	private static void printBoard(int[][] board) {
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) { 
				if(board[row][col] == 1) { 
					System.out.print("Q\t");
					}
				else { 
					System.out.print("_\t"); 
					} 
				} 
			System.out.println("\n"); 
			} 
		System.out.println(""); 
		} 
		*/
}