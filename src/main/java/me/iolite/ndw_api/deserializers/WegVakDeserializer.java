package me.iolite.ndw_api.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import me.iolite.ndw_api.helpers.RDconverter;
import me.iolite.ndw_api.models.WegGeometry;
import me.iolite.ndw_api.models.WegVakProperties;
import me.iolite.ndw_api.models.WegVak;

import java.io.IOException;

public class WegVakDeserializer extends StdDeserializer<WegVak> {
    public WegVakDeserializer() {
        this(null);
    }

    @Override
    public WegVak deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        WegVak wegvak = new WegVak();

        wegvak.setType(node.get("type").asText());

        JsonNode geometryNode = node.get("geometry");
        if (geometryNode != null && !geometryNode.isNull()) {
            wegvak.setWegGeometry(p.getCodec().treeToValue(geometryNode, WegGeometry.class));
        }

        WegGeometry wegGeometry = wegvak.getWegGeometry();
        wegGeometry.getCoordinates().replaceAll(RDconverter::rdtowgs);
        wegvak.setWegGeometry(wegGeometry);

        wegvak.setGeometry_name(node.get("geometry_name").asText());

        // Deserialize "properties" node into the Properties class
        JsonNode propertiesNode = node.get("properties");
        if (propertiesNode != null && !propertiesNode.isNull()) {
            WegVakProperties wegVakProperties = p.getCodec().treeToValue(propertiesNode, WegVakProperties.class);

            // Associate the Properties object with this WegVak
            wegvak.setId(wegVakProperties.getWvk_id());       // Set the back-reference
            wegvak.setWegVakProperties(wegVakProperties);     // Set the properties object
        }

        return wegvak;
    }


    public WegVakDeserializer(Class<?> vc) {
        super(vc);
    }
}
