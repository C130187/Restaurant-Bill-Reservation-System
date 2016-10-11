package assignment;

/**
 * Contains the details of an employee or staff working in the restaurant, and returns the details when asked for. 
 * @author diveshbiyani
 *
 */

public class Staff
{	
	/**
	 * A staff personnel has an employee ID, name, gender and job title 
	 */
	private String employeeID;
	private String name;
	private String gender;
	private String jobTitle;
	/**
	 * Creates a staff object and assigns the details as specified by the constructor parameters.
	 * @param Name
	 * @param employeeId
	 * @param Gender
	 * @param Title
	 */
	Staff(String Name, String employeeId, String Gender, String Title)
	{
		this.employeeID=employeeId;
		this.name=Name;
		this.gender=Gender;
		this.jobTitle=Title;
	}
	/**
	 * Returns the name of a staff.
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the gender of a staff.
	 * @return gender
	 */
	public String getGender()
	{
		return gender;
	}
	/**
	 * Returns the employee ID of a staff.
	 * @return employeeID
	 */
	public String getEmployeeID()
	{
		return employeeID;
	}
	/**
	 * Returns the job title of a staff.
	 * @return jobTitle
	 */
	public String getJobTitle()
	{
		return jobTitle;
	}
}
