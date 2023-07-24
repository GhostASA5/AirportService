package data;

public class Airport {

    public Airport(String cityCode, String countryCode, String name, String timeZone, boolean flightable,
                   double latitude, double longitude, String code, String iataType) {
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.name = name;
        this.timeZone = timeZone;
        this.flightable = flightable;
        this.latitude = latitude;
        this.longitude = longitude;
        this.code = code;
        this.iataType = iataType;
    }

    private String cityCode;
    private String countryCode;
    private String name;
    private String timeZone;
    private boolean flightable;
    private double latitude;
    private double longitude;
    private String code;
    private String iataType;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isFlightable() {
        return flightable;
    }

    public void setFlightable(boolean flightable) {
        this.flightable = flightable;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIataType() {
        return iataType;
    }

    public void setIataType(String iataType) {
        this.iataType = iataType;
    }
}
