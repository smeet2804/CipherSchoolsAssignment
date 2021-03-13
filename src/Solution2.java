import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Grocery{
	
	int price;
	float quantity;
	
}
public class Solution2 {
	
	public static void display(int budget,HashMap hm)
	{
		Iterator<Map.Entry<String, Grocery>> itr = hm.entrySet().iterator(); 
        while(itr.hasNext()) 
        { 
             Entry<String, Grocery> entry = itr.next(); 
             Grocery g=entry.getValue();	
             if(g.price<budget)
            	 System.out.println("Amount left can buy you: "+entry.getKey());
        } 
        System.out.println("GROCERY LIST is: ");
        System.out.println("Product Name ---- Quantity	---- Price ");
        itr = hm.entrySet().iterator(); 
        while(itr.hasNext()) 
        { 
             Entry<String, Grocery> entry = itr.next(); 
             Grocery g=entry.getValue();	
             System.out.println(entry.getKey()+" ---- "+g.quantity+" ---- "+g.price); 
        } 
		
	}
	
	public static void main(String[] args) throws IOException
	{

		HashMap<String,Grocery> hm=new HashMap<String,Grocery>();
		String prod="";
		
		int ch=0,budget=0,price=0,old_price;
		float quant=0;
		Scanner scan=new Scanner(System.in);
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		System.out.println("Enter Your Budget: ");
		 budget=scan.nextInt();  
		while(true)
		{
		 	System.out.println("1. Add an item");
		 	System.out.println("2. Exit");
		 	System.out.println("Enter your choice: ");
		 	ch=scan.nextInt();
		 	  if(ch==1)
		 	  {

				 	System.out.println("Enter Product: ");
				 	prod=input.readLine();
				 	
				 	System.out.println("Enter Quantity in (KG): ");
				 	quant=scan.nextFloat();
				 	System.out.println("Enter Price: ");
				 	price=scan.nextInt();
					if(hm.containsKey(prod))
				 	{
						Grocery g=new Grocery();
				 		g=hm.get(prod);
				 		old_price=g.price;
				         g.price=price;
				         g.quantity=quant;

				 		
				 		if(budget+old_price-price<0)
				 		{
				 			System.out.println("Can't Buy the product ###(because budget left is "+budget+")");
				 		}
				 		else
				 		{
				 		 hm.put(prod,g);
				 		budget=budget+old_price-price;
				 		System.out.println("Amount left: "+budget);
				 		}
				 	}
				 	else
				 	{
				 	
				 		Grocery g=new Grocery();
				 		g.price=price;
				         g.quantity=quant;
				 		
				 		
				 		if(budget-price<0)
				 		{
				 			System.out.println("Can't Buy the product ###(because budget left is "+budget+")");
				 		}
				 		else
				 		{
				 		 hm.put(prod,g);
				 		budget=budget-price;
				 		System.out.println("Amount left: "+budget);
				 		}
				 	}
		 	  }
		 	  else if(ch==2)
		 	  {
		 		  break;
		 	  }
		 	  else
		 	  {
		 		  System.out.println("Please Select Valid Choice");
		 	  }
		}
		display(budget,hm);
	}
	
}
