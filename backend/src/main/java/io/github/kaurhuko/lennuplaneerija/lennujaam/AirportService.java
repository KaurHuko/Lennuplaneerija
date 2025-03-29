package io.github.kaurhuko.lennuplaneerija.lennujaam;

import com.opencsv.CSVReader;
import jakarta.annotation.Nullable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class AirportService {

    private static final Map<String, Airport> airportMap = loadAirportData();

    private static Map<String, Airport> loadAirportData() {
        HashMap<String, Airport> airportHashMap = new HashMap<>();

        ClassPathResource resource = new ClassPathResource("data/airports.csv");
        try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()))) {

            reader.readNext();
            for (String[] line; (line = reader.readNext()) != null; ) {
                String iata = line[13];
                if (iata.isEmpty()) continue;

                String municipality = line[10];

                airportHashMap.put(iata, new Airport(iata, municipality));
            }

        } catch (Exception e) {
            throw new AirportDataLoadException("Failed to load airport data: ", e);
        }
        return airportHashMap;
    }

    @Nullable
    public static Airport getAirport(String iata) {
        return airportMap.get(iata);
    }

}
