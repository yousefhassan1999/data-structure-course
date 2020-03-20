package linked_list_classe;

public class DNode {
		Object data;
		DNode next;
		DNode prev;

		public DNode(Object element) {
			data = element;
			prev = null;
			next = null;
		}
		
		public Object getElement() {
			return data;
		}
		
		public DNode getPrev() {
			return prev;
		}
		
		public DNode getNext() {
			return next;
		}
		
		public void setElement(Object newElem) {
			data = newElem;
		}
		
		public void setPrev(DNode newPrev) {
			prev = newPrev;
		}
		
		public void setNext(DNode newNext) {
			next = newNext;
		}	
}
