public class Customer {
	private String firstname;
	private String surname;
	private Gender gender;

	public Customer(String firstname, String surname, Gender gender) {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.gender = gender;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public Gender getGender() {
		return gender;
	}
}
