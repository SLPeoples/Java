/**
 * This class will use Nodes to form a linked list. It implements the LIFO
 * (Last In First Out) methodology to reverse the input string.
 * @author Samuel L. Peoples, 1527650
 **/

  public class LLStack {
      
      private Node head;
      private int count;
      
      // Constructor with no parameters for outer class
      public LLStack( ) {
    	  head = new Node();
      }
      
      // This is an inner class specifically utilized for LLStack class,
      // thus no setter or getters are needed
      private class Node  {
         private Object data;
         private Node next;
         
         // Constructor with no parameters for inner class
         public Node(){
            data = null;
            next = null;
         }
        // Parametrized constructor for inner class
         public Node(Object d, Node n){
 			data = d; //shallow
 			next = n;
 		}
      }
      
       // Adds a node as the first node element at the start of the list with the specified data.
       public void push(Object itemData) {
    	   head.next = new Node(head.data, head.next);
    	   head.data = itemData;
    	   count++;
       }
       
       // Removes the head node and returns true if the list contains at
       // least one node. Returns false if the list is empty.
       public boolean pop( ) {
         try{
        	 head = head.next;
         }
         catch(NullPointerException e){ //Catches rare errors
        	 return false;
         }
         count--;
         if(head == null)
        	 return false;
         else return true;
       }
      
      // Returns the size of linked list by traversing the list
      public int size( ) {
    	  return count;
      }
    
      // Finds if there is match for the given object
      public boolean contains(Object item) {
    	  Node itemFound = findData(item);
    	  if(itemFound == null)
    		  return false;
    	  else return true;
      }
      
      // Finds the first node containing the target item, and returns a
      // reference to that node. Return null if target not found.
      private Node findData(Object target) {
          Node current = head;
          Object itemAtPosition;
          while (current.data != null) {
              itemAtPosition = current.data;
              
              if (itemAtPosition.equals(target))
                return current;
              current = current.next;
            }
            return null;            // Target not found!
      }
    
      
      /**
     * prints the list character by character
     */
    public void outputList( ) {
          Node current = head;
          while (current.data != null) {
              System.out.println(current.data);
              current = current.next;
          }
      }
      
      /*
       * Overwrites the native toString
       * returns a concantenated string of values from nodes
     */
    public String toString() {
          String retValue = "";
          Node current = head;
          
          while(current.data != null) {
              retValue += current.data.toString() + " ";
              current = current.next;
          }
          return retValue;
      }
  
      
      /**
     * @return true if there are no more elements
     */
    public boolean isEmpty( ) {
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
     * Clears the linked lists
     */
    public void clear( ) {
          while(count != 0)
        	  pop();
      }
      // For two lists to be equal they must contain the same data items in
      // the same order. The equals method of T is used to compare data items.
      public boolean equals(Object otherObject) {
          if (otherObject == null)
            return false;
          
          else if(!(otherObject instanceof LLStack))
            return false;
            
          else {
              LLStack otherList = (LLStack)otherObject;
              if (size( )!= otherList.size( ))
                return false;
              Node position = head;
              Node otherPosition = otherList.head;
              while (position.data != null) {
                  if (!(position.data.equals(otherPosition.data)))
                    return false;
                    position = position.next;
                    otherPosition = otherPosition.next;
              }
              return true;      // objects are the same
            }
      }
      
      /**
     * @return this head's data
     */
    public Object getHead(){
    	  return head.data;
      }
        // There is no need to modify the driver
        public static void main(String[] args) {
            
            // input data for testing
            String target = "Somethings!";
            String palindrome = "a man a plan canal panama";
            
            LLStack list = new LLStack( );
            // objects to be added to list
            Object object1 = (Character) target.charAt(4);
            Object object2 = (Character) target.charAt(1);
            Object object3 = (Character) target.charAt(2);
            Object object4 = (Character) target.charAt(9);
            Object object20 = (Character) target.charAt(6);  // will not be added to list
            
            // add 4 objects to our linked list
            list.push(object1);
            list.push(object2);
            list.push(object3);
            list.push(object4);
            
            // make sure all are added
            System.out.println("My list has " + list.size( ) + " nodes.");
            // display the newly created list
            list.outputList( );
            System.out.println("toString = " + list.toString());
            
            // test findData() here
            Node itemFound = list.findData(object1); 
            System.out.println("Item found: " + itemFound.data);
            
            // Test contains() here
            if (list.contains(object1))
                System.out.println("Object1 found.");
            else
                System.out.println("There is NO object1.");
                
            if (list.contains(object20))
                System.out.println("Object20 found.");
            else
                System.out.println("There is NO object20.");
                
            // Creating a new linked list by iteration using different input   
            LLStack linkedList = new LLStack();
          
            for(int i = 0; i < palindrome.length(); i++) {
              Object object = (Character) palindrome.charAt(i);
              linkedList.push(object);
            }
            // Display your list now
            linkedList.outputList();
             
            // More tests; size() and is Empty()
            System.out.println("This time my list has " + linkedList.size( ) + " nodes.");
            System.out.println("Is our linkedList empty? " + linkedList.isEmpty());
              
            // Creating an Object of different class to compare with Character class
            Object mismatchObject = (Integer) Character.getNumericValue(target.charAt(0));
            
            boolean areEqual = linkedList.equals(mismatchObject);
            System.out.println("Are the 2 objects equal? " + areEqual);
              
            boolean areEqualAgain = linkedList.equals(linkedList);
            System.out.println("Are the 2 objects equal? " + areEqualAgain);
             
           // test pop()   
           list.pop( );
           if (list.contains(object4))
               System.out.println("Object4 found.");
           else
               System.out.println("Object4 has been deleted!");
           while (list.pop( )){            //Empty loop body
	           System.out.println("Start of list:");
	           list.outputList( );
	           System.out.println("End of list.");
           }
                
                    
           System.out.println("In the begining linkedList has " + linkedList.size() + " nodes");
           linkedList.clear();
          
           System.out.println("After testing clear(), linkedList has " + linkedList.size() + " nodes");
        }
            
     }

          
