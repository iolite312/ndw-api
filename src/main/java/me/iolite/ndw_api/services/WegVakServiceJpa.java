package me.iolite.ndw_api.services;

import me.iolite.ndw_api.models.WegVak;
import me.iolite.ndw_api.repositories.WegVakRepository;
import me.iolite.ndw_api.services.interfaces.WegVakService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WegVakServiceJpa implements WegVakService {
    private final WegVakRepository wegVakRepository;

    public WegVakServiceJpa(WegVakRepository wegVakRepository) {
        this.wegVakRepository = wegVakRepository;
    }

    @Override
    public WegVak findById(Integer id) {
        return wegVakRepository.findById(id).orElse(null);
    }

    @Override
    public WegVak createWegvak(WegVak wegVak) {
        return wegVakRepository.save(wegVak);
    }

    @Override
    public WegVak updateWegvak(WegVak wegVak) {
        return wegVakRepository.save(wegVak);
    }

    @Override
    public List<WegVak> createWegvakken(List<WegVak> wegvakken) {
        return wegVakRepository.saveAll(wegvakken);
    }

    @Override
    public Integer wegvakkenCount() {
        return (int) wegVakRepository.count();
    }
}
