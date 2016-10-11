package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 
 * @author shuvamnandi
 *
 */
public class MemberFile 
{
	private int numOfMember=0;
	Member[] memberList=new Member[100];
	private static Scanner sc=new Scanner(System.in);
	private static BufferedReader brStream=new BufferedReader(new InputStreamReader(System.in));
	public Member[] returnMember()
	{
		return memberList;
	}
	public int returnNumOfMember()
	{
		return numOfMember;
	}
	public void addMember()
	{
		String emailID;
		String name;
		int contactNo;
		int memberID;
		int tier;
		try
		{
			BufferedWriter bwStream=new BufferedWriter(new FileWriter("Members.txt", true));
			PrintWriter pwStream=new PrintWriter(bwStream);
			System.out.println("Enter the member ID");
			memberID=sc.nextInt();
			System.out.println("Enter a member name");
			name=brStream.readLine();
			System.out.println("Enter the contact no");
			contactNo=sc.nextInt();
			System.out.println("Enter the email");
			emailID=brStream.readLine();
			System.out.println("Enter the tier");
			tier=sc.nextInt();
			pwStream.println(memberID+"|"+name+"|"+contactNo+"|"+emailID+"|"+tier);
			numOfMember++;
			pwStream.close();
		}
		catch(IOException e)
		{
			System.out.println("IO Error!"+ e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
	public void readMemberData()
	{
		try
	    {
	    	BufferedReader brStream = new BufferedReader(new FileReader("Members.txt"));
	    	String inputLine;
	    	int memberId;
	    	String name;
	    	String email;
	    	int contactNo;
	    	int tier;
	    	inputLine = brStream.readLine(); 
	    	while(inputLine!=null)
	    	{
	    		if(!inputLine.equalsIgnoreCase(""))
	    		{
	    			StringTokenizer extract = new StringTokenizer(inputLine, "|");
	    			memberId = Integer.parseInt(extract.nextToken());
	    			name = extract.nextToken();
	    			contactNo = Integer.parseInt(extract.nextToken());
	    			email= extract.nextToken();
	    			tier = Integer.parseInt(extract.nextToken());
	    			memberList[numOfMember]= new Member(memberId, name, contactNo, email, tier);
	    			numOfMember++;
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
	public void printMemberData()
	{
		if(numOfMember>0)
		{
			System.out.println("Member Information");
			System.out.println(String.format("%10s | %20s | %10s | %30s ", "Member ID", "Name", "Contact No", "Email"));
	        for(int i=0;i<numOfMember;i++)
	        	System.out.println(String.format("%10d | %20s | %10d | %30s ", memberList[i].getMemberID(), memberList[i].getName(), memberList[i].getContactNo(), memberList[i].getEmail()));
		}
		else
			System.out.println("No member information available");
	}
}
