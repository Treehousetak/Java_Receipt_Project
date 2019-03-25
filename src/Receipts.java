//Kemelbek Tashkulov, ITM Student
//Due October 22nd, 2017
//Professor Katherine Papademas, ITM 311-01



import java.util.Scanner;
import java.util.*;
public class Receipts {
	static int order;
	static int a = 0;

	static String drinkNames[] = {"Cola($1.00), ", "Root Beer($1.00), ", "Seltzer Water($1.00), ", "Milk($1.00), ", "Sprite($1.00), "};
	static String drinkName;
	static String nameCustomer;
	static String orderName= "";
	static String orderNameFull = "";
	
	static double orderCost=0;
	static double foodTotal = 0;
	static double total=0;
	static double tax = 0.10;
	static double discountIIT = 0.10;
	static double discountSenior = 0.20;
	static double discountTotal;
	
	static char discountBirth;
	static char choice = 'y';
	
	static boolean control=false;
	
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String [] arg) {
		System.out.println("What is the customer's name?");
		nameCustomer = sc.nextLine();
		
		System.out.println("Is it the customer's birthday? Y or N?");
		discountBirth = sc.next().charAt(0);
		if (discountBirth == 'N' || discountBirth == 'n') { control=true;}
		
		System.out.println("What orders did they take? 1-7");
		System.out.println("");
		System.out.println("1 - Gyros Sandwich($5.50) 2 - Italian Beef Sandwich($4.50)");
		System.out.println("3 - Hot Dog($3.50) 	      4 - Hamburger($3.80)");
		System.out.println("5 - Drinks($1.00)         6 - Large Greek Fries($1.50)");
		System.out.println("7 - Small Greek Fries($1.00)");
		
		
		while(choice == 'Y' || choice =='y') {
			System.out.println("What did they order?");
			menu();
			foodTotal += orderCost;
			orderNameFull += orderName;
			System.out.printf("$%.2f\n", foodTotal);
			System.out.println(orderNameFull);
			System.out.println("Did they order more? Y or N?");
			choice = sc.next().charAt(0);
		}
		
		discounts();
		taxes();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Printing receipt...");
		System.out.println("");
		System.out.println("");
		System.out.println("***********");
		
		
		
		Date date = new Date();
		
		System.out.println("Welcome to George's Gyros!");
		System.out.println("");
		System.out.println("Order Date: " + date.toString());
		System.out.println("Name: " + nameCustomer);
		System.out.println("---------------------------------");
		System.out.println("");
		
		
		System.out.println("You ordered: " + orderNameFull);
		System.out.println("****");
		System.out.printf("This amounts to:$%.2f\n", foodTotal);
		System.out.printf("You saved:$%.2f\n", discountTotal);
		if (discountBirth == 'Y' || discountBirth == 'y') {System.out.println("Free Sandwich!"); }
		System.out.println("****");
		System.out.printf("Tax total:$%.2f\n ", tax);
		System.out.println("****");
		System.out.printf("The grand total is: $%.2f\n", total);
		System.out.println("--------------------------------------");
		System.out.println("Thank You for eating at George's Gyros!");
	}
	
	static void menu() {
		
		
		order= sc.nextInt();
		
		switch(order) {
		
		case 1: orderName = "Gyros Sandwich($5.50), ";
		orderCost = 5.50;
		while (control==false){
			if (discountBirth == 'Y' || discountBirth == 'y') {
			orderCost = 0;
			control = true;
		}
		} 
		break;
		
		case 2: orderName = "Italian Beef Sandwich($4.50), ";
		orderCost = 4.50;
		while (control==false) {
			if (discountBirth == 'Y' || discountBirth == 'y') {
			orderCost = 0;
			control = true;
			}
		}
		break;
		
		case 3: orderName = "Hot Dog($3.50), ";
		orderCost = 3.50;
		break;
		
		case 4: orderName = "Hamburger($3.80), ";
		orderCost = 3.80;
		while (control==false) {
			if (discountBirth == 'Y' || discountBirth == 'y') {
			orderCost = 0;
			control = true;
			}
		}
		break;
		
		case 5:orderName = "";
		orderCost = 1.00;
		System.out.println(Arrays.toString(drinkNames));
		System.out.println("0-4. What drink did they order?");
		a = sc.nextInt();
		drinkName= drinkNames[a];
		orderNameFull += drinkName;
		break;
		
		case 6: orderName = "Large Greek Fries($1.50), ";
		orderCost = 1.50;
		break;
		
		case 7: orderName = "Small Greek Fries($1.00), ";
		orderCost = 1.00;
		break;
		
		default: 
		orderCost = 0;
		break;
		}
	}

	

	static void discounts() {
		int discount = 0;
		
		System.out.println("Discount? 1 - for the IIT discount, 2 - for the senior citizen discount, 3 - for no discount");
		discount = sc.nextInt(); 
		switch(discount) {
	
		case 1:
		discountIIT *= foodTotal;
		discountTotal = discountIIT;
		total += foodTotal;
		total -= discountIIT;
		break;
	
		case 2: 
		discountSenior *= foodTotal;
		discountTotal = discountSenior;
		total += foodTotal;
		total -= discountSenior;
		break;
		default: total = foodTotal;
		break;
		}
	}
	
	static void taxes() {
		tax *= total;
		total += tax;
	}


	
	
}
