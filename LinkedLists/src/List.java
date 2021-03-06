/**
 * This class will use Nodes to form a linked list.
 * @author Samuel L. Peoples, 1527650
 **/

public class List {
	private Node head;
	/**
	 * Constructor with no parameters for outer class
	 * Creates a head node.
	 */
	public List( ) {
		head = new Node();
	}

	/**
	 * Inner class for linking the objects
	 */
	private class Node  {
		private Object data;
		private Node next;
		
		/**
		 * sets data and next to null values
		 */
		public Node(){
			data = null;
    		next = null;
    		}

		/**
		 * Parametrized constructor for inner class, uses a shallow copy
		 * @param d, object
		 * @param n, next
		 */
		public Node(Object d, Node n){
			data = d; //shallow
			next = n;
			}
		}
	/**
	 * Inserts an object at the desired index
	 * @param next, object to insert
	 * @param index, location
	 */
	public void insert(Object next, int index){
		try{
			//Check if the desired index falls outside of the list size
			if(index>size())
				  throw new LinkedListException();
			//If the head or head data is null, and the desired index is zero
			//The head will be modified with the parameter Object
			if(head == null || head.data == null)
				if(index == 0)
					head = new Node(next, null);
				else throw new LinkedListException();
    	    //If the head data is populated, but the next node is null,
			//and the desired index is 1, the head's next Node will be modified
			else if(head.next == null){
				Node current = head;
	    		  //If the desired position is zero, the entire list will be shifted 
	    		  //to accommodate the head motification
	    		  if(index == 0){
	    			  if(current.data != null)
						  head = new Node(next, head);
					  else throw new LinkedListException();
	    		  }
				  //If the desired index is 1, modify head next Node
	    		  if(index == 1)
    			  head.next = new Node(next, null);
			}
    	    //In a list of size greater than 1
			else{
    		  int i = 0;
    		  Node current = head;
    		  //If the desired position is zero, the entire list will be shifted 
    		  //to accommodate the head motification
    		  if(index == 0){
    			  if(current.data != null)
					  head = new Node(next, head);
				  else throw new LinkedListException();
    		  }
    		  //For desired indecies greater than zero
    		  while(i<=index-1){
    			  //If the index is 1, the head Next node is mmodified
    			  if(index == 1){
    				  if(current.data != null)
    					  current.next = new Node(next, current.next);
    				  else throw new LinkedListException();
    			  }
				  current = current.next;
    			  i++;
    			  //When the desired index is reached, the next node is modified 
    			  //to accommodate the new entry
    			  if(i==index-1){
    				  if(current.data != null)
    					  current.next = new Node(next, current.next);
    				  }
    			  }
    		  }
			}
		catch(LinkedListException e){
			System.out.println("Index out of bounds; "+next.toString()+" discarded.");
			System.exit(0);
		}
	}
	
	/**
	 * Removes a desired index
	 * @param index, position to remove
	 * @return, Object removed
	 */
	public Object remove(int index){
		int i = 0;
		try{
			//Check if the desired index falls outside of the list size
			if(index>size())
				  throw new LinkedListException();
			//If the head or head data is null, it will throw an immediate error 
			//for removing from an empty list
			if(head == null || head.data == null)
				throw new LinkedListException();
			//If removing zero, the head will be modified
			if(index == 0){
				Object retVal = head.data;
				head = head.next;
				return retVal;
			}
			//If another index is desired than zero
			else{
				Node current = head;
				while(i<=index){
					//If the desired index is reached, the object will be removed,
					//and the data will be shifted
					if(i == index-1){
						Object retVal = current.next.data;
						current.next = current.next.next;
						return retVal;
					}
					//Keeping track of the position
					else{
						current = current.next;
						i++;
					}
				}
			}
		}
		catch(LinkedListException e){
			System.out.println("Index out of bounds, did not remove position: " +index);
			System.exit(0);
		}
		return null;
	}
	
	/**
	 * @return counter. number of Objects in the linked list
	 */
	public int size(){
		int counter = 0;
		Node current = head;
		if(head == null || head.data == null)
			return 0;
		while(current.next != null){
			counter++;
			current = current.next;
		}
		counter++;
		return counter;
	}
	
	/**
	 * Overrides the native toString, prints the Node data
	 * @return retVal, String of values
	 */
	@Override
	public String toString(){
		Node current = head;
		String retVal = "";
		if(current == null)
			return retVal;
		while(current.data != null){
			if(current.next != null){
				retVal+= current.data+", ";
				current = current.next;
			}
			else{
				retVal+= current.data;
				break;
			}
		}
		return retVal;
	}
	
