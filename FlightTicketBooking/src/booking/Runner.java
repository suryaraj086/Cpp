package booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void booking(FlightTicketBooking fObj, Scanner scan) {
		scan.nextLine();
		System.out.println("Enter source location");
		String from = scan.nextLine();
		System.out.println("Enter Destination");
		String toDes = scan.nextLine();
		System.out.println("The total flights are");
		System.out.println(fObj.searchFlight(from, toDes));
		System.out.println("Enter the flight number");
		String flightNum = scan.nextLine();
		System.out.println("Enter the number of passengers");
		int length = scan.nextInt();
		System.out.println();
		int id = fObj.bookingIds();
		List<Passengers> arr = new ArrayList<>();
		Book obj = new Book();
		scan.nextLine();
		for (int i = 0; i < length; i++) {
			System.out.println("Enter the name");
			String name = scan.nextLine();
			System.out.println("Enter the age");
			int age = scan.nextInt();
			Passengers pass = ObjectSetter.PassengerSetter(name, age, id);
			arr.add(pass);
			scan.nextLine();
			System.out.println("Enter the seat number");
			String seatno = scan.nextLine();
			Seat seat = null;
			try {
				seat = fObj.seatBooking(flightNum, seatno);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			obj.setSeats(seatno, seat);
		}
		System.out.println("Do you want meal\n1.Yes\n2.No");
		int preference = scan.nextInt();
		boolean pref = false;
		if (preference == 1) {
			pref = true;
		}
		obj = ObjectSetter.bookSetter(obj, arr, id, from, toDes, flightNum, pref);
		System.out.println(fObj.flightBooking(arr, id, obj));
		fObj.paymentCalculation(obj);
		System.out.println("Your booking id is " + id);
	}

	public static void main(String[] args) {
		FlightTicketBooking fObj = new FlightTicketBooking();
		boolean bool = true;
		Scanner scan = new Scanner(System.in);
		while (bool) {
			System.out.println(
					"1.List of flights\n2.Booking\n3.Cancellation\n4.Available seats\n5.Meal ordered seats\n6.Booking summary");
			int val = scan.nextInt();
			scan.nextLine();
			switch (val) {
			case 1:
				try {
					System.out.println(fObj.flightDetails());
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("1.Filter using location\n2.Filter using business flights");
				int num = scan.nextInt();
				switch (num) {
				case 1:
					booking(fObj, scan);
					break;
				case 2:
					System.out.println(fObj.filterBusinessClass());
					break;
				default:
					break;
				}

				break;
			case 3:
				System.out.println("1.Cancel Entire Booking id\n2.Cancel Individual");
				int choose = scan.nextInt();
				switch (choose) {
				case 1:
					System.out.println("Enter the booking");
					int bookingId = scan.nextInt();
					System.out.println(fObj.bookingCancellation(bookingId));
					break;
				case 2:
					System.out.println("Enter the booking id");
					int bookId = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter the seat number");
					String seatNum = scan.nextLine();
					System.out.println("Enter the name");
					String name = scan.nextLine();
					System.out.println("Enter the age");
					int age = scan.nextInt();
					System.out.println(fObj.cancelIndividual(seatNum, bookId, name, age));
				default:
					break;
				}
				break;
			case 4:
				System.out.println("Enter the flight name");
				String name = scan.nextLine();
				System.out.println(fObj.availableSeats(name));
				break;

			case 5:
				System.out.println(fObj.mealOrderedSeats());
				break;
			case 6:
				System.out.println("Enter the booking id");
				int bookId = scan.nextInt();
				System.out.println(fObj.bookingSummary(bookId));
				break;
			default:
				break;
			}
		}
		scan.close();
	}

}