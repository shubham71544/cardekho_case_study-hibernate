package com.jspiders.cardekho_case_study_hibernate.main;
import com.jspiders.cardekho_case_study_hibernate.dao.CarOperation;

import java.util.Scanner;

public class CarDekhoMenu {
	 static CarOperation operation=new CarOperation();
	static boolean login = true;
	static Scanner inp = new Scanner(System.in);

	public static void menu() {

		System.out.println("\n ======= Menu =======");
		System.out.println(" 1 - Add Car Details ");
		System.out.println(" 2 - Search Car Details");
		System.out.println(" 3 - Update Car  Details");
		System.out.println(" 4 - Delete Car  Details");
		System.out.println(" 5 Exit");
		System.out.print(" Enter Number := ");
		int choice = inp.nextInt();
		switch (choice) {
		case 1: {
			 operation.add();
		}
			break;
		case 2: {
			while(login) {
				search();
				
			}
		
		}
			break;
		case 3: {
			operation.update();
		}
			break;
		case 4: {
			 operation.delete();
		}
			break;
		case 5: {
			CarOperation.closeConnection();
			login = false;
			System.out.println("\n 00Logged Out Successfully");
		}
			break;

		default: {
			System.out.println("\n1!!!!! Enter the number only !!!!!");
		}
			break;
		}

	}
	
	  public static void	search(){
			System.out.println("\n===== Scarch Car ========="
					+ "\n 1- Scarch Car by ID"
					+ "\n 2- Search Car by Name"
					+ "\n 3- Search Car by Price"
					+ "\n 4- Search Car by Model"
					+ "\n 5- Back to Menu");
			         System.out.print("\n Enter your Number ");
			int choice2=inp.nextInt();
			
			switch (choice2) {
			case 1:
				   operation.searchCarId();			
				break;
			case 2: operation.carName();
				break;
			case 3:  operation.carPrice();
				break;
			case 4: operation.carMOd();
				break;
			case 5: menu();
			    break;

			default:System.out.println("\n1!!!!! Enter the number only !!!!!");
				break;
			}}

	public static void main(String[] args) {
		while (login) {
			menu();
		}

	}

}
