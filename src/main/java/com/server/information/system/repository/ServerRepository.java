package com.server.information.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.server.information.system.model.Server;


// No need implementation, just one interface, and you have CRUD, thanks Spring Data!
public interface ServerRepository extends MongoRepository<Server, String> {

	Optional<Server> findById(String id);

	Server findByName(String name);
	
	@Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
	List<Server> findByNameRegex(String regexString);
}
