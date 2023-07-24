import data.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AirportService {

    public AirportService(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    private List<Flight> flights;

    public void addFlight(String flightNumber, LocalDate date, LocalTime departureTime, String flightTime,
                          String codeIATADeparture, String codeIATAArrival, Double price){
        Flight flight = new Flight(flightNumber, date, departureTime, flightTime, codeIATADeparture,
                codeIATAArrival, price);
        flights.add(flight);
    }

    public String getAllFlight(){
        if (flights.size() != 0){
            StringBuilder sb = new StringBuilder();
            flights.forEach(flight -> sb.append("Информация о рейсе: ").append(flight.toString()).append("\n"));
            return sb.toString();
        } else {
            return "Информация о рейсах отсутствует\n";
        }

    }

    public String getFlight(String flightNumber){
        for (Flight flight : flights){
            if (flight.getFlightNumber().equals(flightNumber)){
                return "Информация о рейсе: " + flight + "\n";
            }
        }
        return "Рейс " + flightNumber + " не найден\n";
    }


}
