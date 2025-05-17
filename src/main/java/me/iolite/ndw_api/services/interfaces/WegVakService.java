package me.iolite.ndw_api.services.interfaces;

import me.iolite.ndw_api.models.WegVak;

import java.util.List;

public interface WegVakService {
    WegVak findById(Integer id);
    WegVak createWegvak(WegVak wegVak);
    WegVak updateWegvak(WegVak wegVak);
    List<WegVak> createWegvakken(List<WegVak> wegvakken);
    Integer wegvakkenCount();
}
