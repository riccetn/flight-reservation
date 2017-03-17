public class Seat {
	private int number;
	private FareClass fareClass;
	private Customer customer = null;

	public Seat(int number, FareClass fareClass) {
		this.number = number;
		this.fareClass = fareClass;
	}

	public void book(Customer customer) throws AlreadyOccupiedException {
		if(this.customer != null)
			throw new AlreadyOccupiedException();
		this.customer = customer;
	}

	public int getNumber() {
		return this.number;
	}

	public FareClass getFareClass() {
		return this.fareClass;
	}

	public int getPrice() {
		switch(fareClass) {
		case First:
			return 20000;
		case Economy:
			return 5000;
		default:
			throw new AssertionError();
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		return "Seat " + number + ": " + fareClass + " class";
	}
}
