package assignment;
import java.util.*;

/**
 * 
 * @author salonigupta
 *
 */
public class Reservation 
{
	protected Restaurant restaurant=new Restaurant();
	protected int size;
	protected int start;
	protected int end;
	protected int contactNo;
	protected int tableID;
	protected Date date=new Date();
	protected String name;
	protected boolean available;
	protected Member[] memberList=new Member[100];
	protected MemberFile memF=new MemberFile();
	protected long d;
	public Reservation()
	{
		date=null;
		name=null;
		tableID=0;
		contactNo=0;
		size=0;
		available=false;
	}
	public Reservation(String customerName, int table, int no, int capacity)
	{
		date=new Date();
		name=customerName;
		tableID=table;
		contactNo=no;
		size=capacity;
		available=false;
	}
	public Date returnDate()
	{
		return date;
	}
	public int returnSize()
	{
		return size;
	}
	public String returnName()
	{
		return name;
	}
	public int returnTableID()
	{
		return tableID;
	}
	public int returnContactNo()
	{
		return contactNo;
	}
	public Restaurant returnRestaurantDetails()
	{
		return restaurant;
	}
	public boolean returnAvailiability()
	{
		return available;
	}
	public void setDate(Date date)
	{
		this.date=date;
	}
	public void setAvailability(boolean avail)
	{
		available=avail;
	}
}

