import data.Airport;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public static List<Airport> parseAirportJson(String filePath) {
        List<Airport> airports = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            JSONArray jsonArray = new JSONArray(new JSONTokener(reader));

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;

                String cityCode = jsonObject.getString("city_code");
                String countryCode = jsonObject.getString("country_code");

                JSONObject nameTranslations = jsonObject.getJSONObject("name_translations");
                String name = nameTranslations.getString("en");

                String timeZone = jsonObject.getString("time_zone");
                boolean flightable = jsonObject.getBoolean("flightable");

                JSONObject coordinatesObject = jsonObject.getJSONObject("coordinates");
                double latitude = coordinatesObject.getDouble("lat");
                double longitude = coordinatesObject.getDouble("lon");

                String code = jsonObject.getString("code");
                String iataType = jsonObject.getString("iata_type");

                airports.add(new Airport(cityCode, countryCode, name, timeZone, flightable, latitude, longitude, code, iataType));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return airports;
    }

    public static List<String> parseAirportCodeJson(String filePath) {
        List<String> airportCodes = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filePath);
            JSONArray jsonArray = new JSONArray(new JSONTokener(reader));

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String code = jsonObject.getString("code");
                airportCodes.add(code);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return airportCodes;
    }


}
