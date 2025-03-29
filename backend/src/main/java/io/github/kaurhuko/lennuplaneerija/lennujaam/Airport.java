package io.github.kaurhuko.lennuplaneerija.lennujaam;

public class Airport {

    private final String country;
    private final String municipality;

    private Airport(String country, String municipality) {
        this.country = country;
        this.municipality = municipality;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getCountry() {
        return country;
    }
}
