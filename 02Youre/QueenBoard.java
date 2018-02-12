public class QueenBoard {
	
	private int[][]board;
	private int size;

	public static void main(String[] args) {
		QueenBoard A = new QueenBoard ( 4 );
		A.addQueen( 1 , 1);
		System.out.println( A );
		A.addQueen( 2 , 1 );
		System.out.println( A );
		A.removeQueen( 1 , 1 );
		System.out.println( A );
		A.solve( );
	}

	public QueenBoard ( int size ) {
		board = new int[size][size];
		this.size = size;
	}

	private boolean addQueen ( int r , int c ) { // make this non-column-specific
		if ( this.board[r][c] == 0 ) {
			changeSquares ( r , c , 1 );
			return true;
		}
		return false;
	}

	private boolean removeQueen ( int r , int c ) {
		if ( this.board[r][c] == -1 ) {
			changeSquares ( r , c , -1 );
			return true;
		}
		return false;
	}
	
	private void clearBoard ( ) {
		this.board = new int[this.size][this.size];
	}

	private void changeSquares ( int r , int c , int increment ) {
		board[r][c] -= increment;
		for ( int i = 1 ; r+i < this.size || c+i < this.size ; i++ ) {
			board[r+i][c] += increment;
			if ( c - i >= 0) {
				board[r+i][c-i] += increment;
			}
			if ( c + i < this.size) {
				board[r+i][c+i] += increment;
			}
		}
	}

	public String toString ( ) {
		String output = "";
		for ( int i = 0 ; i < board.length ; i++ ) {
			for ( int j = 0 ; j < board.length ; j++ ) {
				if ( board[i][j] < 0 ) {
					output += "Q ";
				}
				else if ( board[i][j] > 0 ) {
					output += "X ";
				}
				else {
					output += "_ ";
				}
			}
			output += "\n";
		}
		return output;
	}

	public boolean solve ( ) {
		if ( this.size == 2 || this.size == 3 ) { // size 2 and 3 don't work
			return false;
		}
		else {
			return this.solveHelp( 0 );
		}
	}

	public boolean solveHelp ( int row ) {
		if ( row == this.size ) {
			return true;
		}
		for (int i = 0 ; i < this.size ; i++ ) {
			// addQueen
			if ( solveHelp ( row + 1 ) ) {
				return true;
			}
			// remove queen
		}
		return false;
	}

}

/* solve help only needs row/column 
-> base case is at the last one
loop through column/row to place queens
place queen
-> if (next column is possible), return true
-> if cannot place queen in next column, remove queen
return false outside of loop


*/