package me.iolite.ndw_api.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import me.iolite.ndw_api.helpers.RDconverter;
import me.iolite.ndw_api.models.HectoGeometry;
import me.iolite.ndw_api.models.WegGeometry;
import me.iolite.ndw_api.models.Hectopunt;
import me.iolite.ndw_api.models.HectopuntProperties;

import java.io.IOException;

public class HectopuntDeserializer extends StdDeserializer<Hectopunt> {
    public HectopuntDeserializer() {
        this(null);
    }

    public HectopuntDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Hectopunt deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        Hectopunt hectopunt = new Hectopunt();

        hectopunt.setType(node.get("type").asText());
        hectopunt.setId(node.get("id").asText());

        JsonNode geometryNode = node.get("geometry");
        if (geometryNode != null && !geometryNode.isNull()) {
            hectopunt.setWegGeometry(p.getCodec().treeToValue(geometryNode, HectoGeometry.class));
        }

        HectoGeometry hectoGeometry = hectopunt.getWegGeometry();
        hectoGeometry.setCoordinates(RDconverter.rdtowgs(hectoGeometry.getCoordinates()));
        hectopunt.setWegGeometry(hectoGeometry);

        hectopunt.setGeometry_name(node.get("geometry_name").asText());

        // Deserialize "properties" node into the Properties class
        JsonNode propertiesNode = node.get("properties");
        if (propertiesNode != null && !propertiesNode.isNull()) {
            HectopuntProperties hectopuntProperties = p.getCodec().treeToValue(propertiesNode, HectopuntProperties.class);

            hectopunt.setHectopuntProperties(hectopuntProperties);     // Set the properties object
        }

        return hectopunt;
    }
}
