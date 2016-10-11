package assignment;

/**
 * Contains the details of a person who has bought the membership of the restaurant. Members are entitled to discount.
 * @author diveshbiyani
 *
 */
public class Member 
{
	/**
	 * A member has a memberID, name, contact no, email ID and a tier.
	 * The discount given depends on the tier. Higher the tier, the greater is the discount.
	 */
	private int memberID;
	private String name;
	private int contact;
	private String email;
	private int tier;
	/**
	 * Creates a member object and assigns the details as specified by the constructor parameters.
	 * @param membershipID
	 * @param Name
	 * @param contact
	 * @param email
	 * @param tier
	 */
	Member(int membershipID, String Name, int contact, String email, int tier)
	{
		this.memberID=membershipID;
		this.name=Name;
		this.contact=contact;
		this.email=email;
		this.tier=tier;
	}
	/**
	 * Returns the member ID of a member.
	 * @return memberID
	 */
	public int getMemberID()
	{
		return memberID;
	}
	/**
	 * Returns the name of a member.
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the contact no of a member.
	 * @return contact
	 */
	public int getContactNo()
	{
		return contact;
	}
	/**
	 * Returns the email ID of a member.
	 * @return email
	 */
	public String getEmail()
	{
		return email;
	}
	/**
	 * Returns the tier of a member.
	 * @return tier
	 */
	public int getTier()
	{
		return tier;
	}
}
