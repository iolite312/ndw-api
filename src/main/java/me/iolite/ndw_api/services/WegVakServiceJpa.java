package me.iolite.ndw_api.services;

import me.iolite.ndw_api.models.WegVak;
import me.iolite.ndw_api.repositories.WegVakRepository;
import me.iolite.ndw_api.services.interfaces.WegVakService;
import org.springframework.stereotype.Service;

@Service
public class WegVakServiceJpa implements WegVakService {
    private final WegVakRepository wegVakRepository;

    public WegVakServiceJpa(WegVakRepository wegVakRepository) {
        this.wegVakRepository = wegVakRepository;
    }

    @Override
    public String getWegvakById(String id) {
        return "";
    }

    @Override
    public WegVak createWegvak(WegVak wegvak) {
        return wegVakRepository.save(wegvak);
    }
}
