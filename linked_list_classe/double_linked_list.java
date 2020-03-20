package linked_list_classe;

import linked_list_intterface.ILinkedList;

public class double_linked_list implements ILinkedList{
	
	private DNode Head = new DNode(null);
	private int Size;
	
	public double_linked_list() {
		Head = null;
		Size =0;
	}
	
	public void checkIndex(int index) throws Exception {
		if(index <0 || index > Size)
			throw new Exception("out of bound");
	}
	
	@Override
	public void add(int index, Object element) {
		try {
			checkIndex(index);
		} catch (Exception e) {
			return;
		}
		if(index ==1) {
			DNode new_element=new DNode (element);
			new_element.setNext(Head);
			Head.setPrev(new_element);
			Head = new_element;
			Size++;
		}
		else {
			DNode temp= Head;
			while(index>2) {
				temp=temp.getNext();
				index--;
			}
				DNode new_element=new DNode (element);
				new_element.setNext(temp.getNext());
				new_element.setPrev(temp);
				(temp.getNext()).setPrev(new_element);
				temp.setNext(new_element);
				Size++;
		}
				
	}

	@Override
	public void add(Object element) {
		DNode new_element=new DNode (element);
		if (Size==0) {
			Head=new_element;
		}
		else {
			DNode end=Head;
			while(end.getNext()!=null) {
				end=end.getNext();
			}
			end.setNext(new_element);
			new_element.setPrev(end);
		}
		Size++;
		
	}

	@Override
	public Object get(int index) {
		
		try {
			checkIndex(index);
		}
		catch (Exception e) {
			return null;
		}
		DNode temp=Head;
		if(index ==1) {
			temp=Head;
		}
		else {
			while(index>1) {
				temp=temp.getNext();
				index--;	
			}
		}
		return temp.getElement();
	}

	@Override
	public void set(int index, Object element) {
		try {
			checkIndex(index);
		} catch (Exception e) {
			return;
		}
		DNode temp=Head;
		if(index ==1) {
			Head.setElement(element);
		}
		else {
			while(index>1) {
				temp=temp.getNext();
				index--;	
			}
			temp.setElement(element);
		}
		
	}

	@Override
	public void clear() {
		Head.setNext(null);
		Size=0;
	}

	@Override
	public boolean isEmpty() {
		return Head==null;
	}

	@Override
	public void remove(int index) {
		try {
			checkIndex(index);
		} catch (Exception e) {
			return;
		}
		DNode temp=Head;
		if(index==1) {
			Head=temp.getNext();
			Head.setPrev(null);
			Size--;
		}
		else {
			while(index>2) {
				temp=temp.getNext();
				index--;	
			}
			DNode next = (temp.getNext()).getNext();
			next.setPrev(temp);
			temp.setNext(next);
			Size--;
		}	
	}

	@Override
	public int size() {
		return Size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		try {
			checkIndex(fromIndex);
		} 
		catch (Exception e) {
			return null;
		}
		try {
			checkIndex(toIndex);
		} 
		catch (Exception e) {
			return null;
		}

		DNode start;
		single_linked_liist i = new single_linked_liist();
		int counter =1;
		start=this.Head;
		while(counter!=fromIndex)
		{
			start = start.getNext();
			counter++;
		}
		do {
			i.add(start.getElement());
			start = start.getNext();
			counter++;
		}while(counter!=toIndex+1);
		return  i;
	}

	@Override
	public boolean contains(Object o) {
		DNode check=Head;
		while(check!=null) {
			if(check.getElement()==o)
				return true;
			check = check.getNext();
		}
		return false;
	}
	
	
}
