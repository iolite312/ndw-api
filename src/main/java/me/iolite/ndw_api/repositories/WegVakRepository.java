package me.iolite.ndw_api.repositories;

import me.iolite.ndw_api.models.WegVak;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WegVakRepository extends MongoRepository<WegVak, Integer> {
}
