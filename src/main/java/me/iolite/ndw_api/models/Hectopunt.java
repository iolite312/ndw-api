package me.iolite.ndw_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import me.iolite.ndw_api.deserializers.HectopuntDeserializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "hectopunten")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = HectopuntDeserializer.class)
public class Hectopunt {
    @Id
    private String id;

    private String type;
    private HectoGeometry wegGeometry;
    private String geometry_name;
    private HectopuntProperties hectopuntProperties;

    @DBRef
    private WegVak wegVak;

    public Hectopunt() {}
}
