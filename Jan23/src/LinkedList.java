
public class LinkedList {
	Node root;
	int size = 0;
	
	String get(int index) {
		if(index < 0) {return "you dumb";}
		Node retNode = root;
		for(int i = 0; i<size; i++) {
			if(i == index) {
				return retNode.value;
			}
			retNode = retNode.next;
		}
		return "oh, whoops";
	}
	void add(String element) {
		if(root == null) {
			root = new Node();
			root.value = element;
		}else {
			Node nextNode = root.next;
			while(nextNode!= null) {
				nextNode = nextNode.next;
			}
			nextNode = new Node();
			nextNode.value = element;
		}
		size++;
	}
	void remove(int index) {
		if(index < 0 || index > size) {return;}
		Node currRoot = root;
		if(currRoot == null) {return;}
		Node nextNode = root.next;
		for(int i = 0; i<size; i++) {
			if(i == index) {
				if(nextNode == null) {
					currRoot.next = null;
				}
				else {
					currRoot.next = nextNode.next;
				}
				return;
			}
		}		
	}
	
	int size() {
		return size;
	}
	
	public class Node{
		String value;
		Node next;
	}

}
