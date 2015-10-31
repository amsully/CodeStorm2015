import java.util.ArrayList;
import java.util.Scanner;


public class SaveQuantumLand {

	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		int trials = scan.nextInt();
		
		for(int i = 0; i < trials; i++)
		{
			
			long cities = scan.nextLong();
			ArrayList<Integer> vals = new ArrayList<Integer>();
			for(long j = 0; j < cities; j++)
			{
				vals.add(scan.nextInt());
			}
			System.out.println(solve(cities, vals));
			
		}
		
	}

	private static long solve(long nextInt, ArrayList<Integer> vals) {
		// TODO Auto-generated method stub
		long totalGuards = 0;
		long newGuards = 0;

		int curr = -1;
		int prev = -2;
		
		for(int i = 0; i < vals.size(); i++)
		{
			curr = vals.get(i);
			
			if(curr == 0)
			{
				newGuards++;
			}
			else
			{
				totalGuards = totalGuards + getGuards(newGuards);
				newGuards = 0;
			}
			
			prev = curr;
		}
		
		return totalGuards + getGuards(newGuards);
	}
	
	public static long getGuards(long newGuards)
	{
		return (newGuards/2);
	}
	
}
