import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Ilia {

	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		int numberOfSticks = scan.nextInt();
		
		ArrayList<Integer> stickValues = new ArrayList<Integer>();
		
		for(int i = 0; i < numberOfSticks; i++)
		{
			
			stickValues.add(scan.nextInt());
			
		}
		
		System.out.println( solve(numberOfSticks, stickValues) );
		
	}
	
	public static String solve(int numberOfSticks, ArrayList<Integer> stickValues)
	{
		
		int acute = 0;
		int obtuse = 0;
		int right = 0;
		
		for(int i = 0; i < numberOfSticks; i++)
		{
			int firstVal = stickValues.get(i);
			
			for(int j = i; j < numberOfSticks; j++)
			{
				if(j == i) continue;
				
				int secondVal = stickValues.get(j);
				
				
				for(int k = j; k < numberOfSticks; k++)
				{
					if(k == j || k ==i ) continue;
					
					int thirdVal = stickValues.get(k);
					
					Integer isRightVal = isRight(firstVal, secondVal, thirdVal);
					if( !(isRightVal == Integer.MIN_VALUE) )
					{
						
						if( isRightVal > 0 )
							acute++;
						if( isRightVal < 0 )
							obtuse++;
						if( isRightVal == 0 )
							right++;
					}
				}
				
				
			}
			
			
		}
		
		return acute + " "+ right + " " + obtuse;
	}

	public static Integer isRight(int firstVal, int secondVal, int thirdVal) {
		// TODO Auto-generated method stub
		
		if(firstVal + secondVal <= thirdVal)
		{
			return Integer.MIN_VALUE;
		}
		
		ArrayList<Integer> sort = new ArrayList<Integer>();
		sort.add(firstVal);
		sort.add(secondVal);
		sort.add(thirdVal);
		Collections.sort(sort);
		
//		System.out.println(firstVal + " " + secondVal + " " + thirdVal);
		
		return ((sort.get(0)*sort.get(0))+(sort.get(1)*sort.get(1))) - (sort.get(2)*sort.get(2));
	}


	
}
