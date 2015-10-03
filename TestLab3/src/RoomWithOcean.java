
/*
public class RoomWithOcean extends Room {
	
	public RoomWithOcean(int roomNumber, String description, int groundPrice){
		super(roomNumber, description, groundPrice);
	}
	public double checkOut(int numberOfDays, boolean member){
		double sum  = 0;
		sum = tab + (((grundPrice*numberOfResidents)*1.05)*numberOfDays);
		if(member){
			sum *= 0.8 ;
		}
		clearRoom();
		return sum;
	}

}
*/
//Code above is belonging to Kim code under is belogning to Yasmeen



public class RoomWithOcean extends Room {
	public RoomWithOcean(int roomNumber, String description, double grundPrice) {
	super(roomNumber,description,grundPrice);	
	}
	public double checkOut(int antalDagar,boolean medlem){
		//Code added by kim
		double sum;
		//Code added by Kim
		if(medlem){	
			sum =(grundPrice*numberOfResidents*antalDagar)+100*0.8;
			clearRoom();
		return	sum;
		 	
		}else{
			sum = (grundPrice*numberOfResidents*antalDagar)+100;
			clearRoom();
			return sum;
			
		}
	}
}

