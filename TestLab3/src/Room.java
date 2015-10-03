
public class Room {
protected String name;
protected  String description;
protected String bookingDate;
protected  boolean bookingStatus=false;
protected int numberOfResidents;
protected int roomNumber;
protected double grundPrice;
protected  double tab=0;
protected  int antalDagar;
public Room(int roomNumber,String description,double grundPrice){
	this.roomNumber=roomNumber;
	this.description=description;
	this.grundPrice=grundPrice;
	name=" ";
	 bookingDate=" ";
	 numberOfResidents=0;
	 
}
//Kim Utbult added code
	public boolean isBookingStatus(){
		return bookingStatus;
	}
	public int getRoomNumber(){
		return roomNumber;
	}
	public String getName(){
		return name;
	}
	public String getBookingDate(){
		return bookingDate;
	}
//Kim Utbult end of code




public void rent(String nyName, String nyBookningDate,int nyNumberOfResidents){
	name=nyName;
	numberOfResidents=nyNumberOfResidents;
	bookingDate=nyBookningDate;
	bookingStatus=true;
	}	

public void addToTab(double tab){
	
	this.tab+=tab;	
}
public double checkOut(int antalDagar,boolean medlem){
	double sum = tab + (((grundPrice*numberOfResidents)*1.05));
	if(medlem){
		sum *= 0.8 ;
	}
	clearRoom();
	return sum;
}


//Kim adding code
	public void clearRoom(){
		name=" ";
		bookingDate=" ";
		numberOfResidents=0;
		bookingStatus = false;
		tab=0;
		
	}
//Kim Code ending
}

