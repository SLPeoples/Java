import java.util.*;

/* CSSSKL 162
 * 
 * UsingStacksSuitorsLab
 * 
 * This class is mostly a driver for playing with Strings as palindromes, 
 * both iteratively and recursively.  The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 * 
 * @author Samuel L. Peoples, 1527650
 */

public class UsingStacksSuitorsLab implements Runnable {
	private static int threadCount = 0;
	private String name;
	
	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + " Thread";
	}
	
	public static void main(String[] args) {
		String s1 = "food";		    //not a palindrome
		String s2 = "racecar";      //a palindrome
			
		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");
		
		System.out.println(s1 + " reversed is: ");
		printReverse(s1);
		System.out.println(s2 + " reversed is: ");
		printReverse(s2);
		
		System.out.println();
	    recPrintReverse(s1);
		System.out.println();
		recPrintReverse(s2);
		System.out.println();
		
		System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));
		
		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));	
		
		//System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());
		
		int n = 6;
		System.out.println("For " + n + " suitors, stand in place: " + findPlaceToStand(n));
		
		n = 10;
		System.out.println("For " + n + " suitors, stand in place: " + findPlaceToStand(n));
	}
		
	
	
	
	/**
	 * print reverse with a linked list
	 * @param target to print
	 */
	public static void printReverse(String target) {
		LLStack a = new LLStack();
		for(int i = 0; i < target.length(); i++){
			a.push(target.charAt(i));
		}
		while(a.isEmpty() == false){
			System.out.print(a.getHead().toString());
			a.pop();
		}
	}
	
	/**
	 * recursive reverse printing
	 * @param target toprint
	 */
	public static void recPrintReverse(String target) {
		if(target.length() == 1)
			System.out.print(target.charAt(0));
		else{
			System.out.print(target.charAt(target.length()-1));
			recPrintReverse(target.substring(0, target.length()-1));
		}
	}
	
	/**
	 * uses a linked list to determine if a string is a palindrome
	 * @param input, string to test
	 * @return true if palindrome
	 */
	public static boolean isPalindrome(String input) {
		LLStack a = new LLStack();
		for(int i = 0; i < input.length(); i++){
			a.push(input.charAt(i));
		}
		String compare = "";
		while(a.getHead() != null){
			compare+=a.getHead();
			a.pop();
		}
		if(compare.equals(input))
			return true;
		else return false;
	}

	/**
	 * recursive palindrome
	 * @param sentence, string to test
	 * @return true if palindrome
	 */
	public static boolean isPalindromeRec(String sentence)	{
	  	boolean ret = false;
		if(sentence.length() == 0  || sentence.length() == 1)
	  		return true;
	  	else{
	  		if(sentence.charAt(0) == sentence.charAt(sentence.length()-1))
	  				ret = isPalindromeRec(sentence.substring(1, sentence.length()-1));
	  	}
	  	return ret;
	  	
	}
	
	/**
	 * Uses a queue to find the proper suitor. Removes every third suitor
	 * @param numSuitors, number of suitors
	 * @return best suitor
	 */
	public static int findPlaceToStand(int numSuitors) {
		LLQueue suitors = new LLQueue();
		int i = 1;
		while(i <=numSuitors){
			suitors.enqueue(i);
			i++;
		}
		while(suitors.getHead() != suitors.getRear()){
			suitors.enqueue(suitors.getHead());
			suitors.dequeue();
			suitors.enqueue(suitors.getHead());
			suitors.dequeue();
			suitors.dequeue();
		}
		return (int) suitors.getHead();
		
	}	
	
	/**
	 * This function behaves poorly and does not compile.
	 * @param numSuitors, integer of suitors
	 * @return best suitor
	 */
	public static int findPlaceToStandStack(int numSuitors) {
		Stack<Integer> suitors = new Stack<Integer>();
		int i = 1;
		while(i <=numSuitors){
			suitors.push(i);
			i++;
		}
		while(suitors.size() > 1){
			Stack<Integer> suitors2 = new Stack<Integer>();
			suitors = reverse(suitors);
			suitors2.push(suitors.pop());
			suitors2.push(suitors.pop());
			suitors.pop();
			while(suitors.isEmpty() == false)
				suitors2.push(suitors.pop());
			suitors = reverse(suitors2);
		}
		return (int) suitors.firstElement();
	}	
	/**
	 * reverses a stack
	 * @param input, stack of integers
	 * @return reversed stack
	 */
	public static Stack<Integer> reverse(Stack<Integer> input){
		Stack<Integer> retVal = new Stack<Integer>();
		while(input.isEmpty()==false){
			retVal.push(input.pop());
		}
		return retVal;
	}


	/**
	 * BuildThreadQueue, populates linkedlist with thread
	 * @return true if success
	 */
	public static boolean buildThreadQueue() {	//returns true upon success
		//Queue<Thread> q = new LinkedList<Thread>(); //comment this out and use your own Queue
		LLQueue q = new LLQueue();
		//when our program starts up, it might create multiple threads to use
		q.enqueue( new Thread(new UsingStacksSuitorsLab()));
		
		
		System.out.println("Initial Thread order:");
		q.toString();  
		
		//We need to iterate over our pool of threads and call start() on each one
		//Make a loop that dequeues a thread, calls start on it, and enqueues it again
		//for(?) {
		
		Thread current = (Thread) q.getHead();
		q.dequeue();
		current.start();
		q.enqueue(current);
		/*	current = get a thread
			current.start();
			put the thread back
		}*/
		System.out.println("Thread order after start()ing:");
		q.toString();  
		
		return true;  //on successful start
	}
	
	
	/*
	 * No need to edit anything below here, 
	 * unless you'd like to change the 
	 * behaviour of each thread in the thread pool above
	 */
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				//do nothing here
			}
		}
	}
}