	/**
	 * @return true if there are no Objects in the Linked list
	 */
	public boolean isEmpty(){
		try{
			if(head.data == null)
				return true;
			else return false;
		}
		catch(NullPointerException e){
			return true;
		}
	}
	
	/**
	 * Returns the index of a desired object
	 * @param target, Object to search
	 * @return desired index, or -1 if the Object does not exist
	 */
	public int indexOf(Object target){
		Node current = head;
        Object itemAtPosition;
        int index = 0;
        while (current.data != null) {
            itemAtPosition = current.data;
            if (itemAtPosition.equals(target))
              return index;
            if(current.next != null){
            	current = current.next;
            	index++;
            }
            else
            	break;
          }
          return -1;            // Target not found!
	}
	
	/**
	 * Places an Object at the end of the list
	 * @param target, Object to append
	 */
	public void append(Object target){
		//Modifies the head
		if(isEmpty())
			head = new Node(target, null);
		//Modifies the head Next
		else if(size() == 1)
			head.next = new Node(target, null);
		//Modifies lists of greater size
		else{
			Node current = head;
			for(int i=0;i<size();i++){
				if(current.next == null)
					current.next = new Node(target, null);
				else
					current = current.next;
			}
		}
	}
	//I would not choose to override the isEmpty and indexOf methods because the
	//Program will behave the same way in a stack and a queue.
	/**
	 * main driver, tests methods
	 */
	public static void main(String[] args) {
		List list = new List();
		System.out.println("list is empty?: "+list.isEmpty());
		//list.remove(0); //Out of bounds
		//list.insert("z", 5); //Out of bounds
		System.out.println("Inserting \"a\" at position 0");
		list.insert("a", 0);
		System.out.println("list is empty?: "+list.isEmpty());
		//list.insert("z", 5); //Out of bounds
		System.out.println("List: "+list.toString());
		//list.remove(0); //Works
		//list.remove(1); //Out of bounds
		System.out.println("Inserting \"b\" at position 1");
		list.insert("b", 1);
		System.out.println("list is empty?: "+list.isEmpty());
		System.out.println("Inserting \"c\" at position 2");
		list.insert("c", 2);
		System.out.println("Inserting \"1\" at position 1");
		list.insert("1", 1);
		System.out.println("Inserting \"3\" at position 3");
		list.insert("3", 3);
		System.out.println("Inserting \"0\" at position 0");
		list.insert("0", 0);
		//list.insert("3", 7); //Out of bounds
		System.out.println("Index of 0: " +list.indexOf("0"));
		System.out.println("Index of a: " +list.indexOf("a"));
		System.out.println("Index of 1: " +list.indexOf("1"));
		System.out.println("Index of c: " +list.indexOf("c"));
		System.out.println("Index of z: " +list.indexOf("z"));
		
		System.out.println(list.size()+"; "+list.toString()); //6
		//0, a, 1, b, 3, c
		list.remove(0);
		//a, 1, b, 3, c
		System.out.println(list.size()+"; "+list.toString()); //5
		list.remove(1);
		//a, b, 3, c
		System.out.println(list.size()+"; "+list.toString()); //4
		list.remove(2);
		//a, b, c
		System.out.println(list.size()+"; "+list.toString()); //3
		list.remove(2);
		//a, b
		System.out.println(list.size()+"; "+list.toString()); //2
		list.remove(0);
		//b
		System.out.println(list.size()+"; "+list.toString()); //1
		list.remove(0);
		System.out.println(list.size()+"; "+list.toString()); //0
		System.out.println("list is empty?: "+list.isEmpty());
		//list.remove(7); //Out of bounds
		
		list.append("z");
		System.out.println(list.size()+"; "+list.toString()); //1
		list.append("y");
		System.out.println(list.size()+"; "+list.toString()); //2
		list.insert("a", 0);
		System.out.println(list.size()+"; "+list.toString()); //3
		list.append("x");
		System.out.println(list.size()+"; "+list.toString()); //4
		//Visualizing differences in behavior for stack and queue in one place
		//Further testing in individual mains
		Stack stack = new Stack();
		Queue queue = new Queue();
		stack.append("z");
		stack.push("y");
		stack.insert("a", 0);
		stack.push("x");
		System.out.println("Pushed (in this order), z,y,a,x");
		System.out.println("Stack: "+stack.toString());
		System.out.println("Stack pop: "+stack.pop());
		System.out.println("Stack: "+stack.toString());
		queue.append("z");
		queue.enqueue("y");
		queue.insert("a", 0);
		queue.enqueue("x");
		System.out.println("Enqueue (in this order), z,y,a,x");
		System.out.println("Queue: "+queue.toString());
		System.out.println("Queue dequeue: "+queue.dequeue());
		System.out.println("Queue: "+queue.toString());
	}    
}

          
