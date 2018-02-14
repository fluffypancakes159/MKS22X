public class KnightBoard {

	public int[][]board;
	public int length;
	public int width;
	public static final int[][]moves = { { 2 , 1  } ,
									  { 2 , -1 } , 
									  { -2 , 1 } , 
									  { -2 , -1 } , 
									  { 1 , 2 } , 
									  { 1 , -2 } , 
									  { -1 , 2 } , 
									  { -1 , -2 } };

	public static void main(String[] args) {
		KnightBoard A = new KnightBoard ( 4 , 5 );
		System.out.println( A );
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
		if ( row < 3 && col < 3 ) {
			return false;
		} 

		return solveHelp ( 0 , 0 , 1 );
	}

	public boolean solveHelp ( int row , int col , int level ) {
		if ( level == row * col ) {
			return true;
		}
		for ( int i = 0 ; i < moves.length ; i++ ) {
			if ( moveKnight ( row , col , moves[i] ) ) {
				if ( solveHelp ( row , col , level + 1 ) ) {
					return true;
				}
			}

		}
	}

	public boolean moveKnight ( int row , int col , int[]move ) {
		return true; // check if move leaves knight out of bounds


	}

	public int countSolutions ( ) {
		this.emptyCheck( );
		return 0;
	}

}