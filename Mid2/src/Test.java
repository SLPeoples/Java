
public class Test {
	public static void main(String args[]){
		writeSquares(5);
		System.out.println();
		writeSquares(1);
		System.out.println();
		writeSquares(8);
		System.out.println();
		
		System.out.println(mystery1(4,19)); //1
		System.out.println(mystery1(32,56)); //8
		System.out.println(mystery1(12,20)); //4
		System.out.println(mystery1(4,18)); //2
		System.out.println(mystery1(48,128)); //16
		int[] numbers = {-1,3,5,8,15,18,22, 39,40,42,50,57,71,73,74};
		for(int number:numbers)
			System.out.print(number+", ");
		System.out.println();
		for(int number:exchange(numbers, 4, 6))
			System.out.print(number+", ");
	}
	private static int[] exchange(int[] numbers, int i, int j) {
		int[] store = numbers;
		int[] re = new int[numbers.length];
		if(i<j){
			for(int x = 0; x<i;x++)
				re[x] = numbers[x];
			re[i] = numbers[j];
			for(int x = i+1; x<j; x++)
				re[x] = numbers[x];
			re[j] = numbers[i];
			for(int x = j+1; x<numbers.length; x++)
				re[x] = numbers[x];
			return re;
		}
		else{
			for(int x = 0; x<j;x++)
				re[x] = numbers[x];
			re[j] = numbers[i];
			for(int x = j+1; x<i; x++)
				re[x] = numbers[x];
			re[i] = numbers[j];
			for(int x = i+1; x<numbers.length; x++)
				re[x] = numbers[x];
			return re;
		}
		
	}
	private static int mystery1(int x, int y) {
		if(x%2==1||y%2==1){
			return 1;
		}
		else{
			return 2*mystery1(x/2,y/2);
		}
		
	}
	public static void writeSquares(int n){
		int store;
		//Check if n is even or odd
		if(n%2==1)
			store = (n-1);
		else
			store = n;
		//If n is 1, just print 1
		if(n==1){
			System.out.print(n);
			n-=1;
		}
		//Print odd squares descending
		while(n>0){
			if(n*n%2 == 1)
				System.out.print(n*n+", ");
			n-=1;
		}
		
		n+=1;
		//Print even squares ascending
		while(n<= store){
			if(n == store){
				System.out.print(n*n);
				break;
			}
			if((n*n)%2==0)
				System.out.print(n*n+", ");
			n+=1;
		}	
	}
	
}