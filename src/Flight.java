import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Flight {
	private Seat[] seats;
	private int flightNo;
	private String flightName;
	private String departureTime;
	private int seatsRemainingOnFlight = 10;

	public Flight(int flightNo, String flightName, String departureTime) {
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.departureTime = departureTime;

		seats = new Seat[10];
		for(int i = 0; i < 5; ++i)
		  seats[i] = new Seat(i+1, FareClass.First);
		
		for(int i = 5; i < 10; ++i)
			seats[i] = new Seat(i+1, FareClass.Economy);
	}

	public List<Seat> seatList() {
		return Collections.unmodifiableList(Arrays.asList(this.seats));
	}

	public Seat getSeat(int seatNo)  throws NoSuchSeatException {
		
		if(seatNo < 1 || seatNo > seats.length)
			throw new NoSuchSeatException();
		return seats[seatNo-1];
	}

	public int getFlightNo(){		
		
		return flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public int calcSeatsRemainingOnFlight() {
		seatsRemainingOnFlight--;		
		return seatsRemainingOnFlight;
	}

	@Override
	public String toString() {
		return flightNo + ": " + flightName + " Departure time: " + departureTime;  
	}
}
