import java.util.LinkedList;

public class Calculator {

	public static void main(String[] args) {
		System.out.println( eval( "12") );
		System.out.println( eval( "1 2 * 3 +") );
		System.out.println( eval( "5 2 * 6 + 4 / ") );
		System.out.println( eval( "5 2 % 6 + 2 / ") );
		
	}

	public static double eval ( String exp ) {
		Stack stack = new Stack ( exp.length( ) );
		String currentToken = ""; 
		char currentChar = ' ';
		for ( int i = 0 ; i < exp.length( ) ; i++ ) {
			// System.out.println( stack );
			currentChar = exp.charAt(i);
			// System.out.println( "Char: |" + currentChar + "|" );
			// System.out.println( "Token: |" + currentToken + "|" );
			if ( currentChar == ' ' ) {
				// System.out.println( currentToken );
				stack.push( Double.parseDouble( currentToken ) );
				// System.out.println ( stack );
				currentToken = ""; 
			}
			else if ( currentChar > 47 || currentChar == '.' ) {
				currentToken += currentChar;
			}
			else {			
				double second = stack.pop( );
				double first = stack.pop( );
				if ( currentChar == '+' ) {
					stack.push( first + second );
				}
				else if ( currentChar == '*' ) {
					stack.push( first * second );
				}
				else if ( currentChar == '-' ) {
					stack.push( first - second );
				}
				else if ( currentChar == '/' ) {
					stack.push( first / second );
				}
				else if ( currentChar == '%' ) {
					stack.push( first % second );
				}
				// System.out.println ( stack );
				currentToken = "";
				i++;
			}
		}
		// System.out.println ( stack );
		if ( stack.size == 0 ) {
			return Double.parseDouble( currentToken );
		} 
		return stack.getFirst( );
	}

	private static class Stack {

		double[] data;
		int size;
		// int end;

		public Stack ( int size ) {
			this.data = new double[size];
			this.size = 0;
			// this.end = 0;
		}

		public void push ( double num ) {
			data[size] = num;
			// System.out.println( "Pushed: " + data[size] );
			// end++;
			size++;
			return;
		}

		public double pop ( ) {
			size--;
			double elem = data[size];
			// System.out.println( "Popped: " + elem );
			data[size] = 0.0;
			// size--;
			return elem;
		}

		public double getFirst ( ) {
			if ( size == 0 ) {
				return 0.0;
			}
			return data[size - 1];
		}

		public String toString ( ) {
			return arrayStr ( data );
		}

		public static String arrayStr ( double[]ary ) {
		String output = "[";
		if ( ary.length == 0 ) {
			return "[ ]";
		} 
		for ( int i = 0 ; i < ary.length - 1; i++ ) {
			output += ary[i] + " , ";
		}
		output += ary[ary.length - 1] + "]";
		return output;
	}

	}

}