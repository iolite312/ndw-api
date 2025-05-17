package me.iolite.ndw_api.services.interfaces;

import me.iolite.ndw_api.models.Hectopunt;

import java.util.List;

public interface HectopuntService {
    List<Hectopunt> createHectopunten(List<Hectopunt> hectopunten);
    Hectopunt createHectopunt(Hectopunt hectopunt);
    Integer hectopuntenCount();
}
