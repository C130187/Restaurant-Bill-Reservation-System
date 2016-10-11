package assignment;

/**
 * An interface which provides the basic structure for a menu item.
 * Five different classes are inherited from this interface, namely Dessert, Drink, MainCourse, SetPackage, and Menu Item.
 * Contains the functions to be used in the base classes.
 * @author neethumohanan
 * 
 */
public interface MenuItem
{
	/**
	 * Returns the name of a menu item in the base class.
	 * @return name
	 */
	public String getName();
	/**
	 * Returns the description of a menu item in the base class.
	 * @return description
	 */
	public String getDescription();
	/**
	 * Returns the variable that states whether a menu item exists in the menu or not.
	 * This helps during removing an existing menu item from the menu.
	 * @return exist
	 */
	public boolean ifExists();
	/**
	 * Returns the price of a menu item in the base class.
	 * @return price
	 */
	public float getPrice(); 
	/**
	 * Sets the name of a menu item, as specified by the parameter.
	 * @param name
	 */
	public void setName(String name);
	/**
	 * Sets the description of a menu item, as specified by the parameter.
	 * @param description
	 */
	public void setDescription(String description);
	/**
	 * Sets the exist variable, to suggest whether the menu item exists in the menu or not.
	 * @param e
	 */
	public void setExists(boolean e);
	/**
	 * Sets the price of a menu item, as specified by the parameter.
	 * @param price
	 */
	public void setPrice(float price); 
}
