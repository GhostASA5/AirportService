package data;

import java.time.LocalDate;

public class Flight {

    private String flightNumber;

    private LocalDate date;

    private LocalDate departureTime;

    private Double flightTime;

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

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }

    public Double getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Double flightTime) {
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
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", date=" + date +
                ", departure=" + departureTime +
                ", flightTime=" + flightTime +
                ", codeIATADeparture='" + codeIATADeparture + '\'' +
                ", codeIATAArrival='" + codeIATAArrival + '\'' +
                ", price=" + price +
                '}';
    }
}
