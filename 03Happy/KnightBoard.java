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
	public int solutions;

	public static void main(String[] args) {
		KnightBoard A = new KnightBoard ( 5 , 5 );
		KnightBoard B = new KnightBoard ( 6 , 6 );
		KnightBoard C = new KnightBoard ( 1 , 1 );
		System.out.println( A );
		/*A.moveKnight( 2 , 2 , 1 );
		System.out.println( A );*/
		A.solve( 0 , 0 );
		System.out.println( A );
		
		int totalSolutions = 0;
		for ( int i = 0 ; i < B.length ; i++ ) {
			for ( int j = 0 ; j < B.width ; j++ ) {
				totalSolutions += B.countSolutions( i , j );
				B.clearBoard( );
			}
		}
		System.out.println ( totalSolutions );
		
		// C.solve( 0 , 0 );
		System.out.println( C.countSolutions( 0 , 0 ) );

	}

	public KnightBoard ( int rows , int cols ) {
		if ( rows <= 0 || cols <= 0 ) {
			throw new IllegalArgumentException( );
		}
		this.length = rows;
		this.width = cols;
		this.board = new int[this.length][this.width]; 
		this.solutions = 0;
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

	public void clearBoard ( ) {
		this.board = new int[this.length][this.width];
		this.solutions = 0;
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
		return solveHelp ( row , col , 1 );
	}

	private boolean solveHelp ( int row , int col , int level ) {
		if ( level == length * width + 1) { // add one to check the level after all squares have been filled
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

	private boolean moveKnight ( int row , int col , int level ) {
		if ( row >= length || row < 0 || col >= width || col < 0 || board[row][col] != 0 ) {
			return false;
		}
		board[row][col] = level;
		// System.out.println ( this );
		return true;
	}

	private boolean unmoveKnight ( int row , int col ) {
		if ( row >= length || row < 0 || col >= width  || col < 0 ) {
			return false;
		}
		board[row][col] = 0;
		return true;
	}

	public int countSolutions ( int row , int col ) {
		this.emptyCheck( );
		this.onBoardCheck( row , col );
		if ( length < 3 && width < 3 ) {
			return 0;
		} 
		countHelp( row , col , 1 );
		return solutions;
	}

	public boolean countHelp ( int row , int col , int level) {
		if ( level == length * width + 1) { 
			// this.solutions++;
			return false;
		}
		if ( moveKnight ( row , col , level ) ) {
			for ( int i = 0 ; i < 8 ; i++ ) {
				if ( countHelp ( row + moves[i][0] , col + moves[i][1] , level + 1 ) ) {
					return true;
				}
				// unmoveKnight ( row , col );
			}
			if ( level == length * width ) {
				solutions++;
			}
			unmoveKnight ( row , col );
		}
		return false;
	}

}