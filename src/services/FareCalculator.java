package services;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

public class FareCalculator extends Booking {
	public double book(Hotel hotel) {
		double hotelRate = 0;
		if(hotel.getTodate().isAfter(hotel.getFromdate())) {
			hotelRate =super.booking(hotel.getNoOfPersons(), hotel.getRates());
		}
		return hotelRate;
	}
	public double book(Flight flight) {
		double flightRate = 0;
		if(flight.getTriptype() == "one-way"){
			flightRate = super.booking(flight.getNoOfPersons(), flight.getRates());
		}
		else
		{
			if(flight.getTo().isAfter(flight.getFrom()))
				flightRate = super.booking(flight.getNoOfPersons(), flight.getRates());
		} 
		return flightRate;
	}
	
	public double book(Train train) {
		double trainRate = super.booking(train.getNoOfPersons(), train.getRates());
		return trainRate;
	}
	
	public double book(Bus bus) {
		double busRate = super.booking(bus.getNoOfPersons(), bus.getRates());
		return busRate;
	}
}