import java.util.*;

public class QueenBoard {
	
	private int[][]board;
	private int size;

	public static void main(String[] args) { //testing stuff
		QueenBoard A = new QueenBoard ( 3 );
		QueenBoard B = new QueenBoard ( 4 );
		QueenBoard C = new QueenBoard ( 5 );
		QueenBoard D = new QueenBoard ( 21 );
		/*
		A.addQueen( 1 , 1);
		System.out.println( A );
		A.addQueen( 2 , 3);
		System.out.println( A );
		A.removeQueen( 1 , 1 );
		System.out.println( A );
		A.removeQueen( 2 , 3 );
		System.out.println( A );
		*/
		
		System.out.println( A );
		System.out.println( B );
		System.out.println( C );
		System.out.println( D );

		// A.addQueen( 0 , 0);

		A.solve( );
		System.out.println( A );
		B.solve( );
		System.out.println( B );
		C.solve( );
		System.out.println( C );
		D.solve( );
		System.out.println( D );
		// B.clearBoard( );
		// B.countSolutions( );
		
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
		for ( int i = 1 ; i < size ; i++ ) {
			if ( r + i < this.size) {
				board[r+i][c] += increment;
				if ( c - i >= 0) {
					board[r+i][c-i] += increment;
					board[r][c-i] += increment;
				}
				if ( c + i < this.size) {
					board[r+i][c+i] += increment;
					board[r][c+i] += increment;
				}
			}
			else {
				if ( c - i >= 0) {
					board[r][c-i] += increment;
				}
				if ( c + i < this.size) {
					board[r][c+i] += increment;
				}
			}
		}
	}

	public String toString ( ) {
		String output = "";
		for ( int i = 0 ; i < this.board.length ; i++ ) {
			for ( int j = 0 ; j < this.board.length ; j++ ) {
				
				if ( board[i][j] < 0 ) {
					output += "Q ";
				}
				else if ( board[i][j] > 0 ) {
					output += "X ";
				}
				else {
					output += "_ ";
				}
				
				// output += "" + board[i][j] + " ";
			}
			output += "\n";
		}
		return output;
	}

	private void emptyCheck ( ) {
		for ( int i = 0 ; i < this.board.length ; i++ ) {
			for ( int j = 0 ; j < this.board.length ; j++ ) {
				if ( this.board[i][j] != 0 ) {
					throw new IllegalStateException ( "Board should be empty >:(" );
				}
			}
		}
	}

	public boolean solve ( ) {
		this.emptyCheck( );
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
			if ( addQueen( row , i ) ) {
				// System.out.println( this + "\nAdded Queen");
				if ( solveHelp ( row + 1 ) ) {
					return true;
				}
				this.removeQueen ( row , i );
				// System.out.println( this + "\nRemoved Queen");
			}
		}
		return false;
	}
}