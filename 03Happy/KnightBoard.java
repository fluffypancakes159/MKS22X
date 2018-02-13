import java.util.*;

public class KnightBoard {

	public int[][]board;
	public int length;
	public int width;

	public static void main(String[] args) {
		
	}

	public KnightBoard ( int rows , int cols ) {
		if ( rows <= 0 || cols <= 0 ) {
			throw new IllegalArgumentException( );
		}
		this.length = rows;
		this.width = cols;
		this.board = new int[this.length][this.width]; 
	}

	public String toString ( ) {
		String output = "";
		int currentNum;
		for ( int i = 0 ; i < this.length ; i++ ) {
			for ( int j = 0 ; j < this.width ; j++ ) {
				currentNum = this.board[i][j];
				if ( currentNum < 10 ) {
					output += "_" + currentNum;
				}
				else if ( currentNum == 0 ) {
					output += "__";
				}
				else {
					output += "" + currentNum;
				} 
				output += " ";
			}
			output += "\n";
		}
		return output;
	}

	private void emptyCheck ( ) {
		for ( int i = 0 ; i < this.length ; i++ ) {
			for ( int j = 0 ; j < this.width ; j++ ) {
				if ( this.board[i][j] != 0 ) {
					throw new IllegalStateException ( "Board should be empty >:(" );
				}
			}
		}
	}

	public boolean solve ( int row , int col ) {
		this.emptyCheck( );
		return true;
	}

	public int countSolutions ( ) {
		this.emptyCheck( );
		return 0;
	}

}