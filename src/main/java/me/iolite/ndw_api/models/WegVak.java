package me.iolite.ndw_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import me.iolite.ndw_api.deserializers.WegVakDeserializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "wegvakken")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = WegVakDeserializer.class)
public class WegVak {
    @Id
    private Integer id;

    private String type;
    private WegGeometry wegGeometry;
    private String geometry_name;
    private WegVakProperties wegVakProperties;

    @DBRef(lazy = true)
    private List<Hectopunt> hectopunten;

    public WegVak() {}
}
