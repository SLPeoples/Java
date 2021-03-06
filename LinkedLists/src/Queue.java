/**
 * @author Samuel L. Peoples
 * Linked-list Queue class, inherited from List
 */
public class Queue extends List{
	/**
	 * Accomplishes the desired outcome of an enqueue
	 * Appends the object to the queue
	 * @param obj to be enqueued
	 */
	public void enqueue(Object obj){
		super.append(obj);
	}
	
	/**
	 * Removes the first head object, first object placed in linked list
	 * @return Object dequeued
	 */
	public Object dequeue(){
		try {
			if(super.size() == 0)
				throw new LinkedListException();
		} catch (LinkedListException e) {
			System.out.println("Cannot invoke dequeue() on an empty queue");
			System.exit(0);
		}
		return super.remove(0);
	}
	
	/**
	 * Overrides inherited inster, calls enqueue, discards index
	 * @param next, object to enqueue
	 * @param index, desired index, discarded
	 */
	@Override
	public void insert(Object next, int index){
		enqueue(next);
	}
	
	/**
	 * Overrides the inherited remove(), calls dequeue, discards desired index
	 * @param index, desired index, discarded
	 * @return Object dequeued
	 */
	@Override
	public Object remove(int index){
		return dequeue();
	}
	//I would not choose to override the isEmpty and indexOf methods because the
	//Program will behave the same way in a stack and a queue.
	/**
	 * main driver, tests methods
	 */
	public static void main(String args[]){
		Queue a = new Queue();
		a.enqueue("a");
		a.enqueue("b");
		System.out.println(a.toString());
		System.out.println("dequeued: " +a.dequeue());
		System.out.println(a.toString());
		System.out.println("dequeued: " +a.dequeue());
		System.out.println("the queue is empty: " +a.isEmpty());
		//System.out.println("popped: " +a.dequeue()); //Out of bounds
		a.insert("a", 1);
		a.insert("b", 2);
		a.insert("c", 1);
		a.insert("d", 2);
		System.out.println(a.toString());
		a.remove(3);
		System.out.println(a.toString());
		a.remove(1);
		System.out.println(a.toString());
		System.out.println("a is empty?: "+a.isEmpty());
		System.out.println("Inserting \"a\" at position 0");
		a.insert("a", 0);
		System.out.println("a is empty?: "+a.isEmpty());
		System.out.println("a: "+a.toString());
		//a.remove(0); //Works
		System.out.println("Inserting \"b\" at position 1");
		a.insert("b", 1);
		System.out.println("a is empty?: "+a.isEmpty());
		System.out.println("Inserting \"c\" at position 2");
		a.insert("c", 2);
		System.out.println("Inserting \"1\" at position 1");
		a.insert("1", 1);
		System.out.println("Inserting \"3\" at position 3");
		a.insert("3", 3);
		System.out.println("Inserting \"0\" at position 0");
		a.insert("0", 0);
		//a.insert("3", 77); //Out of bounds
		System.out.println("Index of 0: " +a.indexOf("0"));
		System.out.println("Index of a: " +a.indexOf("a"));
		System.out.println("Index of 1: " +a.indexOf("1"));
		System.out.println("Index of c: " +a.indexOf("c"));
		System.out.println("Index of z: " +a.indexOf("z"));

		System.out.println(a.size()+"; "+a.toString()); //6
		a.remove(0);
		System.out.println(a.size()+"; "+a.toString()); //5
		a.remove(1);
		System.out.println(a.size()+"; "+a.toString()); //4
		a.remove(2);
		System.out.println(a.size()+"; "+a.toString()); //3
		a.remove(2);
		System.out.println(a.size()+"; "+a.toString()); //2
		a.remove(0);
		System.out.println(a.size()+"; "+a.toString()); //1
		a.remove(0);
		System.out.println(a.size()+"; "+a.toString()); //0
		System.out.println("a is empty?: "+a.isEmpty());
		a.append("z");
		System.out.println(a.size()+"; "+a.toString()); //1
		a.append("y");
		System.out.println(a.size()+"; "+a.toString()); //2
		a.insert("a", 0);
		System.out.println(a.size()+"; "+a.toString()); //3
		a.append("x");
		System.out.println(a.size()+"; "+a.toString()); //4
	}
}
