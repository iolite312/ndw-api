package me.iolite.ndw_api.models;

import lombok.Data;

import java.util.List;

@Data
public class HectoGeometry {
    private String type;
    private List<Double> coordinates;
}

