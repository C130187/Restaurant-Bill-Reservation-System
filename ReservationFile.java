package assignment;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * 
 * @author shuvamnandi
 *
 */
public class ReservationFile extends Reservation
{
	Date date;
	protected static Scanner sc=new Scanner(System.in);
	protected static BufferedReader brStream=new BufferedReader(new InputStreamReader(System.in));
	protected SimpleDateFormat dateFormat1=new SimpleDateFormat("EEEE, MMMM dd, YYYY, hh:mm:ss a" );
	protected SimpleDateFormat dateFormat2=new SimpleDateFormat("hh:mm|a|dd/MM/YY");
	private boolean available;
	private int numOfReservation=0;
	private float DIS;
	protected Reservation [] data=new Reservation[100];
	public ReservationFile()
	{
		super();
		date=null;
		available=false;
	}
	public ReservationFile(String customerName, int table, int no, int capacity)
	{
		super(customerName, table, no, capacity);
		available=false;
	}
	public int returnTableID()
	{
		return tableID;
	}
	public int returnNumOfReservation()
	{
		return numOfReservation;
	}
	public Reservation[] returnReservationInfo()
	{
		return data;
	}
	public float returnDiscount()
	{
		return DIS;
	}
	public void setName(String customerName)
	{
		name=customerName;
	}
	public void setTableID(int table)
	{
		tableID=table;
	}
	public void setContactNo(int no)
	{
		contactNo=no;
	}
	public void setSize(int capacity)
	{
		size=capacity;
	}
	public void setAvailability()
	{
		available=true;
	}
	public void setDiscount(int tierNo)
	{
		DIS=(float)(tierNo*0.05);
	}
	public boolean addReservation(Date d) throws IOException
	{
		boolean found=false;
		Restaurant rest;
		dataTransferFromFile();
		boolean check[]=new boolean[returnNumOfReservation()];
		int tableNoRes[]=new int[returnNumOfReservation()];
		for(int i=0;i<returnNumOfReservation();i++)
			check[i]=false;
		do
		{	
			System.out.print("Enter a table size, from 2 to 10: ");
			size=sc.nextInt();
		}while(size<2||size>10);
		rest=returnRestaurantDetails();
		for(int i=0;i<returnNumOfReservation();i++)
		{
			if(!returnReservationInfo()[i].returnAvailiability())
			{
				tableNoRes[i]=returnReservationInfo()[i].returnTableID();
				rest.book(tableNoRes[i]);
				check[i]=true;
			}
		}
		System.out.println("A total of " + rest.checkAvailability(size) + " tables are available with capacity " + ((size+1)/2)*2);
		start=(((size+1)/2)*2-2)*2;
		end=start+3;
		System.out.println("Do you wish to make a booking?");
		char choice=sc.next().toUpperCase().charAt(0);
		int tableNo;
		if(choice=='Y')
		{
			System.out.print("Enter customer name: ");
			name=brStream.readLine();
			memF.readMemberData();
			memberList=memF.returnMember();
			for(int i=0;i<memF.returnNumOfMember();i++)
			{
				if(name.equalsIgnoreCase(memberList[i].getName()))
				{
					found=true;
					System.out.println("Member information found. Proceed to reserve a table.");
					contactNo=memberList[i].getContactNo();
					setDiscount(memberList[i].getTier());
					break;
				}
			}
			if(!found)
			{
				System.out.println("Customer is not a member.");
				System.out.print("Enter the contact no: ");
				contactNo=sc.nextInt();
			}
			System.out.print("Enter the table no: ");
			tableNo=sc.nextInt();
			do
			{
				if((tableNo-1)<start || (tableNo-1)>end)
				{
					System.out.print("Please enter the correct table no.: ");
					tableNo=sc.nextInt();
				}
			}while((tableNo-1)<start || (tableNo-1)>end);
			if(restaurant.book(tableNo))
			{
				System.out.println("Table no "+ tableNo+ " booked successfully.");
				date=d;
				setName(name);
				setTableID(tableNo);
				setContactNo(contactNo);
				setSize(size);
				dataTransferToFile();
			}
			else
				System.out.println("Table "+ tableNo +" is already booked! Please try again.");
		}
		else
			System.out.println("Thank You.");
		return found;
	}
	public void dataTransferToFile()
	{
		try
		{
			BufferedWriter bwStream=new BufferedWriter(new FileWriter("Reservation.txt", true));
			PrintWriter pwStream=new PrintWriter(bwStream);
			pwStream.print(dateFormat2.format(date)+"|"+name+"|"+tableID+"|"+contactNo+"|"+size+"|"+available);
			pwStream.println();
			pwStream.close();
		}
		catch(IOException e)
		{
			System.out.println("IO Error!\n"+ e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
	@SuppressWarnings({ "deprecation" })
	public void dataTransferFromFile()
	{
		numOfReservation = 0;
		String name, time, date, meridian;
		int table, no, size, day, month, year, hour, min;
		boolean exist;
		try
		{
			BufferedReader brStream = new BufferedReader(new FileReader("Reservation.txt"));
			String inputLine;
			inputLine = brStream.readLine(); 
		    for(int i=0;i<100;i++)
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
		    			no=Integer.parseInt(extract.nextToken());
		    			size=Integer.parseInt(extract.nextToken());
		    			exist=Boolean.parseBoolean(extract.nextToken());
		    			data[i]=new Reservation(name, table, no, size);
		    			if(hour!=12)
		    				if(meridian.equals("PM"))
		    					data[i].returnDate().setHours(hour+12);
		    				else
		    					data[i].returnDate().setHours(hour);
		    			else
		    				if(meridian.equals("PM"))
		    					data[i].returnDate().setHours(12);
		    				else
		    					data[i].returnDate().setHours(0);
		    			data[i].returnDate().setMinutes(min);	
		    			data[i].returnDate().setDate(day);
		    			data[i].returnDate().setMonth(month-1);
		    			data[i].returnDate().setYear(year);
		    			data[i].setAvailability(exist);
		    			i++;
		    			numOfReservation++;
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
	public void removeReservationRewrite()
	{
		try
		{
			BufferedWriter bwStream=new BufferedWriter(new FileWriter("Reservation.txt", true));
			PrintWriter pwStream=new PrintWriter(bwStream);
			for(int i=0;i<numOfReservation;i++)
			{
				date=new Date();
				pwStream.println(dateFormat2.format(date)+"|"+data[i].returnName()+"|"+data[i].returnTableID()+"|"+data[i].returnContactNo()+"|"+data[i].returnSize()+"|"+data[i].returnAvailiability());
			}
			pwStream.close();
		}
		catch(IOException e)
		{
			System.out.println("IO Error!\n"+ e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
	public void printData()
	{
		for(int i=0;i<numOfReservation;i++)
			System.out.println(dateFormat2.format(data[i].date) + "|" + data[i].name + "|" + data[i].tableID + "|" + data[i].contactNo + "|" + data[i].available);
	}
	
}
