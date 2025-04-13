package traintickets_booking_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Bookingsystem {
	static int totalberth=3;
	static int rac=2;
	static int waitinglist=1;
	static int upper=1;
	static int middle=1;
	static int lower=1;
	static ArrayList<Passengers> passengersconfirmed=new ArrayList<>();
	static ArrayList<Passengers> passengersrac=new ArrayList<>();
	static ArrayList<Passengers> passengerswaitinglist=new ArrayList<>();

	public void booking()
	{
		Scanner input =new Scanner(System.in);
		if(totalberth==0 && rac==0 && waitinglist==0)
		{
			System.out.println("NO BERTH IS AVAILABLE :");
			return;
		}
		else {
			System.out.println("ENTER THE PASSENGERS DETAILS:");
			System.out.print("ENTER THE NAME :");
			String name=input.nextLine().toLowerCase();
			System.out.print("ENTER THE AGE :");
			int age=input.nextInt();
			input.nextLine();
			System.out.print("ENTER THE GENDER :");
			String gender=input.nextLine().toLowerCase();
			System.out.print("ENTER THE BERTH PREFERENCE :");
			String berth=input.nextLine().toLowerCase();
			
			if(age<5)
			{
				return;
			}
			else {
				if(berth.equals("upper"))
				{
					if(upper==0)
					{
		                System.out.println("Upper berth not available. Suggesting available berths:");
						suggestberth(name,age,gender);

						return;
					}
					else {
						totalberth--;
						upper--;
						passengersconfirmed.add(new Passengers(name,age,gender,berth));
						System.out.println("SUCCESSFULLY BOOKED !");
						System.out.println("-----------------");

						return;
					}
				}
				if(berth.equals("middle"))
				{
					if(middle==0)
					{
		                System.out.println("middle berth not available. Suggesting available berths:");
						suggestberth(name,age,gender);
						return;
					}
					else {
						totalberth--;
						middle--;
						passengersconfirmed.add(new Passengers(name,age,gender,berth));
						System.out.println("SUCCESSFULLY BOOKED !");
						System.out.println("-----------------");
						return;
					}
				}
				if(berth.equals("lower"))
				{
					if(lower==0)
					{
		                System.out.println("lower berth not available. Suggesting available berths:");
						suggestberth(name,age,gender);
						return;
					}
					else {
						totalberth--;
						lower--;
						passengersconfirmed.add(new Passengers(name,age,gender,berth));
						System.out.println("SUCCESSFULLY BOOKED !");
						System.out.println("-----------------");

						return;
					}
				}
			}
			
			

			
		}
		
		return;
	}
	public void suggestberth(String name,int age,String gender)
	{
		Scanner input=new Scanner(System.in);
		if(upper>0) System.out.println("1.upper");
		if(middle>0) System.out.println("2.middle");
		if(lower>0) System.out.println("3.lower");
		if(lower==0 && middle==0 && lower==0)
			{
				if(rac>0)
				{
					System.out.println("4.rac");
				}
				else if(waitinglist>0)
				{
					System.out.println("5.waitinglist");
				}
				
			}
		System.out.println("6.exit");
		System.out.println(" ENTER THE CHOICE (1-5)");
		int choice=input.nextInt();
		input.nextLine();
		switch(choice) {
		case 1:
			totalberth--;
			upper--;
			passengersconfirmed.add(new Passengers(name,age,gender,"upper"));
			System.out.println("SUCCESSFULLY BOOKED -!");
			System.out.println("-----------------");
			break;
		case 2:
			totalberth--;
			middle--;
			passengersconfirmed.add(new Passengers(name,age,gender,"middle"));
			System.out.println("SUCCESSFULLY BOOKED !");
			System.out.println("-----------------");
			break;
		case 3:
			totalberth--;
			lower--;
			passengersconfirmed.add(new Passengers(name,age,gender,"lower"));
			System.out.println("SUCCESSFULLY BOOKED !");
			System.out.println("-----------------");
			break;
		case 4:
			rac--;
			passengersrac.add(new Passengers(name,age,gender,"rac"));
			System.out.println("SUCCESSFULLY BOOKED !");
			System.out.println("-----------------");
			break;
		case 5:
			waitinglist--;
			passengerswaitinglist.add(new Passengers(name,age,gender,"waiting"));
			System.out.println("SUCCESSFULLY BOOKED !");
			System.out.println("-----------------");
			break;
		case 6:
			break;
		default:
			System.out.println("INVALID INPUT");
			break;
		}
		return;
		
	}
	public void cancelbooking()
	{
		if(passengersconfirmed.isEmpty())
		{
			System.out.println("no ticket is booked to cancel");
			return;
		}
		System.out.println("enter the name to cancel the ticket:");

		Scanner input=new Scanner(System.in);
		String cancelingname=input.nextLine();
		Passengers cancelpassenger=null;
		for(Passengers passenger:passengersconfirmed)
		{
			if(passenger.name.equals(cancelingname))
			{
				cancelpassenger=passenger;
				break;
			}
		}
		if(cancelpassenger==null)
		{
			System.out.println("no passengers with this name:");
			return;
		}
		else
		{
			passengersconfirmed.remove(cancelpassenger);
			totalberth++;
			if(!passengersrac.isEmpty())
			{
				Passengers passenger=passengersrac.remove(0);
				totalberth--;
				rac++;
				passengersconfirmed.add(passenger);
			}
			if(!passengerswaitinglist.isEmpty())
			{
				rac--;
				waitinglist++;
				Passengers passenger=passengerswaitinglist.remove(0);
				passengersrac.add(passenger);
			}
			System.out.println("succcessfully removed");
		}
	}
	public void printbooking()
	{
		if(passengersconfirmed.isEmpty())
		{
			System.out.println("NO TICKET IS BOOOKED !");
		}
		else {
			System.out.println("TICKETS CONFIRMED :");
			for(int i=0;i<passengersconfirmed.size();i++)
			{
				Passengers passenger=passengersconfirmed.get(i);
				System.out.println(" name : "+passenger.name+"\nage : passenger.age : "+passenger.age+"\ngender : "+passenger.gender+"\n berth : "+
				passenger.berth_preference);
				System.out.println("-----------------");

			}
			System.out.println("TICKETS rac :");
			for(int i=0;i<passengersrac.size();i++)
			{
				Passengers passenger=passengersrac.get(i);
				System.out.println(" name : "+passenger.name+"\nage : passenger.age : "+passenger.age+"\ngender : "+passenger.gender+"\n berth : "+
				passenger.berth_preference);
				System.out.println("-----------------");

			}
			System.out.println("TICKETS waitinglist :");
			for(int i=0;i<passengerswaitinglist.size();i++)
			{
				Passengers passenger=passengerswaitinglist.get(i);
				System.out.println(" name : "+passenger.name+"\nage : passenger.age : "+passenger.age+"\ngender : "+passenger.gender+"\n berth : "+
				passenger.berth_preference);
				System.out.println("-----------------");

			}
			  System.out.println("----------------------");
	            System.out.println("Total Booked Tickets: " + passengersconfirmed.size());
	            System.out.println("Total RAC_Booked Tickets: " + passengersrac.size());
	            System.out.println("Total Waiting_List Tickets: " + passengerswaitinglist.size());
	            System.out.println("----------------------------");

		}
		
	}
	public void printunbooking()
	{
		 System.out.println("Available Tickets:");
	        System.out.println("----------------------");
	        System.out.println("Available Tickets: " + (totalberth));
	        System.out.println("RAC Available Tickets: " + (rac));
	        System.out.println("Waiting List Available Tickets: " + (waitinglist));
	        System.out.println("Total Available Tickets: " + (totalberth + rac + waitinglist));
	}
	
}
