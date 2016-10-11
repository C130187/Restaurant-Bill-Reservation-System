package assignment;

/**
 * Contains the details of the restaurant, i.e. the number of tables.
 * Checks whether tables empty or not, when the number of seats is specified.
 * Books a specific table, depending on the table no.
 * @author yusufraza
 *
 */
public class Restaurant
{
	/**
	 * A restaurant has a fixed number of tables. This restaurant is set to have 20 seats.
	 */
	private int numOfTable=20;
	Table [] table=new Table[numOfTable];
	/**
	 * Generates 20 objects of class Table; 4 have 2 seats, 4 have 4 seats, 4 have 6 seats, 4 have 8 seats and 4 have 10 seats.
	 */
	Restaurant()
	{
		for(int i=0;i<20;i++)
		{
			if(i<4)
				table[i]=new Table(2);
			else if(i<8)
				table[i]=new Table(4);
			else if(i<12)
				table[i]=new Table(6);
			else if(i<16)
				table[i]=new Table(8);
			else
				table[i]=new Table(10);
		}
	}
	/**
	 * Returns the number of tables in the restaurant
	 * @return numOfTable
	 */
	public int returnNumOfTable()
	{
		return numOfTable;
	}
	/**
	 * Checks whether tables are available, given a specific table size, and returns the number of seats available.
	 * @param tableCapacity
	 * @return numAvailable
	 */
	public int checkAvailability(int tableCapacity)
	{
		int start=(((tableCapacity+1)/2)*2-2)*2;
		int end=start+3;
		int numAvailable=0;
		for(int i=start;i<=end;i++)
		{
			if(table[i].getAvailability())
			{
				System.out.println("Table "+(i+1)+" is available.");
				numAvailable++;
			}
		}
		return numAvailable;
	}
	/**
	 * Books an empty table when the table no is known. 
	 * @param tableNo
	 * @return true/false
	 * Returns true if table is booked successfully, otherwise false.
	 */
	public boolean book(int tableNo)
	{
		if(table[tableNo-1].getAvailability())
		{
			table[tableNo-1].setAvailability();
			return true;
		}
		else
			return false;
	}
	/**
	 * Sets the availability of a specific table, when the table no is known.
	 * @param tableNo
	 */
	public void free(int tableNo)
	{
		table[tableNo-1].giveAvailability();
	}
}
