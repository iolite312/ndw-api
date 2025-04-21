package me.iolite.ndw_api.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import me.iolite.ndw_api.models.Geometry;
import me.iolite.ndw_api.models.Properties;

@Converter
public class PropertiesConverter implements AttributeConverter<Properties, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Properties property) {
        try {
            // Convert Properties object to JSON string
            return objectMapper.writeValueAsString(property);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting Geometry to JSON", e);
        }
    }

    @Override
    public Properties convertToEntityAttribute(String dbData) {
        try {
            // Convert JSON string back to Properties object
            return objectMapper.readValue(dbData, Properties.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting JSON to Geometry", e);
        }
    }
}

