package me.iolite.ndw_api.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.iolite.ndw_api.models.GeoJson;
import me.iolite.ndw_api.models.WegVak;
import me.iolite.ndw_api.services.interfaces.WegVakService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class DataSeeder implements ApplicationRunner {
    private final WegVakService wegVakService;

    public DataSeeder(WegVakService wegVakService) {
        this.wegVakService = wegVakService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File("wegvakken.json");
            GeoJson geoJson = objectMapper.readValue(file, GeoJson.class);
            List<WegVak> wegvakken = geoJson.getFeatures();
            System.out.println("Wegvakken: " + wegvakken.size());

            wegvakken.forEach(wegVak -> {
                wegVakService.createWegvak(wegVak);
                System.out.println("Wegvak: " + wegVak.getId());
            });

        } catch (IOException e) {
            System.err.println("Failed to read wegvak.json: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

