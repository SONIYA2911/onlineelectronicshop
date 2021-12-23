package com.user;

import java.util.Scanner;

import com.UserDao;

public class TestMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("\tWelcome to Online electronic Shop");
		System.out.println("\n1.Register\n2.Login\nEnter your Choice :");
		int choice = Integer.parseInt(scan.nextLine());

		UserDao userDao = null;
		String name = null;
		String email = null;
		switch (choice) {
		case 1:
			userDao = new UserDao();
			int flag = 0;
			System.out.println("Enter user Name:");
			name = scan.nextLine();
			do {
				if (name.matches("[A-Za-z]{5,}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid name ");
				name = scan.nextLine();
				flag = 1;
			} while (flag == 1);
			// email
			System.out.println("Enter email ID:");
			email = scan.nextLine();

			do {
				if (email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid email ");
				email = scan.nextLine();
				flag = 1;
			} while (flag == 1);

			System.out.println("Enter password:");
			String password = scan.nextLine();
			do {
				if (password.matches("[A-Za-z0-9]{8,10}")) {
					flag = 0;
					break;
				} else
					System.out.println("Enter valid password pattern");
				password = scan.nextLine();
				flag = 1;
			} while (flag == 1);
			User user = new User(name, email, password);
			userDao.insertUser(user);
			break;

//				do {
//					System.out.println("Enter user Name:");
//				
//					name=scan.nextLine();
//				
//				if(name.isEmpty()) {
//					System.out.println("name can't be empty ");		
//				}
//				if(!name.matches("^[A-Za-z]+{3,15}+$"))
//						{ 
//					System.out.println("enter valid name");
//				name=scan.nextLine();
//				}
//				}while((!name.matches("^[A-Za-z]+{3,15}+$")));
//				

//				do {
//					System.out.println("Enter email ID:");
//				    email=scan.nextLine();
//				
//					if(!email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+")) {
//						System.out.println("enter valid email");
//					}
//					if(email.isEmpty()) {
//					System.out.println("email can't empty");
//						email=scan.nextLine();
//					}
//					}while((!email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+")));
//									
//				System.out.println("Enter password:");
//				String password=scan.nextLine();
//				if(!(password.matches("[A-Za-z0-9]{8,10}"))) {
//						System.out.println("mismatch password");
//						System.exit(0);				
//				}
//				User user=new User(name,email,password);
//				userDao.insertUser(user);
//				break;
//				
		case 2:
			userDao = new UserDao();
			System.out.println("User Login ");
			System.out.println("Enter the registered mail ID");
			String mailid = scan.nextLine();
			User currentUser = userDao.validateUser(mailid);
		case 3:
			userDao = new UserDao();
			System.out.println("");
		}

	}

}