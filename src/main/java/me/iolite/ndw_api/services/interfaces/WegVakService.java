package me.iolite.ndw_api.services.interfaces;

import me.iolite.ndw_api.models.WegVak;

public interface WegVakService {
    String getWegvakById(String id);
    WegVak createWegvak(WegVak wegvak);
}
