public class QueenBoard {
	
	private int[][]board;
	private int size;

	public static void main(String[] args) {
		QueenBoard A = new QueenBoard ( 4 );
		A.changeSquares( 1 , 1 , 1);
		System.out.println( A );
	}

	public QueenBoard ( int size ) {
		board = new int[size][size];
		this.size = size;
	}

	private boolean addQueen ( int r , int c ) {
		if ( this.board[r][c] == 0 ) {
			this.board[r][c] -= 1;
			return true;
		}
		return false;
	}

	private boolean removeQueen ( int r , int c ) {
		if ( this.board[r][c] == -1 ) {
			this.board[r][c] += 1;
			return true;
		}
		return false;
	}
	
	private void clearBoard ( ) {
		this.board = new int[this.size][this.size];
	}

	private void changeSquares ( int r , int c , int increment ) {
		board[r][c] -= increment * 2;
		for ( int i = 0 ; i < this.size ; i++ ) {
			for ( int j = 0 ; j < this.size ; j++ ) {
				// if ( Math.abs( ))
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
				else {
					output += "_ ";
				}
			}
			output += "\n";
		}
		return output;
	}

	public boolean solve ( ) {
		if ( this.size <= 3 ) {
			return false;
		}
		else {
			return this.solveHelp( 0 , 0 );
		}
	}

	public boolean solveHelp ( int row , int col ) {
		return true;
	}

}