public class Customer {
	private String firstname;
	private String surname;

	public Customer(String firstname, String surname) {
		super();
		this.firstname = firstname;
		this.surname = surname;

	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return "Customer: " + firstname + " " + surname;
	}
}
