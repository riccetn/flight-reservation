import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static FlightList flights = new FlightList();
	private static MealList meals = new MealList();
	private static List<Ticket> tickets = new ArrayList<>();
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("1) Book a flight and a seat");
			System.out.println("2) Print all tickets");
			System.out.println("3) Quit application"); 
			int choise = readInteger("Choose> ");
			switch(choise) {
			case 1:
				bookFlight();
				//bookSeat();
				break;
			case 2:
				printAllTickets();
				break;
			case 3:
				return;
			}
		}
	}
	
	private static void printAllTickets() {
		double totalIncome = 0.0;
		for(Ticket ticket : tickets) {
			System.out.println(ticket);
			totalIncome += ticket.calcPrice();
		}
		System.out.println("Total income: " + totalIncome);
		System.out.println("Total profit (30% of income): " + totalIncome*0.3);
	}

	
	private static void bookFlight() {
		Flight flight = null;
		Customer customer = readCustomerInformation();
		Seat seat = null;
		flight = chooseFlight();		
	

		while(seat == null) {
			seat = chooseSeat(flight);
			try {
				seat.book(customer);
			} catch (AlreadyOccupiedException e) {
				System.out.println("That seat is occupied by an other customer, please choose an other seat.");
				seat = null;
			}
		}
		Meal meal = chooseMeal(seat.getFareClass());
		tickets.add(new Ticket(flight, customer, seat, meal));
	}
	
	
	
	
	
/*	private static void bookSeat() {

		Customer customer = readCustomerInformation();
		Seat seat = null;
		while(seat == null) {
			seat = chooseSeat();
			try {
				seat.book(customer);
			} catch (AlreadyOccupiedException e) {
				System.out.println("That seat is occupied by an other customer, please choose an other seat.");
			}
		}
		Meal meal = chooseMeal(seat.getFareClass());
		tickets.add(new Ticket(flight, customer, seat, meal));
	} 
	*/
	
	private static Meal chooseMeal(FareClass fareClass) {
		meals.printMenu(fareClass);
		Meal meal = null;
		while(meal == null) {
			try {
				int mealid = readInteger("Meal number> ");
				meal = meals.getMeal(fareClass, mealid);
			} catch (NoSuchMealException e) {
				System.out.println("There is no meal with that number on the menu");
			}
		}
		return meal;
	}

	private static Seat chooseSeat(Flight flight) {
		System.out.println("Choose seat:");
		listAvaiableSeats(flight);
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
		return new Customer(firstname, surname);
	}

	private static String readLine(String prompt) {
		System.out.print(prompt);
		try {
			return in.readLine();
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private static void listAvaiableSeats(Flight flight) {
		for(Seat seat : flight.seatList()) {
			if(seat.getCustomer() == null)
				System.out.println(seat.getNumber() + ": Free " + seat.getFareClass() + " class seat");
			else
				System.out.println(seat.getNumber() + ": Occupied seat");
		}
	}
	
	private static Flight chooseFlight() {
		flights.printFlights();
		Flight flight = null;
		while(flight == null) {
			try {
				int flightNo = readInteger("Flight number> ");
				flight = flights.getFlight(flightNo);
			} catch (NoSuchFlightException e) {
				System.out.println("There is no flight with that chosen number");
			}
		}
		return flight;
	}
}
