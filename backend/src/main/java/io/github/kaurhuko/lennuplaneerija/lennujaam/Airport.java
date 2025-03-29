package io.github.kaurhuko.lennuplaneerija.lennujaam;

public class Airport {

    private final String iata;
    private final String municipality;

    Airport(String iata, String municipality) {
        this.iata = iata;
        this.municipality = municipality;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getIata() {
        return iata;
    }
}
