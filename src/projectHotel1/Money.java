package projectHotel1;

public class Money {
	
	public int getRoomprice(int chooseroom, int clientnum) {
	int min=0; int roomprice;
	switch(chooseroom) {
	case 2: min=6;
	case 3: min=5;
	case 4: min=4;
	}
	if(clientnum<=min)
		return 
}
