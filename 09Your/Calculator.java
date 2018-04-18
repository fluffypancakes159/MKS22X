import java.util.LinkedList;

public class Calculator {

	public static void main(String[] args) {
		System.out.println( eval( "1 2 + 3 +") );
	}

	public static double eval ( String exp ) {
		Stack stack = new Stack ( exp.length( ) );
		String currentToken = ""; 
		char currentChar = ' ';
		for ( int i = 0 ; i < exp.length( ) ; i++ ) {
			currentChar = exp.charAt(i);
			System.out.println( "Char: |" + currentChar + "|" );
			System.out.println( "Token: |" + currentToken + "|" );
			if ( currentChar == ' ' ) {
				stack.push( Double.parseDouble( currentToken ) );
				currentToken = ""; 
			}
			else if ( currentChar > 47 ) {
				currentToken += currentChar;
			}
			else {
				if ( currentChar == '+' ) {
					stack.push( stack.pop( ) + stack.pop( ) );
				}
				else if ( currentChar == '*' ) {
					stack.push( stack.pop( ) * stack.pop( ) );
				}
				else if ( currentChar == '-' ) {
					stack.push( stack.pop( ) - stack.pop( ) );
				}
				else if ( currentChar == '/' ) {
					stack.push( stack.pop( ) / stack.pop( ) );
				}
				else if ( currentChar == '%' ) {
					stack.push( stack.pop( ) % stack.pop( ) );
				}
				i++;
			}
		}
		return stack.getFirst( );
	}

	private static class Stack {

		double[] data;
		int size;
		int end;

		public Stack ( int size ) {
			this.data = new double[size];
			this.size = 0;
			this.end = 0;
		}

		public void push ( double num ) {
			data[end] = num;
			end++;
			size++;
			return;
		}

		public double pop ( ) {
			double elem = data[end];
			data[end] = 0;
			end--;
			size--;
			return elem;
		}

		public double getFirst ( ) {
			return data[end];
		}

	}

}