package linked_list_classe;

public class Node {
	private Object data;
	private Node next;
	
	public Node(Object element) {
		data = element; 
		next = null;
	}

	public Object getElement() { 
		return data;
	}
	
	public Node getNext() { 
		return next; 
	}
	
	public void setElement(Object newElem) {
		data = newElem;
	}
	
	public void setNext(Node newNext) {
		next = newNext; 
	}

}