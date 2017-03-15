import java.util.ArrayList;
import java.util.List;

public class FlightList {
	private List<Flight> flightList = new ArrayList<>();
	
	
	public FlightList(){
		flightList.add(new Flight(1, "SK103", "6:00"));
		flightList.add(new Flight(2, "SK939", "8:00"));
		flightList.add(new Flight(3, "SK1495", "11:00"));
		flightList.add(new Flight(4, "SK1419", "16:00"));
		flightList.add(new Flight(5, "SK1827", "21:00"));

	
		
	}
	
// to finish 	
	public void printFlights() {
		for(Flight flight : flightList) {
			System.out.println(flight);
		}
	}
	
	public Flight getFlight(int id) throws NoSuchFlightException {
	
				if(id < 1 || id > flightList.size())
					throw new NoSuchFlightException();
				return flightList.get(id-1);
		}
	}
	
	
