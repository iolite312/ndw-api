package me.iolite.ndw_api.models;

import lombok.Data;
import java.util.List;

@Data
public class WegGeometry {
    private String type;
    private List<List<Double>> coordinates;
}

