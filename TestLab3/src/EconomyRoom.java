/*
public class EconomyRoom extends Room {
	
	public EconomyRoom(int roomNumber, String description, int groundPrice){
		super(roomNumber, description, groundPrice);
	}
	public double checkOut(int numberOfDays, boolean member){
		double sum = 0;
		sum = tab + (((grundPrice*numberOfResidents)*0.95)*numberOfDays);
		if(member){
			sum *= 0.8 ;
		}
		clearRoom();
		return sum;
	}

}
*/
//Code above is belonging to Kim code under is belogning to Yasmeen


public class EconomyRoom extends Room {
public EconomyRoom(int roomNumber,String description,double grundPrice){
	super(roomNumber,description,grundPrice);
}
public double checkOut(int antalDagar,boolean medlem){
	//Code added by kim
	double totalRekning;
	//code ending from kim
	if(medlem){	
		totalRekning=grundPrice*numberOfResidents* 80/100;
		clearRoom();
	return totalRekning ; 	
	}else{
		totalRekning=grundPrice*numberOfResidents;
		clearRoom();
		return totalRekning ;
	}
	
}

}



