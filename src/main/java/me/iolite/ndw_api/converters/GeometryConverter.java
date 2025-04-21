package me.iolite.ndw_api.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import me.iolite.ndw_api.models.Geometry;

@Converter
public class GeometryConverter implements AttributeConverter<Geometry, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Geometry geometry) {
        try {
            // Convert Geometry object to JSON string
            return objectMapper.writeValueAsString(geometry);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting Geometry to JSON", e);
        }
    }

    @Override
    public Geometry convertToEntityAttribute(String dbData) {
        try {
            // Convert JSON string back to Geometry object
            return objectMapper.readValue(dbData, Geometry.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting JSON to Geometry", e);
        }
    }
}

