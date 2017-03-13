import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static Flight flight = new Flight();
	
	public static void main(String[] args) {
		System.out.println("1) Book a seat");
		bookSeat();
		listAvaiableSeats();
	}
	
	private static void bookSeat() {
		Customer customer = readCustomerInformation();
		Seat seat = chooseSeat();
		try {
			seat.book(customer);
		} catch (AlreadyOccupiedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Seat chooseSeat() {
		System.out.println("Choose seat:");
		listAvaiableSeats();
		int seatNo = readInteger("Seat number> ");
		return flight.getSeat(seatNo);
	}

	private static int readInteger(String prompt) {
		while(true) {
			System.out.print(prompt);
			try {
				return Integer.parseInt(in.readLine());
			} catch(IOException ex) {
				throw new RuntimeException(ex);
			} catch(NumberFormatException ex) {
			}
		}
	}

	private static Customer readCustomerInformation() {
		String firstname = readLine("First name> ");
		String surname = readLine("Surname> ");
		Gender gender = readGender("Gender (M/F)> ");
		return new Customer(firstname, surname, gender);
	}

	private static Gender readGender(String prompt) {
		while(true) {
			System.out.print(prompt);
			try {
				String line = in.readLine();
				switch(line) {
					case "M": case "m": return Gender.Male;
					case "F": case "f": return Gender.Female;
				}
			} catch(IOException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	private static String readLine(String prompt) {
		System.out.print(prompt);
		try {
			return in.readLine();
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private static void listAvaiableSeats() {
		for(Seat seat : flight.seatList()) {
			if(seat.getCustomer() == null)
				System.out.println(seat.getNumber() + ": Free " + seat.getFareClass() + " class seat");
			else
				System.out.println(seat.getNumber() + ": Occupied seat");
		}
	}
}
