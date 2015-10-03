import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

	private static Scanner input = new Scanner(System.in);
	private static ArrayList<EconomyRoom> ecoRoomList = new ArrayList<EconomyRoom>();
	private static ArrayList<RoomWithOcean> viewRoomList = new ArrayList<RoomWithOcean>();
	private static ArrayList<Item> item = new ArrayList<Item>();

	public static void main(String[] args){
		
		int choice = 0;
		int groundPrice = 500;
		
		item.add(new Item("Soda", 10));
		item.add(new Item("Beer", 20));
		item.add(new Item("Whiskey", 50));
		
		for(int i=0; i<5; i++){
			ecoRoomList.add(new EconomyRoom(i+1, "Room for economy", groundPrice));
		}	
		for(int i=5; i<10; i++){
			viewRoomList.add(new RoomWithOcean(i+1, "Room with View", groundPrice));
		}
		do{
			System.out.println("Hello and welcome to Hotel X \n"
					+ "1: Rent a room \n"
					+ "2: Check out \n"
					+ "3: Visit shop \n"
					+ "4: Exit \n"
					+ "What would you like to do?");
			choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			
			case 1:
				System.out.println("What kind of Room do you want\n"
						+ "1: Economy room - avaible: "+ getEconomyRoom()+"\n"
						+ "2: Ocean View room - avaible: "+getOpenViewRooms());
				//Assuming no faulty input, no Exception use
				int choiceOfRoom = input.nextInt();
				input.nextLine();
				if(choiceOfRoom == 1){
					rentOpenEconomyRoom();
				}
				else if(choiceOfRoom == 2){
					rentOpenOceanViewRoom();
				}
				
				
				break;
			
			case 2:
				System.out.println("You want to check out");
				checkingOut();
				break;
			
			case 3:
				runShop();
				break;
				
			case 4:
				System.out.println("You quit");
				 break;
			}
		}while(choice != 4);
	}
	/*
	 * Returns the numbers corresponding to the amount rooms that are open to be booked
	 */
	public static int getEconomyRoom(){
		int openEconomyRooms=0;
		for(int i=0; i<5; i++){
			if(!ecoRoomList.get(i).isBookingStatus()){
				openEconomyRooms++;
			}
		}
		return openEconomyRooms;
	}
	public static int getOpenViewRooms(){
		int openViewRooms=0;
		for(int i=0; i<5; i++){
			if(!viewRoomList.get(i).isBookingStatus()){
				openViewRooms++;
			}
		}
		return openViewRooms;
	} 
	/*
	 * Fills the corresponding room number with information of the renter
	 */
	public static void rentOpenEconomyRoom(){
		int roomNumber=0, numberOfPeople =0;
		String renterName, currentDate="";
		for(int i=0; i<5; i++){
			if(!ecoRoomList.get(i).isBookingStatus()){
				roomNumber = ecoRoomList.get(i).getRoomNumber();
				break;
			}
		}
		System.out.println("What is your name");
		renterName = input.nextLine();
		System.out.println("How many people will stay(Maximum of 3");
		numberOfPeople = input.nextInt();
		input.nextLine();
		System.out.println("What is the date?");
		currentDate = input.nextLine();
		ecoRoomList.get(roomNumber-1).rent(renterName, currentDate, numberOfPeople);
		System.out.println("All done! Your room is: "+roomNumber);
	}
	public static void rentOpenOceanViewRoom(){
		int roomNumber=0, numberOfPeople =0;
		String renterName, currentDate;
		for(int i=0; i<5; i++){
			if(!viewRoomList.get(i).isBookingStatus()){
				roomNumber = viewRoomList.get(i).getRoomNumber();
				break;
			}
		}
		System.out.println("What is your name");
		renterName = input.nextLine();
		System.out.println("How many people will stay");
		numberOfPeople = input.nextInt();
		input.nextLine();
		System.out.println("What is the date?");
		currentDate = input.nextLine();
		viewRoomList.get(roomNumber-6).rent(renterName, currentDate, numberOfPeople);
		System.out.println("All done! Your room is: "+roomNumber);
		
	}

	public static void runShop(){
		int choice, numberOfItems, buyersRoom;
		String buyersName="";
		System.out.println("What do you want to buy");
		for(int i=0; i<item.size(); i++){
			System.out.println(i+1+": "+item.get(i).getName()+"- Price "+item.get(i).getPrice()+"�");
		}
		choice = input.nextInt();
		input.nextLine();
		System.out.println("How many items do you want?");
		numberOfItems = input.nextInt();
		input.nextLine();
		System.out.println("What is your room number");
		buyersRoom = input.nextInt();
		input.nextLine();
		System.out.println("What is your name");
		buyersName = input.nextLine();

		for(int i=0; i<5; i++){
			/*
			 * These checks aint working Steve
			 */
			if((ecoRoomList.get(i).getName().equals(buyersName)
			&& ecoRoomList.get(i).getRoomNumber() == buyersRoom)
			|| (viewRoomList.get(i).getName().equals (buyersName) 
			&& viewRoomList.get(i).getRoomNumber() == buyersRoom)){
				if(buyersRoom > 5){
					viewRoomList.get(i).addToTab(item.get(choice-1).getPrice()*numberOfItems);
					break;
				}
				else if(buyersRoom < 6){
					ecoRoomList.get(i).addToTab(item.get(choice-1).getPrice()*numberOfItems);
					break;
				}

			}
			else if(i == 4){
				System.out.println("No match found for name and number");
				break;
			}
			
		}
		
	}
	public static void checkingOut(){
		int roomNumber;
		String residentName;
		System.out.println("What is your room number?");
		roomNumber = input.nextInt();
		input.nextLine();
		System.out.println("What is your name?");
		residentName = input.nextLine();
		for(int i=0; i<5; i++){
			/*
			 * These checks aint working Steve
			 */
			if((ecoRoomList.get(i).getName().equals (residentName)
			&& ecoRoomList.get(i).getRoomNumber() == roomNumber) 
			|| (viewRoomList.get(i).getName().equals (residentName) 
			&& viewRoomList.get(i).getRoomNumber() == roomNumber)){
				
				if(roomNumber > 5){
					System.out.println("Room found! Rented from "+viewRoomList.get(i).getBookingDate());
				}
				else if(roomNumber < 6){
						System.out.println("Room found! Rented from "+ecoRoomList.get(i).getBookingDate());
				}
				else if(i == 4){
					System.out.println("No match found for name and number");
					break;
				}
				System.out.println("How many days did you stay?");
				int daysStayed = input.nextInt();
				input.nextLine();
				boolean member = false;
				System.out.println("Are you a member? \n 1: Yes \n 2: No");
				int choice = input.nextInt();
				input.nextLine();
				if(choice == 1){
					member = true;
				}
				if(member){
					System.out.print("With the member discout 20% off, ");
				}
				else if(!member){
					System.out.print("No membership, ");
				}
				if(roomNumber > 5){
					System.out.println("your bills is: "+viewRoomList.get(i).checkOut(daysStayed, member)+"�");
				}
				else if(roomNumber < 6){
						System.out.println("your bill is: "+ecoRoomList.get(i).checkOut(daysStayed, member)+"�");
				}
				
				break;
				
				
			}
			if(i == 4){
				System.out.println("No match found for name and number");
				break;
			}
		}
	
	}

}
