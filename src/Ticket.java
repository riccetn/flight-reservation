
public class Ticket {
	private Customer customer;
	private Seat seat;
	private Meal meal;
	
	
	public Ticket(Customer customer, Seat seat, Meal meal) {
		super();
		this.customer = customer;
		this.seat = seat;
		this.meal = meal;
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
		return "Ticket [customer=" + customer + ", seat=" + seat + ", meal=" + meal + "]";
	}
	
	public double calcPrice() {
		double price;
		price = seat.getPrice()+ meal.getPrice();
		return price;
		
	}
}
