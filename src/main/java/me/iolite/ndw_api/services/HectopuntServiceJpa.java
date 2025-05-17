package me.iolite.ndw_api.services;

import me.iolite.ndw_api.models.Hectopunt;
import me.iolite.ndw_api.repositories.HectopuntRepository;
import me.iolite.ndw_api.services.interfaces.HectopuntService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HectopuntServiceJpa implements HectopuntService {
    private final HectopuntRepository hectopuntRepository;

    public HectopuntServiceJpa(HectopuntRepository hectopuntRepository) {
        this.hectopuntRepository = hectopuntRepository;
    }
    @Override
    public List<Hectopunt> createHectopunten(List<Hectopunt> hectopunten) {
        return hectopuntRepository.saveAll(hectopunten);
    }

    @Override
    public Hectopunt createHectopunt(Hectopunt hectopunt) {
        return hectopuntRepository.save(hectopunt);
    }

    @Override
    public Integer hectopuntenCount() {
        return (int) hectopuntRepository.count();
    }
}
