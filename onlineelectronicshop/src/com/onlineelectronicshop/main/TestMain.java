package com.onlineelectronicshop.main;


import java.util.List;
import java.util.Scanner;

import com.onlineelectronicshop.dao.AdminDao;
import com.onlineelectronicshop.dao.ComponentDao;
import com.onlineelectronicshop.dao.OrderDao;
import com.onlineelectronicshop.dao.UserDao;
import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.User;



public class TestMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("\tWelcome to Online electronic Shop");
		System.out.println("\n1.Register\n2.Login\nEnter your Choice :");
		int choice = Integer.parseInt(scan.nextLine());

		UserDao userDao = null;
		String user_name = null;
		String email_id = null;
		String password=null; 
		String contact_Number;
		String address=null;
	
		switch (choice) {
		case 1:
			userDao = new UserDao();
			int flag = 0;
			System.out.println("Enter user Name:");
			user_name = scan.nextLine();
			do {
				if (user_name.matches("[A-Za-z]{5,}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid name ");
				user_name = scan.nextLine();
				flag = 1;
			} while (flag == 1);
			// email
			System.out.println("Enter email ID:");
			email_id = scan.nextLine();

			do {
				if (email_id.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid email ");
				email_id = scan.nextLine();
				flag = 1;
			} while (flag == 1);
        //password
			System.out.println("Enter password:");
			password = scan.nextLine();
			do {
				if (password.matches("[A-Za-z0-9]{8,10}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid password pattern");
				password = scan.nextLine();
				flag = 1;
			} while (flag == 1);
			//mobile number
			System.out.println("Enter contact number");
			contact_Number=scan.nextLine();
			do {
				if (contact_Number.matches("[0-9]{10}")) {
				flag=0;
				break;
				}
			else
					System.out.println("enter mobile number ");
			contact_Number=scan.nextLine();
			flag=1;
			}while(flag==1);
			Long contactNumber=Long.parseLong(contact_Number);
	//address
		System.out.println("Enter the addrss");
			address=scan.nextLine();
			do {
				if(address.matches("[A-Za-z0-9/,]")) {
					flag=0;
					break;
				}else
				{
					System.out.println("enter the address");
				address=scan.nextLine();
				flag=1;
				break;
				}
			}while(flag==1);
			
			
			
			User user = new User(user_name,email_id,password,contactNumber,address);
			userDao.insertUser(user);
			System.out.println("enter your update details");
			String update=scan.nextLine();
			userDao.update(update);
			System.out.println("enter your  delete details");          
            String delete=scan.nextLine();
            userDao.deleteUser(delete);	
		

		case 2:
			userDao=new UserDao();
			System.out.println("Login ");
			System.out.println("Enter  email ID");
			email_id=scan.nextLine();
			int userChoice=1;
			do {
				if (email_id.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid email ");
				email_id = scan.nextLine();
				flag = 1;
			} while (flag == 1);

			System.out.println("Enter password:");
		    password = scan.nextLine();
			do {
				if (password.matches("[A-Za-z0-9]{8,10}")) {
					flag = 0;
					break;
				} else
					System.out.println("Mismatch password");
					System.out.println("Enter valid password pattern");
				    password = scan.nextLine();
				    flag = 1;
			} while (flag == 1);
			User currentUser=UserDao.validateUser(email_id,password);
			if(currentUser==null) {
				User adminuser=AdminDao.validateAdmin(email_id, password);
				System.out.println("welcome!\t"+adminuser.getUser_name()+"\t as admin");
				System.out.println("\n1.ListUser \n2.find user\n3.update users \n4.delete users");
				System.out.println("Enter your coice");
				choice=Integer.parseInt(scan.nextLine());
				switch(choice) {
				case 1:
					System.out.println("List all user");
					List<User> UsersList=UserDao.showAllUser();
					for(int i=0;i<UsersList.size();i++) {
						System.out.println("\n"+UsersList.get(i));
						
					}
				case 2:
					userDao=new UserDao();
					System.out.println("enter email_id:\n");
					email_id=scan.nextLine();
					int userId=UserDao.findUserId(email_id);
					System.out.println("user id:"+userId);
					
				case 3:
					System.out.println("enter your updated details");
					String update1=scan.nextLine();
					userDao.update(update1);
					
				case 4:
					System.out.println("enter your details");
					String delete1=scan.nextLine();
					userDao.deleteUser(delete1);
					
				}}else {
					System.out.println("welcom!\t"+currentUser.getUser_name());
					System.out.println();
							
				}   
				System.out.println("Welcome\t"+currentUser.getUser_name());
				System.out.println("\n1.show products\n2.show orders\n3.update order\n4.Cancel order");
			}
		
			choice=Integer.parseInt(scan.nextLine()); 
			int orderChoice=0;
		
			switch(choice) {
			case 1:
				ComponentDao comDao=new ComponentDao();
				List<Components> componentList=comDao.showComponent();
				for(int i=0;i<componentList.size();i++) {
					System.out.println(componentList.get(i));
				}
//				do
//				{
//				System.out.println("\n1.Order Product\n2.show cart");
//				orderChoice=Integer.parseInt(scan.nextLine());
//			    Components component=null;
//				String userFalg=null;
//					switch(orderChoice)
//					{	
//					case 1:
//						
//						do
//						{
//						System.out.println("\nEnter the Product Name:");
//						String ComponentName=scan.nextLine();
//						for(int i=0;i<componentList.size();i++)
//						{
//							if(componentList.get(i).getName().equals(ComponentName))
//							{
//								component=componentList.get(i);
//							}
//						}
//						System.out.println(component);
//						System.out.println("\nEnter no of Products Needed");
//						int noOf=Integer.parseInt(scan.nextLine());
//						
//						orderDao.insertOrder(component,currentUser,noOf);
//						
//					
//						System.out.println("\ndo you want to buy more products(y/n)");
//						userFalg=scan.nextLine();
//					}while(userFalg.charAt(0)=='y');
//					break;
//				
//					
//					case 2:
//						System.out.println("Orders from You");
//						List<Order> userCartList=orderDao.viewUserCart(currentUser);
//						System.out.println(userCartList);
//						break;
//					}
//					}while(orderChoice<3);
//					break;
//			case 2:
//				System.out.println("Orders in cart");
//				List<Order> CartList=orderDao.viewCart(currentUser);
//				System.out.println(CartList.get(0));
//				break;
//			}
//			System.out.println("Do you want to continue or Logout ..(y/n)");
//			userFlagChoice=scan.nextLine();
//		}while(userFlagChoice.charAt(0)=='y');
//			
//		}
//		
//		
//		else
//		{
//			System.out.println("Not a registered mobile number");
//		}
//		}while(userChoice<5);
//		break;
//	case 3:
//		break;
//	default:
//			System.out.println("Invalid Choice");
//			System.exit(0);
//	}
//	
//	
//	

}

		}}
		
			
			
			
			
			
				
			
			
		

	

	


