package assignment;

/**
 * Contains the details of a set package item in the menu, namely name, description, 
 * price and exist (a variable which tells whether the particular item exists in the menu or not). 
 * A set package consists of a variety of a la carte items, as described by the description variable.
 * @author neethumohanan
 *
 */
public class SetPackage implements MenuItem
{
	private String name;
	private boolean exist;
	private float price;
	private String description;
	public SetPackage()
	{
		name="";
		exist=false;
		price=0;
		description="";
	}
	public SetPackage(String name, String description, boolean exist, float price)
	{
		this.name=name;
		this.description=description;
		this.exist=exist;
		this.price=price;
	}
	public String getName() 
	{
		return name;
	}
	public String getDescription() 
	{
		return description;
	}	
	public boolean ifExists() 
	{
		return exist;
	}
	public float getPrice() 
	{
		return price;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public void setExists(boolean e)
	{
		exist=e;
	}
	public void setPrice(float price)
	{
		this.price=price;
	}
}
