
public class ArrayString {
	
	public static void main(String[] args) {
		MyList<String> colors = new MyList<>();
		colors.add("Red");
		colors.add("Yellow");
		colors.add("Blue");
		
		System.out.println(colors.get(0) + colors.get(1) + colors.get(2));
	}
	
	public static class MyList{
		String[] db = new String[10];
		int size = 0;
		
		
		/**
		 * Adds a string to the list
		 * @param s
		 */
		public void add(String s) {
			if(size == db.length) 
			{
				String[] tmp = new String[size + 10];
				for(int i = 0; i < db.length; i++) {
					tmp[i] = db[i];
				}				
				db = tmp;
			}
			db[size] = s;			
			size++;			
		}
		
		
		/** Returns the current size of the list
		 * @return the current size of the list
		 */
		public int size() {
			return size;			
		}
		
	
		/**
		 * Returns the string at the position passed in
		 * @param i the position passed in
		 * @return the string at the position passed in
		 */
		public String get(int i) {
			if(i < 0 || i > size -1 ) 
			{
				return null;
			}
			
			return db[i];
		}
		
//		Removes the element form the list at the given position
//		@param i the position to remove from the list
		public void remove(int i) {
			if(i < 0 || i > size -1 ) 
			{
				return;
			}
						
			for(int j = i; j < size; j++) {
				db[j] = db[j+1];
			}
			
			db[size] = null;
			size = size -1;
		}
	}
}
