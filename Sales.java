package assignment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Generates the sales report by reading the order information stored in the text file.
 * @author shuvamnandi
 *
 */
public class Sales 
{
	private int numOfOrder=0;
	private Order order[]=new Order[1000];
	protected SimpleDateFormat dateFormat2=new SimpleDateFormat("hh:mm|a|dd/MM/YY");
	public int returnNumOfOrder()
	{
		return numOfOrder;
	}
	public Order[] returnOrderData()
	{
		return order;
	}
	@SuppressWarnings({ "deprecation" })
	public void dataTransferFromFile()
	{
		numOfOrder = 0;
		String inputLine, name, time, date, meridian, orderDetails, orderName;
		int table, size, day, month, year, hour, min, count;
		float total, orderPrice;
		boolean exist;
		try
		{
			BufferedReader brStream = new BufferedReader(new FileReader("Order.txt"));
			inputLine = brStream.readLine(); 
		    for(int i=0;i<1000;i++)
		    {
		    	while(inputLine!=null)
		    	{
		    		if(!inputLine.equalsIgnoreCase(""))
		    		{
		    			StringTokenizer extract=new StringTokenizer(inputLine, "|");
		    			time=extract.nextToken();
		    			StringTokenizer extractTime=new StringTokenizer(time, ":");
		    			hour=Integer.parseInt(extractTime.nextToken());
		    			min=Integer.parseInt(extractTime.nextToken());
		    			meridian=extract.nextToken();
		    			date=extract.nextToken();
		    			StringTokenizer extractDate=new StringTokenizer(date, "/");
		    			day=Integer.parseInt(extractDate.nextToken());
		    			month=Integer.parseInt(extractDate.nextToken());
		    			year=Integer.parseInt(extractDate.nextToken());
		    			name=extract.nextToken();
		    			table=Integer.parseInt(extract.nextToken());
		    			count=Integer.parseInt(extract.nextToken());
		    			orderDetails=extract.nextToken();
		    			StringTokenizer extractOrder=new StringTokenizer(orderDetails, "-");
		    			int j=0;
		    			order[i]=new Order();
		    			while(j<count)
		    			{	
		    				orderName=extractOrder.nextToken();
		    				orderPrice=Float.parseFloat(extractOrder.nextToken());
		    				order[i].returnOrderItem()[j].setName(orderName);
		    				order[i].returnOrderItem()[j].setPrice(orderPrice);
		    				j++;
		    			}
		    			total=Float.parseFloat(extract.nextToken());
		    			if(hour!=12)
		    				if(meridian.equals("PM"))
		    					order[i].returnDate().setHours(hour+12);
		    				else
		    					order[i].returnDate().setHours(hour);
		    			else
		    				if(meridian.equals("PM"))
		    					order[i].returnDate().setHours(12);
		    				else
		    					order[i].returnDate().setHours(0);
		    			order[i].returnDate().setMinutes(min);	
		    			order[i].returnDate().setDate(day);
		    			order[i].returnDate().setMonth(month-1);
		    			order[i].returnDate().setYear(year);
		    			order[i]=new Order(order[i].returnOrderItem(), order[i].returnDate(), table, count, null, 0);
		    			order[i].setTotal(total);
		    			i++;
		    			numOfOrder++;
		    		}
		    		inputLine = brStream.readLine(); 
		    	}
		    }
		    brStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println( "Error opening the input file!\n" + e.getMessage());
			System.exit(0);	
		}
		catch (IOException e)
		{
			System.out.println( "IO Error!\n" + e.getMessage() );
			e.printStackTrace();
			System.exit(0);
	    }
	}
	public void printOrderData()
	{
		for(int i=0;i<numOfOrder;i++)
			System.out.println(dateFormat2.format(order[i].returnDate()) + "|" +  order[i].returnTableID() + "|" + order[i].returnTotal());
	}
	
}
