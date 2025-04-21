package me.iolite.ndw_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import me.iolite.ndw_api.converters.GeometryConverter;
import me.iolite.ndw_api.converters.PropertiesConverter;

@Data
@Entity
@Table(name = "wegvak")
@AllArgsConstructor
public class WegVak {
    @Id
    @Column(name = "id")
    private Long dbid;
    private String type;

    @Column(name = "weg_id")
    private String id;

    @Convert(converter = GeometryConverter.class)
    private Geometry geometry;
    private String geometry_name;

    @Convert(converter = PropertiesConverter.class)
    private Properties properties;

    public WegVak() {}
}
