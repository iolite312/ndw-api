package me.iolite.ndw_api.converters;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import me.iolite.ndw_api.models.Geometry;
import me.iolite.ndw_api.models.Properties;
import me.iolite.ndw_api.models.WegVak;

import java.io.IOException;

public class WegVakDeserializer extends StdDeserializer<WegVak> {
    public WegVakDeserializer() {
        this(null);
    }

    public WegVakDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WegVak deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        WegVak wegvak = new WegVak();

            wegvak.setType(node.get("type").asText());
            wegvak.setGeometry_name(node.get("geometry_name").asText());
            JsonNode geometryNode = node.get("geometry");
            wegvak.setGeometry(p.getCodec().treeToValue(geometryNode, Geometry.class));

        // Deserialize "properties" node into the Properties class
        JsonNode propertiesNode = node.get("properties");
        if (propertiesNode != null && !propertiesNode.isNull()) {
            Properties properties = p.getCodec().treeToValue(propertiesNode, Properties.class);

            // Associate the Properties object with this WegVak
            wegvak.setId(properties.getWvk_id()); // Set ID from wvk_id
            wegvak.setProperties(properties);     // Set the properties object
        }

        return wegvak;
    }


}
