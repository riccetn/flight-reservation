import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Flight {
	private Seat[] seats;
	private int flightNo;
	private String flightName;
	private String departureTime;

	
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
	
	public Seat getSeat(int seatNo) {
		return seats[seatNo-1];
	}
	
	
	public int getFlightNo() {
		return flightNo;
	}
	
	public String getFlightName() {
		return flightName;
	}
	
	
	
	@Override
	public String toString() {
		return flightNo + ": " + flightName + " Departure time: " + departureTime;  
	}
	
	
/*
	public void addCustomer(Customer customer) throws TooManyCustomersException {
		if(customers.size() >= maxCapacity)
			throw new TooManyCustomersException();
		customers.add(customer);
	}

	public void removeCustomer(Customer customer) {
		customers.remove(customer);
	}

	public boolean findCustomer(String firstname, String surname) {
		for(Customer customer : customers) {
			if(customer.getFirstname().equals(firstname) && customer.getSurname().equals(surname)) {
				return true;
			}
		}
		return false;
	}

	public void printCustomers() {
		for(Customer customer : customers) {
			System.out.println(customer);
		}
	}
	*/
}
