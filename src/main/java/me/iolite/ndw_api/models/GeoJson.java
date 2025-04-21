package me.iolite.ndw_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoJson {
    private String type;
    private List<WegVak> features;
    private Integer totalFeatures;
    private Integer numberMatched;
    private Integer numberReturned;
}

