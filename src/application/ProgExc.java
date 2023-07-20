package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class ProgExc {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in Date (dd/mm/yyyy)");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Check-out Date (dd/mm/yyyy)");
		Date checkout = sdf.parse(sc.next());
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Checkout date must be after Checkin date");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println(reservation);
			System.out.println();
			System.out.println("Enter date to update the reservation:");

			System.out.println("Check-in Date (dd/mm/yyyy)");
			checkin = sdf.parse(sc.next());
			System.out.println("Check-out Date (dd/mm/yyyy)");
			checkout = sdf.parse(sc.next());

			String error = reservation.updateDates(checkin, checkout);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println(reservation);
			}
		}
		sc.close();
	}

}
