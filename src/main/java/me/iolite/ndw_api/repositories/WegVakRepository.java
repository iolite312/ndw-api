package me.iolite.ndw_api.repositories;

import me.iolite.ndw_api.models.WegVak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WegVakRepository extends JpaRepository<WegVak, Long> {
}
