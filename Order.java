package assignment;

import java.util.*;
/**
 * An order consists of the details of all the items that have been ordered, the number of items in the order, 
 * the staff who created the order, the table no of where customers were seated at, the discount which is to be given to the customer, and
 * the total amount of the order.
 * @author salonigupta
 *
 */
public class Order
{
	public OrderItem [] orderedItems;
	private int tableID;
	private int count;
	private float discount;
	private float total;
	private Date date;
	private String staff;
	/**
	 * Creates an empty object of class Order.
	 */
	public Order()
	{
		orderedItems=new OrderItem[100];
		for(int i=0;i<100;i++)
			orderedItems[i]=new OrderItem();
		date=new Date();
		tableID=-1;
		count=0;
		total=0;
		discount=0;
		staff=null;
	}
	/**
	 * Creates an object of class Order when the parameters are specified. 
	 * @param OrderItem[] order
	 * @param Date d
	 * @param int tableId
	 * @param int qty
	 * @param String staffName
	 * @param float disc
	 */
	public Order(OrderItem [] order, Date d, int tableId, int qty, String staffName, float disc)
	{
		orderedItems=order;
		date=d;
		tableID=tableId;
		count=qty;
		staff=staffName;
		discount=disc;
	}
	public OrderItem[] returnOrderItem()
	{
		return orderedItems;
	}
	/**
	 * Returns the date when an order was created at.
	 * @return date
	 */
	public Date returnDate()
	{
		return date;
	}
	/**
	 * Returns the table ID of an order.
	 * @return tableID
	 */
	public int returnTableID()
	{
		return tableID;
	}
	/**
	 * Returns the total amount of an order.
	 * @return total
	 */
	public float returnTotal()
	{
		return total;
	}
	/**
	 * Returns the total amount of an order, inclusive of taxes (7% GST and 10% service tax).
	 * @return (float)(total*1.17)
	 */
	public float returnTotalInclusiveOfTaxes()
	{
		return (float) (total*1.17);
	}
	/**
	 * Returns the total amount of an order, after a discount has been given. A discount is given if the customer is a member of the restaurant,
	 * and it depends on the tier as well. The higher the tier, the greater the discount.
	 * @return
	 */
	public float returnTotalAfterDiscount()
	{
		return total*(1-discount);
	}
	/**
	 * Returns the number of items placed in an order.
	 * @return
	 */
	public int returnCount()
	{
		return count;
	}
	/**
	 * Returns the name of the staff member who created an order.
	 * @return
	 */
	public String returnStaff()
	{
		return staff;
	}
	/**
	 * Returns the discount given to any customer. It is 0 % if the customer is not a member of the restaurant.
	 * @return
	 */
	public float returnDiscount()
	{
		return discount;
	}
	/**
	 * Sets the total amount of an order.
	 * @param orderTotal
	 */
	public void setTotal(float orderTotal)
	{
		total=orderTotal;
	}
	/**
	 * Sets the date of an order 
	 * @param date
	 */
	public void setDate(Date date) 
	{
		this.date = date;
	}
}
