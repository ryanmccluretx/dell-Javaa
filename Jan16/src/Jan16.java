import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;

public class Jan16 {
	public static void main(String[] args) {
		
//		TreeSet<Integer> myTree = new TreeSet<Integer>();
//		for(int i=0; i<1000; i++) {
//			myTree.add(new Integer(i));
//		}
//		
//		Iterator<Integer> treeIt = myTree.iterator();
//		
//		while(treeIt.hasNext()) {
//			System.out.println(treeIt.next());
//		}
		MyStack theStack = new MyStack();
		
		
	}
	
	public class MyStack extends Stack<Integer> {
		Stack<Integer> internalStack = new Stack<Integer>();
		Integer largest = null;
		
		public void Push(Integer i) {
			if(largest == null) {
				largest = new Integer(i); 
			}else if(largest < i ) {
				largest = i;
			}
			internalStack.push(i);
		}
		
		public Integer Pop() {
			if(internalStack.peek() == largest) {
				Integer returnVal = internalStack.pop();
				
			}
			return largest;
		}
		
		
		
		
	}
}
