import data.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int command = 10;
        Scanner scanner = new Scanner(System.in);

        while (command != 0){
            System.out.println("Сервис поиска авиабилетов\n");
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

            } else if (command == 2) {
                if (allFlight().size() != 0){
                    allFlight().forEach(flight -> System.out.println(flight.toString()));
                    System.out.println("\n");
                } else {
                    System.out.println("Информация о рейсах отсутствует\n");
                }
            } else if (command == 3) {
                System.out.print("Введите номер рейса в формате XXXX: ");
                String flightNumber = scanner.next();
                if(getFlight(flightNumber) != null) {
                    System.out.println("Информация о рейсе: " + getFlight(flightNumber) + "\n");
                } else{
                    System.out.println("Рейс " + flightNumber + " не найден");
                }
            }
        }
    }

    public static List<Flight> flights = new ArrayList<>();

    public static List<Flight> allFlight(){
        return flights;
    }

    public static String getFlight(String flightNumber){
        for (Flight flight : flights){
            if (flight.getFlightNumber().equals(flightNumber)){
                return flight.toString();
            }
        }
        return null;
    }



    public static void addFlight(){

    }

}