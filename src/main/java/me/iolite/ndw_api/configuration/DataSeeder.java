package me.iolite.ndw_api.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.iolite.ndw_api.models.GeoJsonHectopunt;
import me.iolite.ndw_api.models.GeoJsonWegVak;
import me.iolite.ndw_api.models.Hectopunt;
import me.iolite.ndw_api.models.WegVak;
import me.iolite.ndw_api.services.interfaces.HectopuntService;
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
    private final HectopuntService hectopuntService;

    public DataSeeder(WegVakService wegVakService, HectopuntService hectopuntService) {
        this.hectopuntService = hectopuntService;
        this.wegVakService = wegVakService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!wegVakService.wegvakkenCount().equals(0)) {
            System.out.println("wegvakken data already seeded.");
        } else {
            seedWegvakken();
        }

        if (!hectopuntService.hectopuntenCount().equals(0)) {
            System.out.println("hectopunten data already seeded.");
        } else {
            seedHectopunten();
        }

    }

    private void seedWegvakken() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("wegvakken.json");
            GeoJsonWegVak geoJsonWegVak = objectMapper.readValue(file, GeoJsonWegVak.class);
            List<WegVak> wegvakken = geoJsonWegVak.getFeatures();
            System.out.println("Wegvakken: " + wegvakken.size());

            wegvakken.forEach(wegVak -> {
                wegVak.setId(wegVak.getWegVakProperties().getWvk_id());
                System.out.println("Wegvak: " + wegVak.getId());
            });
            wegVakService.createWegvakken(wegvakken);
            System.out.println("wegvakken data seeded.");

        } catch (IOException e) {
            System.err.println("Failed to read wegvak.json: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void seedHectopunten() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("hectopunten.json");
            GeoJsonHectopunt geoJsonHectopunt = objectMapper.readValue(file, GeoJsonHectopunt.class);
            List<Hectopunt> hectopunten = geoJsonHectopunt.getFeatures();
            System.out.println("Hectopunten: " + hectopunten.size());

            hectopunten.forEach(hectopunt -> {
                System.out.println("Hectopunt: " + hectopunt.getId());

                // Find the associated WegVak and set the relationship
                WegVak relatedWegVak = wegVakService.findById(hectopunt.getHectopuntProperties().getWvk_id());
                if (relatedWegVak != null) {
                    hectopunt.setWegVak(relatedWegVak);  // Link the parent to the child
                    hectopuntService.createHectopunt(hectopunt);  // Save the child
                    if (relatedWegVak.getHectopunten() == null) {
                        relatedWegVak.setHectopunten(List.of(hectopunt));
                    } else {
                        // Update the parent's list of children
                        relatedWegVak.getHectopunten().add(hectopunt);
                    }
                    wegVakService.updateWegvak(relatedWegVak);
                } else {
                    System.err.println("WegVak not found for hectopunt: " + hectopunt.getId());
                }
            });
            System.out.println("hectopunten data seeded.");

        } catch (IOException e) {
            System.err.println("Failed to read hectopunten.json: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

