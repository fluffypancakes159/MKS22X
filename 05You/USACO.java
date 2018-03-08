import java.util.*;
import java.io.*;
public class USACO {

	public static void main(String[] args) {
		try {
			System.out.println( USACO.bronze( "makelake.in" ) );
		}
		catch ( FileNotFoundException e ) {
			System.out.println ( "no file found :(" );
		}
	}

	public static int bronze ( String filename ) throws FileNotFoundException {
		try {
			Scanner bronzeIn = new Scanner ( new File ( filename ) );
			int length = bronzeIn.nextInt( );
			int width = bronzeIn.nextInt( );
			int elevation = bronzeIn.nextInt( );
			int numInstructions = bronzeIn.nextInt( );
			System.out.println ( length );
			System.out.println ( width );
			System.out.println ( elevation );
			System.out.println ( numInstructions );
			int[][]lake = new int[length][width];
			int[][]instructions = new int[numInstructions][3];
			for ( int i = 0 ; i < length ; i++ ) {
				for ( int j = 0 ; j < width ; j++ ) {
					lake[i][j] = bronzeIn.nextInt( );
					printArray ( lake );
				}
			}
			for ( int i = 0 ; i < numInstructions ; i++ ) {
				for ( int j = 0 ; j < 3 ; j++ ) {
					if ( j % 3 != 2 ) {
						instructions[i][j] = bronzeIn.nextInt( ) - 1; // adjust instructions to start at 0 instead of 1
					}
					else {
						instructions[i][j] = bronzeIn.nextInt( );
					}
				}
			}
			bronzeIn.close( );
			for ( int i = 0 ; i < numInstructions ; i++ ) {
				printArray ( lake );
				executeBronze ( lake , instructions[i] );
			}
			printArray ( lake );
			return calcVolume ( lake , elevation );
		}
		catch ( FileNotFoundException e ) {
			throw new FileNotFoundException ( "no file found :(" );
		}
	}

	private static void executeBronze ( int[][]input , int[]instructions ) {
		int max = input[instructions[0]][instructions[1]];
		for ( int i = 0 ; i < 3 ; i++ ) {
			for ( int j = 0 ; j < 3 ; j++ ) {
				try {
					int currentNum = input[i+instructions[0]][j+instructions[1]];
					if ( currentNum > max ) {
						max = currentNum;
					}
				}
				catch ( ArrayIndexOutOfBoundsException e ) {
					// do nothing
				}
			}
		}
		int newVal = max - instructions[2];
		for ( int i = 0 ; i < 3 ; i++ ) {
			for ( int j = 0 ; j < 3 ; j++ ) {
				try {
					if ( input[i+instructions[0]][j+instructions[1]] > newVal ) {
						input[i+instructions[0]][j+instructions[1]] = newVal;
					}
				}
				catch ( ArrayIndexOutOfBoundsException e ) {
					// do nothing again
				}
			}
		}
	} 

	private static int calcVolume ( int[][]lake , int elevation ) {
		int volume = 0;
		for ( int i = 0 ; i < lake.length ; i++ ) {
			for ( int j = 0 ; j < lake[0].length ; j++ ) {
				if ( lake[i][j] < elevation ) {
					volume += elevation - lake[i][j];
				}
			}
		}
		return volume * 72 * 72;
	}

	public static void printArray ( int[][]ary ) {
		String output = "";
		for ( int i = 0 ; i < ary.length ; i++ ) {
			for ( int j = 0 ; j < ary[0].length ; j++ ) {
				output += ary[i][j] + " ";
			}
			output += "\n";
		}
		System.out.println( output );
	}

	public static int silver ( String filename ) {
		return 0;
	}	


}