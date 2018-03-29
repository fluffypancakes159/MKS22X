private class Node {
	
	private Node prev;
	private Node next;
	private Integer data;

	public Node ( Integer data ) {
		prev = null;
		next = null;
		this.data = data;
	}

	public Node ( Node prev , Node next , Integer data) {
		this.prev = prev;
		this.next = next;
		this.data = data;
	}

	private void setPrev ( Node prev ) {
		this.prev = prev; 
	}

	private void setNext ( Node next ) {
		this.next = next;
	}

	private void setValue ( Integer value ) {
		data = value;
	}

	public Node getPrev ( ) {
		return prev;
	}

	public Node getNext ( ) {
		return next;
	}

	public int getValue ( ) {
		return data;
	}

	public String toString ( ) {
		return "" + data;
	}

}