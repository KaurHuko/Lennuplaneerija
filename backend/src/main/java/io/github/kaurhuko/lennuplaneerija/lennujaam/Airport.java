package io.github.kaurhuko.lennuplaneerija.lennujaam;

public class Airport {

    private final String iata;
    private final String country;
    private final String municipality;

    private Airport(String iata, String country, String municipality) {
        this.iata = iata;
        this.country = country;
        this.municipality = municipality;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getCountry() {
        return country;
    }

    public String getIata() {
        return iata;
    }
}
