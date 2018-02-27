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
		KnightBoard A = new KnightBoard ( 5 , 5 );
		System.out.println( A );
		/*A.moveKnight( 2 , 2 , 1 );
		System.out.println( A );*/
		System.out.println( A.solve( 2 , 2 ) );
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

	private void onBoardCheck ( int row , int col ) {
		if ( row >= length || row < 0 || col >= width  || col < 0 ) {
			throw new IllegalArgumentException ( "Starting posiiton outside board" );
		}
	}

	public boolean solve ( int row , int col ) {
		this.onBoardCheck( row , col );
		this.emptyCheck( );
		if ( length < 3 && width < 3 ) {
			return false;
		} 
		return solveHelp ( row , col , 1 );
	}

	public boolean solveHelp ( int row , int col , int level ) {
		if ( level == length * width + 1) {
			return true;
		}
		if ( moveKnight ( row , col , level ) ) {
			for ( int i = 0 ; i < 8 ; i++ ) {
				if ( solveHelp ( row + moves[i][0] , col + moves[i][1] , level + 1 ) ) {
					return true;
				}
				// unmoveKnight ( row , col );
			}
			unmoveKnight ( row , col );
		}
		return false;
	}

	public boolean moveKnight ( int row , int col , int level ) {
		if ( row >= length || row < 0 || col >= width || col < 0 || board[row][col] != 0 ) {
			return false;
		}
		board[row][col] = level;
		System.out.println ( this );
		return true;
	}

	public boolean unmoveKnight ( int row , int col ) {
		if ( row >= length || row < 0 || col >= width  || col < 0 ) {
			return false;
		}
		board[row][col] = 0;
		return true;
	}

	public int countSolutions ( ) {
		this.emptyCheck( );
		return 0;
	}

}