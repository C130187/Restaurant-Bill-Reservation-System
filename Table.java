package assignment;

/**
 * A table has a fixed number of seats in the restaurant.
 * Depending on whether it has been booked or not, availability will be assigned true or false.
 * @author yusufraza
 *
 */
public class Table
{
	private int numSeats;
	private boolean availability;
	/**
	 * Assigns a fixed number of seats to the object variable numSeats.
	 * @param noOfSeats
	 * By default, availability is true.
	 */
	Table(int noOfSeats)
	{
		numSeats=noOfSeats;
		availability=true;
	}
	/**
	 * Returns the number of seats in a table.
	 * @return numSeats 
	 */
	public int getNumSeats()
	{
		return numSeats;
	}
	/**
	 * Returns the boolean variable stating whether a table is booked or not.
	 * @return availability
	 */
	public boolean getAvailability()
	{
		return availability;
	}
	/**
	 * setAvailiability() sets the table as reserved. It can not be used for future reservations, unless 
	 * released from the booking.
	 */
	public void setAvailability()
	{
		availability=false;
	}
	/**
	 * giveAvailiability() allows the table be free again for future reservations.
	 */
	public void giveAvailability()
	{
		availability=true;
	}
}
