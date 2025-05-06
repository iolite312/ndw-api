package me.iolite.ndw_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import me.iolite.ndw_api.converters.GeometryConverter;
import me.iolite.ndw_api.converters.WegVakDeserializer;

@Data
@Entity
@Table(name = "wegvak")
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = WegVakDeserializer.class)
public class WegVak {
    @Id
    @Column(name = "weg_id")
    @JsonProperty("properties.wvk_id")
    private Long id;

    private String type;

    @Convert(converter = GeometryConverter.class)
    private Geometry geometry;
    private String geometry_name;

    @OneToOne(mappedBy = "wegVak", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Properties properties;

    public WegVak() {}
}
