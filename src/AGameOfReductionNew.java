import java.util.ArrayList;
import java.util.Scanner;


public class AGameOfReductionNew {
	
	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		int trials = scan.nextInt();
		
		for(int i = 0; i < trials; i++)
		{
			int n = scan.nextInt();
			int aliceSize = scan.nextInt();
			
			int[] even_odd_aliceEven_aliceOdd = getAll(n, scan, aliceSize);
			
//			ArrayList<Integer> alice = getAlice(scan, aliceSize);
//			int[] odd_even_aliceOdd_aliceEven = getOddEven(n,alice);
//			System.out.println(odd_even_aliceOdd_aliceEven[0] + " " + odd_even_aliceOdd_aliceEven[1] + " " +odd_even_aliceOdd_aliceEven[2] +" " + odd_even_aliceOdd_aliceEven[3]);
			int lvl = even_odd_aliceEven_aliceOdd[3];
			
			if( n < 10 )
				System.out.println(((long)Math.pow(2, even_odd_aliceEven_aliceOdd[0])-1)%((long)Math.pow(10, 9)+7));
			else
				System.out.println(solve(lvl%2, aliceSize%2, even_odd_aliceEven_aliceOdd[1], even_odd_aliceEven_aliceOdd[0])%((long)Math.pow(10, 9)+7));
		}
		
	}

	private static int[] getAll(int n, Scanner scan, long aliceSize) {
		// TODO Auto-generated method stub
		
		int[] allIndex = getAllIndex(n);
		
		for(int i = 0; i < aliceSize; i++)
		{
			
			int val = scan.nextInt();
			
			int valSize = Integer.toString(val).length();
			
			if(val < 10)
			{
				allIndex[0]--;
				allIndex[2]++;
			}
			else if(valSize %2 == 0)
			{
				allIndex[0]--;
				allIndex[2]++;
			}
			else
			{
				allIndex[1]--;
				allIndex[3]++;
			}
			
		}
		//System.out.println(allIndex[0] + " " + allIndex[1] + " " + allIndex[2] + " " + allIndex[3]);
		return allIndex;
	}

	public static int[] getAllIndex(int n) {
		// TODO Auto-generated method stub
		int[] allIndex = new int[4];
		
		for(int i = 1; i <= n; i++)
		{
			if(((Integer.toString(i).length()+1)%2) == 0)
			{
				allIndex[0]++;
			}
			else
				allIndex[1]++;
		}
		return allIndex;
		
	}

	private static long solve(int level, int size, int odds, int evens) {
		
		//System.out.println(level + " " + size + " "+evens+" "+odds);
		long count = 0;
		
		if(odds == 0 && level == 1) return 0;
		
		
		for(int i = 0; i <= odds; i++)
		{
			if(i%2 == level && i%2 == size && i >0 )
			{

					count += nChooseK(odds, i);
			}else if((i+1)%2 == level && (i+1)%2 == size)
			{
				count += nChooseK(odds, i);
			}
			
			
			for(int j = 0; j <= evens; j++)
			{
				if((i+j)%2 == size && i+j != 0)
				{
						count+= nChooseK(odds, i)*nChooseK(evens, j);
				}
			}
			
		}
		
		return count;
	}

	private static int[] getOddEven(long n, ArrayList<Integer> alice) {
		// TODO Auto-generated method stub
		int[] odd_even = new int[4];
		for(int i = 0; i < n; i ++)
		{
			
			if(!alice.contains(i))
			{
				if( Integer.toString(i).length() %2 == 0)
					odd_even[1]++;
				else
					odd_even[0]++;
			}else
			{
				if( Integer.toString(i).length() %2 == 0)
					odd_even[3]++;
				else
					odd_even[2]++;				
			}
			
		}
		return odd_even;
	
	}

	private static ArrayList<Integer> getAlice(Scanner scan, long aliceSize) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> alice = new ArrayList<Integer>();
		
		for(int i = 0; i < aliceSize; i++)
			alice.add(scan.nextInt());
		
		return alice;
	}
	
	private static long nChooseK(long n, int k) {
		// TODO Auto-generated method stub		
		return fact(n) / (fact(n-k)*fact(k));
	}
	private static long fact(long odd) {
		// TODO Auto-generated method stub
		
		long start = 1;
		
		for(long i = odd; i > 0; i--)
		{
			start = start *i;
		}
		return start;
	}
	
}
