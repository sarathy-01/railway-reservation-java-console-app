package traintickets_booking_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("WELL COME TO PONDICHERRY RAILWAY :");
		Scanner input=new Scanner(System.in);
		Bookingsystem bookingsystem=new Bookingsystem();
		while(true)
		{
			System.out.println(" CHOOSE THE SERVICE (1-4):");
			System.out.println(" 1-booking \n 2-cancelling \n 3- booked details \n 4-unbooked details \n 5-exit");
			int choice=input.nextInt();
			input.nextLine();
			switch(choice)
			{
			case 1:
				bookingsystem.booking();
				break;
			case 2:
				bookingsystem.cancelbooking();
				break;
			case 3:
				bookingsystem.printbooking();
				break;
			case 4:
				bookingsystem.printunbooking();
				break;
			case 5:
				System.exit(0);
				

			}
		}
	}

}
