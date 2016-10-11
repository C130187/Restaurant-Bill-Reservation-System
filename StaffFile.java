package assignment;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * @author shuvamnandi
 *
 */
public class StaffFile 
{
	private int numOfStaff=0;
	Staff[] staffList=new Staff[100];
	private static BufferedReader brStream=new BufferedReader(new InputStreamReader(System.in));
	public Staff[] returnStaff()
	{
		return staffList;
	}
	public int returnNumOfStaff()
	{
		return numOfStaff;
	}
	public void addStaff()
	{
		String name;
		String ID;
		String gender;
		String title;
		try
		{
			BufferedWriter bwStream=new BufferedWriter(new FileWriter("Staff.txt", true));
			PrintWriter pwStream=new PrintWriter(bwStream);
			System.out.println("Enter a staff name");
			name=brStream.readLine();
			System.out.println("Enter the employee ID");
			ID=brStream.readLine();
			System.out.println("Enter the gender");
			gender=brStream.readLine();
			System.out.println("Enter the title");
			title=brStream.readLine();
			pwStream.println(ID+"|"+name+"|"+gender+"|"+title);
			numOfStaff++;
			pwStream.close();
		}
		catch(IOException e)
		{
			System.out.println("IO Error!"+ e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
	public void readStaffData()
	{
	    staffList=new Staff[100];
	    String inputLine;
    	String name;
    	String gender;
    	String title;
    	String employeeId;
    	try
	    {
	    	BufferedReader brStream = new BufferedReader(new FileReader("Staff.txt"));
	    	inputLine = brStream.readLine(); 
	    	while(inputLine!=null)
	    	{
	    		if(!inputLine.equalsIgnoreCase(""))
	    		{
	    			StringTokenizer extract = new StringTokenizer(inputLine, "|");
	    			employeeId = extract.nextToken();
	    			name = extract.nextToken();
	    			gender = extract.nextToken();
	    			title = extract.nextToken();
	    			staffList[numOfStaff]= new Staff(name, employeeId, gender, title);
	    			numOfStaff++;
	    		}
	    		inputLine = brStream.readLine(); 
	    	}
	    	brStream.close();
	    }
	    catch(FileNotFoundException e)
	    {
	    	System.out.println( "Error opening the input file!" + e.getMessage());
	    	System.exit(0);	
	    }
	    catch (IOException e) 
	    {
            System.out.println( "IO Error!" + e.getMessage() );
            e.printStackTrace();
            System.exit(0);
        }
	}
	public void printStaffData()
	{
		if(numOfStaff>0)
		{
			System.out.println("Staff Information");
			System.out.println(String.format("%10s | %30s | %8s | %10s ", "EmployeeID", "Name", "Gender", "Job Title"));
	        for(int i=0;i<numOfStaff;i++)
	        	System.out.println(String.format("%10s | %30s | %8s | %10s ", staffList[i].getEmployeeID(), staffList[i].getName(), staffList[i].getGender() , staffList[i].getJobTitle()));
		}
		else
			System.out.println("No staff information available");
	}
}
