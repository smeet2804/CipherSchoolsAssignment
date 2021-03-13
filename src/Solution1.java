import java.util.Scanner;


public class Solution1 {

	
	public static void print_pattern1(int n)
	{
	  for(int i=1;i<=n;i++)
	  {
		  for(int j=1;j<2*n;j++)
		  {
			  if(j>=6-i && j<=4+i)
			  {
				  if((i+j)%2!=0)
				  {
					  System.out.print(" ");
				  }
				  else
				  {
					  System.out.print("*");
				  }
			  }
			  else
				  System.out.print(" ");
		  }
		  System.out.println();
	  }
	  
	}
	
	public static void print_pattern2(int n)
	{
		char c='A';
		for(int i=1;i<=n;i++)
		  {
			  for(int j=1;j<=n;j++)
			  {
				  if(j<=n-i)
			    System.out.print(" ");
				  else
					  System.out.print(c++);
				  System.out.print(" ");
			  }
			  System.out.println();
		  }
	}
	
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	
	
	System.out.println("Enter n:");
	int n=scan.nextInt();
	
	print_pattern1(n);
	
	print_pattern2(n);
	}
	
	
}
