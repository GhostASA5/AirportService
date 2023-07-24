import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final AirportService airportService = new AirportService(new ArrayList<>());

    private static final List<String> airportCodes = new JSONParser().parseAirportCodeJson("resources/airports.json");

    private static final ConsoleMessages consoleMessages = new ConsoleMessages();

    public static void main(String[] args) {

        int command = 10;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сервис поиска авиабилетов\n");

        while (command != 0){
            System.out.println("""
                    Глвное меню:\s
                    1 - ввод рейса
                    2 - вывод всех рейсов
                    3 - поиск рейса по номеру
                    0 - завершение работы
                    """);
            System.out.print("Введите номер пункта меню : ");
            command = scanner.nextInt();

            if(command == 1){
                System.out.println("Введите данные рейса: ");
                System.out.print("XXXX - номер рейса: ");
                String flightNumber = scanner.next();
                System.out.print("ДД/ММ/ГГГГ - дата рейса: ");
                String date = scanner.next();
                System.out.print("ЧЧ:ММ - время вылета: ");
                String departureTime = scanner.next();
                System.out.print("XX.XX - длительность перелета: ");
                String flightTime = scanner.next();
                System.out.print("XXX - аэропорт вылета: ");
                String codeIATADeparture = scanner.next();
                System.out.print("XXX - аэропорт назначения: ");
                String codeIATAArrival = scanner.next();
                System.out.print(".XX - стоимость билета: ");
                String price = scanner.next();
                if (isFlightCorrect(flightNumber, date, departureTime, flightTime, codeIATADeparture,
                        codeIATAArrival, price)){
                    airportService.addFlight(flightNumber.toUpperCase(), LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm")),
                            flightTime, codeIATADeparture, codeIATAArrival, Double.valueOf(price));
                    System.out.println(airportService.getFlight(flightNumber.toUpperCase()).replace("\n", "") + " добавлена\n");
                    consoleMessages.addMessage(airportService.getFlight(flightNumber.toUpperCase()).replace("\n", "") + " добавлена\n");
                } else{
                    System.out.println("Не все данные проходят по формату");
                    consoleMessages.addMessage("Не все данные проходят по формату");
                }
            } else if (command == 2) {
                System.out.println(airportService.getAllFlight());
                consoleMessages.addMessage(airportService.getAllFlight());
            } else if (command == 3) {
                System.out.print("Введите номер рейса в формате XXXX: ");
                String flightNumber = scanner.next();
                System.out.println(airportService.getFlight(flightNumber.toUpperCase()));
                consoleMessages.addMessage(airportService.getFlight(flightNumber.toUpperCase()));
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