import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final AirportService airportService = new AirportService(new ArrayList<>());

    private static final List<String> airportCodes = new JSONParser().parseAirportCodeJson("resources/airports.json");

    public static void main(String[] args) {
        int command = 10;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleMessages.AIRPORT_SERVICE);
        while (command != 0){
            System.out.print(ConsoleMessages.MAIN_MENU + ConsoleMessages.MENU_ITEM_NUMBER);
            command = scanner.nextInt();
            scanner.nextLine();
            if(command == 1){
                System.out.println(ConsoleMessages.FLIGHT_DATA);
                System.out.print(ConsoleMessages.FLIGHT_NUMBER);
                String flightNumber = scanner.nextLine();
                System.out.print(ConsoleMessages.DATE);
                String date = scanner.nextLine();
                System.out.print(ConsoleMessages.DEPARTURE_TIME);
                String departureTime = scanner.nextLine();
                System.out.print(ConsoleMessages.FLIGHT_TIME);
                String flightTime = scanner.nextLine();
                System.out.print(ConsoleMessages.CODE_IATA_DEPARTURE);
                String codeIATADeparture = scanner.nextLine();
                System.out.print(ConsoleMessages.CODE_IATA_ARRIVAL);
                String codeIATAArrival = scanner.nextLine();
                System.out.print(ConsoleMessages.PRICE);
                String price = scanner.nextLine();
                if (isFlightCorrect(flightNumber, date, departureTime, flightTime, codeIATADeparture, codeIATAArrival, price)){
                    airportService.addFlight(flightNumber.toUpperCase(), LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm")),
                            flightTime, codeIATADeparture, codeIATAArrival, Double.valueOf(price));
                    System.out.println(airportService.getFlight(flightNumber.toUpperCase()).replace("\n", "") + " добавлена\n");
                } else{
                    System.out.println(ConsoleMessages.ERROR_DATA_FLIGHT_FORMAT);
                }
            } else if (command == 2) {
                System.out.println(airportService.getAllFlight());
            } else if (command == 3) {
                System.out.print(ConsoleMessages.ENTER_FLIGHT_NUMBER);
                String flightNumber = scanner.nextLine();
                System.out.println(airportService.getFlight(flightNumber.toUpperCase()));
            }
        }
    }

    private static boolean isFlightCorrect(String flightNumber, String date, String departureTime, String flightTime,
                                           String codeIATADeparture, String codeIATAArrival, String price){
        return flightNumber.matches("^[A-Za-z]{4}$") &
                date.length() == 10 &
                departureTime.length() == 5 &
                flightTime.matches("^\\d{2}\\.\\d{2}$") &
                codeIATADeparture.length() == 3 &
                airportCodes.stream().anyMatch(code -> code.equals(codeIATADeparture)) &
                codeIATAArrival.length() == 3 &
                airportCodes.stream().anyMatch(code -> code.equals(codeIATAArrival)) &
                price.matches("^\\d+(\\.\\d+)?$");
    }
}