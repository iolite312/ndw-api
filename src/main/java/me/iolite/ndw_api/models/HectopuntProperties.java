package me.iolite.ndw_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HectopuntProperties {
    private String hectomtrng;
    private Integer afstand;
    private Integer wvk_id;
    private String wvk_begdat;
    private String zijde;
    private String hecto_lttr;
}
