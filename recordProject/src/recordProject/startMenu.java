package recordProject;
import java.util.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.ExecutionException;
import java.nio.file.*;

public class startMenu	{

	public static void main(String[] argv) {
		while(true) {
			try {
			System.out.println("*******************************");
			System.out.println("* 1. Input Data                ");
			System.out.println("* 2. Review Data               ");
			System.out.println("* 3. Exit                      ");
			System.out.println("*******************************");
			Scanner input = new Scanner(System.in);
			System.out.print("Please choose: ");
			int choose = Integer.parseInt(input.nextLine());
			System.out.println();
			
			
			switch(choose) {
				case 1  : input_Menu();break;
				case 2  : show_Menu();break;
				case 3  : System.exit(-1);
				default : System.out.println("Please input again!");break;
			}
		}catch (NumberFormatException e) {
			System.out.println("Please input your choice!");
		}finally {}
		}
	}
	
	public static void input_Menu() {
		LocalDate localdate = LocalDate.now();
		Scanner input = new Scanner(System.in);
		String Month = Integer.toString(localdate.getMonthValue());
		String Year = Integer.toString(localdate.getYear());
		boolean MTROrNot = false;
		String path = Month + "-" + Year + "Record.txt";
		List<Data_List> list = new ArrayList<>();
		Iterator<Data_List> itr = list.iterator();
		try {
			Path check = Paths.get(path);
			if(Files.notExists(check)) {
				System.out.println("New File Created " + path);
			}
			FileWriter file = new FileWriter(path,true);
			BufferedWriter writer = new BufferedWriter(file);	
			boolean state = true;
			String currentDate = Integer.toString(localdate.getDayOfMonth()) + "/" + Month ;
			while(state) {
				Data_List new_data = new Data_List();
				//Type
				System.out.println("*******************************");
				System.out.println("Type : ");
				System.out.println("1. Transport");
				System.out.println("2. Food");
				System.out.println("3. Appearance");
				System.out.println("4. Other");
				System.out.println("5. Return to Main Menu");
				System.out.println("*******************************");
				System.out.print("Please choose: ");
				try {
					int Type_choice = Integer.parseInt(input.nextLine());
					System.out.println();
					
					switch(Type_choice) {
					// Transport Menu
					case 1: new_data.setNo(currentDate);
							new_data.setType("Transport");
							System.out.println("*******************************");
							System.out.println("Transport Menu : ");
							System.out.println("1. Minibus");
							System.out.println("2. Bus");
							System.out.println("3. MTR");
							System.out.println("4. Other");
							System.out.println("5. Return to Main Menu");
							System.out.println("*******************************");
							System.out.print("Please choose: ");
							int TName_choice = Integer.parseInt(input.nextLine());
							System.out.println();
							
							switch(TName_choice){
							case 1: new_data.setName("Minibus");
									System.out.println("*******************************");
									System.out.println("Minibus Menu : ");
									System.out.println("1. 1A/1");
									System.out.println("2. 101M");
									System.out.println("3. KT");
									System.out.println("4. MK");
									System.out.println("5. TW to KT");
									System.out.println("6. Other");
									System.out.println("7. Return to Main Menu");
									System.out.println("*******************************");
									System.out.print("Please choose: ");
									int TMName_choice = Integer.parseInt(input.nextLine());
									System.out.println();
									
									switch(TMName_choice) {
									case 1:	new_data.setNameType("1A/1");
											new_data.setPrice(8.9);
											break;
									case 2:	new_data.setNameType("101M");
											new_data.setPrice(9.7);
											break;
									case 3: new_data.setNameType("KT");
											new_data.setPrice(15);
											break;
									case 4: new_data.setNameType("MK");
											new_data.setPrice(18);
											break;
									case 5:	new_data.setNameType("TW to KT");
											new_data.setPrice(18);
											break;
									case 6: System.out.println("Please input the Name: ");
											String other = input.nextLine();
											new_data.setNameType(other);
											System.out.print("Please input the price: ");
											double price = Double.parseDouble(input.nextLine());
											new_data.setPrice(price);
											break;
											
									case 7: main(null);
											break;
									}
									break;
									
							case 2: new_data.setName("Bus");
									System.out.println("*******************************");
									System.out.println("Bus Menu : ");
									System.out.println("1. 92");
									System.out.println("2. 299x");
									System.out.println("3. 26");
									System.out.println("4. 290/290A");
									System.out.println("5. Other");
									System.out.println("6. Return to Main Menu");
									System.out.println("*******************************");
									System.out.print("Please choose: ");
									int TBName_choice = Integer.parseInt(input.nextLine());
									System.out.println();
									
									switch(TBName_choice) {
									case 1:	new_data.setNameType("92");
											new_data.setPrice(6.8);
											break;
									case 2:	new_data.setNameType("299x");
											new_data.setPrice(10.3);
											break;
									case 3: new_data.setNameType("26");
											new_data.setPrice(6.8);
											break;
									case 4: new_data.setNameType("290/290A");
											new_data.setPrice(10.7);
											break;
									case 5: System.out.println("Please input the Name: ");
											String other = input.nextLine();
											new_data.setNameType(other);
											System.out.print("Please input the price: ");
											double price = Double.parseDouble(input.nextLine());
											new_data.setPrice(price);
											break;
											
									case 6: main(null);
											break;
									
									}
									break;
									
							case 3: System.out.println("*******************************");
									System.out.println("MTR Menu : ");
									System.out.println("Please input total trips rided today: ");
									int No = Integer.parseInt(input.nextLine());
									MTROrNot = true;
									for(int i = 0; i<No; i++) {
										Data_List temp = new Data_List();
										System.out.println((i+1) + " trip");
										System.out.print("Please the price of this trip:  ");
										double price = Double.parseDouble(input.nextLine());
										temp.setNo(currentDate);
										temp.setType("Transport");
										temp.setName("MTR");
										temp.setNameType("NA");
										temp.setPrice(price);
										list.add(temp);
									}
									break;
									
							case 4: System.out.print("Please enter the name the transportation: ");
									String Name = input.nextLine();
									new_data.setName(Name);
									System.out.print("Please enter the price of this transportation: ");
									double price = Double.parseDouble(input.nextLine());
									new_data.setNameType("NA");
									new_data.setPrice(price);
									break;
									
							case 5: main(null);
									break;
									
							}
							break;
							//Transport Menu
							
					//Food Menu		
					case 2: new_data.setNo(currentDate);
							new_data.setType("Food");
							System.out.println("*******************************");
							System.out.println("Food Menu: ");
							System.out.println("1. Breakfast");
							System.out.println("2. Lunch");
							System.out.println("3. Dinner");
							System.out.println("4. Snack");
							System.out.println("5. Return to Main Menu");
							System.out.println("*******************************");
							System.out.print("Please choose: ");
							int FName_Choice = Integer.parseInt(input.nextLine());
							System.out.println();
							
							switch(FName_Choice) {
							
							case 1: new_data.setName("Breakfast");
									System.out.println("*******************************");
									System.out.println("Breakfast Menu: ");
									System.out.println("Please input Restaurant Name: ");
									new_data.setNameType(input.nextLine());
									System.out.println("Please input Price: ");
									new_data.setPrice(Double.parseDouble(input.nextLine()));
									break;
									
							case 2: new_data.setName("Lunch");
									System.out.println("*******************************");
									System.out.println("Lunch Menu: ");
									System.out.println("Please input Restaurant Name: ");
									new_data.setNameType(input.nextLine());
									System.out.println("Please input Price: ");
									new_data.setPrice(Double.parseDouble(input.nextLine()));
									break;
									
							case 3: new_data.setName("Dinner");
									System.out.println("*******************************");
									System.out.println("Dinner Menu: ");
									System.out.println("Please input Restaurant Name: ");
									new_data.setNameType(input.nextLine());
									System.out.println("Please input Price: ");
									new_data.setPrice(Double.parseDouble(input.nextLine()));
									break;
									
							case 4: new_data.setName("Snack");
									System.out.println("*******************************");
									System.out.println("Snack");
									System.out.println("Please input Snack Name: ");
									new_data.setNameType(input.nextLine());
									System.out.println("Please input Price: ");
									new_data.setPrice(Double.parseDouble(input.nextLine()));
									break;
							
							case 5: main(null);
									break;
									
							default: System.out.println("Please input vaild choice!");
									 break;
							
							}
							break;
					//Food Menu
					
					//Apperance Menu
					case 3: new_data.setNo(currentDate);
							new_data.setType("Apperance");
							System.out.println("*******************************");
							System.out.println("Apperance Menu: ");
							System.out.println("1. Upper");
							System.out.println("2. Pants");
							System.out.println("3. Shoe");
							System.out.println("4. Other");
							System.out.println("*******************************");
							System.out.print("Please choose: ");
							int AName_Choice = Integer.parseInt(input.nextLine());
							System.out.println();
							
							switch(AName_Choice) {
							
							case 1: new_data.setName("Upper");
									System.out.println("*******************************");
									System.out.println("Upper Menu: ");
									System.out.println("Please enter brand: ");
									new_data.setNameType(input.nextLine());
									System.out.println("Please input Price: ");
									new_data.setPrice(Double.parseDouble(input.nextLine()));
									break;
									
							case 2: new_data.setName("Pants");
									System.out.println("*******************************");
									System.out.println("Pants Menu: ");
									System.out.println("Please enter brand: ");
									new_data.setNameType(input.nextLine());
									System.out.println("Please input Price: ");
									new_data.setPrice(Double.parseDouble(input.nextLine()));
									break;
									
							case 3: new_data.setName("Shoe");
									System.out.println("*******************************");
									System.out.println("Shoe Menu: ");
									System.out.println("1. Adidas ");
									System.out.println("2. Nike ");
									System.out.println("3. Vans ");
									System.out.println("4. Converse ");
									System.out.println("5. Puma ");
									System.out.println("6. Other ");
									System.out.println("7. Return to Main Menu");
									System.out.println("*******************************");
									System.out.print("Please choose: ");
									switch(Integer.parseInt(input.nextLine())) {
									
									case 1: new_data.setNameType("Adidas");
											System.out.println("Please input Price: ");
											new_data.setPrice(Double.parseDouble(input.nextLine()));
											break;
											
									case 2: new_data.setNameType("Nike");
											System.out.println("Please input Price: ");
											new_data.setPrice(Double.parseDouble(input.nextLine()));
											break;
											
									case 3: new_data.setNameType("Vans");
											System.out.println("Please input Price: ");
											new_data.setPrice(Double.parseDouble(input.nextLine()));
											break;
											
									case 4: new_data.setNameType("Converse");
											System.out.println("Please input Price: ");
											new_data.setPrice(Double.parseDouble(input.nextLine()));
											break;
											
									case 5: new_data.setNameType("Puma");
											System.out.println("Please input Price: ");
											new_data.setPrice(Double.parseDouble(input.nextLine()));
											break;
											
									case 6: System.out.println("Please enter brand: ");
											new_data.setNameType(input.nextLine());
											System.out.println("Please input Price: ");
											new_data.setPrice(Double.parseDouble(input.nextLine()));
											break;
											
									case 7: main(null);
											break;
									
									}
									break;
									
							case 4: System.out.println("Please enter Category: ");
									new_data.setNameType(input.nextLine());
									System.out.println("Please input the Name: ");
									new_data.setNameType(input.nextLine());
									System.out.print("Please input the price: ");
									new_data.setPrice(Double.parseDouble(input.nextLine()));
									break;
									
							case 5: main(null);
									break;
							
									
							}
							break;
					//Apperance Menu		
					
					//Other menu		
					case 4: new_data.setNo(currentDate);
							System.out.print("Please input type: ");
							String other = input.nextLine();
							new_data.setType(other);
							System.out.println("Please input Category: ");
							new_data.setName(input.nextLine());
							System.out.println("Please input the Name: ");
							new_data.setNameType(input.nextLine());
							System.out.print("Please input the price: ");
							new_data.setPrice(Double.parseDouble(input.nextLine()));
							break;
					
					//Other menu		
							
					case 5: main(null);
							break;
							
					default: System.out.println("Please input vaild number!");
							 break;
					}
					//type
					if(!MTROrNot)
						list.add(new_data);
					MTROrNot = false;
					for(int i = 0;i < list.size() ; i++) 
						System.out.println(list.get(i).toString());
					System.out.println("Continue? Y/N");
					String temp = input.nextLine();
					System.out.println();
					switch(temp) {
					case"Y" :case "y" : break;
					case"N" :case "n" : state = false;
							   break;
					default	 : System.out.println("Please input vaild choice!");
					 		   break;
					}
					
				}catch (NumberFormatException e1) {
					System.out.println("Please input vaild data!");
				}
				finally {}
		}
			for(int i = 0 ; i < list.size() ; i++) {
				writer.newLine();
				writer.write("\n" + list.get(i).toString());
			}
			writer.close();			
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {}
	}
		
	
	public static void show_Menu() {
		System.out.println("*******************************");
		System.out.println("Please input the Month of the Record: ");
		Scanner input = new Scanner(System.in);
		String Month = input.nextLine();
		System.out.println("Please input the Year of the Record: ");
		String Year = input.nextLine();
		File file = new File(Month + "-" + Year + "Record.txt");
		Double total = 0.0;
		System.out.println();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String nextLine;
			while((nextLine = reader.readLine()) != null) {
				System.out.println(nextLine);
				String[] split = nextLine.split("	");
				total += Double.parseDouble((split[4].substring(1)));			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found!");
			show_Menu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error!");
		}
		System.out.println("____________________________________________");
		System.out.println("Total:					$" + total);
		System.out.println();
	}
	
	
}

