public class Ticket {
	private Customer customer;
	private Seat seat;
	private Meal meal;
	private Flight flight;

	public Ticket(Flight flight, Customer customer, Seat seat, Meal meal) {
		super();
		this.flight = flight;
		this.customer = customer;
		this.seat = seat;
		this.meal = meal;
	}

	public Flight getFlight() {
		return flight;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public Seat getSeat() {
		return seat;
	}

	public Meal getMeal() {
		return meal;
	}

	@Override
	public String toString() {
		return "Ticket [customer= " + customer + ", flight= " + flight.getFlightName() + ", seat= " + seat + ", meal= " + meal + "]";
	}
	
	public double calcPrice() {
		double price;
		price = seat.getPrice()+ meal.getPrice();
		return price;
		
	}
}
