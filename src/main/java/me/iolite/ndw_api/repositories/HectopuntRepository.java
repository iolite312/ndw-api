package me.iolite.ndw_api.repositories;

import me.iolite.ndw_api.models.Hectopunt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HectopuntRepository extends MongoRepository<Hectopunt, Integer> {
}
