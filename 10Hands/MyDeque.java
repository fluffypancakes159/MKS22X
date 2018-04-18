import java.util.*;

public class MyDeque<E> implements Queue<E> {
	
	private E[] data;
	private int start;
	private int end;

	public static void main(String[] args) {
		
	}

	@SuppressWarnings ( "unchecked" )
	public MyDeque ( ) {
		data = (E[]) new Object[10];
		start = 4;
		end = 4;
	}

	public E peek ( ) {
		
	}

}