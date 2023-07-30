import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final AirportService airportService = new AirportService(new ArrayList<>());
    private static final List<String> airportCodes = new JSONParser().parseAirportCodeJson("resources/airports.json");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int command = 10;
        System.out.println(ConsoleMessages.AIRPORT_SERVICE);

        while (command != 0){
            System.out.print(ConsoleMessages.MAIN_MENU + ConsoleMessages.MENU_ITEM_NUMBER);
            command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> addFlight();
                case 2 -> System.out.println(airportService.getAllFlight());
                case 3 -> getFlightByNumber();
            }
        }
    }

    private static void addFlight() {
        System.out.println(ConsoleMessages.FLIGHT_DATA);

        String flightNumber = readStringWithFormat(ConsoleMessages.FLIGHT_NUMBER, "^[A-Za-z]{4}$");
        String date = readStringWithFormat(ConsoleMessages.DATE, ".{10}");
        String departureTime = readStringWithFormat(ConsoleMessages.DEPARTURE_TIME, ".{5}");
        String flightTime = readStringWithFormat(ConsoleMessages.FLIGHT_TIME, "^\\d{2}\\.\\d{2}$");
        String codeIATADeparture = readStringWithFormat(ConsoleMessages.CODE_IATA_DEPARTURE, ".{3}");
        String codeIATAArrival = readStringWithFormat(ConsoleMessages.CODE_IATA_ARRIVAL, ".{3}");
        String price = readStringWithFormat(ConsoleMessages.PRICE, "^\\d+(\\.\\d+)?$");

        if (isFlightCorrect(flightNumber, date, departureTime, flightTime, codeIATADeparture, codeIATAArrival, price)) {
            airportService.addFlight(
                    flightNumber.toUpperCase(),
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm")),
                    flightTime, codeIATADeparture, codeIATAArrival, Double.valueOf(price)
            );
            System.out.println(airportService.getFlight(flightNumber.toUpperCase()).replace("\n", "") + " добавлена\n");
        } else {
            System.out.println(ConsoleMessages.ERROR_DATA_FLIGHT_FORMAT);
        }
    }

    private static void getFlightByNumber() {
        System.out.print(ConsoleMessages.ENTER_FLIGHT_NUMBER);
        String flightNumber = scanner.nextLine();
        System.out.println(airportService.getFlight(flightNumber.toUpperCase()));
    }

    private static String readStringWithFormat(String message, String regexPattern) {
        String input;
        boolean isValid;
        do {
            System.out.print(message);
            input = scanner.nextLine();
            isValid = input.matches(regexPattern);

            if (isValid && (message.equals(ConsoleMessages.CODE_IATA_DEPARTURE) || message.equals(ConsoleMessages.CODE_IATA_ARRIVAL))) {
                isValid = airportCodes.contains(input);
            }

            if (!isValid) {
                System.out.println("Недопустимый формат данных. Пожалуйста, повторите ввод.");
            }
        } while (!isValid);
        return input;
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