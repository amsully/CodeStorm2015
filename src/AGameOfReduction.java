import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AGameOfReduction {
	
	public HashSet<ArrayList<Integer>> powerSet;
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner scan = new Scanner(System.in);
		
		int trials = scan.nextInt();

		AGameOfReduction game = new AGameOfReduction();
		game.powerSet = new HashSet<ArrayList<Integer>>();
		
		for(int i = 0; i < trials; i++)
		{
			game.powerSet.clear();
			int set = scan.nextInt();
			int lisaSetSize = scan.nextInt();
			
			ArrayList<Integer> lisasSet = game.scanSet(lisaSetSize, scan);
			long ans = ( game.solveSize(set, lisasSet)% ((long)Math.pow(10, 9) +7) );
			
			if(set%2 == 0)
				System.out.println(2*ans);
			else
				System.out.println(2*ans - 1);
		}
		
	}

	public long solveSize(int set, ArrayList<Integer> lisasSet) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> bobsList = getBobsSet(set, lisasSet);

		long[] lisaOddEven = getOddsEvens(lisasSet);
		long[] bobOddEven  = getOddsEvens(bobsList);
		
		// EVEN EVEN
		if(lisasSet.size()%2 == 0 && (lisaOddEven[0] + lisaOddEven[1]) % 2 == 0)
		{
			return(getEvenSizeEvenLevels(bobOddEven[0], bobOddEven[1]));
		}
		// ODD EVEN
		else if(lisasSet.size()%2 == 0 && (lisaOddEven[0] + lisaOddEven[1]) % 2 == 0)
		{
			return(getOddSizeEvenLevels(bobOddEven[0], bobOddEven[1]));

		}
		// EVEN ODD
		else if(lisasSet.size()%2 == 0 && (lisaOddEven[0] + lisaOddEven[1]) % 2 == 1)
		{
			return(getEvenSizeOddLevels(bobOddEven[0], bobOddEven[1]));
		}
		// ODD ODD
		else //if(lisasSet.size()%2 == 1 && (lisaOddEven[0] + lisaOddEven[1]) % 2 == 1)
		{
			return(getOddSizeOddLevels(bobOddEven[0], bobOddEven[1]));
		}
	}



	private long getOddSizeOddLevels(long odd, long even) {
		// TODO Auto-generated method stub
		//System.out.println(odd + " " + even);
		long count = 0;
		for( int i = 1; i <= odd; i+=2 )
		{
			for(int j = 0; j <= even; j++ )
			{
				if( (j+i)%2 == 1 )
				{
					if(even == 0) return 0;
					long newTot = nChooseK(odd,i)*nChooseK(even,j);
					
//					System.out.println(i + " " + j + " " + nChooseK(odd, i) + " " + nChooseK(even, j));
					
					count += newTot;
				}
			}
		}
		
		return count;
	}



	private long getEvenSizeOddLevels(long odd, long even) {
		// TODO Auto-generated method stub
		long count = 0;
		for( int i = 1; i <= odd; i+=2 )
		{
			for(int j = 0; j <= even; j++ )
			{
				if( (j+i)%2 == 0 )
				{
					count += nChooseK(odd,i)*nChooseK(even,j);
				}
			}
		}
		
		return count;	
	}

	private long getOddSizeEvenLevels(long odd, long even) {
		// TODO Auto-generated method stub
		long count = 0;
		for( int i = 0; i <= odd; i+=2 )
		{
			for(int j = 0; j <= even; j++ )
			{
				if( (j+i)%2 == 1 )
				{
					count += nChooseK(odd,i)*nChooseK(even,j);
				}
			}
		}
		
		return count;	
	}

	//EVEN EVEN
	private long getEvenSizeEvenLevels(long odd, long even) {
		long count = 0;
		for( int i = 0; i <= odd; i+=2 )
		{
			for(int j = 0; j <= even; j++ )
			{
				if( (j+i)%2 == 0 )
				{
					count += nChooseK(odd,i)*nChooseK(even,j);
				}
			}
		}
		
		return count;	
	}
	private long nChooseK(long n, int k) {
		// TODO Auto-generated method stub
		
//		if(n == 0) return 0;
		
		return fact(n) / (fact(n-k)*fact(k));
	}
	private long fact(long odd) {
		// TODO Auto-generated method stub
		
		long start = 1;
		
		for(long i = odd; i > 0; i--)
		{
			start = start *i;
		}
		return start;
	}

	private long[] getOddsEvens(ArrayList<Integer> set) {
		// TODO Auto-generated method stub
		long[] arrays = new long[2];
		
		long odds = 0;
		long evens = 0;
		for(Integer val : set)
		{
				if(getSumHeight(val)%2 == 0 || val < 10)
					evens++;
				else
					odds++;
		
			
		}
		arrays[0] = odds;
		arrays[1] = evens;
		return arrays;
	}




	public long getSumHeight(Integer play) {
		// TODO Auto-generated method stub
		
		if(play < 10)
			return 0;
		
		return Integer.toString(play).length()-1;
		
	}
	private static ArrayList<Integer> getBobsSet(int set,
			ArrayList<Integer> lisasSet) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> bobsSet = new ArrayList<Integer>();
		
		for(int i = 1; i <= set; i++)
		{
			if(!lisasSet.contains(i))
			{
				bobsSet.add(i);
			}
		}
		
		return bobsSet;
	}

	private ArrayList<Integer> scanSet(int size, Scanner scan) {
		// TODO Auto-generated method stub
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++)
		{
			set.add( scan.nextInt() );
		}
		return set;
	}
	
}
