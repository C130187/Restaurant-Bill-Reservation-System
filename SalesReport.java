package assignment;

import java.text.*;

public class SalesReport 
{
	private Sales sales=new Sales();
	private Menu menu=new Menu();
	private int width=menu.returnMaxNumOfDessert()+menu.returnMaxNumOfMainCourse()+menu.returnMaxNumOfDrink()+menu.returnMaxNumOfSetPackage();
	private SaleStructure matrix[];
	private Order order[];
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("hh:mm|a|dd/MM/YY");
	public SalesReport(int month)
	{
		menu.readDessertData();
		menu.readMainCourseData();
		menu.readDrinkData();
		menu.readSetPackageData();
		width=menu.returnNumOfDessert()+menu.returnNumOfMainCourse()+menu.returnNumOfDrink()+menu.returnNumOfSetPackage();
		matrix=new SaleStructure[width];
		createReportStructure();
	}
	public void createReportStructure()
	{
		int i, j;
		i=0;
		j=0;
		for(i=0;i<width;i++)
			matrix[i]=new SaleStructure();
		i=0;
		for(j=0;j<menu.returnNumOfDessert();i++, j++)
			matrix[i].setName(menu.returnDessert()[j].getName());
		for(j=0;j<menu.returnNumOfMainCourse();i++, j++)
			matrix[i].setName(menu.returnMainCourse()[j].getName());
		for(j=0;j<menu.returnNumOfDrink();i++, j++)
			matrix[i].setName(menu.returnDrink()[j].getName());
		for(j=0;j<menu.returnNumOfSetPackage();i++, j++)
			matrix[i].setName(menu.returnSetPackage()[j].getName());
	}
	public void generateReport(int month)
	{
		sales.dataTransferFromFile();
		order=new Order[sales.returnNumOfOrder()];
		order=sales.returnOrderData();
		boolean generate=false;
		for(int i=0;i<sales.returnNumOfOrder();i++)
		{
			if(month==(order[i].returnDate().getMonth()+1))
			{
				for(int j=0;j<order[i].returnCount();j++)
				{
					for(int k=0;k<width;k++)
					{
						if(matrix[k].getName().equalsIgnoreCase(order[i].returnOrderItem()[j].getName()))
						{	
							matrix[k].increaseQuantity();
							matrix[k].setPrice(order[i].returnOrderItem()[j].getPrice());
						}
					}
				}
				generate=true;
			}
		}
		if(generate)
		{
			float total=0;
			System.out.println("Sales Report for month " + month);
			System.out.println(String.format("%27s | %8s | %10s ", "Menu Item", "Quantity", "Total Revenue"));
			for(int j=0;j<width;j++)
			{
				if(matrix[j].getQuantity()>0)
					System.out.println(String.format("%27s | %8s | %10s ", matrix[j].getName(), matrix[j].getQuantity(), matrix[j].getPrice()));
			}
			for(int j=0;j<width;j++)
				total+=matrix[j].getPrice();
			System.out.println("Total Revenue for Month " + month+ ": SGD "+ total);
		}
		else
			System.out.println("No orders found.");
	}
}
