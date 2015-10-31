import java.util.Scanner;


public class EmmasNotbook {

	
	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		long seconds = scan.nextLong();
		
		long total = 0;
		for(long i = 2; i <= seconds+1; i++)
		{
			if(i%2 == 0)
				total = total + i/2;
			else
				total = total + i/2+1;
			
		}
		System.out.println(total);
	}
}
