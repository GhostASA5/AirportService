package data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Flight {

    public Flight() {
    }

    public Flight(String flightNumber, LocalDate date, LocalTime departureTime, String flightTime, String codeIATADeparture, String codeIATAArrival, Double price) {
        this.flightNumber = flightNumber;
        this.date = date;
        this.departureTime = departureTime;
        this.flightTime = flightTime;
        this.codeIATADeparture = codeIATADeparture;
        this.codeIATAArrival = codeIATAArrival;
        this.price = price;
    }

    private String flightNumber;

    private LocalDate date;

    private LocalTime departureTime;

    private String flightTime;

    private String codeIATADeparture;

    private String codeIATAArrival;

    private Double price;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getCodeIATADeparture() {
        return codeIATADeparture;
    }

    public void setCodeIATADeparture(String codeIATADeparture) {
        this.codeIATADeparture = codeIATADeparture;
    }

    public String getCodeIATAArrival() {
        return codeIATAArrival;
    }

    public void setCodeIATAArrival(String codeIATAArrival) {
        this.codeIATAArrival = codeIATAArrival;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return flightNumber + " " +
                date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " +
                departureTime + " " +
                flightTime + " " +
                codeIATADeparture + " " +
                codeIATAArrival + " " +
                price;
    }
}
