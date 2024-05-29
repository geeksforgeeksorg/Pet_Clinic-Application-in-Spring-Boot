package com.pet.clinic.app;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface PetRepo extends MongoRepository<Pet, String> {

	List<Pet> findBySlotid(String slotId);

}
