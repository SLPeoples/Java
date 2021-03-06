/**
 * @author Samuel L. Peoples
 * Linked-list Stack class, inherited from List
 */
public class Stack extends List{
	/**
	 * Accomplishes the desired outcome of a push, appends the
	 * parameter object to the stack
	 * @param obj, object to be appended
	 */
	public void push(Object obj){
		super.insert(obj,0);
	}
	
	/**
	 * Accomplishes the desired outcome of a pop, removes the last 
	 * element placed in the stack 
	 * @return object popped
	 */
	public Object pop(){
			try {
				if(super.size() == 0)
					throw new LinkedListException();
			} catch (LinkedListException e) {
				System.out.println("Cannot invoke pop() on an empty stack");
				System.exit(0);
			}
		return super.remove(0);
	}
	
	/**
	 * Overrides inherited inster, calls push, discards index
	 * @param next, object to push
	 * @param index, desired index, discarded
	 */
	@Override
	public void insert(Object next, int index){
		push(next);
	}
	
	/**
	 * Overrides inherited append, calls push
	 * @param next, object to push
	 */
	@Override
	public void append(Object next){
		push(next);
	}
	
	/**
	 * Overrides the inherited remove(), calls pop, discards desired index
	 * @param index, desired index, discarded
	 * @return Object popped
	 */
	@Override
	public Object remove(int index){
		return pop();
	}
	
	//I would not choose to override the isEmpty and indexOf methods because the
	//Program will behave the same way in a stack and a queue.
	/**
	 * main driver, tests methods
	 */
	public static void main(String args[]){
		Stack a = new Stack();
		a.push("a");
		a.push("b");
		System.out.println(a.toString());
		System.out.println("popped: " +a.pop());
		System.out.println(a.toString());
		System.out.println("popped: " +a.pop());
		System.out.println("the stack is empty: " +a.isEmpty());
		//System.out.println("popped: " +a.pop()); //Out of bounds
		a.insert("a", 1);
		a.insert("b", 2);
		a.insert("c", 1);
		a.insert("d", 2);
		System.out.println(a.toString());
		a.remove(3);
		System.out.println(a.toString());
		a.remove(1);
		System.out.println(a.toString());
		a.append("z");
		a.append("y");
		a.append("x");
		a.append("w");
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
