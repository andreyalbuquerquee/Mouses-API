package com.andreymousesapi.mousesapi.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.andreymousesapi.mousesapi.models.Mouse;

public interface MousesRepository extends MongoRepository<Mouse, String> {
    
}
